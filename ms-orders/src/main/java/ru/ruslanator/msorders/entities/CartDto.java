package ru.ruslanator.msorders.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ruslanator.msorders.beans.Cart;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class CartDto {
    private List<OrderDto> items;
    private int totalPrice;

    public CartDto(Cart cart) {
        this.totalPrice = cart.getTotalPrice();
        this.items = cart.getItems().stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
