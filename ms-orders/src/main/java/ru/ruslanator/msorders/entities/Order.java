package ru.ruslanator.msorders.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.ruslanator.msproducts.entities.Product;
import ru.ruslanator.msproducts.entities.ProductDto;

import javax.persistence.*;

@Entity
@Table(name = "orders_table")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price_per_product")
    private int pricePerProduct;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;


    public void incrementQuantity() {
        quantity++;
        price = quantity * pricePerProduct;
    }

    public void decrementQuantity() {
        quantity--;
        price = quantity * pricePerProduct;
    }
}
