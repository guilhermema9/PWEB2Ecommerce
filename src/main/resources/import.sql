INSERT INTO produto (descricao,valor) VALUES ('Arroz',12.50);
INSERT INTO produto (descricao,valor) VALUES ('Feijão',8.45);
INSERT INTO produto (descricao,valor) VALUES ('Batata',4.35);
INSERT INTO produto (descricao,valor) VALUES ('CocaCola',8.70);
INSERT INTO produto (descricao,valor) VALUES ('Guaraná',7.30);

INSERT INTO venda (data) VALUES ('2023-02-05');
INSERT INTO venda (data) VALUES ('2023-03-17');
INSERT INTO venda (data) VALUES ('2023-01-04');
INSERT INTO venda (data) VALUES ('2023-07-10');

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