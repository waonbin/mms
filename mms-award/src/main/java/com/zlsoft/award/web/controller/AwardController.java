package com.zlsoft.award.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.zlsoft.award.Constants;
import com.zlsoft.award.domain.Award;
import com.zlsoft.award.domain.AwardQuota;
import com.zlsoft.award.domain.Reference;
import com.zlsoft.award.model.AwardInfo;
import com.zlsoft.award.model.AwardQuotaInfo;
import com.zlsoft.award.service.AwardService;
import com.zlsoft.award.service.ReferenceService;
import com.zlsoft.common.web.controller.BaseController;

@Controller
@RequestMapping("/award/awards")
public class AwardController extends BaseController {

    @Inject
    private AwardService awardService;
    
    @Inject
    private ReferenceService referenceService;

    /**
     * GET  /page/{page} : get data of award by page
     * @param page zero-based page index
     * @return data of awards by page
     */
    @GetMapping("/page/{page}")
    public ResponseEntity getAllAwardListByPage(@PathVariable("page") int page, String name, Integer pageSize, String processStatus){
		Specification<Award> specification = (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			if(!StringUtils.isEmpty(name)){
				predicates.add(cb.like(root.get("name").as(String.class), "%"+name+"%"));
			}
			if(!StringUtils.isEmpty(processStatus)){
				if(processStatus.equals(Constants.STATUS_PUBLISH)){
					predicates.add(cb.greaterThan(root.get("declareDate").as(Date.class), new Date()));
				}else if(processStatus.equals(Constants.STATUS_DECLARE)){
					predicates.add(cb.lessThanOrEqualTo(root.get("declareDate").as(Date.class), new Date()));
					predicates.add(cb.greaterThan(root.get("firstTrialDate").as(Date.class), new Date()));
				}else if(processStatus.equals(Constants.STATUS_FIRSTTRIAL)){
					predicates.add(cb.lessThanOrEqualTo(root.get("firstTrialDate").as(Date.class), new Date()));
					predicates.add(cb.greaterThan(root.get("retrialDate").as(Date.class), new Date()));
				}else if(processStatus.equals(Constants.STATUS_RETRIAL)){
					predicates.add(cb.lessThanOrEqualTo(root.get("retrialDate").as(Date.class), new Date()));
				}
			}
			query.where(cb.and(predicates.stream().toArray(Predicate[]::new)));
            return query.getRestriction();
		};
		if(pageSize == null || pageSize <= 0){
			pageSize = Constants.PAGE_SIZE;
		}
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Award> awards = this.awardService.findAll(specification, pageRequest);
        
        Date date = new Date();
        awards.stream().forEach(x->{
        	//get process
        	if(x.getDeclareDate().getTime() > date.getTime()){
        		x.setProcessStatus(Constants.STATUS_PUBLISH);
        	}else if(x.getDeclareDate().getTime() <= date.getTime() && x.getFirstTrialDate().getTime() > date.getTime()){
        		x.setProcessStatus(Constants.STATUS_DECLARE);
        	}else if(x.getFirstTrialDate().getTime() <= date.getTime() && x.getRetrialDate().getTime() > date.getTime()){
        		x.setProcessStatus(Constants.STATUS_FIRSTTRIAL);
        	}else if(x.getRetrialDate().getTime() <= date.getTime()){
        		x.setProcessStatus(Constants.STATUS_RETRIAL);
        	}
        	
        	//get count
        	if(x.getDeclares()!= null){
        		x.setCount(x.getDeclares().size());;
        	}else{
        		x.setCount(0);
        	}
        });
        
        return ResponseEntity.ok(awards);
    }
    
    @GetMapping("/{awardId}")
    public ResponseEntity getAllAwardListById(@PathVariable("awardId") Long awardId){
    	Optional<Award> awardOptional = this.awardService.findById(awardId);
    	Award award = null;
        if(awardOptional.isPresent()){
        	award = awardOptional.get();
        	Date date = new Date();
            //get process
          	if(award.getDeclareDate().getTime() > date.getTime()){
          		award.setProcessStatus(Constants.STATUS_PUBLISH);
          	}else if(award.getDeclareDate().getTime() <= date.getTime() && award.getFirstTrialDate().getTime() > date.getTime()){
          		award.setProcessStatus(Constants.STATUS_DECLARE);
          	}else if(award.getFirstTrialDate().getTime() <= date.getTime() && award.getRetrialDate().getTime() > date.getTime()){
          		award.setProcessStatus(Constants.STATUS_FIRSTTRIAL);
          	}else if(award.getRetrialDate().getTime() <= date.getTime()){
          		award.setProcessStatus(Constants.STATUS_RETRIAL);
          	}
          	
          	//get count
        	if(award.getDeclares()!= null){
        		award.setCount(award.getDeclares().size());;
        	}else{
        		award.setCount(0);
        	}
        	return ResponseEntity.ok(award);
        }
                
        return new ResponseEntity<String>("{\"message\":\"Award does not found.\"}", HttpStatus.NOT_FOUND);
    }
    
    
    /**
     * POST  /save : save award data
     * @param award award data to be saved
     * @return saved award data
     */
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody String strAwardInfo) {
    	AwardInfo awardInfo = JSONObject.parseObject(strAwardInfo, AwardInfo.class);
    	Award award = JSONObject.parseObject(strAwardInfo, Award.class);
    	
    	//add AwardQuota
    	if(!awardInfo.getAwardQuotaInfos().isEmpty()){
    		List<AwardQuota> lstAwardQuota = new ArrayList<AwardQuota>();
    		AwardQuota awardQuota = new AwardQuota();
    		for(AwardQuotaInfo awardQuotaInfo : awardInfo.getAwardQuotaInfos()){
    			awardQuota = new AwardQuota();
    			Optional<Reference> referenceOpt= referenceService.findById(awardQuotaInfo.getReferenceId());
    			if(referenceOpt.isPresent()){
    				awardQuota.setReference(referenceOpt.get());
    			}
    			awardQuota.setQuota(awardQuotaInfo.getQuota());
    			if(awardQuotaInfo.getId() != null){
    				awardQuota.setId(awardQuotaInfo.getId());
    			}
    			lstAwardQuota.add(awardQuota);    			
    		}
    		award.setAwardQuotas(lstAwardQuota);
    	}    	
        award = this.awardService.save(award);
        return ResponseEntity.ok(award);
    }

    /**
     * POST  /delete : delete award data by id
     * @param id award id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/delete")
    public ResponseEntity delete(long id) {
        this.awardService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
