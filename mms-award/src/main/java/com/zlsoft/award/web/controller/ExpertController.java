package com.zlsoft.award.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.zlsoft.award.Constants;
import com.zlsoft.award.domain.Expert;
import com.zlsoft.award.service.ExpertService;
import com.zlsoft.common.web.controller.BaseController;

@Controller
@RequestMapping("/expert")
public class ExpertController extends BaseController {

    
    @Autowired
	private ExpertService expertService;
	
    @GetMapping("/page/{page}")
    public ResponseEntity getReferences(@PathVariable("page") int page, Integer pageSize){
    	if(pageSize == null || pageSize <= 0){
			pageSize = Constants.PAGE_SIZE;
		}
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Expert> references = this.expertService.findAll(pageRequest);
        return ResponseEntity.ok(references);
    }
	
    /**
     * POST  /save : save reference data
     * @param reference data to be saved
     * @return saved reference data
     */
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody String expertInfo) {
    	if(StringUtils.isEmpty(expertInfo)){
    		return ResponseEntity.badRequest().body("expert is null");
    	}
    	Expert expert = JSONObject.parseObject(expertInfo, Expert.class);
    	expert = this.expertService.save(expert);
        return ResponseEntity.ok(expert);
    }

   /**
    * delete reference data by id
    * @param id
    * @return
    */
    @PostMapping("/delete")
    public ResponseEntity delete(long id) {
        this.expertService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
