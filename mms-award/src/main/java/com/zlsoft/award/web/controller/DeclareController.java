package com.zlsoft.award.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.zlsoft.award.domain.Declare;
import com.zlsoft.award.model.DeclareInfo;
import com.zlsoft.award.service.AwardService;
import com.zlsoft.award.service.DeclareService;
import com.zlsoft.common.web.controller.BaseController;

@Controller
@RequestMapping("/declare")
public class DeclareController extends BaseController {

    
    @Autowired
	private DeclareService declareService;
    
    @Autowired
	private AwardService awardService;	
    	
    @GetMapping("/page/{page}")
    public ResponseEntity getDeclareList(@PathVariable("page") int page, String name, Integer pageSize, Integer status){
    	Specification<Declare> specification = (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			if(!StringUtils.isEmpty(name)){
				Join<Award, Declare> join = root.join("award", JoinType.INNER);
				predicates.add(cb.like(join.get("name"), "%"+name+"%"));
			}
			if(status != null && status != 0){
				predicates.add(cb.equal(root.get("status").as(Integer.class), status));
			}
			
			query.where(cb.and(predicates.stream().toArray(Predicate[]::new)));
            return query.getRestriction();
		};
    	if(pageSize == null || pageSize <= 0){
			pageSize = Constants.PAGE_SIZE;
		}
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Declare> declares = this.declareService.findAll(specification, pageRequest);
        List<DeclareInfo> lstDeclareInfo = new ArrayList<DeclareInfo>();
        DeclareInfo declareInfo = new DeclareInfo();
        for(Declare declare : declares.getContent()){
        	declareInfo = new DeclareInfo();
        	declareInfo.setId(declare.getId());
        	declareInfo.setStatus(declare.getStatus());
        	declareInfo.setAwardId(declare.getAward().getId());
        	declareInfo.setCategory(declare.getAward().getCategory());
        	declareInfo.setContent(declare.getAward().getContent());
        	declareInfo.setDeclareDate(declare.getAward().getDeclareDate());
        	declareInfo.setMajor(declare.getAward().getMajor());
        	declareInfo.setName(declare.getAward().getName());
        	lstDeclareInfo.add(declareInfo);
        }
        return ResponseEntity.ok(lstDeclareInfo);
    }
    /**
     * POST  /save : save declare data
     * @param reference data to be saved
     * @return saved reference data
     */
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody String declareInfo) {
    	if(StringUtils.isEmpty(declareInfo)){
    		return new ResponseEntity<String>("{\"message\":\"declare is null.\"}", HttpStatus.NOT_FOUND);
    	}

    	Map<String, Object> mapDeclare = JSONObject.parseObject(declareInfo, Map.class);
    	Declare declare = new Declare();
    	if(mapDeclare.containsKey("declareId")){
    		Long declareId = Long.parseLong(mapDeclare.get("declareId").toString());
    		Optional<Declare> declareOpt = declareService.findById(declareId);
    		if(declareOpt.isPresent()){
    			declare = declareOpt.get();
    		}
    	}
    	
    	if(mapDeclare.containsKey("awardId")){
    		Long awardId = Long.parseLong(mapDeclare.get("awardId").toString());
    		Optional<Award> awardOption = awardService.findById(awardId);
    		if(awardOption.isPresent()){    			
    			declare.setAward(awardOption.get());
    			Integer status = Integer.parseInt(mapDeclare.get("status").toString());
    			declare.setStatus(status);
    			declare = declareService.save(declare);
    		}
    	}
    	
        return ResponseEntity.ok(declare);
    }

   /**
    * delete declare data by id
    * @param id
    * @return
    */
    @PostMapping("/delete")
    public ResponseEntity delete(long id) {
        this.declareService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
