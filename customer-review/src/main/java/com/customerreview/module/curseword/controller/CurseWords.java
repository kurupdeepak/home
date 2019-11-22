package com.customerreview.module.common.controller;

import com.customerreview.module.common.model.CurseWord;

import java.util.List;

public class CurseWords {
    List<CurseWord> curseWordList;

    public List<CurseWord> getCurseWordList() {
        return curseWordList;
    }

    public void setCurseWordList(List<CurseWord> curseWordList) {
        this.curseWordList = curseWordList;
    }
}
