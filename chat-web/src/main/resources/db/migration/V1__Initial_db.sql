drop table person;

create table person (
    personId bigserial primary key,
    username varchar(100),
    password varchar(256),
    name varchar(100)
);

insert into person (username, password, name) values ('admin', 'admin', 'admin');