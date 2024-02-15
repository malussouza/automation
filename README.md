# Desafio Técnico de QA para o Agibank

## Objetivo

Este é um desafio técnico para a posição de Qualidade de Software (QA) no Agibank.

## Documentação Técnica da Aplicação

A documentação técnica da API está disponível através do [link](https://www.interviewzen.com/apply/RvsWcy).

## Requisitos

Para executar este projeto, é necessário ter os seguintes requisitos:

- Java 11+ JDK 
- Maven configurado no PATH da aplicação


## limpar o cache local e atualizar as dependências
01 Limpar cache
```bash
mvn dependency:purge-local-repository
```
02 Atualizar dependencias
```bash
mvn clean install 
```

## Executar testes<br>

É Possivel executar pela propria IDE, selecionado runners > runner dar play no método <br>
do teste ou podera executar pela linha de comando atraves do comando:<br>
Executar todos os testes<br>

```bash
mvn test 
```



## Estrutura do Projeto
O projeto está dividido em pacotes, conforme a seguir:

pages: Contém classes que representam as páginas do sistema.

steps: Contém classes com os passos dos testes escritos em Gherkin.

utils: Contém classes utilitárias, como a classe para instanciar o WebDriver e a classe para tirar screenshots dos testes.

resources: Contém arquivos de recursos, como o arquivo com as configurações do WebDriver.