package com.My_Shopping.My_Shopping.service;

import com.My_Shopping.My_Shopping.ProductDTO.Product_DTO;
import com.My_Shopping.My_Shopping.Repository.ProductRepository;
import com.My_Shopping.My_Shopping.expections.ResourceNotFound;
import com.My_Shopping.My_Shopping.expections.UnAutherized;
import com.My_Shopping.My_Shopping.models.AppUser;
import com.My_Shopping.My_Shopping.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    UserService userService;

    @Autowired
    ProductRepository productRepository;


    public Product getProductById(UUID id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public List<Product_DTO> convertProductIntoProductDTO(List<Product> product)
    {
        List<Product_DTO> productDtos= new ArrayList<>();

        for(Product product1 : product)
        {
            Product_DTO productDto = new Product_DTO();
            productDto.setName(product1.getName());
            productDto.setCategory(product1.getCategory());
            productDto.setId(product1.getId());
            productDto.setRating(product1.getRating());
            productDto.setPrice(product1.getPrice());
            productDto.setDescription(product1.getDescription());
            productDto.setSellername(product1.getAppUser().getName());
            productDtos.add(productDto);

        }
        return productDtos;
    }
    public List<Product_DTO> searchByProductName(String product)
    {
        List<Product> products= productRepository.getProductByName(product);
        List<Product_DTO> product_dtos = convertProductIntoProductDTO(products);
        return product_dtos;
    }

    public List<Product_DTO> searachByCategory(String category)
    {
        List<Product> products=productRepository.getProductByCategory(category);
        List<Product_DTO> product_dtos = convertProductIntoProductDTO(products);
        return product_dtos;
    }

    public List<Product_DTO> searchByProductAndCategory(String category, String product)
    {
        List<Product> products=productRepository.getProduvtByCategoryandName(category,product);
        List<Product_DTO> product_dtos = convertProductIntoProductDTO(products);
        return product_dtos;
    }

    public List<Product_DTO> getAllProduct()
    {
        List<Product> products=productRepository.findAll();
        List<Product_DTO> product_dtos = convertProductIntoProductDTO(products);
        return product_dtos;
    }
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
