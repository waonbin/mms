package com.zlsoft.portal.web.controller;

import com.zlsoft.common.service.AdministrativeDivisionService;
import com.zlsoft.common.web.controller.BaseController;
import com.zlsoft.domain.AdministrativeDivision;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/division")
public class DivisionController extends BaseController {

    @Inject
    private AdministrativeDivisionService administrativeDivisionService;

    /**
     * GET  /data : get administrative division data
     * @return administrative division data
     */
    @GetMapping("/data")
    public @ResponseBody ResponseEntity getDivisions(){
        List<AdministrativeDivision> divisions = this.administrativeDivisionService.findAll();
        return ResponseEntity.ok(divisions);
    }
}
