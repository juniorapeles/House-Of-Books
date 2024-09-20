# Changelog

Todas as mudanças importantes deste projeto.

## [1.0.1] - 2024-09-19

### Adicionado
- Primeira versão do projeto House-of-Books.
- Login JWT implementado. (pendente)
- Sistema de autenticação e autorização com Spring Security. (pendente)
- Documentação Swagger para a API. (pendente)

### Alterado
- Melhorias na injeção de dependência.
- Refatoração da camada de serviços e repositórios para desacoplamento e melhor testabilidade.
- Ajuste no mapeamento de entidades para DTO usando ModelMapper. (pendente)
- Incrementos no Clean Architecture e padrões de design. (pendente)

### Corrigido
- Erro ao mapear o DTO no serviço de livros.
- Correções nos métodos `insert`, `findAllPaged` e `findById` do `LoanController` e `LoanService`.
- Ajustes nos testes unitários e de integração para cobrir novos cenários de autenticação e busca paginada.

### Implementado
- Containerização com Docker para a aplicação e banco de dados. (pendente)
- Configuração de um ambiente com Docker Compose para facilitar o deploy. (pendente)
