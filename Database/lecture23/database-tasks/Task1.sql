CREATE TABLE Player (
    id   NUMBER       NOT NULL,
    name VARCHAR2(100),
    age  NUMBER,
    CONSTRAINT uq_player_id UNIQUE (id),
    CONSTRAINT uq_player_name UNIQUE (name)
);

CREATE TABLE Manager (
    id   NUMBER       NOT NULL,
    name VARCHAR2(100),
    age  NUMBER,
    CONSTRAINT pk_manager PRIMARY KEY (id)
);

DROP TABLE Manager;

CREATE TABLE Manager (
    id   NUMBER       NOT NULL,
    name VARCHAR2(100),
    age  NUMBER,
    CONSTRAINT pk_manager PRIMARY KEY (id)
);
