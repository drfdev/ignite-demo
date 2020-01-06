package dev.drf.ignite.demo;

import dev.drf.ignite.demo.ignite.IgniteService;
import dev.drf.ignite.demo.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("ignite-demo");

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        MyService myService = context.getBean(MyService.class);
        IgniteService igniteService = context.getBean(IgniteService.class);
    }
}
