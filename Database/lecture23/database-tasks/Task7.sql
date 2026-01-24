DROP TABLE Employee;

CREATE TABLE Employee (
    id   NUMBER       NOT NULL,
    name VARCHAR2(100),
    age  NUMBER,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

DROP TABLE Phone;

CREATE TABLE Phone (
    id           NUMBER       NOT NULL,
    phoneNumber  VARCHAR2(20),
    employee_id  NUMBER       NOT NULL,

    CONSTRAINT pk_phone PRIMARY KEY (id),

    CONSTRAINT uq_phone_employee UNIQUE (employee_id),

    CONSTRAINT fk_phone_employee
        FOREIGN KEY (employee_id)
        REFERENCES Employee(id)
);
