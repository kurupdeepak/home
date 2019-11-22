package com.customerreview.module.review.service;

import com.customerreview.module.common.dao.CurseWordDAO;
import com.customerreview.module.common.model.CurseWord;
import com.customerreview.module.customer.model.Customer;
import com.customerreview.module.product.model.Product;
import com.customerreview.module.review.dao.CustomerReviewDAO;
import com.customerreview.module.review.model.CustomerReview;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
public class CustomerReviewServiceImplTest {

    @Autowired
    CustomerReviewServiceImpl customerReviewService;

    @MockBean
    CustomerReviewDAO customerReviewDAO;

    @MockBean
    CurseWordDAO curseWordDAO;

    @Before
    public void setup(){
    }

    @Test
    public void testAddReviewSuccess() {
        Product p = new Product("Starbucks Cafe Latte");
        p.setProductId(1);
        Customer c = new Customer("Tom");
        c.setCustomerId(10);
        /*List<Customer> custList = Arrays.asList(new Customer("John"),
                new Customer("Tom"),
                new Customer("Ronald"));*/

        Mockito.when(curseWordDAO.findAll()).thenReturn(Arrays.asList(new CurseWord("Fcuk"),
                new CurseWord("Shit"),
                new CurseWord("Duck")));

        CustomerReview review = new CustomerReview();
        review.setComments("Product is really cool!!");
        review.setCustomerId(c);
        review.setProductId(p);
        review.setRating(4);
        review.setReviewId(90);
        Mockito.when(customerReviewDAO.save(Mockito.any(CustomerReview.class))).thenReturn(review);

        customerReviewService.addReview(review);
    }

    @Test
    public void testAddReviewFailureOnCurseWords() {
        Product p = new Product("Starbucks Cafe Latte");
        p.setProductId(1);
        Customer c = new Customer("Tom");
        c.setCustomerId(10);
        /*List<Customer> custList = Arrays.asList(new Customer("John"),
                new Customer("Tom"),
                new Customer("Ronald"));*/

        Mockito.when(curseWordDAO.findAll()).thenReturn(Arrays.asList(new CurseWord("Fcuk"),
                new CurseWord("Shit"),
                new CurseWord("Duck")));

        CustomerReview review = new CustomerReview();
        review.setComments("Product is really Fcuk ng bad!!");
        review.setCustomerId(c);
        review.setProductId(p);
        review.setRating(4);
        review.setReviewId(90);
        Mockito.when(customerReviewDAO.save(Mockito.any(CustomerReview.class))).thenReturn(review);

        customerReviewService.addReview(review);
    }

    @Test
    public void testAddReviewFailureOnZeroRating() {
        Product p = new Product("Starbucks Cafe Latte");
        p.setProductId(1);
        Customer c = new Customer("Tom");
        c.setCustomerId(10);
        /*List<Customer> custList = Arrays.asList(new Customer("John"),
                new Customer("Tom"),
                new Customer("Ronald"));*/

        Mockito.when(curseWordDAO.findAll()).thenReturn(Arrays.asList(new CurseWord("Fcuk"),
                new CurseWord("Shit"),
                new CurseWord("Duck")));

        CustomerReview review = new CustomerReview();
        review.setComments("Product is really good!!");
        review.setCustomerId(c);
        review.setProductId(p);
        review.setRating(0);
        review.setReviewId(90);
        Mockito.when(customerReviewDAO.save(Mockito.any(CustomerReview.class))).thenReturn(review);

        customerReviewService.addReview(review);
    }

    @Test
    public void getProductReviewInRange() {
    }
}
