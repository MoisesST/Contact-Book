create database contact_book;

use contact_book;

create table contacts (
	id smallint unsigned primary key auto_increment,
    name varchar(50) not null,
    type char(1) not null,
    email varchar(50),
    phone varchar(20) not null,
);

create table if not exists users (
	id smallint unsigned primary key auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    phone varchar(20) not null,
	password varchar(20) not null
);

insert into contacts
	(name, phone)
values
	('Moisés Santos Teixeira', '5511912345678');

select * from contacts;