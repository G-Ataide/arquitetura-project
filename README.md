﻿# Arquitetura de Software Aplicada
## Project Aero
#### Desenvolvido por:
1. Gabriel Cardoso - 11811ECP008
2. João Barboza - 11811ECP005
3. Alan Nicolas - 12011ECP025

### Objetivo:
1. Criar um simples projeto Back-end de uma Companhia Aérea para realizar a consulta de voos e venda de passagens.
2. Criar uma imagem de um container UBUNTU, instalar os componentes necessários para a aplicação.
3. Rodar o container, disponibilizando a porta 5000 para consumir as API's.

### Rodando Projeto:
1. Acesse o CMD/SHELL na pasta raiz e rode o comando ``docker-compose up`` para iniciar o projeto.
2. Importe o arquivo `ProjectAero.postman_collection.json` no Postman para consumir as API's do projeto.

### Funcionalidades:
1. Efetuar Login:

    [POST] ``localhost:5000/airtravel/login``
    
    Body: 
    ````json
    {
        "email": "test@mail.com",
        "password": "Test123" 
    }
    ````

2. Efetuar Logout:

    [GET] ``localhost:5000/airtravel/logout/:token``

3. Validar Sessão:

    [GET] ``localhost:5000/airtravel/valid-session/:token``

4. Retornar Aeroportos:

    [GET] ``localhost:5000/airtravel/all``

5. Retornar Aeroportos por Origem:

    [GET] ``localhost:5000/airtravel/orig/:origId``

6. Retornar Voos:

    [GET] ``localhost:5000/airtravel/date/:date[YYYY-MM-DD]``

7. Pesquisar Voos:

    [GET] ``localhost:5000/airtravel/amount-passenger/:amount-passanger``

8. Efetuar Compra:

    [POST] ``localhost:5000/ticket/buy``

    Body: 
    ````json
    {
        "token": "d98712fed8d4214a08a006580cbd3895",
        "seat": "B4155",
        "airtravelId": "1",
        "passengerName": "Gabriel Cardoso",
        "passengerDocument": "123456RG"
    }
    ````

### OBS:
1. Caso seja necessário, acesse o banco de dados através da URL: ``http://localhost:5000/h2-console/`` utilizando as seguintes credenciais:
    1. Url: ``jdbc:h2:mem:aerocompany``
    2. Username: ``sa``
    3. Password: ``password``

2. Os arquivos presentes na pasta ``app-java`` servem somente para consulta, não é necessário utiliza-los para subir/rodar o projeto.
