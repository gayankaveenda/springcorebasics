package com.basic.core.chapter1.beanconfig;

import com.basic.core.chapter1.autowiring.service.ElectricStoreService;
import com.basic.core.chapter1.autowiring.service.StoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CompanyConfig {
    @Bean
    @Primary
    public Address addressBean() {
        return new Address("High Street", 100);
    }

    @Bean(name="electricCompanyAddress")
    @Qualifier("electricCompanyAddress")
    public Address electricCompanyAddressBean() {
        return new Address("Howthorn Stree", 21);
    }

    @Bean
    @Primary
    public Company companyBean(Address address) {
        return new Company(address);
    }

    @Bean(name="electricCompany")
    @Qualifier("electricCompany")
    public Company electricCompanyBean(@Qualifier("electricCompanyAddress") Address address) {
        return new Company(address);
    }


    @Bean
    @Primary
    public StoreService electricStoreService() {
        return new ElectricStoreService();
    }

}
