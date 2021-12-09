create database student_management;

use student_management;

create table class(
id int primary key,
`name` varchar(50),
gmail varchar(50) 
);

insert into class
values (1,'hung','hung@gamil.com');

insert into class
values (2,'hoang','hoang@gmail.com');

alter table class
add height int;

insert into class
values(4,'nha','nha@gmail.com',60),
(5,'thanh','thanh@gmail.com',65);

update class
set height = 5
where id = 1 or id = 2;


create table teacher(
id int primary key,
`name` varchar(50),
age int,
country varchar(50)
);