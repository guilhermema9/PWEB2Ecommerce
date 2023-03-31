INSERT INTO produto (descricao,valor) VALUES ('Arroz',12.50);
INSERT INTO produto (descricao,valor) VALUES ('Feijão',8.45);
INSERT INTO produto (descricao,valor) VALUES ('Batata',4.35);
INSERT INTO produto (descricao,valor) VALUES ('CocaCola',8.70);
INSERT INTO produto (descricao,valor) VALUES ('Guaraná',7.30);

INSERT INTO pessoa_fisica (id,nome,cpf) VALUES (1,'João da Silva','02648935478');
INSERT INTO pessoa_fisica (id,nome,cpf) VALUES (2,'Pedro Soares','74865798214');
INSERT INTO pessoa_fisica (id,nome,cpf) VALUES (3,'Joaquim Teixeira','93514702156');
INSERT INTO pessoa_juridica (id,nome,cnpj) VALUES (4,'Ponto Frio','14268745000147');
INSERT INTO pessoa_juridica (id,nome,cnpj) VALUES (5,'Magazine Luiza','24895754000147');
INSERT INTO pessoa_juridica (id,nome,cnpj) VALUES (6,'Casas Bahia','93547125000147');

INSERT INTO venda (data,cliente_id) VALUES ('2023-02-05',1);
INSERT INTO venda (data,cliente_id) VALUES ('2023-03-17',2);
INSERT INTO venda (data,cliente_id) VALUES ('2023-01-04',5);
INSERT INTO venda (data,cliente_id) VALUES ('2023-07-10',6);

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