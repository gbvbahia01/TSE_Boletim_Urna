package com.gbvbahia.tre;

import java.util.Arrays;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import com.gbvbahia.tre.batch.StartBatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@RequiredArgsConstructor
@Slf4j
public class TreBoletimUrnaWebApplication implements ApplicationRunner {

  private final StartBatchService startBatchService;

  // Users/guilhermebahia/Developer/Eclipse/TRE/bweb_2t_ZZ_311020221535
  // @Value("${pathToFile}")
  // private String pathToFile;


  public static void main(String[] args) {
    SpringApplication.run(TreBoletimUrnaWebApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("Args: {}", Arrays.toString(args.getSourceArgs()));
    log.info("pathToFile: {}", args.getOptionValues("pathToFile"));
    StopWatch sw = new StopWatch();
    sw.start();


    try {
      
      startBatchService.processStarter(args.getOptionValues("pathToFile").toArray()[0].toString());
      
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }

    sw.stop();
    log.info("TreBoletimUrnaWebApplication finished: " + sw.toString());
    System.exit(0);
  }

}
