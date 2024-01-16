package com.ll.sbb20240111.batch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class Hello2JobConfig {
    @Bean
    public Job hello2Job(JobRepository jobRepository, Step hello2Step1) {
        return new JobBuilder("hello2Job", jobRepository)
                .start(hello2Step1)
                .incrementer(new RunIdIncrementer()) // 잡이 매번 실행되게끔 만들어줌
                .build();
    }

    @Bean
    @JobScope
    public Step hello2Step1(JobRepository jobRepository, Tasklet hello2Step1Tasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("helloStep1Tasklet", jobRepository)
                .tasklet(hello2Step1Tasklet, platformTransactionManager)
                .build();
    }

    @Bean
    @JobScope
    public Step hello2Step2(JobRepository jobRepository, Tasklet hello2Step2Tasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("helloStep1Tasklet", jobRepository)
                .tasklet(hello2Step2Tasklet, platformTransactionManager)
                .build();
    }

    @Bean
    @StepScope
    public Tasklet hello2Step1Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("Hello World 2/1");
            return RepeatStatus.FINISHED;
        });
    }

    @Bean
    @StepScope
    public Tasklet hello2Step2Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("Hello World 2/2");
            return RepeatStatus.FINISHED;
        });
    }


}
