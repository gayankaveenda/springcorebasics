package com.basics.core.springcorebasics;

import com.basic.core.chapter1.autowiring.Store;
import com.basic.core.chapter1.autowiring.service.StoreService;
import com.basic.core.chapter1.beanconfig.Company;
import com.basic.core.chapter1.beanconfig.CompanyConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringCoreBasicsApplication {

    public static void main(String[] args) {
        //  SpringApplication.run(SpringCoreBasicsApplication.class, args);

        //when you only have one config Java class
        //annotationConfigWithSingleConfiguration();

        //when you have more than one config Java class
        multipleAnnotationConfigFiles();

    }

    private static void multipleAnnotationConfigFiles() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(CompanyConfig.class, Config.class);

            context.refresh();

            Company company = context.getBean(Company.class);
            System.out.println("In multipleAnnotationConfigFiles: " + company);

            usingQualifiersAndPrimaryAnnotations(context);

            usingServiceAnnotationWithClassConfig(context);
        }
    }

    private static void usingServiceAnnotationWithClassConfig(AnnotationConfigApplicationContext context) {
        StoreService storeService = (StoreService)  context.getBean("electricStoreService");
        System.out.println("Store Service Address : " + storeService.getStoreAddress());
    }

    private static void usingQualifiersAndPrimaryAnnotations(AnnotationConfigApplicationContext context) {
        //Using Primary and Qualifiers

        //This is Primary
        Store store = context.getBean(Store.class);
        System.out.println("In the main method: " + store);

        //using Qualifiers
        Store berwickStore = (Store) context.getBean("BerwickStore");
        System.out.println("In usingQualifiersAndPrimaryAnnotations: " + berwickStore);
    }

    private static void annotationConfigWithSingleConfiguration() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(
                             CompanyConfig.class)) {

            Company company = context.getBean(Company.class);
            System.out.println("In annotationConfigWithSingleConfiguration: " + company);
        }
    }

}
