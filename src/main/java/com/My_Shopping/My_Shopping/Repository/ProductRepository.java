package com.My_Shopping.My_Shopping.Repository;

import com.My_Shopping.My_Shopping.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value ="select * from product where category =:category and name =:product", nativeQuery = true)
    public List<Product> getProduvtByCategoryandName(String category, String product);

    @Query(value ="select * from product where category =:category", nativeQuery = true)
    public List<Product> getProductByCategory(String category);

    @Query(value = "select * from product where name=:name", nativeQuery = true)
    public List<Product> getProductByName(String name);
}
