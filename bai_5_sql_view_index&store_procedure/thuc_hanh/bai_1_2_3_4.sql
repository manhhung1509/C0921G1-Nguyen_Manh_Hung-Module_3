use student_management1;

-- thực hành bài 1 (data trên jame dài quá em không biết cop nên em lấy database sẵn nghe anh):
select *
from student
where `name` = 'vy';

create index idx_student
on student(`name`);

alter table student
drop index idx_student;


-- thực hành bài 2:
delimiter //
 drop procedure if exists find_student//
 create procedure find_student()
 begin
 select * from student where student.id = 5;
 end ;
 // delimiter ;
 
 call find_student();
 
 
 -- thực hành bài 3:
 -- tham số loại in:
delimiter //
drop procedure if exists get_student_by_id//
create procedure get_student_by_id(in id int(10))
begin
select * from student 
where student.id = id;
end ;
// delimiter ;

call get_student_by_id(2);
 -- tham số loại out:
delimiter //
drop procedure if exists get_student_by_id//
create procedure get_student_count_by_id(in student_name varchar(50), out total int)
begin
select count(student.class_id)
into total
from student
where student.name = student_name;
end;
// delimiter ;

CALL get_student_count_by_id('vy', @total);
SELECT @total;

 -- tham số loại inout:

delimiter //
create procedure SetCounter(inout counter int, in inc int)
begin
    set counter = counter + inc;
end//
delimiter ;

set @counter = 1;
call SetCounter(@counter,1);
call SetCounter(@counter,1);
call SetCounter(@counter,5);
select @counter;

-- thực hành bài 4:
-- create view:
create view student_view
as
select s.id, s.`name`, s.date_of_birth
from student as s;

select * from student_view;

-- update view:
create or replace view student_view as 
select s.id, s.`name`, s.date_of_birth, s.email
from student as s;

-- delete view:

drop view student_view;