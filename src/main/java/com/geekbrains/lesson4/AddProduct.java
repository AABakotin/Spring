package com.geekbrains.lesson4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddProduct {


    public static void newProduct(String category, String product, int price) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Product products = new Product();
        Category categories = new Category();
        categories.setName(category);
        categories.setId(Comparator.catToInt(category));
        products.setTitle(product);
        products.setPrice(price);
        products.setCategory_id(categories);
        session.beginTransaction();
        session.save(products);
        session.save(categories);
        session.getTransaction().commit();

        factory.close();
        session.close();
    }

}
