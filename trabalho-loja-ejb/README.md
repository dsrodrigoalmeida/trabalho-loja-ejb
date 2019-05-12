Trabalho de criação de um carrinho de compras para a cadeira de Desenvolvimento Com Frameworks E Componentes com o professor Michel Vasconcelos pela Uni7.

Os pre requisitos do sistema :

Java 11
Maven
Wildfly 16

O context root do projeto é /loja

Para fazer a instalção no computador utilizar os seguintes comandos:

mvn clean install

mvn eclipse:eclipse

Instalando com o uso do docker utilizar os seguintes comandos

docker build -t loja .

docker run -p 9990:9990 -p 8080:8080 loja
