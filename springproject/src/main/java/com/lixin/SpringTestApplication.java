package com.lixin;


import com.lixin.core.AuthorizationAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.Scanner;

public class SpringTestApplication {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext();
        ((ClassPathXmlApplicationContext) context).refresh();
        context.getBean(AuthorizationAdvisor.class);

        InputStream in = System.in;
        Scanner scanner=new Scanner(in);
        while (scanner.hasNext()){
            System.out.println(111);
        }
    }
}
