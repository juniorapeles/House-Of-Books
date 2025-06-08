# 📚 TechLibrary API

Uma API RESTful simples e automatizada para gerenciamento de empréstimos de livros. Desenvolvido com Java 17, Spring Boot, JPA e padrões genéricos para reaproveitamento de código.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- Banco de postgres
- insomnia (para testes)
- Maven

---

## 🧠 Estrutura do Projeto

A aplicação é baseada em uma estrutura **genérica e automatizada** para facilitar reuso de código
e agilidade no desenvolvimento de novos módulos.

com.techlibrary
│
├── config # Configurações gerais do projeto
├── generics # Camada genérica para controller, service, repository e mapeamento
├── features # Funcionalidades (User, Book, Loan)
│ ├── book # CRUD de livros
│ ├── user # CRUD de usuários
│ └── loan # CRUD de empréstimos (inclui lógica de status)
└── TechLibraryApplication.java

---

## 📦 Funcionalidades

- 📘 Cadastrar, listar, editar e remover **livros**
- 👤 Cadastrar, listar, editar e remover **usuários**
- 🔄 Realizar **empréstimos** e marcar como **devolvidos**
- 🔒 Controle de status do livro (Livre ou Emprestado)

---

## 🔁 Lógica de Empréstimo

- Ao criar um empréstimo (`Loan`), o status do livro é automaticamente alterado para `BORROWED`.
- Ao devolver um livro, o status é atualizado para `AVAILABLE`.

---

## 🔨 Endpoints Exemplo

### 📚 Books

| Método | Endpoint         | Descrição               |
|--------|------------------|-------------------------|
| GET    | `/books`         | Lista todos os livros   |
| POST   | `/books`         | Cria um novo livro      |
| PUT    | `/books/{id}`    | Atualiza um livro       |
| DELETE | `/books/{id}`    | Remove um livro         |

### 👤 Users

| Método | Endpoint         | Descrição               |
|--------|------------------|-------------------------|
| GET    | `/users`         | Lista todos os usuários |
| POST   | `/users`         | Cria um novo usuário    |

### 🔁 Loans

| Método | Endpoint         | Descrição                         |
|--------|------------------|-----------------------------------|
| GET    | `/loans`         | Lista os empréstimos             |
| POST   | `/loans`         | Cria um novo empréstimo          |
| PUT    | `/loans/return/{id}` | Devolve um livro (atualiza status) |

---

## 💡 Exemplo de JSON para Empréstimo

```json
{
  "book": {
		"id":5,
    "title": "Clean Code",
    "author": "Robert C. Martin"
  },
  "user": {
		"id":2,
    "name": "Júnior",
    "email": "junior@example.com"
  }
}

✅ To-Do Futuro
 Implementar autenticação (Spring Security + JWT)

 Swagger para documentação automática

 Testes unitários e de integração

 Integração com banco MySQL/PostgreSQL

 Dockerização da aplicação
