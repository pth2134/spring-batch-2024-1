package com.ll.sbb20240111.batch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//원본 데이터 가공
//EX : 50 -> "no. 50"
@StepScope
@Component
@RequiredArgsConstructor
public class Hello4Step1Processor implements ItemProcessor<Integer, String> {

    private final Hello4Step1Counter hello4Step1Counter;

    @Override
    public String process(Integer item) {
        hello4Step1Counter.printCount("process");
        return "no. " + item;
    }
}
