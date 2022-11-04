# Spring Batch

### Essa aplicação esta configurada para utilizar o PostgreSQL.   
Se for utilizar outro banco de dados revise as bibliotecas do mesmo no pom.xml e atualize suas properiedades nos aquivos application.yml e application-dev.yml.

### application-dev.yml
Atualizar as propriedades referente ao banco de dados que será utilizado.

### Leitura dos arquivos de boletim de urnas do TSE segundo turno eleições 2022

Arquivos:   
https://dadosabertos.tse.jus.br/dataset/resultados-2022-boletim-de-urna   
Baixe os CSV   

Copiar todos na mesma pasta.


Executar:
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --pathToFiles=/<PATH>"

mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --pathToFiles=/Users/guilhermebahia/Developer/Eclipse/TRE/allfiles"


### Index para depois da importação
CREATE INDEX "nr_partido_idx" ON boletim_urna USING btree (nr_partido);