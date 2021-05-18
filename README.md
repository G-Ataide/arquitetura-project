# Arquitetura-Project

## Objetivo:
1. Criar um simples projeto Back-end de uma Companhia Aérea para realizar a consulta de vôos e venda de passagens.
2. Criar uma imagem de um container com a aplicação.
3. Rodar o container, disponibilizando a porta 5000 para consumir as API's.

## Rodando Projeto:
1. Acesse o CMD/SHELL na pasta raiz e rode o comando ``docker build -t spring-app .`` para criar a imagem.
2. Após criada a imagem, rode o comando ``docker run -p 5000:8080 spring-app`` para subir um container da imagem criada anteriormente.
3. Importe o arquivo `ProjectAero.postman_collection.json` no Postman para consumir as API's do projeto.

## TODO:
1. Finalizar Docker Compose

## OBS:
Caso seja necessário, acesse o banco de dados através da URL: ``http://localhost:5000/h2-console/`` utilizando as seguintes credenciais:
    1. url: ``jdbc:h2:mem:aerocompany``
    2. username: ``sa``
    3. password: ``password``