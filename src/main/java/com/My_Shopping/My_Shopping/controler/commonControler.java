package com.My_Shopping.My_Shopping.controler;

import com.My_Shopping.My_Shopping.ProductDTO.Product_DTO;
import com.My_Shopping.My_Shopping.models.AppUser;
import com.My_Shopping.My_Shopping.models.Product;
import com.My_Shopping.My_Shopping.service.ProductService;
import com.My_Shopping.My_Shopping.service.UserService;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class commonControler {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;
    @PostMapping("/user/register")
    public String RegisterUser(@RequestBody AppUser appUser)
    {
        userService.registerUser(appUser);
        return "User got successfully saved";
    }

    @GetMapping("/product/search")
    public List<Product_DTO> searchProductByCategory(@RequestParam(required = false) String category, @RequestParam(required = false) String product)
    {
        if(category!=null && product!=null)
        {
            return productService.searchByProductAndCategory(category, product);
        }
        else if(category!=null)
        {
            return productService.searachByCategory(category);
        }
        else if(product!=null)
        {
            return productService.searchByProductName(product);
        }
        else {
            return productService.getAllProduct();
        }
    }
}
