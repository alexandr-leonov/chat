create table person (
    person_id serial primary key,
    username varchar(100),
    password varchar(256),
    name varchar(100)
);

create table dialog (
    dialog_id serial primary key,
    name varchar(100),
    last_used_date timestamp,
    person_ids integer[]
);

create table message (
    message_id serial primary key,
    person_id serial,
    dialog_id serial,
    text varchar(1024),
    creation_date timestamp,
    who_reads integer[]
);

insert into person (person_id, username, password, name) values (DEFAULT, 'admin', 'admin', 'admin');
insert into person (person_id, username, password, name) values (DEFAULT, 'test', 'test', 'test');

insert into dialog (dialog_id, name, last_used_date, person_ids)
values (DEFAULT, 'Init discuss', current_timestamp, array(select person_id  from person));

insert into message (message_id, person_id, dialog_id, text, creation_date, who_reads)
values (DEFAULT, 1, (select dialog_id from dialog limit 1), 'PING',  current_timestamp, array(select person_id  from person));

insert into message (message_id, person_id, dialog_id, text, creation_date, who_reads)
values (DEFAULT, 2, (select dialog_id from dialog limit 1), 'PONG',  current_timestamp, array(select person_id  from person));

-- log generated tables
select * from person;
select * from dialog;
select * from message;