package com.rxtracker.prescription.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.rxtracker.common.TestConstants;
import com.rxtracker.prescription.dao.PrescriptionDailyLogRepository;
import com.rxtracker.prescription.dao.PrescriptionRepository;
import com.rxtracker.prescription.data.Prescription;
import com.rxtracker.prescription.data.PrescriptionDailyLogEntry;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =WebEnvironment.RANDOM_PORT)
public class PrescriptionControllerIT {

	@Autowired
	TestRestTemplate template;
	
	@Autowired
	PrescriptionRepository rxRepository;
	
	@Autowired
	PrescriptionDailyLogRepository rxEntryRepository;
	
	/*
	 * @Autowired GlucoMonitorRepository monitorRepository;
	 */
	
	
	List<Prescription> rxDummyList;
	
	List<PrescriptionDailyLogEntry> rxDummyEntryList;
	
//	List<GlucoMonitorEntry> monitorDummyEntryList;

	@Mock
	Prescription rx;
	
	@Mock
	PrescriptionDailyLogEntry rxEntry;
	
	@Before
	public void setup() {
	}
	
	
	@Test
	public void testRegisterPrescription() {
		ResponseEntity<Long> response = template.postForEntity(TestConstants.PRESCRIPTION_URL, 
				new HttpEntity<Prescription>(new HttpHeaders()), Long.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody().longValue(),is(notNullValue()));
	}
	
	@Test
	public void testUpdatePrescription() {
		ResponseEntity<Long> response = template.exchange(TestConstants.PRESCRIPTION_URL, HttpMethod.PUT,
				new HttpEntity<Prescription>(new HttpHeaders()), Long.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		Long value = response.getBody().longValue();
		assertThat(value,is(notNullValue()));
	}
	
	
	@Test
	public void testDeletePrescription() {
		ResponseEntity<Long> response = template.exchange(TestConstants.PRESCRIPTION_URL, HttpMethod.DELETE,
				new HttpEntity<Prescription>(new HttpHeaders()), Long.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		Long value = response.getBody().longValue();
		assertThat(value,is(notNullValue()));
	}
	
	@Test
	public void testGetPrescription() {
		ResponseEntity<Prescription> response = template.getForEntity(TestConstants.PRESCRIPTION_URL + "/1" , Prescription.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		Long value = response.getBody().getPrescriptionId();
		assertThat(value,is(notNullValue()));
	}
}
