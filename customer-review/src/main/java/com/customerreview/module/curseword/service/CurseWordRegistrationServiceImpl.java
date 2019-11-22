package com.customerreview.module.curseword.service;

import com.customerreview.module.curseword.dao.CurseWordDAO;
import com.customerreview.module.curseword.model.CurseWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurseWordRegistrationServiceImpl implements CurseWordRegistrationService {
    @Autowired
    CurseWordDAO curseWordDAO;

    @Override
    public CurseWord addWord(String s) {
        return curseWordDAO.save(new CurseWord(s));
    }

    @Override
    public void deleteWord(CurseWord s) {
            curseWordDAO.delete(s);
    }

    @Override
    public void updateWord(CurseWord word, String newWord) {
        Optional<CurseWord> theWord = curseWordDAO.findById(word.getId());
        if(!theWord.isPresent())
            throw new NotFoundException("No word entry found : " + word);
        theWord.get().setWord(newWord);
        word = curseWordDAO.save(theWord.get());
    }

    @Override
    public List<CurseWord> getAllWords() {
        return (List<CurseWord>) curseWordDAO.findAll();
    }

    @Override
    public void addWords(List<CurseWord> words) {
        curseWordDAO.saveAll(words);
    }
}
