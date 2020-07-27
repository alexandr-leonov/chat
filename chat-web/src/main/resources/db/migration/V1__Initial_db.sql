--drop table person;

create table person (
    person_id serial primary key,
    username varchar(100),
    password varchar(256),
    name varchar(100)
);

insert into person (person_id, username, password, name) values (DEFAULT, 'admin', 'admin', 'admin');

-- check person table
select * from person;