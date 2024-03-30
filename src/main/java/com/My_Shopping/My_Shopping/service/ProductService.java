package com.My_Shopping.My_Shopping.service;

import com.My_Shopping.My_Shopping.Repository.ProductRepository;
import com.My_Shopping.My_Shopping.expections.ResourceNotFound;
import com.My_Shopping.My_Shopping.expections.UnAutherized;
import com.My_Shopping.My_Shopping.models.AppUser;
import com.My_Shopping.My_Shopping.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    UserService userService;

    @Autowired
    ProductRepository productRepository;
    public void registerProduct(Product product, UUID sellerId)
    {
        AppUser user = userService.getUserId(sellerId);
        if(user==null)
        {
            throw new ResourceNotFound(String.format("Seller with sellerId %s does not exsit in System", sellerId.toString()));
        }

        if(!user.getUsertype().equals("Seller"))
        {
            throw new UnAutherized(String.format("user with id %s doesn't have access to perform this operation", sellerId.toString()));
        }

        product.setAppUser(user);
        productRepository.save(product);
    }
}
