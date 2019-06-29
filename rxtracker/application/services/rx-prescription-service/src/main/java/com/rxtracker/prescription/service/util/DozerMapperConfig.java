package com.rxtracker.prescription.service.util;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerMapperConfig {

	@Bean
	 public Mapper mapper() throws Exception {
	     Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	     return mapper;
	 }
}
