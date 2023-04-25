package com.basic.core.chapter1.autowiring.service;

import com.basic.core.chapter1.beanconfig.Address;
import com.basic.core.chapter1.beanconfig.Company;

public interface StoreService {

    String getStoreType();

    Address getStoreAddress();

    Company geStoreInfo();
}
