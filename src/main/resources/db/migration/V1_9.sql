create table tama_reports.dosage (
    id serial not null,
    patient_id varchar(100),
    dosage_date date,
    dosage_status varchar(100),
    reason text,
    dosage_taken_late boolean,
    dosage_status_updated_at timestamp
);