package com.rxtracker.glucomonitor.controller;

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

import com.rxtracker.common.AbstractObjectTestFactory;
import com.rxtracker.common.TestConstants;
import com.rxtracker.glucomonitor.data.GlucoMonitorEntryVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =WebEnvironment.RANDOM_PORT)
public class GlucoMonitorControllerIT {

	@Autowired
	protected TestRestTemplate template;
	
	@Autowired
	protected AbstractObjectTestFactory<GlucoMonitorEntryVO> factory;

	 
	protected List<GlucoMonitorEntryVO> monitorDummyList;

	@Mock
	GlucoMonitorEntryVO monitorEntry;
	
	@Before
	public void setup() {
		createDummyEntries();
	}
	
	
	private void createDummyEntries() {
		monitorDummyList = factory.createTestObject(3);
	}


	@Test
	public void testRegisterGlucoMonitorEntry() {
		
		GlucoMonitorEntryVO obj = monitorDummyList.stream().findAny().get();
		obj.setEntryId(null);

		ResponseEntity<Long> response = template.postForEntity(TestConstants.GLUCO_MONITOR_URL, 
				new HttpEntity<GlucoMonitorEntryVO>(obj,new HttpHeaders()), Long.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody().longValue(),is(notNullValue()));
	}
	
	@Test
	public void testUpdateGlucoMonitorEntry() {
		GlucoMonitorEntryVO obj = monitorDummyList.stream().findAny().get();
		obj.setLevelEntered(6.5f);
		ResponseEntity<Long> response = template.exchange(TestConstants.GLUCO_MONITOR_URL + "/" + obj.getEntryId(), HttpMethod.PUT,
				new HttpEntity<>(obj,new HttpHeaders()), Long.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		Long value = response.getBody().longValue();
		assertThat(value,is(obj.getEntryId()));
	}
	
	
	@Test
	public void testDeleteGlucoMonitorEntry() {
		GlucoMonitorEntryVO obj = monitorDummyList.stream().findAny().get();
		
		ResponseEntity<Long> response = template.exchange(TestConstants.GLUCO_MONITOR_URL + "/" + obj.getEntryId(), HttpMethod.DELETE,
				new HttpEntity<>(new HttpHeaders()), Long.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		Long value = response.getBody().longValue();
		assertThat(value,is(obj.getEntryId()));
	}
	
	@Test
	public void testGetGlucoMonitorEntry() {
		GlucoMonitorEntryVO obj = monitorDummyList.stream().findAny().get();
		
		ResponseEntity<GlucoMonitorEntryVO> response = template.getForEntity(TestConstants.GLUCO_MONITOR_URL + "/" + obj.getEntryId(), GlucoMonitorEntryVO.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		Long value = response.getBody().getEntryId();
		assertThat(value,is(obj.getEntryId()));
	}
}
