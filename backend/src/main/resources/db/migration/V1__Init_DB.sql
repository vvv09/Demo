create sequence hibernate_sequence start 1 increment 1;

create table todos (
    object_id int4 not null,
    description varchar(255),
    primary key (object_id)
);
