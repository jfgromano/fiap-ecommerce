FROM postgres:15.2

#timezone
ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#pacotes comuns
RUN apt update && apt-get install -y \
    vim \ 
    git

COPY create-multiple-postgresql-databases.sh /docker-entrypoint-initdb.d/

EXPOSE $POSTGRES_HOST_PORT