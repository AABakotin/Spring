package lesson1;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component ("terapevt")

public class Doctor2 implements Reception{


    @Override
    public void doctor() {
        System.out.println("Терапевт в 234 кабинете");
    }
}
