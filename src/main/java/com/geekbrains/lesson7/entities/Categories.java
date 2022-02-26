package com.geekbrains.lesson7.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name="products_categories",
            joinColumns=@JoinColumn(name="category_id"),
            inverseJoinColumns=@JoinColumn(name="product_id")
    )

    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public Categories() {
    }
}
