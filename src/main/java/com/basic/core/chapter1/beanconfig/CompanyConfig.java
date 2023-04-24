package com.basic.core.chapter1.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CompanyConfig {
    @Bean
    public Address addressBean() {
        return new Address("High Street", 1000);
    }

    @Bean
    public Company companyBean(Address address) {
        return new Company(address);
    }


}
