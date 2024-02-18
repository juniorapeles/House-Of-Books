
INSERT INTO tb_author (name, biography) VALUES ('George Orwell', 'example biography');
INSERT INTO tb_author (name, biography) VALUES ('Jorge Amado', 'example biography');
INSERT INTO tb_author (name, biography) VALUES ('J.R.R Tolkien', 'example biography');
INSERT INTO tb_author (name, biography) VALUES ('Erin Doom', 'example biography');

INSERT INTO tb_book (borrowed, name, author_id, description) VALUES (false, '1984', 1, 'Descrição do Livro');
INSERT INTO tb_book (borrowed, name, author_id, description) VALUES (false, 'Capitães da Areia', 2, 'Descrição do Livro');
INSERT INTO TB_USER (name) VALUES ('Roberto');
INSERT INTO TB_LOAN (book_id, User_id) VALUES (1,1);
