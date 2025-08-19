# **Forum Hub API**

## **Descrição do Projeto**

Este projeto foi desenvolvido como parte do curso "Oracle ONE e Alura" e consiste em uma API RESTful para um fórum. A aplicação foi criada utilizando o framework Spring e permite o gerenciamento de tópicos de discussão.

A API oferece os seguintes endpoints para interação:

* **Criação de Tópicos**: Para que os usuários possam postar novas discussões.  
* **Listagem de Tópicos**: Para exibir os tópicos existentes, com paginação para melhor performance.  
* **Validação de Tópicos**: Garante que tópicos com títulos ou mensagens duplicados não sejam criados.

## **Funcionalidades Principais**

* **API RESTful**: Segue os princípios REST para comunicação entre cliente e servidor.  
* **Controle de Versão**: Gerenciamento de código com Git e hospedagem no GitHub.  
* **Paginação**: Implementa paginação na listagem de tópicos para um acesso mais eficiente.  
* **Validação de Dados**: Utiliza validações de campos para garantir a integridade dos dados recebidos.

## **Tecnologias Utilizadas**

* **Java 21**: Linguagem de programação.  
* **Spring Boot 3.5.4**: Framework para facilitar a criação da aplicação.  
* **Spring Data JPA**: Para abstrair a comunicação com o banco de dados.  
* **Lombok**: Simplifica a criação de classes de modelo.  
* **Maven**: Gerenciador de dependências.

## **Como Configurar e Executar o Projeto**

### **Pré-requisitos**

Certifique-se de que você tem os seguintes softwares instalados:

* JDK 21 ou superior.  
* Uma IDE de desenvolvimento (como IntelliJ IDEA ou VS Code).

### **Configuração do Banco de Dados**

Este projeto foi configurado para usar um banco de dados relacional, mas o código de persistência não está incluído neste README.md. No entanto, você pode facilmente integrar um banco de dados de sua escolha (como MySQL ou PostgreSQL) atualizando o arquivo src/main/resources/application.properties com as credenciais do seu banco de dados.

### **Execução da Aplicação**

1. Clone o repositório do GitHub.  
2. Importe o projeto na sua IDE.  
3. Certifique-se de que todas as dependências do Maven estão instaladas.  
4. Execute a classe principal da aplicação, ForumhubApplication.java.

A API será iniciada e estará disponível em http://localhost:8080.

## **Estrutura do Projeto**

* controller: Contém as classes que gerenciam os endpoints da API.  
* dto: Contém os Data Transfer Objects (DTOs) para mapear os dados das requisições e respostas.  
* model: Contém as classes de entidade que representam o modelo de dados do banco.  
* repository: Contém as interfaces de repositório do Spring Data JPA para acesso ao banco de dados.

## **Autor**

* **Sergio de Oliveira Rafael**  
* **LinkedIn**: [www.linkedin.com/in/sergio-de-oliveira-rafael-47ba29286]
  
