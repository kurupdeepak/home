package com.customerreview.module.curseword.dao;

import com.customerreview.module.curseword.model.CurseWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CurseWordDAO extends CrudRepository<CurseWord,Integer> {

}

