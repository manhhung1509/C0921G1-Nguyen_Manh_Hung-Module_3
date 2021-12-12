use quan_ly_sinh_vien;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select *
from student
where student_Name like "H%";

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
update class
set start_date = "2021-08-12 00:00:00"
where class_id = 3;

select *
from class
where start_date like "%-12-%";

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select *
from `subject`
where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.  
update student
set class_id = 2
where student_id = 1;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select  s.student_Name, sub.sub_name, m.mark
from student as s
join mark as m on s.student_id = m.student_id
join `subject` as sub on m.sub_id = sub.sub_id
order by m.mark, s.student_name
