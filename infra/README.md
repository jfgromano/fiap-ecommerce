# FIAP Pós Tech - Tech Challenge

## Ambiente dev
O ambiente dev é util para testes com IDE, ele nao vai compilar os microservicos e criar um container java, mas sobe os containers de banco e rabbit para funcionar em conjunto com a IDE, na pasta dev basta fazer o build e subir os containers:

```bash
cp .env.example .env
vim .env # editar se necessario alterar alguma porta
docker compose up -d
```

## Ambiente homolog
O ambiente homolog sobe a aplicação completa, sem a necessidade de uma IDE para executar a aplicação Java.

Basta criar a rede e depois entrar em cada uma das pastas dos servicos, criar o arquivo de variaveis de ambiente, fazer o build das imagens e subir os containers, se for um ambiente linux deixei um arquivo up.sh para facilitar.

```bash
docker network create jfgr-ecommerce
bash up.sh
``` 
ou

```bash
docker network create jfgr-ecommerce

cd autenticacao
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d
cd ..

cd carrinho
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d
cd ..

cd gateway
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d
cd ..

cd gestao-itens
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d
cd ..

cd pagamento
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d
cd ..

cd rabbit
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d
```