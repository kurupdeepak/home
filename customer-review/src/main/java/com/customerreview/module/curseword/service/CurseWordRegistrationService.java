package com.customerreview.module.curseword.service;

import com.customerreview.module.curseword.model.CurseWord;

import java.util.List;

public interface CurseWordRegistrationService {
    CurseWord addWord(String s);
    void deleteWord(CurseWord s);
    void updateWord(CurseWord word, String newWord);
    List<CurseWord> getAllWords();

    void addWords(List<CurseWord> words);
}
