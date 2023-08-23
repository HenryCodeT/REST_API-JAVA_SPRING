package com.example.spring_test.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private Double prize;

    @NotNull
    private String existences;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Sale> sales;

    public Product() {
    }
    public Product(String description, Double prize, String existences) {
        this.description = description;
        this.prize = prize;
        this.existences = existences;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public String getExistences() {
        return existences;
    }

    public void setExistences(String existences) {
        this.existences = existences;
    }
}
