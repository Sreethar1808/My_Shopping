package com.My_Shopping.My_Shopping.ProductDTO;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderProductDTO {
    UUID id;
    String productName;
    int quantity;
}
