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
import com.rxtracker.glucomonitor.data.GlucoMonitorEntryVO;
import com.rxtracker.prescription.dao.PrescriptionDailyLogRepository;
import com.rxtracker.prescription.dao.PrescriptionRepository;
import com.rxtracker.prescription.data.Prescription;
import com.rxtracker.prescription.data.PrescriptionDailyLogEntry;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =WebEnvironment.RANDOM_PORT)
public class PrescriptionDailyLogControllerIT {

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
	
	@Mock
	GlucoMonitorEntryVO monitorEntry;
	
	@Before
	public void setup() {
	}
	
	
	private void createDummyEntries() {
		rxDummyList = rxRepository.findAll();
		rxDummyEntryList = rxEntryRepository.findAll();
//		monitorDummyEntryList = monitorRepository.findAll();
	}


	@Test
	public void testRegisterPrescriptionDailyEntry() {
		ResponseEntity<Long> response = template.postForEntity(TestConstants.PRESCRIPTION_DAILY_LOG_URL, 
				new HttpEntity<Prescription>(new HttpHeaders()), Long.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody().longValue(),is(notNullValue()));
	}
	
	@Test
	public void testUpdatePrescriptionDailyEntry() {
		ResponseEntity<Long> response = template.exchange(TestConstants.PRESCRIPTION_DAILY_LOG_URL + "/1", HttpMethod.PUT,
				new HttpEntity<Prescription>(new HttpHeaders()), Long.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		Long value = response.getBody().longValue();
		assertThat(value,is(notNullValue()));
	}
	
	
	@Test
	public void testDeletePrescriptionDailyEntry() {
		ResponseEntity<Long> response = template.exchange(TestConstants.PRESCRIPTION_DAILY_LOG_URL  + "/1", HttpMethod.DELETE,
				new HttpEntity<Prescription>(new HttpHeaders()), Long.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		Long value = response.getBody().longValue();
		assertThat(value,is(notNullValue()));
	}
	
	@Test
	public void testGetPrescriptionDailyEntry() {
		ResponseEntity<Prescription> response = template.getForEntity(TestConstants.PRESCRIPTION_DAILY_LOG_URL + "/1" , Prescription.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		Long value = response.getBody().getPrescriptionId();
		assertThat(value,is(notNullValue()));
	}
}
