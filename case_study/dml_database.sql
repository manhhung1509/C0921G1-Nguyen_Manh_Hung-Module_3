-- task_1:
use case_study;

 insert into position
 values
 (1,'quản lý'),
 (2,'nhân viên');
 
 insert into `level`
 values
(1,'Trung Cấp'),
(2,'Cao Đẳng'),
(3,'Đại Học'),
(4,'Sau Đại Học');

insert into department
 values
 (1,'Sale-Marketing'),	
(2,'Hành chính'),	
(3,'Phục vụ'),	
(4,'Quản lý');

insert into employee
values 
(1,'Nguyễn Văn An','1970-11-07','456231786','10000000','0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),	
(2,'Lê Văn Bình','1997-04-09','654231234','7000000','0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),	
(3,'Hồ Thị Yến','1995-12-12','999231723','14000000','0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),	
(4,'Võ Công Toản','1980-04-04','123231365','17000000','0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),	
(5,'Nguyễn Bỉnh Phát','1999-12-09','454363232','6000000','0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),	
(6,'Khúc Nguyễn An Nghi','2000-11-08','964542311','7000000','0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),	
(7,'Nguyễn Hữu Hà','1993-01-01','534323231','8000000','0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),	
(8,'Nguyễn Hà Đông','1989-09-03','234414123','9000000','0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),	
(9,'Tòng Hoang','1982-09-03','256781231','6000000','0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),	
(10,'Nguyễn Công Đạo','1994-01-08','755434343','8000000','0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);					
				
insert into custommer_type
values
(1,'Diamond'),	
(2,'Platinium'),	
(3,'Gold'),	
(4,'Silver'),	
(5,'Member');

insert into customer
values
(1,'Nguyễn Thị Hào','1970-11-07',b'0','643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
(2,'Phạm Xuân Diệu','1992-08-08',b'1','865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
(3,'Trương Đình Nghệ','1990-02-27',b'1','488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
(4,'Dương Văn Quan','1981-07-08',b'1','543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
(5,'Hoàng Trần Nhi Nhi','1995-12-09',b'0','795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
(6,'Tôn Nữ Mộc Châu','2005-12-06',b'0','732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),	
(7,'Nguyễn Mỹ Kim','1984-04-08',b'0','856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),	
(8,'Nguyễn Thị Hào','1999-04-08',b'0','965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),	
(9,'Trần Đại Danh','1994-07-01',b'1','432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),	
(10,'Nguyễn Tâm Đắc','1989-07-01',b'1','344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);

insert into rental_type
values
(1,'year'),	
(2,'month'),	
(3,'day'),	
(4,'hour');

insert into service_type
values
(1,'Villa'),	
(2,'House'),	
(3,'Room');

insert into service
values
(1,'Villa Beach Front',25000,10000000,'10','vip','Có hồ bơi','500',4,3,1),
(2,'House Princess 01',14000,5000000,'7','vip','Có thêm bếp nướng',null,3,2,2),
(3,'Room Twin 01',5000,1000000,'2','normal','Có tivi',null,null,4,3),
(4,'Villa No Beach Front',22000,9000000,'8','normal','Có hồ bơi','300',3,3,1),
(5,'House Princess 02',10000,'4000000','5','normal','Có thêm bếp nướng',null,2,3,2),
(6,'Room Twin 02',3000,'900000','2','normal','Có tivi',null,null,4,3);

insert into Accompanied_service
values
(1,'Karaoke','10000','giờ','tiện nghi, hiện tại'),
(2,'Thuê xe máy','10000','chiếc','hỏng 1 xe'),
(3,'Thuê xe đạp','20000','chiếc','tốt'),
(4,'Buffet buổi sáng','15000','suất','đầy đủ đồ ăn, tráng miệng'),
(5,'Buffet buổi trưa','90000','suất','đầy đủ đồ ăn, tráng miệng'),
(6,'Buffet buổi tối','16000','suất','đầy đủ đồ ăn, tráng miệng');

insert into contract
values
(1,'2020-12-08','2020-12-08','0',3,1,3),	
(2,'2020-07-14','2020-07-21','200000',7,3,1),	
(3,'2021-03-15','2021-03-17','50000',3,4,2),	
(4,'2021-01-14','2021-01-18','100000',7,5,5),	
(5,'2021-07-14','2021-07-15','0',7,2,6),	
(6,'2021-06-01','2021-06-03','0',7,7,6),	
(7,'2021-09-02','2021-09-05','100000',7,4,4),	
(8,'2021-06-17','2021-06-18','150000',3,4,1),	
(9,'2020-11-19','2020-11-19','0',3,4,3),	
(10,'2021-04-12','2021-04-14','0',10,3,5),	
(11,'2021-04-25','2021-04-25','0',2,2,1),	
(12,'2021-05-25','2021-05-27','0',7,10,1);

insert into detail_contract
values
(1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1),
(5,11,3,2),
(6,1,1,3),
(7,2,1,2),
(8,2,12,2);

/*task_2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong
các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.*/

SELECT * FROM employee WHERE employee_name like "H%" or employee_name like "T%" or employee_name like "K%"  and length(employee_name) <= 15 ;

-- task_3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

SELECT * 
FROM customer
	WHERE (round(datediff(curdate(), birthday)/365,0) <= 50 
	and (round(datediff(curdate(), birthday)/365,0) >= 18 )
	and address like "%Đà Nẵng" or address like "%Quảng Trị"
	);

/* task_4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần
 theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
 
select ctm.customer_code, ctm.customer_name, count(*) number_of_bookings
from customer as ctm
	join contract ctr on ctm.customer_code = ctr.customer_code 
	join custommer_type ctmt on ctmt.custommer_type_code = ctm.custommer_type_code
	where ctmt.custommer_type_name ="Diamond" 
	group by ctm.customer_code
	order by number_of_bookings asc;

/*task_5:	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
 tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng
 dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng
 cũng phải hiển thị ra).*/ 
 
 select customer.customer_code, customer.customer_name, custommer_type.custommer_type_name,
        contract.contract_code, service.service_name, contract.date_do_contract,
        contract.end_date, sum(ifnull(service.rental_costs,0) + ifnull(accompanied_service.price,0)* ifnull(detail_contract.quantity,0) ) as total_money
from customer
	left join custommer_type on customer.custommer_type_code = custommer_type.custommer_type_code
	left join contract on customer.customer_code = contract.customer_code
	left join service on contract.service_code= service.service_code
	left join service_type on service.service_code = service_type.service_type_code
	left join detail_contract on contract.contract_code = detail_contract.contract_code
	left join accompanied_service on accompanied_service.Accompanied_service_code = detail_contract.Accompanied_service_code
	group by contract_code
	order by customer_code asc, contract_code desc;

/* task_6. Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được 
           khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).*/
           
select service.service_code, service.service_name, service.area, service.rental_costs, service_type.service_type_name
from service
	join service_type on service.service_type_code = service_type.service_type_code
	where service.service_code not in (
		select service.service_code
		from service
			join service_type on service.service_type_code = service_type.service_type_code
			join contract on service.service_code = contract.service_code
			where contract.date_do_contract between '2021/1/1' and '2021/3/30'
			);

/* task_7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại
 dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.*/
 
 select service.service_code, service.service_name, service.area, service.rental_costs, service_type.service_type_name
from service
	join service_type on service.service_type_code = service_type.service_type_code
	where service.service_code in (
		select service.service_code
			from service
			join service_type on service.service_type_code = service_type.service_type_code
			join contract on service.service_code = contract.service_code
			where contract.date_do_contract between '2020/1/1' and '2020/12/31' 
			and service.service_code not in (
				select service.service_code
					from service
					join service_type on service.service_type_code = service_type.service_type_code
					join contract on service.service_code = contract.service_code
					where contract.date_do_contract between '2021/1/1' and '2021/12/31')
					);

/*task_8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.*/
-- cách 1:
select distinct customer.customer_name
from customer;

-- cách 2:
select customer.customer_name
from customer
group by customer.customer_name;

-- cách_3:
select customer.customer_name
from customer
	union
	select customer.customer_name
	from customer;

/*task_9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực
           hiện đặt phòng.*/
select month(ct.date_do_contract) as `month`, count(month(ct.date_do_contract)) as amount_customer
from customer as c
	join contract as ct on c.customer_code = ct.customer_code
	where year(ct.date_do_contract) = 2021
	group by month(ct.date_do_contract)
	order by `month`;
	
/*10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong,
 ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).*/

select contract.contract_code, contract.date_do_contract, contract.end_date, contract.deposit, sum(ifnull(detail_contract.quantity,0)) as number_of_accompanied_service
from contract
	left join detail_contract on contract.contract_code = detail_contract.contract_code
	left join accompanied_service on detail_contract.Accompanied_service_code = accompanied_service.Accompanied_service_code
	group by contract.contract_code
	order by contract.contract_code
;	
/* task_11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi 
            ở “Vinh” hoặc “Quảng Ngãi”.*/
            
 select `as`.Accompanied_service_code, `as`.Accompanied_service_name
 from accompanied_service as `as`
	 join detail_contract as dc on `as`.Accompanied_service_code = dc.Accompanied_service_code
	 join contract as ct on dc.contract_code = ct.contract_code
	 join customer as c on ct.customer_code = c.customer_code
	 join custommer_type as ctmt on c.custommer_type_code = ctmt.custommer_type_code
	 where ctmt.custommer_type_code = 1 and (c.address like '%Vinh' or c.address like '%Quảng Ngãi');
 
 /*task_12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu,
			so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch
            vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021*/

select ct.contract_code, e.employee_name, c.customer_name, c.phone_number, sv.service_name,
       sum(ifnull(dtct.quantity,0)) as number_of_accompanied_service, ct.deposit
from contract as ct 
	join customer c on ct.customer_code = c.customer_code
	join employee e on ct.employee_code = e.employee_code
	join service sv on ct.service_code = sv.service_code
	left join detail_contract dtct on ct.contract_code = dtct.contract_code
	left join accompanied_service asv on dtct.Accompanied_service_code = asv.Accompanied_service_code
	where (year(ct.date_do_contract) = 2020 and month(ct.date_do_contract) in (10 , 11, 12))
	and (month(ct.date_do_contract) not in (1,2,3,4,5,6) and year(ct.date_do_contract) = 2020)
	group by ct.contract_code 
	order by ct.contract_code ;

/*task_13. Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
           (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/

select asv.Accompanied_service_code, asv.Accompanied_service_name, sum(dtct.quantity)
from accompanied_service as asv
	join  detail_contract dtct on asv.Accompanied_service_code = dtct.Accompanied_service_code
	join  contract ct on dtct.contract_code = ct.contract_code
	group by asv.Accompanied_service_code
	having sum(dtct.quantity) >= all(select quantity
	from detail_contract );
           
/* task_14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong,
			ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).*/
            
select ct.contract_code, svt.service_type_name, asv.Accompanied_service_name, count(asv.Accompanied_service_code) as number_used
from contract as ct
	join service as sv on ct.service_code = sv.service_code
	join service_type as svt on sv.service_type_code = svt.service_type_code 
	join detail_contract as dtct on ct.contract_code = dtct.contract_code
	join accompanied_service as asv on dtct.Accompanied_service_code = asv.Accompanied_service_code
	group by asv.Accompanied_service_code
	having count(asv.Accompanied_service_code) = 1
	order by ct.contract_code ;

/*task_15. Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai,
             dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.*/           
             
select e.employee_code, e.employee_name , l.level_name, d.department_name, e.phone_number, e.address    
from employee as e
	join department as d on e.department_code = d.department_code
	join `level` as l on e.level_code = l.level_code 
	join contract as ct on e.employee_code = ct.employee_code
	where year(ct.date_do_contract) = 2021 or year(ct.date_do_contract) = 2020
	group by ct.employee_code 
	having count(ct.employee_code) <=3 
	order by ct.employee_code;

-- task_16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

SET FOREIGN_KEY_CHECKS = 0;
delete from employee as e
where e.employee_code not in (
	select temp.employee_code 
    from
		(select e.employee_code
			from employee as e
			join contract as ct on e.employee_code = ct.employee_code
			where year(ct.date_do_contract) between 2020 and 2021
			group by ct.employee_code 
			having count(ct.employee_code) >=1 ) as temp) ;
SET FOREIGN_KEY_CHECKS = 1;

/*task_17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng
            đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 1.000.000 VNĐ.*/
            
 update customer
 set custommer_type_code = 1
 where customer.customer_code in (
 select temp.customer_code 
    from
		(select c.customer_code
			from customer as c
			join contract as ct on c.customer_code = ct.customer_code
			join service as sv on ct.service_code = sv.service_code
            join detail_contract as dtct on ct.contract_code = dtct.contract_code
            join accompanied_service as asv on dtct.Accompanied_service_code = asv.Accompanied_service_code
			where year(ct.date_do_contract) = 2021 and c.custommer_type_code =2
			group by ct.customer_code 
			having sum(sv.rental_costs + asv.price * dtct.quantity ) > 1000000 ) as temp
 );
 
 
 
         