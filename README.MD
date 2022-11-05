# Aplicação Spring Batch Boletim de Urna   
### Leitura dos arquivos de boletim de urnas do TSE segundo turno eleições 2022   

Aplicação para importar os arquivos referente aos boletins de urna no formato CSV liberado pelo TSE.         
Onde baixar: https://dadosabertos.tse.jus.br/dataset/resultados-2022-boletim-de-urna         
Baixe os CSV     

### Essa aplicação esta configurada para utilizar o PostgreSQL.    
Se for utilizar outro banco de dados revise as bibliotecas do mesmo no pom.xml e atualize suas properiedades nos aquivos application.yml e application-dev.yml.      
Os arquivos que geram as tabelas do banco de dados necessários para execução podem ser encontrados no caminho: src/main/resources/db/migration.      
Caso você utilize outro banco de dados que não seja o Postgre deverá atualizar esses arquivo com a sintaxe do banco de sua preferencia.       

##### application.yml    
Se quiser aumentar a quantidade de threads deverá também aumentar a quantidade de conexões com o banco de dados, para não ter erros de falta de conexão ao salvar as linhas:

```
app:
  batch:
    threads:
      chunks: 1000
      amount: 30 #<- Quantidade máxima de Threads executando.
      
  datasource:
    hikari:
      connectionTimeout: 20000
      maximumPoolSize: 30 #<- Quantidade máxima de conexões com o banco de dados.
```

##### application-dev.yml   
Atualizar as propriedades referente ao banco de dados que será utilizado.   


### Execução   
Após baixar os arquivos, copiar todos na mesma pasta e executar o comando passando como argumento pathToFiles o caminho até os arquivos.   

Executar:   
> mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --pathToFiles=/<PATH>"   

Exemplo:
> mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --pathToFiles=/Users/guilhermebahia/Developer/Eclipse/TRE/allfiles"   


### Index para depois da importação   
CREATE INDEX "nr_partido_idx" ON boletim_urna USING btree (nr_partido);   

### SQL   
select * from public.boletim_urna bu where cd_eleicao = 545 order by nm_municipio, nr_zona, nr_secao ; --Somente votos para presidente      
select * from public.boletim_urna bu where cd_eleicao = 547 order by nm_municipio, nr_zona, nr_secao ; --Somente gorvenadores   
