create database quan_ly_ban_hang;

use quan_ly_ban_hang;

create table customer(
cID int not null auto_increment primary key,
cNAME varchar(50),
cAGE int not null
);

create table `order`( 
oID int not null auto_increment primary key,
cID int,
o_date date,
o_total_price int ,
foreign key(cID) references customer(cID)
);

create table product(
pID int not null auto_increment primary key,
pNAME varchar(40),
pPrice int
); 

create table order_datail(
oID int,
pID int,
odQTY varchar(50),
primary key (oID,pID),
foreign key(oID) references `order`(oID),
foreign key(pID) references product(pID)
);
