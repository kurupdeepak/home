package com.customerreview.module.common.dao;

import com.customerreview.module.common.model.CurseWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CurseWordDAO extends CrudRepository<CurseWord,Integer> {

}

