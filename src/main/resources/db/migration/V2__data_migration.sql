
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('John Smith', '12345', 'YES');
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('Jane Doe', '67890', 'NO');
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('Bob Johnson', '54321', 'YES');
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('Samantha Lee', '09876', 'NO');
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('David Kim', '13579', 'YES');
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('Emily Chen', '86420', 'NO');
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('Michael Nguyen', '24680', 'YES');
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('Olivia Brown', '97531', 'NO');
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('William Davis', '75319', 'YES');
INSERT INTO PERSONS (NAME, DOCUMENT, VOTE_TYPE) VALUES ('Sophia Wilson', '32145', 'NO');


COMMENT ON COLUMN PERSONS.ID IS 'Уникальный идентификатор персоны';
COMMENT ON COLUMN PERSONS.NAME IS 'Имя персоны';
COMMENT ON COLUMN PERSONS.DOCUMENT IS 'Документ, удостоверяющий личность персоны';
COMMENT ON COLUMN PERSONS.VOTE_TYPE IS 'Тип голоса, отданного персоной';