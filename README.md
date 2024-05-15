Projeto Spring Boot para Aula de Web Services - UNINORTE
Descrição
Este projeto é uma aplicação Spring Boot desenvolvida como parte da aula de Web Services na UNINORTE. O objetivo é demonstrar a criação e o consumo de Web Services RESTful, abordando conceitos de segurança, validação de dados e integração com bancos de dados.

Funcionalidades
CRUD de Entidades: Implementação de operações de Create, Read, Update e Delete para gerenciar entidades.
Autenticação e Autorização: Utilização de Spring Security para proteger endpoints e controlar acesso baseado em roles.
Validação de Dados: Validação de dados de entrada usando anotações de validação do Spring.
Documentação da API: Documentação dos endpoints utilizando Swagger/OpenAPI.
Tecnologias Utilizadas
Spring Boot : Framework principal para ac
Spring Data JPA: Persistência e acesso a dados.
Spring Security: Segurança e controle de acesso.
Hibernate : Implementação
MySQL: Banco de dados relacional.
Swagger: Ferramenta para documentação da API.
Maven: Gerenciamento de dependências e build da aplicação.
Pré-requisitos
JDK 11 ou superior
Maven
MySQL
Configuração do Banco de Dados
Certifique-se de que o MySQL está instalado e em execução. Crie um banco de dados para o projeto:
CREATE DATABASE uninorte_aulas;
Atualize as credenciais de acesso ao banco de dados no arquivo src/main/resources/application.properties:
# Driver e Autenticação
spring.datasource.url=jdbc:mysql://localhost:3306/uninorte_aulas?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

Compile e execute a aplicação:
mvn spring-boot:run

A aplicação estará disponível em http://localhost:8080.

Endpoints Principais
GET /api/entidades: Lista todas as entidades.
GET /api/entidades/{id}: Obtém uma entidade pelo ID.
POST /api/entidades: Cria uma nova entidade.
PUT /api/entidades/{id}: Atualiza uma entidade existente.
DELETE /api/entidades/{id}: Deleta uma entidade pelo ID.
Segurança
Autenticação: Os usuários devem se autenticar para acessar endpoints protegidos.
Roles: Controle de acesso baseado em roles de usuário (e.g., ADMIN, USER).
Documentação da API
A documentação da API pode ser acessada via Swagger em http://localhost:8080/swagger-ui.html.

Contribuição
Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

Fork o repositório.
Crie uma branch para sua feature (git checkout -b feature/nova-feature).
Commit suas mudanças (git commit -am 'Adiciona nova feature').
Push para a branch (git push origin feature/nova-feature).
Abra um Pull Request.
Contato
Para dúvidas ou sugestões, entre em contato pelo email: endriosrobert@gmail.com.
