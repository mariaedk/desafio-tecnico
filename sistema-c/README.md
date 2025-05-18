# Sistema C - Consulta de Eventos Relacionados a CPF

## Descrição
Tem como objetivo expor informações públicas relacionadas a um determinado CPF. Essas informações incluem:

- Última consulta em bureau de crédito
- Lista de movimentações financeiras
- Última compra realizada com cartão

O sistema é enxuto.

## Endpoints Disponíveis

### `GET /evento/{cpf}?consultadoPor={entidade}`
Consulta os eventos públicos associados ao CPF informado.

#### Parâmetros:
- `cpf` (path): CPF a ser consultado.
- `consultadoPor` (query): Nome da entidade responsável pela consulta (ex: banco, instituição financeira).

#### Exemplo de resposta:
```json
{
  "cpf": "12345678900",
  "consultaBureau": {
    "data": "2025-05-16T14:00:00",
    "consultadoPor": "Banco Inter"
  },
  "movimentacoes": [
    {
      "data": "2025-05-15T10:00:00",
      "tipoTransferencia": "PIX",
      "direcao": "ENVIADO",
      "valor": 1500,
      "statusEvento": "PAGO",
      "descricao": "Pagamento de boleto"
    }
  ],
  "ultimaCompraCartao": {
    "data": "2025-05-17T15:30:00",
    "valor": 359.90,
    "estabelecimento": "Loja Online"
  }
}
```

## Segurança
Este sistema **não possui autenticação**, pois os dados são considerados públicos para fins de simulação. A responsabilidade pela requisição é indicada por meio do parâmetro `consultadoPor`.

## Arquitetura
- Linguagem: Java 21
- Framework: Spring Boot 3.4
- Estilo: Nanosserviço (sem banco, sem domínio complexo)
- Os dados são mockados e carregados em memória durante a inicialização.
- As responsabilidades estão divididas em:
    - Repositórios simulados (`RepositoryImpl`)
    - Conversores de dados (`MapperUtils`)
    - DTOs com estrutura simplificada e aderente ao payload definido no desafio

## Health Check

### `GET /health`
Retorna `200 OK` se o serviço estiver ativo.
