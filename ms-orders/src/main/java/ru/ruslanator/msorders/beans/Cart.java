package ru.ruslanator.msorders.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import ru.ruslanator.msorders.entities.Order;
import ru.ruslanator.msproducts.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class Cart {

    private final ProductService productService;
    private List<Order> items;
    private int totalPrice;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>();
    }

//    public void addToCart(Long id) {
//        for (Order o : items) {
//            if (o.getProduct().getId().equals(id)) {
//                o.incrementQuantity();
//                recalculate();
//                return;
//            }
//        }
//        ProductDto p = productService.findProductDtoById(id).orElseThrow();
//        Order order = new Order(p);
//        items.add(order);
//        recalculate();
//    }

    public void clear() {
        items.clear();
        recalculate();
    }

    public void recalculate() {
        totalPrice = 0;
        for (Order o : items) {
            totalPrice += o.getPrice();
        }
    }
}
