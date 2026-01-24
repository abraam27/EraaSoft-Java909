DROP TABLE Language;

CREATE TABLE Language (
    id NUMBER NOT NULL,
    name VARCHAR2(100),
    CONSTRAINT pk_language PRIMARY KEY (id)
);

DROP TABLE Teacher;

CREATE TABLE Teacher (
    id NUMBER NOT NULL,
    name VARCHAR2(100),
    salary NUMBER,
    language_id NUMBER NOT NULL,

    CONSTRAINT pk_teacher PRIMARY KEY (id),

    CONSTRAINT fk_teacher_language
        FOREIGN KEY (language_id)
        REFERENCES Language(id)
);
