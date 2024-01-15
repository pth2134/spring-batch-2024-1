package com.ll.sbb20240111.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final JobLauncher jobLauncher;
    private final Job simpleJob; //Bean으로 등록된 helloJob

    public void runSimpleJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time",System.currentTimeMillis()) // 없으면 재실행안됨 EXIT_CODE가 NOOP
                    .toJobParameters();
            jobLauncher.run(simpleJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
