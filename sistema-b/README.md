# Sistema B - Score de Crédito

## Visão Geral
Este sistema é responsável por fornecer informações relacionadas ao score de crédito de uma pessoa. Foi projetado para simular um serviço independente, com autenticação JWT, consumo via API REST e controle de acesso por roles.

## Funcionalidades Implementadas
- Consulta de dados de score de crédito por CPF.
- Mock de base de dados simulando retorno de dados.
- Autenticação JWT integrada.
- Controle de acesso baseado em roles.
- Health check exposto em `/health`.

## Estrutura da API
### Endpoint principal
- `GET /pessoa/score/{cpf}`
   - Retorna dados de score de crédito de uma pessoa.
   - Necessário passar token JWT com role `CONSULTA`.

### Autenticação
- `POST /auth/login`
   - Corpo da requisição:
     ```json
     {
       "username": "analista",
       "password": "analista123"
     }
     ```
   - Retorna:
     ```json
     {
       "accessToken": "JWT_TOKEN"
     }
     ```

### Health Check
- `GET /health`
   - Retorna 200 OK se a aplicação estiver funcional.

## Roles disponíveis
- `CONSULTA`: Permite acesso ao endpoint de consulta de score.

## Observações Técnicas
- O sistema não possui banco de dados real, utilizando listas mockadas em memória.
- O CPF recebido é consultado diretamente na base mockada.
- A role esperada deve estar presente no token JWT para liberação do acesso.
- As entidades foram simplificadas para manter performance e independência entre os sistemas.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.4.x
- Spring Security
- JWT (jjwt)
- Swagger OpenAPI 3
- Maven

## Execução
- Porta padrão: `8082`
- Após rodar o sistema, acesse `http://localhost:8082/swagger-ui.html` para testar os endpoints via Swagger.