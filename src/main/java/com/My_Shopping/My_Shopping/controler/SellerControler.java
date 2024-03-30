package com.My_Shopping.My_Shopping.controler;

import com.My_Shopping.My_Shopping.expections.ResourceNotFound;
import com.My_Shopping.My_Shopping.expections.UnAutherized;
import com.My_Shopping.My_Shopping.models.Product;
import com.My_Shopping.My_Shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/seller")
public class SellerControler {

    @Autowired
    ProductService productService;
    @PostMapping ("/Product/add")
    public String addProduct(@RequestBody Product product, @RequestParam UUID sellerId)
    {
        try {
            productService.registerProduct(product, sellerId);
        }
        catch (ResourceNotFound resourceNotFound)
        {
           return resourceNotFound.getMessage();
        }
        catch (UnAutherized unAutherized)
        {
           return unAutherized.getMessage();
        }

        return "Product got saved Successfully";
    }
}
