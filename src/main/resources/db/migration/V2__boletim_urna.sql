CREATE TABLE boletim_urna (
	id int8 NOT NULL,
	dt_geracao timestamp NOT NULL,
	ano_eleicao int4 NOT NULL,
	cd_tipo_eleicao int4 NOT NULL,
	nm_tipo_eleicao varchar(100) NULL,
	cd_pleito int4 NOT NULL,
	dt_pleito date NOT NULL,
	nr_turno int4 NOT NULL,
	cd_eleicao int4 NOT NULL,
	ds_eleicao varchar(100) NULL,
	sg_uf varchar(10) NULL,
	cd_municipio int4 NOT NULL,
	nm_municipio varchar(250) NULL,
	nr_zona int4 NOT NULL,
	nr_secao int4 NOT NULL,
	nr_local_votacao int4 NOT NULL,
	cd_cargo_pergunta int4 NOT NULL,
	ds_cargo_pergunta varchar(100) NULL,
	nr_partido int4 NULL,
	sg_partido varchar(10) NULL,
	nm_partido varchar(250) NULL,
	dt_bu_recebido timestamp NULL,
	qt_aptos int4 NULL,
	qt_comparecimento int4 NULL,
	qt_abstencoes int4 NULL,
	cd_tipo_urna int4 NULL,
	ds_tipo_urna varchar(250) NULL,
	cd_tipo_votavel int4 NULL,
	ds_tipo_votavel varchar(250) NULL,
	nr_votavel int4 NULL,
	nm_votavel varchar(250) NULL,
	qt_votos int4 NULL,
	nr_urna_efetivada int4 NULL,
	cd_carga1_urna_efetivada varchar(100) NULL,
	cd_carga2_urna_efetivada varchar(100) NULL,
	cd_flashcard_urna_efetivada varchar(100) NULL,
	dt_carga_urna_efetivada date NULL,
	ds_cargo_pergunta_secao varchar(250) NULL,
	ds_agregadas varchar(250) NULL,
	dt_abertura timestamp NULL,
	dt_encerramento timestamp NULL,
	qt_eleitores_biometria_nh int4 NULL,
	dt_emissao_bu timestamp NULL,
	nr_junta_apuradora int4 NULL,
	nr_turma_apuradora int4 NULL,
	file_name varchar(250) NULL,
	CONSTRAINT boletim_urna_pkey PRIMARY KEY (id)
);
CREATE INDEX "nr_partido_idx" ON boletim_urna USING btree (nr_partido);


CREATE SEQUENCE seq_boletim_urna
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;
