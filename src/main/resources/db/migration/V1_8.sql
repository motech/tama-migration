create table tama_reports.sms_sent (
    id serial not null,
    recipient varchar(20),
    message text,
    sent_date_time timestamp
);