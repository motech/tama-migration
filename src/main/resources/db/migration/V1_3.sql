create table tama_reports.call_log (
    id serial,
    patient_doc_id varchar(100),
    call_doc_id varchar(100),
    call_id varchar(100),
    call_direction varchar(20),
    call_language varchar(10),
    clinic_id varchar(100),
    start_time timestamp,
    end_time timestamp,
    phone_number varchar(50)
);

create table tama_reports.patient_on_call (
    id serial,
    call_id varchar(100),
    patient_id varchar(100)
);