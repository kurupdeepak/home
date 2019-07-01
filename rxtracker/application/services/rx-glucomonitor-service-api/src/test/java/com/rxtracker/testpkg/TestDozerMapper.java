package com.rxtracker.testpkg;

import java.time.LocalDateTime;

import com.github.dozermapper.core.CustomConverter;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class TestDozerMapper {

	Mapper dozerMapr;
	
	public static void main(String a[]) {
//		SpringApplication.run(GlucomonitorServiceApiApplication.class, a);
		Mapper mapper = DozerBeanMapperBuilder.create().withCustomConverter(new CustomConverter() {

			@Override
			public Object convert(Object destFldVal, Object srcFldVal,
					Class<?> destinationClass, Class<?> sourceClass) {
				if(destFldVal instanceof LocalDateTime) {
					if(srcFldVal == null) {
						return srcFldVal;
					}else
						destFldVal = srcFldVal;
				}
				
				return null;
			}
			
		}).build();
		DateValue2 obj = mapper.map(new DateValue(LocalDateTime.now()), DateValue2.class);
		System.out.println(obj);
	}
}

class DateValue{
	LocalDateTime dateTime;

	public DateValue(LocalDateTime now) {
		this.dateTime = now;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}

class DateValue2{
	LocalDateTime dateTime;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "DateValue2 [dateTime=" + dateTime + "]";
	}
	
	
	
}
