create database demo;

use demo;

create table products(
Id int,
product_code int primary key, 
product_name varchar(50),
product_price int,
product_amount int,
product_description varchar(100),
product_status varchar(30));

insert into products
values
(1, 123,'iphone', 100, 5, 'made in campuchia', 'new'),
(2,4352,'samsunng', 300, 10, 'made in lao', '99%'),
(3,234,'nokia', 200, 5, 'made in vietnam', '98%'),
(4,2341,'vsmart', 700, 1, 'made in china', 'old'),
(5,989,'oppo', 500, 2, 'made in korea', 'new'),
(6,8273984,'realme', 900, 23, 'made in brunei', 'new');
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create index idx_products
on products(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index idx_products1
on products(product_code, id);

explain select products.product_code, products.product_name  from products where products.product_code = 2341 ;


-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create  view products_view
as select p.product_code, p.product_name, p.product_price, p.product_status
from products as p;

-- update view:
create or replace view products_view as
select p.product_code, p.product_name, p.product_price
from products as p;

-- delete view:
drop view products_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product:
delimiter //
create procedure sp_find_products()
begin
select * from products;
end;
// delimiter ;
call sp_find_products();

-- Tạo store procedure thêm một sản phẩm mới:
delimiter //
create procedure sp_create_new_products(id int, `code` int,`name` varchar(50), price int, amount int, `description` varchar(100), `status` varchar(20))
begin
insert into products
values(id, `code`, `name`, price, amount, `description`, `status`);
end;
// delimiter ;
call sp_create_new_products(8, 67292, 'xiaomi', 400,7, 'made in usa', 'old');

-- Tạo store procedure sửa thông tin sản phẩm theo id:
delimiter //
create procedure sp_update_products_by_id(id int, id_update int, `code` int,`name` varchar(50), price int, amount int,
				`description` varchar(100), `status` varchar(20))
begin
update products as p
set p.id = id_update, p.product_code = `code`, p.product_name = `name`,
    p.product_price = price, p.product_amount =amount, p.product_description = `description`, p.product_status=`status`
where p.id = id ;
end;
// delimiter ;
call sp_update_products_by_id(2, 10 , 1509000, 'vertu', 1000, 1, 'made in uk', 'new');

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure sp_delete_products_by_id(id int)
begin
delete from products
where products.id = id ;
end;
// delimiter ;
call sp_delete_products_by_id(4);
select * from products;
