package com.My_Shopping.My_Shopping.ProductDTO;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product_DTO {

    UUID id;
    String name;
    String category;
    String rating;
    String description;
    String sellername;
    int price;
}
