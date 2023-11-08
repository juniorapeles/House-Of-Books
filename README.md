# Sistema de Gerenciamento de Biblioteca

## Resumo
O Sistema de Gerenciamento de Biblioteca é uma aplicação web que permite aos usuários registrar bibliotecas, livros e empréstimos de livros. Os principais recursos incluem a adição de bibliotecas, cadastramento de livros, empréstimos de livros e acompanhamento de empréstimos.

## Entidades Principais
- `Library`: Representa uma biblioteca com um nome e uma lista de livros.
- `Book`: Representa um livro com um nome e um autor.
- `User`: Representa um usuário com informações de nome, email e senha.
- `Loan`: Representa um empréstimo de livro com data de início, data de retorno prevista, status, usuário associado e lista de livros emprestados.

## Funcionalidades

### Bibliotecas
- [X] Cadastrar uma nova biblioteca.
- [X] Listar todas as bibliotecas.
- [X] Visualizar detalhes de uma biblioteca específica.

### Livros
- [X] Cadastrar um novo livro associado a uma biblioteca.
- [X] Listar todos os livros em uma biblioteca.
- [X] Visualizar detalhes de um livro específico.

### Usuários
- [X] Registrar um novo usuário.
- [X] Autenticar usuários (login).
- [X] Atualizar informações do usuário.

### Empréstimos
- [X] Registrar um novo empréstimo de livros.
- [X] Listar empréstimos ativos de um usuário.
- [X] Estender o prazo de um empréstimo.
- [X] Verificar a disponibilidade de um livro para empréstimo.
- [X] Listar todos os empréstimos ativos.

## Tecnologias Utilizadas
- Java (Spring Boot) para o backend.
- Banco de dados (por exemplo, PostgreSQL) para armazenar informações.
- HTML, CSS e JavaScript para o frontend.
- Spring Security para autenticação e autorização.
- Spring Data JPA para interação com o banco de dados.

## Próximos Passos
- Implementar a interface do usuário (frontend).
- Configurar as regras de negócios, serviços e controladores para todas as funcionalidades.
- Adicionar validações de entrada e tratamento de exceções.
- Implementar documentação da API.
- Testar o sistema e otimizá-lo conforme necessário.
- Implementar medidas de segurança adicionais, como proteção contra ataques.

Lembre-se de que este é apenas um esboço do sistema. Você pode expandir e detalhar cada funcionalidade de acordo com os requisitos específicos do seu projeto. O mapeamento acima serve como um guia geral para ajudá-lo a estruturar seu sistema de gerenciamento de biblioteca.
