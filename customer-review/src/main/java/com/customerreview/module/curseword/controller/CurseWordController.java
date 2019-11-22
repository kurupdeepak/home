package com.customerreview.module.curseword.controller;

import com.customerreview.module.curseword.model.CurseWord;
import com.customerreview.module.curseword.service.CurseWordRegistrationService;
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
