create database case_study;

use case_study;

create table `position`(
position_code int primary key,
position_name varchar(45)
);

create table `level`(
level_code int primary key,
level_name varchar(45)
);

 create table department(
 department_code int primary key,
 department_name varchar(45)
 );
 
 create table employee(
employee_code int primary key,
employee_name varchar(45),
employee_birthday date,
employee_id varchar(45),
salary double,
phone_number varchar(45),
email varchar(45),
address varchar(45),
position_code int,
level_code int,
department_code int,
foreign key(position_code) references `position`(position_code),
foreign key(level_code) references `level`(level_code),
foreign key(department_code) references department(department_code)
);

 create table custommer_type(
 custommer_type_code int primary key,
 custommer_type_name varchar(45)
 );

create table customer(
customer_code int primary key,
customer_name varchar(45),
birthday date,
gender bit(1),
id varchar(45),
phone_number varchar(45),
email varchar(45),
address varchar(45),
custommer_type_code int,
foreign key(custommer_type_code) references custommer_type(custommer_type_code)
);

create table rental_type(
rental_type_code int primary key,
rental_type_name varchar(45)
);

create table service_type(
service_type_code int primary key,
service_type_name varchar(45)
);


create table service(
service_code int primary key,
service_name varchar(45),
area int,
rental_costs double,
maximun_people int,
standard_of_room varchar(45),
description_other_Utilities varchar(45),
pool_area double,
number_of_floor int,
rental_type_code int,
service_type_code int,	
foreign key (rental_type_code) references rental_type(rental_type_code),
foreign key (service_type_code) references service_type(service_type_code)
);

create table accompanied_service(
accompanied_service_code int primary key,
accompanied_service_name varchar(45),
price double,
unit varchar(10),
`status` varchar(45)
);

 create table contract(
 contract_code int primary key,
 date_do_contract date,
 end_date date,
 deposit double,
 employee_code int,
 customer_code int,
 service_code int,
 foreign key(employee_code) references employee(employee_code),
 foreign key(customer_code) references customer(customer_code),
  foreign key(service_code) references service(service_code)
 );

create table detail_contract(
 detail_contract_code int primary key,
 quantity int,
 contract_code int,
 accompanied_service_code int,
 foreign key(contract_code) references contract(contract_code),
 foreign key(accompanied_service_code) references accompanied_service(accompanied_service_code)
 );
 




	









