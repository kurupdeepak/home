package com.customerreview.module.review.dao;

import com.customerreview.module.customer.dao.CustomerDAO;
import com.customerreview.module.customer.model.Customer;
import com.customerreview.module.product.dao.ProductDAO;
import com.customerreview.module.product.model.Product;
import com.customerreview.module.review.model.CustomerReview;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerReviewDAOTest {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    CustomerReviewDAO customerReviewDAO;

    private List<Product> products;

    private List<Customer> customers;

    @Test
    public void testGetReviewsForProductInRange(){
        List<CustomerReview> results = customerReviewDAO.findReviewsForProduct(products.stream().findFirst().get(),1,5);
        //Add check for product id
        // Add check for the rating between given range
        results.stream().forEach(cr ->{
            Assert.assertEquals(products.stream().findFirst().get(),cr.getProductId());
            Assert.assertTrue((cr.getRating() >= 1 || cr.getRating() <= 5 ));
        });
    }

    @Before
    public void createReviews() {
        Random r = new Random();
        createProducts();
        createCustomers();
        customers.forEach(c1 ->{
                    CustomerReview review = new CustomerReview();
                    review.setComments("Product is really good!!");
                    review.setCustomerId(c1);
                    review.setProductId(products.stream().findFirst().get());
                    review.setRating(Math.abs(r.nextInt() % 10 )) ;
                    customerReviewDAO.save(review);
                }
        );
    }

    private void createProducts(){
        products = new ArrayList<>();
        products.add(productDAO.save(new Product("Latte")));
        products.add(productDAO.save(new Product("Capaccino")));
    }

    private void createCustomers(){
        customers = new ArrayList<>();
        customers.add(customerDAO.save(new Customer("John")));
        customers.add(customerDAO.save(new Customer("Tom")));
        customers.add(customerDAO.save(new Customer("Tim")));
        customers.add(customerDAO.save(new Customer("Roney")));
        customers.add(customerDAO.save(new Customer("Jeremy")));
    }
}
