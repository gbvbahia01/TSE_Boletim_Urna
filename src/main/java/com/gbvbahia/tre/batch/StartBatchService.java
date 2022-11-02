package com.gbvbahia.tre.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartBatchService {

  private final JobLauncher jobLauncher;
  private final Job jobExecuteProcessor;
  
  public void processStarter(String file) throws Exception {
    log.trace("Init Job Processor");
    
    JobParameters jobParameters =
        new JobParametersBuilder()
            .addLong("JOB_TIMESTAMP", System.nanoTime())
            .addString("PATH_TO_FILE", file)
            .toJobParameters();
    
    JobExecution jobResult = jobLauncher.run(jobExecuteProcessor, jobParameters);
    
    log.trace("End Job Processor with status: {}", jobResult.getStatus());
  }
}
