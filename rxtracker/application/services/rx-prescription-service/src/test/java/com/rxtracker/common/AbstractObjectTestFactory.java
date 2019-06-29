package com.rxtracker.common;

import java.util.List;
import java.util.Random;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractObjectTestFactory<T> {
	
	protected Random rg = new Random();

	@Autowired
	protected Mapper dozerMapper;

	public abstract T createTestObject();

	public abstract List<T> createTestObject(int noOfObjects);

	protected Random getRg() {
		return rg;
	}

	protected void setRg(Random rg) {
		this.rg = rg;
	}

	protected Mapper getDozerMapper() {
		return dozerMapper;
	}

	protected void setDozerMapper(Mapper dozerMapper) {
		this.dozerMapper = dozerMapper;
	}
	
	
}
