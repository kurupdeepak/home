package com.customerreview.module.common.service;

import com.customerreview.module.common.model.CurseWord;

import java.util.List;

public interface CurseWordRegistrationService {
    CurseWord addWord(String s);
    void deleteWord(CurseWord s);
    void updateWord(CurseWord word, String newWord);
    List<CurseWord> getAllWords();
}
