package com.geekbrains.lesson7.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;




    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DETACH})

    private Collection<Categories> categoriesList;

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

    public Collection<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(Collection<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product id=" + id + ", Category=" + categoriesList.size() + '}';
    }
}
