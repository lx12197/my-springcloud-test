package com.mw.eurekaclientconsumerfeign;

import org.springframework.stereotype.Component;

@Component
public class TestServiceHystric implements TestService{
    @Override
    public String hi(String name) {
        return "I'm sorry "+name;
    }
}
