package com.customerreview.module.curseword.model;

import javax.persistence.*;

@Entity
public class CurseWord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String word;

    public CurseWord(){}

    public CurseWord(String s) {
        this.word = s;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
