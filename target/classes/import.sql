INSERT INTO produto (descricao,valor) VALUES ('Arroz',12.50);
INSERT INTO produto (descricao,valor) VALUES ('Feijão',8.45);
INSERT INTO produto (descricao,valor) VALUES ('Batata',4.35);
INSERT INTO produto (descricao,valor) VALUES ('Coca Cola',8.70);
INSERT INTO produto (descricao,valor) VALUES ('Guaraná',7.30);

INSERT INTO pessoa_fisica (id,nome,email,telefone,cpf) VALUES (1,'João da Silva','joao@email.com','6332175833','02648935478');
INSERT INTO pessoa_fisica (id,nome,email,telefone,cpf) VALUES (2,'Pedro Soares','pedro@email.com','63984567214','74865798214');
INSERT INTO pessoa_fisica (id,nome,email,telefone,cpf) VALUES (3,'Joaquim Teixeira','joaquim@email.com','6232475684','93514702156');
INSERT INTO pessoa_juridica (id,nome,email,telefone,cnpj) VALUES (4,'Ponto Frio','pontofrio@email.com','08001234567','14268745000147');
INSERT INTO pessoa_juridica (id,nome,email,telefone,cnpj) VALUES (5,'Magazine Luiza','magalu@email.com','08007534124','24895754000147');
INSERT INTO pessoa_juridica (id,nome,email,telefone,cnpj) VALUES (6,'Casas Bahia','casasbahia@email.com','03001234568','93547125000147');

INSERT INTO ESTADO(CODIGO, NOME, SIGLA) VALUES(17, 'Tocantins', 'TO');
INSERT INTO CIDADE(ESTADO_CODIGO,CODIGO,NOME) VALUES (17,1721000,'Palmas');

INSERT INTO ENDERECO(ID,DESCRICAO,LOGRADOURO,COMPLEMENTO,BAIRRO,CEP,CIDADE_CODIGO,PESSOA_ID) VALUES (1,'Casa','Quadra 106 Norte Alameda 1','Casa 01','Plano Diretor Norte','77006052',1721000,1);
INSERT INTO ENDERECO(ID,DESCRICAO,LOGRADOURO,COMPLEMENTO,BAIRRO,CEP,CIDADE_CODIGO,PESSOA_ID) VALUES (2,'Casa','Quadra 106 Norte Alameda 2','Casa 02','Plano Diretor Norte','77006052',1721000,2);
INSERT INTO ENDERECO(ID,DESCRICAO,LOGRADOURO,COMPLEMENTO,BAIRRO,CEP,CIDADE_CODIGO,PESSOA_ID) VALUES (3,'Casa','Quadra 106 Norte Alameda 3','Casa 03','Plano Diretor Norte','77006052',1721000,3);
INSERT INTO ENDERECO(ID,DESCRICAO,LOGRADOURO,COMPLEMENTO,BAIRRO,CEP,CIDADE_CODIGO,PESSOA_ID) VALUES (4,'Trabalho','Quadra 102 Norte Avenida NS 1','Lote 01','Plano Diretor Norte','77006004',1721000,4);
INSERT INTO ENDERECO(ID,DESCRICAO,LOGRADOURO,COMPLEMENTO,BAIRRO,CEP,CIDADE_CODIGO,PESSOA_ID) VALUES (5,'Trabalho','Quadra 102 Norte Avenida NS 2','Lote 02','Plano Diretor Norte','77006004',1721000,5);
INSERT INTO ENDERECO(ID,DESCRICAO,LOGRADOURO,COMPLEMENTO,BAIRRO,CEP,CIDADE_CODIGO,PESSOA_ID) VALUES (6,'Trabalho','Quadra 102 Norte Avenida NS 3','Lote 03','Plano Diretor Norte','77006004',1721000,6);

INSERT INTO venda (data,cliente_id,endereco_id) VALUES ('2023-02-05',1,1);
INSERT INTO venda (data,cliente_id,endereco_id) VALUES ('2023-03-17',2,2);
INSERT INTO venda (data,cliente_id,endereco_id) VALUES ('2023-01-04',5,5);
INSERT INTO venda (data,cliente_id,endereco_id) VALUES ('2023-07-10',6,6);

INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (1,1,1);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (2,2,1);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (2,1,1);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (10,3,1);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (5,2,2);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (2,2,2);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (2,1,2);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (4,2,3);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (2,3,3);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (2,2,4);
INSERT INTO item_venda (quantidade,produto_id,venda_id) VALUES (2,1,4);

INSERT INTO usuario (login, password, pessoa_id) VALUES ('admin', '$2a$10$uOIhCq/DbD/byUlnKGvptuF.pi8ijQcJ.a8jd8YNAFii56PrZ56jK', 1);
INSERT INTO usuario (login, password, pessoa_id) VALUES ('usuario', '$2a$10$uOIhCq/DbD/byUlnKGvptuF.pi8ijQcJ.a8jd8YNAFii56PrZ56jK', 2);

INSERT INTO role (nome) VALUES ('ROLE_ADMIN');
INSERT INTO role (nome) VALUES ('ROLE_USER');

INSERT INTO usuario_roles (usuarios_id, roles_id) VALUES (1,1);
INSERT INTO usuario_roles (usuarios_id, roles_id) VALUES (2,2);
