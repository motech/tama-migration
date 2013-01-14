create table tama_reports.call_log (
    id serial,
    call_id varchar(100),
    call_direction varchar(20),
    call_language varchar(10),
    clinic_id varchar(100),
    start_time date,
    end_time date,
    phone_number varchar(50)
);

create table tama_reports.patient_on_call (
    id serial,
    call_id varchar(100),
    patient_id varchar(100)
);