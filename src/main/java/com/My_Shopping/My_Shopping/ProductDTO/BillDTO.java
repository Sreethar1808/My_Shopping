package com.My_Shopping.My_Shopping.ProductDTO;

import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class BillDTO {

    UUID Billid;
    String BuyerName;
    UUID BuyerId;
    String emailId;
    int totalQuantity;
    int totalPrice;
    List<OrderProductDTO> orderProducts;
}
