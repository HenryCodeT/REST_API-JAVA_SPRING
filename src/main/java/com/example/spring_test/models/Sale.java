package com.example.spring_test.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public double subtotal() {
        return cantidad * product.getPrize();
    }

    public double igv() {
        double subtotal = subtotal();
        return subtotal * 0.18;
    }

    public double total() {
        return subtotal() + igv();
    }


}
