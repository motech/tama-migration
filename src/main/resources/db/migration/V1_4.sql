create table tama_reports.simple_call_event (
    id serial,
    name varchar(10),
    call_event_id varchar(100),
    mobile_number varchar(100),
    call_id varchar(100),
    previous_event_id varchar(100),
    next_event_id varchar(100),
    call_start_time timestamp,
    response text,
    occurred_at timestamp
);

create table tama_reports.user_input_event (
    id serial,
    call_id varchar(100),
    call_event_id varchar(40),
    tree_name varchar(100),
    user_input varchar(100),
    previous_event_id varchar(100),
    next_event_id varchar(100),
    response text,
    occurred_at timestamp,
    duration numeric
);