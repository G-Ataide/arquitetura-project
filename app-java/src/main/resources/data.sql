-- auto-generated definition
CREATE TABLE IF NOT EXISTS air_travel
(
    id              bigint auto_increment
        primary key,
    amount_seat     bigint         null,
    price           decimal(19, 2) null,
    ts_arrival      datetime(6)    null,
    ts_departure    datetime(6)    null,
    airport_dest_id bigint         not null,
    aiport_orig_id  bigint         not null,
    constraint FK2e8o49qltdwr9s8tnl0em5ob0
        foreign key (airport_dest_id) references airport (id),
    constraint FKoofsu7nygmrroylnv5aiasew3
        foreign key (aiport_orig_id) references airport (id)
);

-- auto-generated definition
CREATE TABLE IF NOT EXISTS airport
(
    id   bigint auto_increment
        primary key,
    code varchar(255) null,
    name varchar(255) null
);

-- auto-generated definition
CREATE TABLE IF NOT EXISTS ticket
(
    id                 bigint auto_increment
        primary key,
    locator            varchar(255)   null,
    passenger_document varchar(255)   null,
    passenger_name     varchar(255)   null,
    price              decimal(19, 2) null,
    seat               varchar(255)   null,
    airtravel_id       bigint         not null,
    constraint FK7cu9uh8dldggbq919cwnuwbg7
        foreign key (airtravel_id) references air_travel (id)
);

-- auto-generated definition
CREATE TABLE IF NOT EXISTS user
(
    id       bigint auto_increment
        primary key,
    email    varchar(255) null,
    name     varchar(255) null,
    password varchar(255) null,
    token    varchar(255) null
);

INSERT INTO airport (id, code, name) VALUES (1, 'UBR', 'Uberlândia');
INSERT INTO airport (id, code, name) VALUES (2, 'DUB', 'Dubai');
INSERT INTO airport (id, code, name) VALUES (3, 'ARG', 'Araguari');
INSERT INTO airport (id, code, name) VALUES (4, 'SPA', 'São Paulo');
INSERT INTO airport (id, code, name) VALUES (5, 'RDJ', 'Rio de Janeiro');
INSERT INTO airport (id, code, name) VALUES (6, 'SNT', 'Santos');
INSERT INTO airport (id, code, name) VALUES (7, 'ARX', 'Araxá');
INSERT INTO airport (id, code, name) VALUES (8, 'SGT', 'São Gotardo');

INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (1, 390, 123.60, '2021-05-14 15:45:00', '2021-05-14 12:00:00', 2, 1);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (2, 111, 321.60, '2021-05-14 17:00:00', '2021-05-14 13:00:00', 3, 1);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (3, 90, 99.99, '2021-05-14 19:30:00', '2021-05-14 14:30:00', 4, 1);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (4, 70, 87.50, '2021-05-15 09:55:00', '2021-05-15 09:00:00', 3, 2);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (5, 50, 55.60, '2021-05-15 19:00:00', '2021-05-15 10:00:00', 4, 2);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (6, 200, 9987.50, '2021-05-16 16:30:00', '2021-05-16 10:30:00', 4, 3);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (7, 100, 55.99, '2021-05-16 18:30:00', '2021-05-16 10:30:00', 5, 3);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (8, 60, 654.69, '2021-05-15 11:00:00', '2021-05-15 10:00:00', 6, 4);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (9, 80, 987.99, '2021-05-14 20:00:00', '2021-05-14 11:00:00', 1, 5);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (10, 110, 369.98, '2021-05-14 19:00:00', '2021-05-14 13:00:00', 2, 6);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (11, 100, 258.55, '2021-05-30 10:45:00', '2021-05-30 09:45:00', 8, 7);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (12, 300, 147.58, '2021-05-30 09:00:00', '2021-05-30 08:00:00', 1, 8);
INSERT INTO air_travel (id, amount_seat, price, ts_arrival, ts_departure, airport_dest_id, aiport_orig_id) VALUES (13, 200, 50.00, '2021-05-30 09:10:00', '2021-05-30 07:10:00', 4, 8);

INSERT INTO ticket (id, locator, passenger_document, passenger_name, price, seat, airtravel_id) VALUES (3, 'UBR-ARG-5ai1j0dbdh4ji1cj0a70je5ah55ddb', '13123RG', 'João Barboza', 321.60, 'B15', 2);
INSERT INTO ticket (id, locator, passenger_document, passenger_name, price, seat, airtravel_id) VALUES (4, 'UBR-ARG-5ai1j0dbdh4f123123123e5ah5569c', '587988', 'Márcio Cunha', 321.60, 'B155', 2);
INSERT INTO ticket (id, locator, passenger_document, passenger_name, price, seat, airtravel_id) VALUES (5, 'UBR-ARG-5abcd1234asdfg5688qfge5ah55587', '12589987', 'Gabriel Cardoso', 321.60, 'B4155', 2);

INSERT INTO user (id, email, name, password, token) VALUES (1, 'g@gmail.com', 'Gabriel', '68eacb97d86f0c4621fa2b0e17cabd8c', '367e58209bf0ae5dba9dac254bc31123');
INSERT INTO user (id, email, name, password, token) VALUES (2, 'gcm@gmail.com', 'Gabriel Cardoso', '68eacb97d86f0c4621fa2b0e17cabd8c', null);
INSERT INTO user (id, email, name, password, token) VALUES (3, 'marcio@ufu.br', 'Márcio', '40c9f2b212323f51e517cc29969bee', null);