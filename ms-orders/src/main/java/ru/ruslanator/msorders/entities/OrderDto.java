package ru.ruslanator.msorders.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderDto {
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public OrderDto(Order order) {
        this.productTitle = order.getProduct().getTitle();
        this.quantity = order.getQuantity();
        this.pricePerProduct = order.getPricePerProduct();
        this.price = order.getPrice();
    }
}

