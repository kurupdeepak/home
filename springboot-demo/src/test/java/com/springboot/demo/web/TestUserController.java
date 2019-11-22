package com.springboot.demo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.data.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class TestUserController {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void testGet() throws Exception {
        User user = createTestUser();
        when(userService.get(1)).thenReturn(user);
        mockMvc.perform(get("/users/1")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(user)));

        mockMvc.perform(get("/users/1")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }

    private User createTestUser() {
        User user = new User();
        user.setId(1);
        user.setName("John McCarthy");
        user.setEmail("john.carthy@users.com");
        return user;
    }
}
