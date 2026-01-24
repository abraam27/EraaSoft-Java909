DROP TABLE Doctor;

CREATE TABLE Doctor (
    id NUMBER NOT NULL,
    name VARCHAR2(100),
    salary NUMBER,
    CONSTRAINT pk_doctor PRIMARY KEY (id)
);

DROP TABLE Patient;

CREATE TABLE Patient (
    id NUMBER NOT NULL,
    name VARCHAR2(100),
    age NUMBER,
    CONSTRAINT pk_patient PRIMARY KEY (id)
);

CREATE TABLE Doctor_Patient (
    doctor_id NUMBER NOT NULL,
    patient_id NUMBER NOT NULL,

    CONSTRAINT pk_doctor_patient 
        PRIMARY KEY (doctor_id,
patient_id),

    CONSTRAINT fk_dp_doctor 
        FOREIGN KEY (doctor_id)
        REFERENCES Doctor(id),

    CONSTRAINT fk_dp_patient 
        FOREIGN KEY (patient_id)
        REFERENCES Patient(id)
);
