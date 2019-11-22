package com.customerreview.module.review.model;

import com.customerreview.module.customer.model.Customer;
import com.customerreview.module.product.model.Product;

import javax.persistence.*;

@Entity
public class CustomerReview {
    @Id
    @GeneratedValue
    int reviewId;

    @OneToOne
    @JoinColumn
    Product productId;

    @OneToOne
    @JoinColumn
    Customer customerId;

    @Column
    String comments;

    @Column
    int rating;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Customer getCustomerId() {
        return customerId;
    }
}
