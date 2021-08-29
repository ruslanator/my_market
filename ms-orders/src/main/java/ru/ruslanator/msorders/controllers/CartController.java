package ru.ruslanator.msorders.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ruslanator.msorders.beans.Cart;
import ru.ruslanator.msorders.entities.CartDto;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final Cart cart;

    @GetMapping
    public CartDto getCart() {
        return new CartDto(cart);
    }
//
//    @GetMapping("/add/{id}")
//    public void addToCart(@PathVariable Long id) {
//        cart.addToCart(id);
//    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clear();
    }
}
