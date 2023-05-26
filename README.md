# API de Confirmação de Voos

Esta é uma API RESTful desenvolvida em Java com o framework Spring Boot, destinada à gestão de confirmações de voos, incluindo gerenciamento de passageiros, assentos e pontos de fidelidade.

## Funcionalidades

- **Registro de Passageiros**: permite o registro de passageiros com informações como CPF, nome, data de nascimento, classificação e saldo de milhas.
- **Confirmação de Voos**: permite a realização do check-in do passageiro, indicando o assento escolhido e se as malas foram despachadas.
- **Gestão de Assentos**: gerencia a disponibilidade dos assentos no voo e regras especiais para fileiras de emergência.
- **Cálculo de Milhas**: atualiza o saldo de milhas do passageiro de acordo com a sua classificação após a confirmação do voo.

## Uso

O uso da API é através de requisições HTTP para os respectivos endpoints.

Para realizar uma confirmação de voo, envie uma requisição POST para /api/passageiros/confirmacao com o CPF do passageiro, o assento escolhido e se as malas foram despachadas.

Exemplo de requisição:

```json
POST /api/passageiros/confirmacao
Content-Type: application/json

{
    "cpf": 12345678901,
    "assento": "4A",
    "malasDespachadas": true
}
```

Exemplo de resposta de sucesso:

```json
HTTP 200 OK
Content-Type: application/json

{
    "eticket": "89cce4b6-d315-4382-9652-500c61cde768",
    "dataHoraConfirmacao": "25/05/2023 15:34:33"
}
```

## Tratamento de Erros

A API possui tratamento de exceções personalizado, retornando mensagens de erro claras e HTTP Status Codes apropriados. 
As regras de negócio estão definidas para garantir que apenas passageiros registrados possam confirmar voos, que os assentos 
escolhidos estejam disponíveis e que as regras para as fileiras de emergência sejam respeitadas.
