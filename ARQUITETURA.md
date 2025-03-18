## Arquitetura do projeto
Este projeto utiliza Spring Boot 3.4.3 como base para o desenvolvimento de uma aplicação web robusta e escalável. Este projeto é desenvolvido com as seguintes tecnologias e frameworks principais:

### Tecnologias Utilizadas
Spring Boot 3.4.3 – Framework principal para desenvolvimento da aplicação.
Java 17 – Versão da JVM utilizada.
Maven – Gerenciador de dependências e build.
### Frameworks e Bibliotecas
* Spring MVC – Estrutura para desenvolvimento de APIs RESTful.
* Spring Security – Implementação de autenticação e controle de acesso.
* Spring Data JPA (Hibernate) – Integração com banco de dados relacional utilizando JPA.
* MySQL Connector – Driver JDBC para conexão com MySQL.
* JWT (Java Web Token - JJWT) – Implementação para autenticação baseada em tokens JWT.
* Swagger/OpenAPI (Springdoc) – Documentação automática da API.
* Docker Compose – Gerenciamento de serviços em containers para facilitar a configuração de ambiente.
* Spring Boot Starter Test – Suporte para testes unitários e de integração.
### Configuração de Ambientes
A integração com Docker Compose permite a configuração simplificada do ambiente de desenvolvimento e execução da aplicação, garantindo uma infraestrutura consistente e portátil.

### Suporte a Testes
O projeto inclui o Spring Boot Starter Test, que oferece suporte a JUnit e Mockito, permitindo a criação de testes unitários e de integração para garantir a qualidade do código.

### Escolha das tecnologias

O projeto utiliza um banco de dados relacional (MySQL) para garantir integridade, consistência e segurança dos dados, aproveitando transações ACID e modelagem estruturada. A eficiência e escalabilidade são otimizadas por recursos como indexação, caching e replicação. Além disso, o Spring Data JPA facilita a integração, e a compatibilidade com Docker Compose agiliza a configuração do ambiente.

Utiliza JWT para autenticação stateless, eliminando a necessidade de armazenar sessões no servidor e garantindo escalabilidade. Os tokens são assinados digitalmente, garantindo integridade e segurança. Além disso, reduzem consultas ao banco, melhorando a performance. O JWT é compatível com RESTful APIs e Spring Security, facilitando a integração. Também permite expiração e controle de acesso, reforçando a segurança.

## Próximos passos
1. Definir a arquitetura de Frontend e Mobile.
2. Para o backend avaliar uma migração para nuvem AWS.
3. Definição e implementação de regras para CRUD de  restaurantes, produtos e entregadores.
4. Definição de layout de front e mobile usando Figma