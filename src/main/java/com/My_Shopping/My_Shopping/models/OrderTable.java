package com.My_Shopping.My_Shopping.models;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;
import java.util.UUID;

@Entity
public class OrderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID orderid;
    int toalprice;
    int totalQuantity;

    @ManyToOne
    AppUser appUser;

 @OneToMany//(mappedBy = "orderid", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Product> products;
    String status;
    String paymentmode;

    public OrderTable(UUID orderid, int toalprice, int totalQuantity, AppUser appUser, List<Product> products, String status, String paymentmode) {
        this.orderid = orderid;
        this.toalprice = toalprice;
        this.totalQuantity = totalQuantity;
        this.appUser = appUser;
        this.products = products;
        this.status = status;
        this.paymentmode = paymentmode;
    }

    public OrderTable() {
    }

    public UUID getOrderid() {
        return orderid;
    }

    public void setOrderid(UUID orderid) {
        this.orderid = orderid;
    }

    public int getToalprice() {
        return toalprice;
    }

    public void setToalprice(int toalprice) {
        this.toalprice = toalprice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }
}
