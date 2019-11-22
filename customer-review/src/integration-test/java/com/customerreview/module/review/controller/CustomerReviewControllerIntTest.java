package com.customerreview.module.review.controller;

import com.customerreview.module.review.rules.CustomerCommentsCheckForCurseWordsRule;
import com.customerreview.module.review.rules.CustomerRatingZeroCheckRule;
import com.customerreview.module.review.rules.CustomerReviewRule;
import com.customerreview.module.review.service.CustomerReviewService;
import com.customerreview.module.review.service.CustomerReviewServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CustomerReviewControllerIntTest
{
    @Autowired
    MockMvc mockMvc;

    private String pid;

    private String cid;

    @TestConfiguration
    static class CustomerReviewServiceImplTestContextConfiguration {
       @Bean
        public List<CustomerReviewRule> rulesToCheck(){
            return Arrays.asList(zeroRatingCheck(),curseWordCheck());
        }

        @Bean
        public CustomerReviewRule zeroRatingCheck(){
            return new CustomerRatingZeroCheckRule();
        }

        @Bean
        public CustomerReviewRule curseWordCheck(){
            return new CustomerCommentsCheckForCurseWordsRule();
        }
    }

    @Before
    public void setup() throws Exception {
           cid = createCustomer();
           pid = createProduct();
           createCurseWords();
           System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + cid + " and product " + pid);
    }

    private String createCustomer() throws Exception {
            MvcResult result = mockMvc.perform(post("/customer")
                    .contentType("application/json")
                    .accept("application/json")
                    .content("{\"name\":\"Geremy\"}"))
                    .andExpect(status().isOk())
                    .andReturn();

            return result.getResponse().getContentAsString();
    }

    private String createProduct() throws Exception {
        MvcResult result = mockMvc.perform(post("/product")
                .contentType("application/json")
                .accept("application/json")
                .content("{\"name\":\"IPhone 11\"}"))
                .andExpect(status().isOk())
                .andReturn();
        return result.getResponse().getContentAsString();
    }

    public void createCurseWords() throws Exception {
        mockMvc.perform(post("/curseword")
                .contentType("application/json")
                .accept("application/json")
                .content("[\"Fcuk\",\"Shit\",\"Asshole\"]"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSuccessfulCustomerReview() throws Exception {
        mockMvc.perform(post("/customer/"+cid+"/review/product/"+pid)
                .contentType("application/json")
                .accept("application/json")
                .content("{\n" +
                        "\t\"comments\":\"Hello its a cool product\",\n" +
                        "\t\"rating\":\"4\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCurseWordsInCustomerReview() throws Exception {
        mockMvc.perform(post("/customer/"+cid+"/review/product/"+pid)
                .contentType("application/json")
                .accept("application/json")
                .content("{\n" +
                        "\t\"comments\":\"Hello its a shit product\",\n" +
                        "\t\"rating\":\"0\"\n" +
                        "}"))
                .andExpect(status().isBadRequest());
    }



    @Test
    public void testRatingNonZeroOrNonNegativeInCustomerReview() throws Exception {
        mockMvc.perform(post("/customer/"+cid+"/review/product/"+pid)
                .contentType("application/json")
                .accept("application/json")
                .content("{\n" +
                        "\t\"comments\":\"I didnt like it\",\n" +
                        "\t\"rating\":\"0\"\n" +
                        "}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCustomerReview4ProductInRange() throws Exception {
        mockMvc.perform(post("/customer/"+cid+"/review/product/"+pid)
                .contentType("application/json")
                .accept("application/json")
                .content("{\n" +
                        "\t\"comments\":\"Hello its a cool product\",\n" +
                        "\t\"rating\":\"4\"\n" +
                        "}"))
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(get("/customer/review/product/"+pid+"/rating/1/5"))
                .andExpect(status().isOk())
                .andReturn();
        JSONAssert.assertEquals(" [{\"reviewId\":6,\"productId\":{\"productId\":2,\"productName\":\"{\\\"name\\\":\\\"IPhone 11\\\"}\"},\"customerId\":{\"customerId\":1,\"name\":\"{\\\"name\\\":\\\"Geremy\\\"}\"},\"comments\":\"Hello its a cool product\",\"rating\":4}]",result.toString(),false);
    }
}
