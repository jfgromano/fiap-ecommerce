#!/bin/bash

# Encontra todos os diretórios contendo arquivos docker-compose.yml
for docker_compose_dir in $(find . -type f -name "docker-compose.yml" -exec dirname {} \;); do
    echo "Entrando no diretório: $docker_compose_dir"
    cd "$docker_compose_dir" || exit
    echo "Executando docker-compose down..."
    docker compose down
    echo "Retornando para o diretório anterior."
    cd - > /dev/null || exit
done
