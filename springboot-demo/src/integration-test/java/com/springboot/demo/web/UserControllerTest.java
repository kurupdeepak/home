package com.springboot.demo.web;

import com.springboot.demo.data.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
/*
    @Autowired
    private MockMvc mockMvc;
*/

//    @MockBean
    @LocalServerPort
    int TEST_PORT;

    @Autowired
    UserService userService;

    @Autowired
    TestRestTemplate testRestTemplate;

    private final String HOST_URL = "http://localhost" ;

    public void setup(){

    }

    @Test
    public void testGet() throws Exception {
        User user = createUserObject();
        User u = testRestTemplate.getForObject(HOST_URL + ":" + TEST_PORT+"/users/"+user.getId(),User.class);
        assertThat(user).isEqualToComparingFieldByField(u);
//        org.hamcrest.MatcherAssert.assertThat(user, equalTo(u));
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
        return userService.create(user);
    }
}