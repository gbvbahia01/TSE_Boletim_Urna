package com.gbvbahia.tre.batch;

import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.gbvbahia.tre.dto.BoletimUrnaDto;
import com.gbvbahia.tre.model.BoletimUrna;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class BoletimJob {

  public static final Integer INTEGER_OVERRIDDEN_BY_EXPRESSION = null;
  public static final Long LONG_OVERRIDDEN_BY_EXPRESSION = null;
  public static final String STRING_OVERRIDDEN_BY_EXPRESSION = null;
  private static final Integer HEADER_LINE = 1;
  
  private final JobBuilderFactory jobsFactory;
  private final StepBuilderFactory stepsFactory;

  // Job
  @Bean
  Job jobExecuteProcessor(Step stepExecuteProcessor) {

    return jobsFactory.get("jobExecuteProcessor").incrementer(new RunIdIncrementer())
        .start(stepExecuteProcessor).build();
  }

  // Step
  @Bean
  Step stepExecuteProcessor(@Value("${app.batch.threads.chunks}") Integer chunks,
      @Value("${app.batch.threads.amount}") Integer amountThreads) {
    return this.stepsFactory
        .get("stepExecuteProcessor")
        .<BoletimUrnaDto, BoletimUrna>chunk(chunks)
        .reader(reader(STRING_OVERRIDDEN_BY_EXPRESSION))
        .processor(boletimProcessor(STRING_OVERRIDDEN_BY_EXPRESSION))
        .writer(writer())
        .taskExecutor(taskExecutor(INTEGER_OVERRIDDEN_BY_EXPRESSION))
        .throttleLimit(amountThreads)
        .build();
  }
  
  // CSV Reader
  @Bean
  @StepScope
  FlatFileItemReader<BoletimUrnaDto> reader(@Value("#{jobParameters['PATH_TO_FILE']}") String pathToFile) {
    
    log.info("File to read: {}", pathToFile);
    
    FlatFileItemReader<BoletimUrnaDto> reader = new FlatFileItemReaderBuilder<BoletimUrnaDto>().name("BoletimUrnaItemReader")
        .resource(new FileSystemResource(pathToFile))// sample-data.csv
        .delimited().delimiter(";")
        .names(new String[] {"DT_GERACAO", "HH_GERACAO", "ANO_ELEICAO", "CD_TIPO_ELEICAO",
            "NM_TIPO_ELEICAO", "CD_PLEITO", "DT_PLEITO", "NR_TURNO", "CD_ELEICAO", "DS_ELEICAO",
            "SG_UF", "CD_MUNICIPIO", "NM_MUNICIPIO", "NR_ZONA", "NR_SECAO", "NR_LOCAL_VOTACAO",
            "CD_CARGO_PERGUNTA", "DS_CARGO_PERGUNTA", "NR_PARTIDO", "SG_PARTIDO", "NM_PARTIDO",
            "DT_BU_RECEBIDO", "QT_APTOS", "QT_COMPARECIMENTO", "QT_ABSTENCOES", "CD_TIPO_URNA",
            "DS_TIPO_URNA", "CD_TIPO_VOTAVEL", "DS_TIPO_VOTAVEL", "NR_VOTAVEL", "NM_VOTAVEL",
            "QT_VOTOS", "NR_URNA_EFETIVADA", "CD_CARGA_1_URNA_EFETIVADA",
            "CD_CARGA_2_URNA_EFETIVADA", "CD_FLASHCARD_URNA_EFETIVADA", "DT_CARGA_URNA_EFETIVADA",
            "DS_CARGO_PERGUNTA_SECAO", "DS_AGREGADAS", "DT_ABERTURA", "DT_ENCERRAMENTO",
            "QT_ELEITORES_BIOMETRIA_NH", "DT_EMISSAO_BU", "NR_JUNTA_APURADORA",
            "NR_TURMA_APURADORA"})
        .fieldSetMapper(new BeanWrapperFieldSetMapper<BoletimUrnaDto>() {
          {
            setTargetType(BoletimUrnaDto.class);
          }
        }).build();
    reader.setEncoding("ISO-8859-1");
    reader.setLinesToSkip(HEADER_LINE);
    return reader;
  }

  @Bean
  @StepScope
  BoletimUrnaProcessor boletimProcessor(@Value("#{jobParameters['PATH_TO_FILE']}") String pathToFile) {
    return new BoletimUrnaProcessor(pathToFile);
  }
  
  @Bean
  ItemWriter<BoletimUrna> writer() {
    return (b -> log.info("BoletimUrna: {}", b));
  }
  

  @Bean
  ThreadPoolTaskExecutor taskExecutor(@Value("${app.batch.threads.amount}") Integer amountThreads) {
    
    log.info("ThreadPoolTaskExecutor amount threads: {}", amountThreads);
    
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(amountThreads);
    executor.setMaxPoolSize(amountThreads);
    executor.setQueueCapacity(0);
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.setThreadNamePrefix("process-thread");
    executor.initialize();
    return executor;
  }
}
