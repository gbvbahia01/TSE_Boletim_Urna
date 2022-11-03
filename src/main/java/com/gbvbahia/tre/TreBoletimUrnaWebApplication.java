package com.gbvbahia.tre;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import com.gbvbahia.tre.batch.StartBatchService;
import com.gbvbahia.tre.util.IOHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@RequiredArgsConstructor
@Slf4j
public class TreBoletimUrnaWebApplication implements ApplicationRunner {

  private static final String PATH_TO_FILES = "pathToFiles";
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
    log.info("pathToFiles: {}", args.getOptionValues(PATH_TO_FILES));
    StopWatch sw = new StopWatch();
    sw.start();


    try {
      
      String dir = args.getOptionValues(PATH_TO_FILES).toArray()[0].toString();
      
      Collection<File> listCsvFiles = IOHelper.listFilesRecursive(dir, "csv");
      
      for (File csv : listCsvFiles) {
        log.info("To process: {}", csv.getAbsolutePath());
        startBatchService.processStarter(csv.getAbsolutePath());
      }
      
    } catch (Exception e) {
      String error = String.format("The parameter %s should be informed. %s", e.getMessage(), PATH_TO_FILES);
      log.error(error, e);
    }

    sw.stop();
    log.info("TreBoletimUrnaWebApplication finished: {} seconds", sw.getTotalTimeSeconds());
    System.exit(0);
  }

}
