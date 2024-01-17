package com.ll.sbb20240111.batch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@StepScope
@Component
@RequiredArgsConstructor
public class Hello4Step1Writer implements ItemWriter<String> {

    private final Hello4Step1Counter hello4Step1Counter;

    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {


        List<String> items = (List<String>) chunk.getItems();
        for (String item : items) {
            hello4Step1Counter.printCount("write, item = " + item);
        }
    }
}
