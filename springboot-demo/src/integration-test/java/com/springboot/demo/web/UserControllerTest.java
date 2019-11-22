package com.springboot.demo.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.dao.UserRepository;
import com.springboot.demo.data.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@WebMvcTest
@SpringBootTest
public class UserControllerTest {
/*
    @Autowired
    private MockMvc mockMvc;
*/

//    @MockBean
    @Autowired
    UserRepository userRepository;

    @Autowired
    TestRestTemplate testRestTemplate;

    private static final String HOST_URL = "http://localhost:8080/";

    public void setup(){

    }

    @Test
    public void testGet() throws Exception {
        User user = createUserObject();
        testRestTemplate.getForObject(HOST_URL + "/")
        /*mockMvc.perform(get("/users/1")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(user)));*/
    }

    @Test
    public void update() {
    }

    @Test
    public void create() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void patch() {
    }

    private User createUserObject(){
        User user = new User();
        user.setName("Donald Trump");
        user.setEmail("donald.trump@users.com");
        return userRepository.save(user);
    }
}