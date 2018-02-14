INSERT INTO AUTHORS (NAME, SURNAME, YEAR, COUNTRY)
VALUES 
	('Илья', 'Ильф', 1897, 'СССР'),
	('Евгений', 'Петров', 1903, 'СССР'),
    ('Лев', 'Толстой', 1828, 'Россия'),
	('Александр', 'Дюма', 1802, 'Франция'),
	('Уильям', 'Шекспир', 1564, 'Великобритания'),
	('Габриэль', 'Маркес', 1927, 'Колумбия');

INSERT INTO BOOKS (NAME, GENRE, YEAR, QUANTITY) 
VALUES
	('Война и мир', 'Роман-эпопея', 1865, 2),
    ('Граф Монте-Кристо', 'Исторический роман', 1844, 3),
    ('Три мушкетёра', 'Историко-приключенческий роман', 1844, 3),
    ('Гамлет', 'Трагедия', 1603, 4);
    
INSERT INTO BOOKS_AUTHORS 
	VALUES
    (3, 1),
    (4, 2),
    (4, 3),
    (5, 4);
    
INSERT INTO LIBRARIANS (SURNAME, NAME, SECOND_NAME,EMAIL, PASSWORD) VALUES
('Юнец',  'Евгений', 'Олегович' , 'eyunets@outlook.com', 'eyunets123');

INSERT INTO READERS (SURNAME, NAME, SECOND_NAME, BIRTHDAY) VALUES
('Агарков',  'Михаил', 'Дмитриевич', '1994-06-07');
INSERT INTO READERS (SURNAME, NAME, SECOND_NAME) VALUES
('Бодрик',  'Марина', 'Антоновна');

INSERT INTO FORMS(BOOK_ID, READER_ID, LIBRARIAN_ID, RECEIVAL_TYPE, RECEIVAL_DATE, RETURN_DATE)
	VALUES(1, 1, 1, 'АБОНЕМЕНТ', CURDATE(), ADDDATE(CURDATE(), INTERVAL 14 DAY));
    