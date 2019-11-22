package com.customerreview.module.review.controller;

import com.customerreview.module.customer.model.Customer;
import com.customerreview.module.product.model.Product;
import com.customerreview.module.review.model.CustomerReview;
import com.customerreview.module.review.service.CustomerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerReviewController {
    @Autowired
    CustomerReviewService customerReviewService;

    @PostMapping("/customer/{cid}/review/product/{pid}")
    public void addReview(@PathVariable int cid, @PathVariable int pid, @RequestBody CustomerReview review) {
        Product p = new Product();
        p.setProductId(pid);
        Customer c = new Customer();
        c.setCustomerId(cid);
        review.setProductId(p);
        review.setCustomerId(c);
        customerReviewService.addReview(review);
    }

    @PostMapping("/customer/{cid}/review")
    public List<CustomerReview> getReview(@PathVariable int cid) {
        return customerReviewService.getReview(cid);
    }

    @GetMapping("/customer/review/product/{pid}/rating/{min}/{max}")
    public List<CustomerReview> getReviewsInRange(@PathVariable int pid, @PathVariable int min, @PathVariable int max) {
        return customerReviewService.getProductReviewInRange(pid, min, max);
    }
}
