create database quan_ly_ban_hang;

use quan_ly_ban_hang;

create table customer(
cID int primary key,
cNAME varchar(50),
cAGE int
);

create table `order`( 
oID int primary key,
cID int,
o_date date,
o_total_price int ,
foreign key(cID) references customer(cID)
);

create table product(
pID int primary key,
pNAME varchar(40),
pPrice int
); 

create table order_datail(
oID int,
pID int,
odQTY int,
primary key (oID,pID),
foreign key(oID) references `order`(oID),
foreign key(pID) references product(pID)
);


