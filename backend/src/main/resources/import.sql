INSERT INTO tb_author (name, biography) VALUES ('José', 'José vida loca');
INSERT INTO tb_address (street, city, state, postal_code, country) VALUES ('Nome da Rua', 'Nome da Cidade', 'Nome do Estado', 'Código Postal', 'Nome do País');
INSERT INTO tb_user (name, Rg, email, telephone, address_id) VALUES ('João Ribeiro', '123.456.789-00', 'fulano@example.com', '(00) 12345-6789', 1);
INSERT INTO tb_categories (name, deascription) VALUES ('Ficção Científica', 'Livros sobre viagens no tempo e futuros distópicos.');
INSERT INTO tb_author (name, biography) VALUES ('Isaac Asimov', 'Autor prolífico de ficção científica, conhecido por suas obras como a série Fundação e Eu, Robô.');
INSERT INTO tb_author (name, biography) VALUES ('George Orwell', 'Autor de obras icônicas como "1984" e "A Revolução dos Bichos".');
INSERT INTO tb_author (name, biography) VALUES ('J.K. Rowling', 'Conhecida mundialmente pela série "Harry Potter".');
INSERT INTO tb_author (name, biography) VALUES ('Harper Lee', 'Autora do clássico "O Sol é para Todos".');
INSERT INTO tb_author (name, biography) VALUES ('Gabriel García Márquez', 'Ganhador do Prêmio Nobel, famoso por "Cem Anos de Solidão".');
INSERT INTO tb_author (name, biography) VALUES ('Agatha Christie', 'Rainha do romance policial, autora de várias obras de mistério.');
INSERT INTO  TB_PUBLISHING_COMPANY  (name) VALUES ('Editora TechBooks');
INSERT INTO tb_book (name, img_path, author_id, publication_date, description, categorie_id, publishing_Company_id) VALUES ('Nome do Livro', 'Caminho/da/Imagem.jpg', 1, '2023-11-28', 'Descrição do Livro', 1, 1);
INSERT INTO tb_book (name, img_path, author_id, publication_date, description, categorie_id, publishing_Company_id) VALUES ('1984', 'imagem_1984.jpg', 2, '1949-06-08', 'Ficção distópica sobre vigilância governamental.', 1, 1);
INSERT INTO tb_book (name, img_path, author_id, publication_date, description, categorie_id, publishing_Company_id) VALUES ('Harry Potter e a Pedra Filosofal', 'imagem_hp.jpg', 3, '1997-06-26', 'Primeiro livro da série de fantasia.', 1, 1);
INSERT INTO tb_book (name, img_path, author_id, publication_date, description, categorie_id, publishing_Company_id) VALUES ('O Sol é para Todos', 'imagem_o_soleparatodos.jpg', 4, '1960-07-11', 'Explora questões raciais nos EUA.', 1, 1);
INSERT INTO tb_book (name, img_path, author_id, publication_date, description, categorie_id, publishing_Company_id) VALUES ('Cem Anos de Solidão', 'imagem_cem_anos_de_solidao.jpg', 5, '1967-05-30', 'Realismo mágico em uma saga familiar.', 1, 1);
INSERT INTO tb_book (name, img_path, author_id, publication_date, description, categorie_id, publishing_Company_id) VALUES ('O Assassinato no Expresso do Oriente', 'imagem_assassinato_no_expresso.jpg', 6, '1934-01-01', 'Um clássico de mistério e detetive.', 1, 1);

