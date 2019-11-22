package com.customerreview.model;

import com.customer.model.Customer;
import com.product.model.Product;

public class CustomerReview {

    int reviewId;

    Product productId;

    Customer customerId;

    String comments;

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
}
