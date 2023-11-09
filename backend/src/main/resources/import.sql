-- Inserir dados na tabela User
INSERT INTO tb_user (name, email, password) VALUES
('John Doe', 'john@example.com', 'password123'),
('Jane Smith', 'jane@example.com', 'password456');


-- Inserir dados na tabela Library
INSERT INTO tb_library (name, location) VALUES
('Central Library', '123 Main St'),
('City Library', '456 Oak St');

-- Inserir dados na tabela Book
INSERT INTO tb_book (name, author, library_id, available) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 1, true),
('To Kill a Mockingbird', 'Harper Lee', 1, true),
('1984', 'George Orwell', 2, true);

-- Inserir dados na tabela Loan
INSERT INTO tb_loan (start_date, due_date, status, user_id) VALUES
('2023-01-01', '2023-01-15', 'Borrowed', 1),
('2023-02-01', '2023-02-15', 'Borrowed', 2);

-- Inserir dados na tabela loan_book (relacionamento entre Loan e Book)
INSERT INTO loan_book (loan_id, book_id) VALUES
(1, 1),
(1, 2),
(2, 3);
