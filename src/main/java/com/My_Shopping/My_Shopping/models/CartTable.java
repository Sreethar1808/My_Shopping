package com.My_Shopping.My_Shopping.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class CartTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    int quantity;
    @OneToOne
    AppUser appUser;
    int totalprice;

    @OneToMany
    List<Product> productList;

    public CartTable(UUID id, int quantity, AppUser appUser, int totalprice, List<Product> productList) {
        this.id = id;
        this.quantity = quantity;
        this.appUser = appUser;
        this.totalprice = totalprice;
        this.productList = productList;
    }

    public CartTable() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
