package com.zlsoft.award.web.rest;

import com.zlsoft.award.Constants;
import com.zlsoft.award.domain.Award;
import com.zlsoft.award.service.AwardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/award/awards")
public class AwardResource {

//    @Inject
//    private AwardService awardService;
//
//    /**
//     * GET  /page/{page} : get data of award by page
//     * @param page zero-based page index
//     * @return data of awards by page
//     */
//    @GetMapping("/page/{page}")
//    public ResponseEntity getMeetings(@PathVariable("page") int page){
//        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
//        Page<Award> awards = this.awardService.findAll(pageRequest);
//        return ResponseEntity.ok(awards);
//    }
//
//    /**
//     * POST  /save : save award data
//     * @param award award data to be saved
//     * @return saved award data
//     */
//    @PostMapping("/save")
//    public ResponseEntity save(Award award) {
//        award = this.awardService.save(award);
//        return ResponseEntity.ok(award);
//    }
//
//    /**
//     * POST  /delete : delete award data by id
//     * @param id award id
//     * @return HTTP status to figure if operation is successful
//     */
//    @PostMapping("/delete")
//    public ResponseEntity delete(long id) {
//        this.awardService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
}
