# Eu-Comida

## Visão Geral

Este é um projeto desenvolvido com **Spring Boot 3.4.3**, utilizando **Spring MVC**, **Spring Security**, **JPA (Hibernate)** e **MySQL**. Ele implementa uma API RESTful para um sistema de gerenciamento de alimentos, com autenticação baseada em **JWT** e documentação automática via **Swagger/OpenAPI**.

## Tecnologias Utilizadas

- **Spring Boot 3.4.3**
- **Java 17**
- **Spring MVC**
- **Spring Security**
- **Spring Data JPA**
- **MySQL**
- **JWT (Java Web Token - JJWT)**
- **Swagger/OpenAPI**
- **Docker** 
- **JUnit e Mockito** para testes

## Pré-requisitos

Antes de rodar o projeto, você precisa ter as seguintes ferramentas instaladas:

- **Java 17**: [Instalar Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **Maven**: [Instalar Maven](https://maven.apache.org/install.html)
- **Docker e  Docker Compose** : [Instalar Docker](https://docs.docker.com/get-docker/)

## Instalação e Execução

1. **Clone o repositório**:
   ```sh
   git clone https://github.com/seu-usuario/eu-comida.git
   cd eu-comida
1. **Inicie o Docker**: no Windows pelo aplicativo desktop ou no Linux com o comando:
   ```sh
   sudo systemctl start docker
2. **Instale as dependências e rode o projeto**:
   ```sh
   docker-compose up --build

3. **O aplicativo estará disponível em: http://localhost:8080**

## Documentação da API
A documentação da API gerada automaticamente pelo Swagger/OpenAPI pode ser acessada em: http://localhost:8080/swagger-ui/index.html

No diretório .postman está o Json das requisições e das variaveis de ambiente que devem ser importadas no postman:
Na aba Collections clicar em **Import** então selecionar o arquivo XXXX
Na aba Enviroments clicar em **Import** então selecionar o arquivo XXXX
Depois de importado em cada requisição existe um exemplo de chamada desta com o request e o response.

## Autenticação e Segurança
O sistema utiliza JWT para autenticação. Para acessar as rotas protegidas, você deve obter um token JWT ao realizar o login e incluir esse token no cabeçalho das requisições.

Exemplo de cabeçalho para requisições autenticadas:
   Authorization: Bearer <seu_token_jwt>

## Contribuição
Se você deseja contribuir para o projeto, siga os seguintes passos:

1. Fork o repositório.
1. Crie uma nova branch para suas modificações.
1. Envie um pull request descrevendo suas alterações.

## Contato
Para mais informações, entre em contato com:

Email: majadarosa@gmail.com