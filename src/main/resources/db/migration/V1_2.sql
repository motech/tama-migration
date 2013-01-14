create table tama_reports.clinic (
    id serial,
    address varchar(500),
    city_id varchar(100),
    name varchar(50),
    phone varchar(50)
);

create table tama_reports.clinic_contact (
    id serial,
    name varchar(50),
    phone varchar(50)
);