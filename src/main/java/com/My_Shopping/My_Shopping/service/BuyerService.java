package com.My_Shopping.My_Shopping.service;

import com.My_Shopping.My_Shopping.ProductDTO.BillDTO;
import com.My_Shopping.My_Shopping.ProductDTO.OrderDetailsDTO;
import com.My_Shopping.My_Shopping.ProductDTO.OrderProductDTO;
import com.My_Shopping.My_Shopping.Repository.OrderRepository;
import com.My_Shopping.My_Shopping.models.AppUser;
import com.My_Shopping.My_Shopping.models.OrderTable;
import com.My_Shopping.My_Shopping.models.Product;
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

    @Autowired
    MailService mailService;
    public BillDTO placeorder(List<OrderDetailsDTO> orderdetails, UUID id)
    {
        AppUser user = userService.getUserId(id);
        OrderTable orderTable = new OrderTable();

        BillDTO billDTO = new BillDTO();
        int totalPrice=0;
        int totalquantity =0;

        List<Product> products = new ArrayList<>();
        List<OrderProductDTO> orderProductDTOS = new ArrayList<>();

        for(OrderDetailsDTO orderDetailsDTO : orderdetails)
        {
            OrderProductDTO orderProductDTO= new OrderProductDTO();


            UUID productId = orderDetailsDTO.getId();
            orderProductDTO.setId(productId);

            totalquantity+=orderDetailsDTO.getQuantity();
            orderProductDTO.setQuantity(totalquantity);

            Product product = productService.getProductById(productId);
            orderProductDTO.setProductName(product.getName());

            totalPrice+=(product.getPrice()*totalquantity);
            products.add(product);
            orderTable.setPaymentmode(orderDetailsDTO.getPaymentMode());

            orderProductDTOS.add(orderProductDTO);

            productService.updateProductQuantity(productId,orderDetailsDTO.getQuantity());
        }

        billDTO.setBuyerId(user.getId());
        billDTO.setTotalPrice(totalPrice);
        billDTO.setTotalQuantity(totalquantity);
        billDTO.setBuyerName(user.getName());
        billDTO.setEmailId(user.getEmail());
        billDTO.setOrderProducts(orderProductDTOS);

        orderTable.setProducts(products);
        orderTable.setAppUser(user);
        orderTable.setStatus("Not Delivered");
        orderTable.setToalprice(totalPrice);
        orderTable.setTotalQuantity(totalquantity);


        orderRepository.save(orderTable);
        billDTO.setBillid(orderTable.getOrderid());

        mailService.sendmail("Hey order got placed",user.getEmail(),"Hey Congralation Order got placed");
        return billDTO;
    }
}
