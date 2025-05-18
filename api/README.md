# Sistema de Integração (API Gateway)

Este projeto representa a camada de integração entre os sistemas A, B e C. Ele funciona como uma API intermediária, responsável por autenticar o usuário, validar a disponibilidade dos serviços e encaminhar as requisições aos sistemas responsáveis por cada tipo de dado.

## Objetivo

Disponibilizar, de forma centralizada e segura, os dados provenientes das três bases (Sistema A, Sistema B e Sistema C), garantindo autenticação e controle de acesso baseados em roles.

## Funcionalidades

- Login com usuário e senha.
- Armazenamento temporário das credenciais para chamadas subsequentes.
- Health check automático dos sistemas A, B e C.
- Encaminhamento de chamadas GET para os endpoints de cada sistema.
- Proteção dos endpoints com JWT e validação de roles específicas.

## Tecnologias

- Java 21
- Spring Boot 3
- Spring Security (JWT)
- WebClient (para chamadas HTTP entre serviços)
- Swagger/OpenAPI 3

## Estrutura de Roles

- `ADMINISTRADOR`: acesso ao Sistema A
- `CONSULTA`: acesso ao Sistema B e C

## Endpoints

- `POST /auth/login`: autentica e salva temporariamente as credenciais.
- `GET /integracao/sistema-a/{cpf}`: consulta dados do Sistema A.
- `GET /integracao/sistema-b/{cpf}`: consulta dados do Sistema B.
- `GET /integracao/sistema-c/{cpf}`: consulta dados do Sistema C.

## Considerações Técnicas

- Cada chamada GET valida se o sistema está online via `/health`.
- As credenciais do login feito na API são utilizadas internamente para autenticação nos sistemas A e B.
- O Sistema C não exige autenticação.

## Considerações finais
- A exportação em planilhas foi deixada de fora para manter a API enxuta e focada na comunicação entre sistemas. Caso seja necessário, essa funcionalidade pode ser implementada futuramente e consumida por aplicações consumidoras (como frontends ou ferramentas de BI).