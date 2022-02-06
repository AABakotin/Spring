package lesson1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {

//AppConfig
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//Annotation
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Registry registry = context.getBean("Registry", Registry.class);
        registry.doctor();


    }
}
