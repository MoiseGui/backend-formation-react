create sequence hibernate_sequence start with 1 increment by 1;
create table nemo (id bigint not null, created_at timestamp, email varchar(255), first_name varchar(255), last_name varchar(255), status integer, primary key (id));
