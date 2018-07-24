package com.zlsoft.manager.web.controller;

import com.zlsoft.common.service.MeetingPaperService;
import com.zlsoft.common.service.PaperAuditService;
import com.zlsoft.common.web.controller.BaseController;
import com.zlsoft.domain.MeetingPaper;
import com.zlsoft.domain.PaperAudit;
import com.zlsoft.manager.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Optional;

@Controller("AdminPaperController")
@RequestMapping("/admin/meeting/paper")
public class PaperController extends BaseController {

    @Inject
    private MeetingPaperService meetingPaperService;

    @Inject
    private PaperAuditService paperAuditService;

    /**
     * GET  / : get meeting paper list page
     * @return meeting paper list page
     */
    @GetMapping
    public String getPage() {
        return "/admin/meeting/paper";
    }

    /**
     * GET  /page/{page} : get data of meetings' papers by page
     * @param page zero-based page index
     * @return data of meetings; papers by page
     */
    @GetMapping("/page/{page}")
    public @ResponseBody ResponseEntity getPapers(@PathVariable("page") int page){

        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<MeetingPaper> enrollments = this.meetingPaperService.findAll(pageRequest);

        return ResponseEntity.ok(enrollments);
    }

    /**
     * GET  /detail : get details of meeting paper
     * @param id meeting paper id
     * @return meeting paper data
     */
    @GetMapping("/details")
    public @ResponseBody ResponseEntity getMeetingPaper(long id){
        Optional<MeetingPaper> enrollment = this.meetingPaperService.findById(id);
        return ResponseEntity.ok(enrollment);
    }

    /**
     * POST  /delete : delete meeting paper by id
     * @param id meeting paper id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/delete")
    public @ResponseBody ResponseEntity delete(long id) {
        this.meetingPaperService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * POST  /audit : audit the meeting paper
     * @param audit paper audit info
     * @return saved paper audit info
     */
    @PostMapping("/audit")
    public @ResponseBody ResponseEntity audit(PaperAudit audit){

        Optional<PaperAudit> auditInDB = this.paperAuditService.findById(audit.getPaperId());
        PaperAudit paperAudit;

        if(auditInDB.isPresent()){
            paperAudit = auditInDB.get();
        } else {
            paperAudit = new PaperAudit();
            paperAudit.setPaperId(audit.getPaperId());
        }

        paperAudit.setPaperAudit(audit.getPaperAudit());
        paperAudit.setPaperResult(audit.getPaperResult());
        paperAudit.setSpeechAudit(audit.getSpeechAudit());
        paperAudit.setSpeechResult(audit.getSpeechResult());

        paperAudit = this.paperAuditService.save(paperAudit);

        return ResponseEntity.ok(paperAudit);
    }
}
