package com.customerreview.module.common.controller;

import com.customerreview.module.common.model.CurseWord;
import com.customerreview.module.common.service.CurseWordRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CurseWordController {
    @Autowired
    CurseWordRegistrationService curseWordRegistrationService;

    @PostMapping("/curseword")
    public void addWords(@RequestBody List<CurseWord> words){
        curseWordRegistrationService.addWords(words);
    }

    @DeleteMapping("/curseword/{word}")
    public void deleteWord(@PathVariable String word){
        curseWordRegistrationService.deleteWord(new CurseWord(word));
    }

}
