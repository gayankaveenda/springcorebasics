package com.basics.core.springcorebasics;

import com.basic.core.chapter1.beanconfig.Company;
import com.basic.core.chapter1.beanconfig.CompanyConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringCoreBasicsApplication {

    public static void main(String[] args) {

        Company company;
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                CompanyConfig.class)) {

            company = context.getBean(Company.class);
        }
        System.out.println("In the main method: " + company);

      //  SpringApplication.run(SpringCoreBasicsApplication.class, args);
    }

}
