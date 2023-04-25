package com.basic.core.chapter1.autowiring.service;

import com.basic.core.chapter1.beanconfig.Address;
import com.basic.core.chapter1.beanconfig.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ElectricStoreService implements StoreService {
    private Address address;
    private Company company;


    @Override
    public String getStoreType() {
        return "Electric Store";
    }


    @Override
    public Address getStoreAddress() {
        return getAddress();
    }


    @Override
    public Company geStoreInfo() {
        return getCompany();
    }

    @Autowired
    @Qualifier("electricCompanyAddress")
    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Autowired
    @Qualifier("electricCompany")
    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }
}
