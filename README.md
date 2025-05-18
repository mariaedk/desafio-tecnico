# Desafio Técnico Serasa

Este repositório contém a implementação completa de uma solução distribuída composta por quatro sistemas distintos: Sistema A, Sistema B, Sistema C e uma API de Integração. Cada sistema representa uma base de dados externa simulada, com níveis diferentes de sensibilidade e requisitos técnicos.

---

## Visão Geral da Arquitetura

A solução foi estruturada com base em microserviços e nanosserviços, seguindo os princípios de segurança, desacoplamento e escalabilidade. Cada serviço foi implementado de forma isolada, com seu próprio controle de acesso, modelo de domínio e integração simulada via mock.
Todas as APIs foram desenvolvidas em Java.

---

## Componentes

### 🔷 Sistema A – Microserviço (Base A)
- **Descrição:** Exposição de dados sensíveis como CPF, nome, endereço e lista de dívidas.
- **Segurança:** Implementação de autenticação JWT, criptografia de CPF e controle de acesso por role.

### 🔷 Sistema B – Microserviço (Base B)
- **Descrição:** Exposição de dados relevantes para cálculo de score, como bens, renda, tipo de renda e histórico de empréstimos.
- **Segurança:** Autenticação JWT com validação de usuário e senha no login.

### 🔷 Sistema C – Nanosserviço (Base C)
- **Descrição:** Exposição de eventos relacionados ao CPF (última consulta em bureau, movimentações financeiras e compras recentes).
- **Segurança:** Serviço público (sem autenticação) para refletir a natureza de dados não sensíveis.

### 🔷 API de Integração
- **Descrição:** Interface única que centraliza o acesso aos dados das três bases.
- **Funcionalidade:** Após realizar login com usuário e senha, esta API propaga as credenciais para autenticar nos Sistemas A e B e retorna os dados do CPF consultado.
- **Segurança:** JWT próprio com controle de escopo por endpoint:
  - `/integracao/sistema-a/**` → `ADMINISTRADOR`
  - `/integracao/sistema-b/**` → `CONSULTA`
  - `/integracao/sistema-c/**` → `CONSULTA`

---

## Autenticação e Permissões

A autenticação é feita por JWT, com as seguintes credenciais pré-configuradas nas bases A e B:

- `admin` / `admin123` → Role: `ADMINISTRADOR`
- `analista` / `analista123` → Role: `CONSULTA`

Na API de integração, o login aceita as mesmas credenciais e as reaproveita nos serviços A e B para autenticação e recuperação de dados.

---

## Execução Local

Certifique-se de executar as aplicações nas seguintes portas:

- `sistema-a` → `8081`
- `sistema-b` → `8082`
- `sistema-c` → `8083`
- `api (integração)` → `8080`

---

## Considerações sobre Exportação de Dados

Apesar de não implementada nesta versão, a exportação de dados em CSV ou Excel pode ser adicionada futuramente, com o objetivo de atender perfis analíticos que exigem relatórios manuais. Por ora, a escolha pelo formato JSON atende a demanda de integrações rápidas e sistemas consumidores.

---

## Observações Finais

- Todos os sistemas utilizam dados simulados (mockados).
- As requisições de consulta partem sempre da API de Integração.

---

