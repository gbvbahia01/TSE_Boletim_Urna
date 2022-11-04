# Spring Batch

### Leitura dos arquivos de boletim de urnas do TSE segundo turno eleições 2022

Arquivos:   
https://dadosabertos.tse.jus.br/dataset/resultados-2022-boletim-de-urna   
Baixe os CSV   

Copiar todos na mesma pasta.


Executar:
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --pathToFiles=/<PATH>"

mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --pathToFiles=/Users/guilhermebahia/Developer/Eclipse/TRE/allfiles"
