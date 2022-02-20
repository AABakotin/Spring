package com.geekbrains.lesson1;


import org.springframework.stereotype.Component;

@Component ("lor")

public class Doctor1 implements Reception{


    public void doctor() {
        System.out.println("Лор в 323 кабинете");
    }
}
