create database if not exists pokemon;

use pokemon;

drop table if exists pokemon;

create table pokemon (
	id int(10) not null auto_increment,
    name varchar(50) not null,
    level int (3) not null,
    type varchar(25) not null,
    gender varchar(10),
    primary key(id)
);
