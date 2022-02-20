package com.geekbrains.lesson4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListProduct {


    public static void list(String categories) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Category category = session.get(Category.class,  Comparator.catToInt(categories));
        System.out.println(category);
        session.getTransaction().commit();
        factory.close();
        session.close();

    }



}
