package com.My_Shopping.My_Shopping.service;

import com.My_Shopping.My_Shopping.ProductDTO.OrderDetailsDTO;
import com.My_Shopping.My_Shopping.Repository.OrderRepository;
import com.My_Shopping.My_Shopping.models.AppUser;
import com.My_Shopping.My_Shopping.models.OrderTable;
import com.My_Shopping.My_Shopping.models.Product;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BuyerService {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderRepository orderRepository;
    public OrderTable placeorder(List<OrderDetailsDTO> orderdetails, UUID id)
    {
        AppUser user = userService.getUserId(id);
        OrderTable orderTable = new OrderTable();
        int totalPrice=0;
        int totalquantity =0;

        List<Product> products = new ArrayList<>();
        for(OrderDetailsDTO orderDetailsDTO : orderdetails)
        {
            UUID productId = orderDetailsDTO.getId();
            totalquantity+=orderDetailsDTO.getQuantity();
            Product product = productService.getProductById(productId);
            totalPrice+=(product.getPrice()*totalquantity);
            products.add(product);
            orderTable.setPaymentmode(orderDetailsDTO.getPaymentMode());
        }

        orderTable.setProducts(products);
        orderTable.setOrderid(id);
        orderTable.setStatus("Not Delivered");
        orderTable.setToalprice(totalPrice);
        orderTable.setTotalQuantity(totalquantity);

        orderRepository.save(orderTable);

        return orderTable;
    }
}
