use quan_ly_ban_hang;

-- Thêm dữ liệu vào trong 4 bảng như dưới đây:
insert into customer
values 
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into `order`
values 
(1,1,'2006/3/21',null),
(2,2,'2006/3/23',null),
(3,1,'2006/3/16',null);

insert into product
values 
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into order_datail
values 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select  o.oID, o.o_date, o.o_total_price
from `order` as o ;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.cID , c.cNAME, p.pNAME
from customer as c
join `order` as o on c.cID = o.cID
join order_datail as od on o.oID = od.oID
join product as p on od.pID = p.pID;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.cNAME
from customer as c
where c.cNAME not in (
select c.cNAME
from customer
join `order` as o on c.cID = o.cID
join order_datail as od on o.oID = od.oID
join product as p on od.pID = p.pID);

/* Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt
 hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)*/
 select o.oID, o.o_date, sum(od.odQTY * p.pPrice) as price_of_each_invoice
 from `order` as o
 join order_datail as od on o.oID = od.oID
 join product as p on od.pID = p.pID
 group by oID;
