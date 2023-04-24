package com.basics.core.springcorebasics;


import com.basic.core.chapter1.autowiring.Item;
import com.basic.core.chapter1.autowiring.Store;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Bean
    @Primary
    public Item itemBean() {
        return new Item("Hollow Item", 10);
    }

    @Bean
    @Qualifier("Filler")
    public Item itemBean2() {
        return new Item("Filler Item", 30);
    }


    @Bean
    @Primary
    public Store storeBeanA(Item item) {
        return new Store(item);
    }

    @Bean(name="BerwickStore")
    @Qualifier("BerwickStore")
    public Store storeBeanB(@Qualifier("Filler") Item item) {
        return new Store(item);
    }
}
