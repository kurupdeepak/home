package com.common.service;

import java.util.List;

public interface CurseWordRegistrationService {
    int addWord();
    int deleteWord();
    int updateWord(String word,String newWord);
    List<String> getAllWords();
}
