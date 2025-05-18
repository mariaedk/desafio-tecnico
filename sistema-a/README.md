Sistema A - Serviço de Consulta de Pessoa
=========================================

Descrição
------------
O Sistema A é um microserviço responsável por fornecer informações sensíveis de pessoas, como CPF, nome, endereço e lista de dívidas. Ele acessa a Base A, que exige altos níveis de segurança, mas não demanda performance extrema. O foco principal deste sistema é garantir a integridade e a confidencialidade dos dados.

Objetivo
-----------
Expor, de maneira segura e controlada, os dados cadastrais e financeiros de uma pessoa vinculados ao CPF informado.

Segurança
------------
Este serviço foi projetado com foco em segurança:

- Utiliza autenticação via JWT, com geração de tokens válidos via /auth/login
- Proteção dos endpoints com controle de acesso via roles específicas
- Criptografia de CPF armazenado
- Filtro JWT implementado para validar e extrair as roles do token
- Configuração de CORS e exposição mínima de dados
- Mapeamento explícito dos campos retornados para evitar vazamentos

Endpoints
------------

Autenticação:
POST /auth/login
Entrada: { "username": "admin", "password": "admin123" }
Saída: { "accessToken": "<jwt_token>" }

Consulta de Pessoa:
GET /pessoa/{cpf}
- Protegido por role: ADMINISTRADOR
- Exige JWT válido no cabeçalho Authorization: Bearer <token>
- Retorna:
  {
  "cpf": "12345678900",
  "nome": "Maria Eduarda",
  "endereco": { ... },
  "dividas": [ ... ]
  }

Tecnologias Utilizadas
-------------------------
- Java 21
- Spring Boot 3.x
- Spring Security (JWT)
- MapStruct
- Maven

Dados Mockados
-----------------
Os dados retornados são simulados (mockados) para fins do desafio. A criptografia é aplicada ao CPF, e durante a resposta ele é convertido de volta manualmente para exibição.

Requisitos de Acesso
------------------------
Este sistema só pode ser acessado com tokens válidos emitidos pelo próprio endpoint /auth/login. A role do usuário deve ser ADMINISTRADOR para acessar os dados da pessoa.

Health Check
---------------
GET /health
Retorna 200 OK se o serviço estiver online.