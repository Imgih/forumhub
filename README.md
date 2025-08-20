#   ForumHub 👩‍💻

API REST com Spring Boot!

FórumHub é uma API REST desenvolvida em **Java com Spring Boot**, que permite a criação e gerenciamento de tópicos em um fórum, com autenticação via **JWT**. O projeto foi construído como parte de um desafio de backend, utilizando boas práticas de segurança e persistência de dados.

---

## 📌 Funcionalidades

- CRUD completo de tópicos:
    - Criar novo tópico
    - Listar todos os tópicos
    - Buscar tópico por ID
    - Atualizar tópico
    - Deletar tópico
- Autenticação de usuários via **JWT**
- Proteção de rotas com **Spring Security**
- Persistência de dados em **MySQL**
- Migrações de banco de dados com **Flyway**
- Validação de dados via **Spring Validation**

---

## 👩‍💻 Tecnologias

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- MySQL 8+
- JWT (Auth0)
- Flyway
- Lombok
- Maven

---
## Tópicos
- Método	    Endpoint	    Descrição

        POST	 /topicos	 Criar novo tópico
        GET	  /topicos	Listar todos os tópicos
        GET   /topicos/{id}	Buscar tópico por ID
        PUT	  /topicos/{id}	Atualizar tópico
        DELETE /topicos/{id}	Deletar tópico


## Desenvolvido por Giovanna Felicio ⭐