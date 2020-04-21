package com.self.organizer.dailycounter.controller;

import com.self.organizer.dailycounter.service.DailyCounterServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class DailyCounterControllerMockTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DailyCounterServiceImpl dailyCounterService;

    @Test
    void test_CreateCounter() throws Exception {
        mockMvc.perform(post("/self/daily/counter/MockCounter")).andExpect(status().isCreated());
    }

    @Test
    void test_CreateEntry() throws Exception {
        mockMvc.perform(post("/self/daily/counter/MockCounter/entries")
                .param("value","12"))
                .andExpect(status().isCreated());
    }

    @Test
    void test_GetEntries() throws Exception {
        mockMvc.perform(get("/self/daily/counter/MockCounter/entries"))
                .andExpect(status().isOk());
    }

    @Test
    void test_GetCounters() throws Exception {
        mockMvc.perform(get("/self/daily/counter"))
                .andExpect(status().isOk());
    }
}