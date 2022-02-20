package com.geekbrains.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Registry")

public class Registry {

    private Reception reception;
    final String TERAPEVT = "terapevt";
    final String LOR = "lor";

    @Autowired
//    @Qualifier(LOR)
    @Qualifier(TERAPEVT)
    public void setReception(Reception reception) {
        this.reception = reception;
    }

    public void doctor() {
        System.out.println("Направление");
        reception.doctor();
    }

}
