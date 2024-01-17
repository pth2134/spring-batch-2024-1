package com.ll.sbb20240111.batch.config;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.stereotype.Component;

@JobScope
@Component
public class Hello4Step1Counter {
    private int count = 0;

    public void printCount(String where){
        System.out.println("count = " + ++count + " in " + where);
    }
}
