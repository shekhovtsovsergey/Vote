drop table if exists PERSONS;
CREATE TABLE PERSONS
(
    ID             SERIAL        PRIMARY KEY,
    NAME           VARCHAR(255)     NOT NULL,
    DOCUMENT       VARCHAR(255)     NOT NULL,
    VOTE_TYPE      VARCHAR(255)     NOT NULL,
    IS_DELETED     INTEGER      DEFAULT 0
);

COMMENT ON COLUMN PERSONS.ID IS 'Уникальный идентификатор персоны';
COMMENT ON COLUMN PERSONS.NAME IS 'Имя персоны';
COMMENT ON COLUMN PERSONS.DOCUMENT IS 'Документ, удостоверяющий личность персоны';
COMMENT ON COLUMN PERSONS.VOTE_TYPE IS 'Тип голоса, отданного персоной';
COMMENT ON COLUMN PERSONS.IS_DELETED IS 'Флаг, указывающий на удаление записи. 0 - не удалена, 1 - удалена';