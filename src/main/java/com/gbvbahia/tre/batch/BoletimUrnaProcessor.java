package com.gbvbahia.tre.batch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.util.StringUtils;
import com.gbvbahia.tre.dto.BoletimUrnaDto;
import com.gbvbahia.tre.model.BoletimUrna;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoletimUrnaProcessor implements ItemProcessor<BoletimUrnaDto, BoletimUrna> {

  private final String fileName;
  
  @Override
  public BoletimUrna process(BoletimUrnaDto item) throws Exception {
    
    BoletimUrna urna = new BoletimUrna();
    urna.setFileName(fileName);
    
    String dataGeracao = String.format("%s %s", item.getDtGeracao(), item.getHhGeracao());
    urna.setDtGeracao(LocalDateTime.parse(dataGeracao, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    urna.setAnoEleicao(Integer.valueOf(item.getAnoEleicao()));
    urna.setCdTipoEleicao(Integer.valueOf(item.getCdTipoEleicao()));
    urna.setNmTipoEleicao(item.getNmTipoEleicao());
    urna.setCdPleito(Integer.valueOf(item.getCdPleito()));
    urna.setDtPleito(LocalDate.parse(item.getDtPleito(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    
    urna.setNrTurno(Integer.valueOf(item.getNrTurno()));
    urna.setCdEleicao(Integer.valueOf(item.getCdEleicao()));
    urna.setDsEleicao(item.getDsEleicao());
    urna.setSgUf(item.getSgUf());
    urna.setCdMunicipio(Integer.valueOf(item.getCdMunicipio()));
    urna.setNmMunicipio(item.getNmMunicipio());
    urna.setNrZona(Integer.valueOf(item.getNrZona()));
    urna.setNrSecao(Integer.valueOf(item.getNrSecao()));
    urna.setNrLocalVotacao(Integer.valueOf(item.getNrLocalVotacao()));
    urna.setCdCargoPergunta(Integer.valueOf(item.getCdCargoPergunta()));
    urna.setNrPartido(Integer.valueOf(item.getNrPartido()));
    urna.setSgPartido(item.getSgPartido());
    urna.setNmPartido(item.getNmPartido());
    urna.setDtBuRecebido(LocalDateTime.parse(item.getDtBuRecebido(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    urna.setQtAptos(Integer.valueOf(item.getQtAptos()));
    urna.setQtComparecimento(Integer.valueOf(item.getQtComparecimento()));
    urna.setQtAbstencoes(Integer.valueOf(item.getQtAbstencoes()));
    urna.setCdTipoUrna(Integer.valueOf(item.getCdTipoUrna()));
    urna.setDsTipoUrna(item.getDsTipoUrna());
    urna.setCdTipoVotavel(Integer.valueOf(item.getCdTipoVotavel()));
    urna.setDsTipoVotavel(item.getDsTipoVotavel());
    urna.setNrVotavel(Integer.valueOf(item.getNrVotavel()));
    urna.setNmVotavel(item.getNmVotavel());
    urna.setQtVotos(Integer.valueOf(item.getQtVotos()));
    urna.setNrUrnaEfetivada(Integer.valueOf(item.getNrUrnaEfetivada()));
    urna.setCdCarga1UrnaEfetivada(item.getCdCarga1UrnaEfetivada());
    urna.setCdCarga2UrnaEfetivada(item.getCdCarga2UrnaEfetivada());
    urna.setCdFlashcardUrnaEfetivada(item.getCdFlashcardUrnaEfetivada());
    urna.setDsCargoPerguntaSecao(item.getDsCargoPerguntaSecao());
    urna.setDsAgregadas(item.getDsAgregadas());
    if (StringUtils.hasText(item.getDtAbertura())) {
      urna.setDtAbertura(LocalDateTime.parse(item.getDtAbertura(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
    if (StringUtils.hasText(item.getDtEncerramento())) {
      urna.setDtEncerramento(LocalDateTime.parse(item.getDtEncerramento(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
    urna.setQtEleitoresBiometriaNh(Integer.valueOf(item.getQtEleitoresBiometriaNh()));
    if (StringUtils.hasText(item.getDtEmissaoBu())) {
      urna.setDtEmissaoBu(LocalDateTime.parse(item.getDtEmissaoBu(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
    urna.setNrJuntaApuradora(Integer.valueOf(item.getNrJuntaApuradora()));
    urna.setNrTurmaApuradora(Integer.valueOf(item.getNrTurmaApuradora()));
    
    return urna;
  }

}
