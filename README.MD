# Spring Batch

### Leitura dos arquivos de boletim de urnas do TSE segundo turno eleições 2022

https://dadosabertos.tse.jus.br/dataset/resultados-2022-boletim-de-urna

To run:
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --pathToFile=/<PATH>/bweb_2t_AC_311020221535.csv"

mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --pathToFile=/Users/guilhermebahia/Developer/Eclipse/TRE/bweb_2t_AC_311020221535/bweb_2t_AC_311020221535.csv"