create table dt
(id int auto_increment primary key not null,
name varchar(10) not null,
regdate date not null);

create table dt2
(id int auto_increment primary key not null,
name varchar(10) not null,
regdate time not null);

create table dt3
(id int auto_increment primary key not null,
name varchar(10) not null,
regdate datetime not null);