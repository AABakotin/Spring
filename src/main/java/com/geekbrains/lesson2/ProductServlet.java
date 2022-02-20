package com.geekbrains.lesson2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        logger.info("Product request");

        PrintWriter pw = resp.getWriter();

        Product[] productsList = new Product[]{
                new Product(1, "product1", 100),
                new Product(2, "product2", 110),
                new Product(3, "product3", 120),
                new Product(4, "product4", 130),
                new Product(5, "product5", 140),
                new Product(6, "product6", 150),
                new Product(7, "product7", 160),
                new Product(8, "product8", 170),
                new Product(9, "product9", 180),
                new Product(10, "product10", 190)
        };

        for (Product product : productsList) {
            pw.printf(
                    "<h1>"
                            + "ID = " + product.getId()
                            + ", Name product = " + product.getTitle()
                            + ", Price = " + product.getCost()
                            +
                    "</h1>"
            );
        }

        pw.close();
    }

}

