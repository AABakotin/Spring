package com.geekbrains.lesson4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FindProduct {

    public static void find(int id) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        System.out.println(product);
        factory.close();
        session.close();
    }



}
