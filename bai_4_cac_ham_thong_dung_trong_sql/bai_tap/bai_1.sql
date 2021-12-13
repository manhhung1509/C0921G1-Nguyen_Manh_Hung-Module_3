use quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

SELECT * 
FROM `subject`
where `subject`.credit >= all(select credit from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

SELECT s.sub_id, s.sub_name, s.credit, s.`status`, m.mark
FROM `subject` as s
join mark as m on s.sub_id = m.sub_id
where m.mark >= all(select mark
from  `subject`
join mark on s.sub_id = m.sub_id); 

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select s.student_id, s.student_Name, 
s.adress, s.phone, s.`status`,
s.class_id,  avg(mark.mark)
from student as s
join mark on s.student_id = mark.student_id
group by s.student_id, s.student_Name
order by mark.mark desc;