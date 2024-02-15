#!/bin/bash

# Encontra todos os diretórios contendo arquivos docker-compose.yml
for docker_compose_dir in $(find . -type f -name "docker-compose.yml" -exec dirname {} \;); do
    echo "Entrando no diretório: $docker_compose_dir"
    cd "$docker_compose_dir" || exit
    if [ ! -f .env ]; then
        echo "Arquivo .env não encontrado. Copiando .env.example para .env..."
        cp .env.example .env
    fi
    
    echo "Executando docker-compose build..."
    docker compose build
    echo "Executando docker-compose up -d..."
    docker compose up -d
    echo "Retornando para o diretório anterior."
    cd - > /dev/null || exit
done
