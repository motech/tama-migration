create table tama_reports.patient (
    id serial,
    activation_date date,
    date_of_birth date,
    clinic_id varchar(100),
    patient_doc_id varchar(100),
    patient_id varchar(100),
    gender varchar(1),
    status varchar(50),
    phone_number varchar(15)
);