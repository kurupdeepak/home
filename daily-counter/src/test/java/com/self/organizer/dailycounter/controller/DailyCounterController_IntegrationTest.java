package com.self.organizer.dailycounter.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class DailyCounterController_IntegrationTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    int testPort;

    String BASE_URI = "/self/daily";

    String COUNTER_URL="/counter/TestCounter";

    @Test
    @Order(1)
    void test_CreateCounter() {
        ResponseEntity responseEntity = testRestTemplate.postForEntity("http://localhost:"+testPort + BASE_URI + COUNTER_URL,null,null);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @Order(2)
    void test_CreateEntry() {
        MultiValueMap<String, Integer> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("value",5);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        HttpEntity<MultiValueMap<String,Integer>> payload = new HttpEntity<>(requestMap,headers);
        HttpEntity<MultiValueMap<String,Integer>> payload = new HttpEntity<>(requestMap);

        ResponseEntity entryResponse = testRestTemplate.postForEntity("http://localhost:"+testPort + BASE_URI  + COUNTER_URL + "/entries",payload,String.class);
        assertThat(entryResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @Order(3)
    void test_GetEntriesStatus() {
        ResponseEntity<EntryList> responseEntity = testRestTemplate.getForEntity("http://localhost:"+testPort + BASE_URI  + COUNTER_URL + "/entries", EntryList.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @Order(4)
    void test_GetEntriesSize() {
        ResponseEntity<EntryList> responseEntity = testRestTemplate.getForEntity("http://localhost:"+testPort + BASE_URI  + COUNTER_URL + "/entries", EntryList.class);
        assertThat(responseEntity.getBody().entryList).hasSize(1);
    }

}