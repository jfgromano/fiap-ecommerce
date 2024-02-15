# Sugestão de fluxo para testar as rotas

## Criar usuario admin
```
curl --location 'http://localhost:9090/auth/cadastrar' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "teste222@outlook.com",
    "senha": "123456",
    "nome": "Joao",
    "sexo": "M",
    "dataDeNascimento": "01/02/1990",
    "cpf": 70942337018,
    "admin": true,
    "endereco": {
        "rua": "Rua teste",
        "numero": "12",
        "bairro": "Bairro XYZ",
        "cidade": "São Paulo",
        "estado": "SP"
    },
    "contato" : {
        "email": "asddsa@asd.com.br",
        "numeroCelular": "(11) 95842-8545"
    }

}'
```

## Com o email e senha gerar o JWT, utilizar ele em todas as requests apartir de agora
```
curl --location 'http://localhost:9090/auth' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "teste222@outlook.com",
    "senha": "123456"
}'
```

## Cadastrar alguns itens
```
curl --location 'http://localhost:9090/item' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZTIyMkBvdXRsb29rLmNvbSIsImlzcyI6InRlY2gtY2hhbGxlbmdlIiwiaWF0IjoxNzExMTYzNzc5LCJleHAiOjE3MTExNjQ5Nzl9.7evWxLptxM9rTXBBtn-3fVMbP0r-uIo-_d7nGijna8pju70aYjTshB2uXvahN_YwrtZxhuueDMtZvYXLMBJAnA' \
--data '{
    "nome": "Caneta verde",
    "descricao": "Caneta verde",
    "quantidade": 2 ,
    "valor": 5 
}'

curl --location 'http://localhost:9090/item' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZTIyMkBvdXRsb29rLmNvbSIsImlzcyI6InRlY2gtY2hhbGxlbmdlIiwiaWF0IjoxNzExMTYzNzc5LCJleHAiOjE3MTExNjQ5Nzl9.7evWxLptxM9rTXBBtn-3fVMbP0r-uIo-_d7nGijna8pju70aYjTshB2uXvahN_YwrtZxhuueDMtZvYXLMBJAnA' \
--data '{
    "nome": "Caneta azul",
    "descricao": "Caneta azul",
    "quantidade": 5 ,
    "valor": 4 
}'
```

## Listar os itens disponiveis

```
curl --location 'http://localhost:9090/item?page=0' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZTIyMkBvdXRsb29rLmNvbSIsImlzcyI6InRlY2gtY2hhbGxlbmdlIiwiaWF0IjoxNzExMTYzNzc5LCJleHAiOjE3MTExNjQ5Nzl9.7evWxLptxM9rTXBBtn-3fVMbP0r-uIo-_d7nGijna8pju70aYjTshB2uXvahN_YwrtZxhuueDMtZvYXLMBJAnA'
```

## Usando o id do item desejado, adicionar ele no seu carrinho, alterando a quantidade desejada
```
curl --location 'http://localhost:9090/carrinho/96ce31ec-9a4c-42f3-9adf-d0e82fc5a57e/add' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZTIyMkBvdXRsb29rLmNvbSIsImlzcyI6InRlY2gtY2hhbGxlbmdlIiwiaWF0IjoxNzExMTYzNzc5LCJleHAiOjE3MTExNjQ5Nzl9.7evWxLptxM9rTXBBtn-3fVMbP0r-uIo-_d7nGijna8pju70aYjTshB2uXvahN_YwrtZxhuueDMtZvYXLMBJAnA' \
--data '{
    "quantidade": 1
}'
```

## Visualizar carrinho
```
curl --location 'http://localhost:9090/carrinho' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZTIyMkBvdXRsb29rLmNvbSIsImlzcyI6InRlY2gtY2hhbGxlbmdlIiwiaWF0IjoxNzExMTYzNzc5LCJleHAiOjE3MTExNjQ5Nzl9.7evWxLptxM9rTXBBtn-3fVMbP0r-uIo-_d7nGijna8pju70aYjTshB2uXvahN_YwrtZxhuueDMtZvYXLMBJAnA'
```

## Finalizar pedido, passando os dados de cartao
> Aqui deixei fixo na simulação de pagamento, um agamento com cartao de CREDITO vai falhar e DEBITO vai efetuar pagamento com sucesso.

```
curl --location 'http://localhost:9090/pedido' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZTIyMkBvdXRsb29rLmNvbSIsImlzcyI6InRlY2gtY2hhbGxlbmdlIiwiaWF0IjoxNzExMTYzNzc5LCJleHAiOjE3MTExNjQ5Nzl9.7evWxLptxM9rTXBBtn-3fVMbP0r-uIo-_d7nGijna8pju70aYjTshB2uXvahN_YwrtZxhuueDMtZvYXLMBJAnA' \
--data '{
    "numero": "2222.2222.2222.2222",
    "cvv": "234",
    "tipo": "DEBITO"
}'
```

## Com o id do pedido consultar o status
```
curl --location 'http://localhost:9090/pedido/0d93a12b-05d5-4020-989c-83a459f7f64c' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZTIyMkBvdXRsb29rLmNvbSIsImlzcyI6InRlY2gtY2hhbGxlbmdlIiwiaWF0IjoxNzExMTYzNzc5LCJleHAiOjE3MTExNjQ5Nzl9.7evWxLptxM9rTXBBtn-3fVMbP0r-uIo-_d7nGijna8pju70aYjTshB2uXvahN_YwrtZxhuueDMtZvYXLMBJAnA'
```

Se preferir usar o postman disponivel a collection:

 - [Collection Postman](collection.json)