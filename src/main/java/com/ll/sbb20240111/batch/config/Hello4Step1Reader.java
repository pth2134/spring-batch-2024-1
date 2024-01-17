package com.ll.sbb20240111.batch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@StepScope
@Component
@RequiredArgsConstructor
public class Hello4Step1Reader implements ItemReader<Integer> {

    private final Hello4Step1Counter hello4Step1Counter;
    @Override
    public Integer read() {
        hello4Step1Counter.printCount("read");
        int no = (int) (Math.random()*101);

        if(no == 100) return null;

        return no;
    }
}
