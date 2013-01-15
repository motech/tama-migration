create table tama_reports.symptom_report (
    id serial not null,
    call_id varchar(100),
    doctor_contacted varchar(40),
    patient_doc_id varchar(100),
    reported_at timestamp,
    advice_given varchar(100)
)