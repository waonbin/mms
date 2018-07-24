package com.zlsoft.portal.web.controller;

import com.zlsoft.common.service.DictionaryItemService;
import com.zlsoft.common.web.controller.BaseController;
import com.zlsoft.domain.DictionaryItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController {

    @Inject
    private DictionaryItemService dictionaryItemService;

    /**
     * GET  /{dictionaryId} : get all dictionary items
     * @return dictionary items
     */
    @GetMapping()
    public @ResponseBody ResponseEntity getDictionary(){
        List<DictionaryItem> items = this.dictionaryItemService.findAll();
        return ResponseEntity.ok(items);
    }

    /**
     * GET  /{dictionaryId} : get dictionary items by dictionary id
     * @param dictionaryId dictionary id
     * @return dictionary items
     */
    @GetMapping("/{dictionaryId}")
    public @ResponseBody ResponseEntity getDictionary(@PathVariable("dictionaryId") long dictionaryId){
        List<DictionaryItem> items = this.dictionaryItemService.findByDictionaryId(dictionaryId);
        return ResponseEntity.ok(items);
    }
}
