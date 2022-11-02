package com.gbvbahia.tre.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "boletim_urna")
@Data
public class BoletimUrna {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_boletim_urna")
  @SequenceGenerator(name = "seq_boletim_urna", sequenceName = "seq_boletim_urna",
      allocationSize = 1)
  @Column(name = "ID")
  private Long id;

  @Column(name = "dt_geracao")
  private LocalDateTime dtGeracao;
  @Column(name = "ano_eleicao")
  private Integer anoEleicao;
  @Column(name = "cd_tipo_eleicao")
  private Integer cdTipoEleicao;
  @Column(name = "nm_tipo_eleicao")
  private String nmTipoEleicao;
  @Column(name = "cd_pleito")
  private Integer cdPleito;
  @Column(name = "dt_pleito")
  private LocalDate dtPleito;
  @Column(name = "nr_turno")
  private Integer nrTurno;
  @Column(name = "cd_eleicao")
  private Integer cdEleicao;
  @Column(name = "ds_eleicao")
  private String dsEleicao;
  @Column(name = "sg_uf")
  private String sgUf;
  @Column(name = "cd_municipio")
  private Integer cdMunicipio;
  @Column(name = "nm_municipio")
  private String nmMunicipio;
  @Column(name = "nr_zona")
  private Integer nrZona;
  @Column(name = "nr_secao")
  private Integer nrSecao;
  @Column(name = "nr_local_votacao")
  private Integer nrLocalVotacao;
  @Column(name = "cd_cargo_pergunta")
  private Integer cdCargoPergunta;
  @Column(name = "ds_cargo_pergunta")
  private String dsCargoPergunta;
  @Column(name = "nr_partido")
  private Integer nrPartido;
  @Column(name = "sg_partido")
  private String sgPartido;
  @Column(name = "nm_partido")
  private String nmPartido;
  @Column(name = "dt_bu_recebido")
  private LocalDateTime dtBuRecebido;
  @Column(name = "qt_aptos")
  private Integer qtAptos;
  @Column(name = "qt_comparecimento")
  private Integer qtComparecimento;
  @Column(name = "qt_abstencoes")
  private Integer qtAbstencoes;
  @Column(name = "cd_tipo_urna")
  private Integer cdTipoUrna;
  @Column(name = "ds_tipo_urna")
  private String dsTipoUrna;
  @Column(name = "cd_tipo_votavel")
  private Integer cdTipoVotavel;
  @Column(name = "ds_tipo_votavel")
  private String dsTipoVotavel;
  @Column(name = "nr_votavel")
  private Integer nrVotavel;
  @Column(name = "nm_votavel")
  private String nmVotavel;
  @Column(name = "qt_votos")
  private Integer qtVotos;
  @Column(name = "nr_urna_efetivada")
  private Integer nrUrnaEfetivada;
  @Column(name = "cd_carga1_urna_efetivada")
  private String cdCarga1UrnaEfetivada;
  @Column(name = "cd_carga2_urna_efetivada")
  private String cdCarga2UrnaEfetivada;
  @Column(name = "cd_flashcard_urna_efetivada")
  private String cdFlashcardUrnaEfetivada;
  @Column(name = "dt_carga_urna_efetivada")
  private LocalDate dtCargaUrnaEfetivada;
  @Column(name = "ds_cargo_pergunta_secao")
  private String dsCargoPerguntaSecao;
  @Column(name = "ds_agregadas")
  private String dsAgregadas;
  @Column(name = "dt_abertura")
  private LocalDateTime dtAbertura;
  @Column(name = "dt_encerramento")
  private LocalDateTime dtEncerramento;
  @Column(name = "qt_eleitores_biometria_nh")
  private Integer qtEleitoresBiometriaNh;
  @Column(name = "dt_emissao_bu")
  private LocalDateTime dtEmissaoBu;
  @Column(name = "nr_junta_apuradora")
  private Integer nrJuntaApuradora;
  @Column(name = "nr_turma_apuradora")
  private Integer nrTurmaApuradora;
  @Column(name = "file_name")
  private String fileName;
  
}
