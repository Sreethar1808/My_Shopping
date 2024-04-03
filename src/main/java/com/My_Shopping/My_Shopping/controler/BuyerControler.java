package com.My_Shopping.My_Shopping.controler;

import com.My_Shopping.My_Shopping.ProductDTO.BillDTO;
import com.My_Shopping.My_Shopping.ProductDTO.OrderDetailsDTO;
import com.My_Shopping.My_Shopping.models.OrderTable;
import com.My_Shopping.My_Shopping.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/buyer")
public class BuyerControler {

    @Autowired
    BuyerService buyerService;
    @PostMapping("/placeOrder")
    public BillDTO placeorder(@RequestBody List<OrderDetailsDTO> orders, @RequestParam UUID id)
    {
        return buyerService.placeorder(orders,id);
    }
}
