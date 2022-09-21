create database contact_book;

use contact_book;

create table contacts (
	id smallint unsigned primary key auto_increment,
    name varchar(50) not null,
    phone varchar(20) not null,
    email varchar(50) default 'empty@gmail.com',
    creation_date timestamp default current_timestamp,
    update_date timestamp default current_timestamp
);

insert into contacts
	(name, phone)
values
	('Moisés Santos Teixeira', '5511912345678');

select * from contacts;