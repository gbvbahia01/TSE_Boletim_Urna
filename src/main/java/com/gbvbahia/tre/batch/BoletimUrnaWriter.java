package com.gbvbahia.tre.batch;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.batch.item.ItemWriter;
import com.gbvbahia.tre.model.BoletimUrna;
import com.gbvbahia.tre.repository.BoletimUrnaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class BoletimUrnaWriter implements ItemWriter<BoletimUrna> {

  private static AtomicLong counter = new AtomicLong();
  
  private final BoletimUrnaRepository boletimUrnaRepository;
  
  @Override
  public void write(List<? extends BoletimUrna> items) throws Exception {

    counter.addAndGet(items.size());
    
    boletimUrnaRepository.saveAll(items);
    
    if (counter.get() > 1000) {
      log.info("Thousand urns saved");
      counter.set(0);
    }
    
  }

}
