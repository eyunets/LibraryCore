INSERT INTO AUTHORS (NAME, SURNAME, YEAR, COUNTRY)
VALUES 
	('����', '����', 1897, '����'),
	('�������', '������', 1903, '����'),
    ('���', '�������', 1828, '������'),
	('���������', '����', 1802, '�������'),
	('������', '�������', 1564, '��������������'),
	('��������', '������', 1927, '��������');

INSERT INTO BOOKS (NAME, GENRE, YEAR, QUANTITY) 
VALUES
	('����� � ���', '�����-������', 1865, 2),
    ('���� �����-������', '������������ �����', 1844, 3),
    ('��� ��������', '��������-��������������� �����', 1844, 3),
    ('������', '��������', 1603, 4);
    
INSERT INTO BOOKS_AUTHORS 
	VALUES
    (3, 1),
    (4, 2),
    (4, 3),
    (5, 4);
    
INSERT INTO LIBRARIANS (SURNAME, NAME, SECOND_NAME,EMAIL, PASSWORD) VALUES
('����',  '�������', '��������' , 'eyunets@outlook.com', 'eyunets123');

INSERT INTO READERS (SURNAME, NAME, SECOND_NAME, BIRTHDAY) VALUES
('�������',  '������', '����������', '1994-06-07');
INSERT INTO READERS (SURNAME, NAME, SECOND_NAME) VALUES
('������',  '������', '���������');

INSERT INTO FORMS(BOOK_ID, READER_ID, LIBRARIAN_ID, RECEIVAL_TYPE, RECEIVAL_DATE, RETURN_DATE)
	VALUES(1, 1, 1, '���������', CURDATE(), ADDDATE(CURDATE(), INTERVAL 14 DAY));
    