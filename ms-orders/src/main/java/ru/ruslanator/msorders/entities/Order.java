package ru.ruslanator.msorders.entities;

import lombok.Data;
import ru.ruslanator.msproducts.entities.Product;

import javax.persistence.*;

@Entity
@Table(name = "orders_table")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;
}
