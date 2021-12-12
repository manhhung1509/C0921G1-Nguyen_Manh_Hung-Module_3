use quan_ly_sinh_vien;

select *
from student;

select *
from student
where `status` = true;

select *
from subject
where credit < 10;

select s.student_id, s.student_name, c.class_id
from student as s
join class as c on s.class_id = c.class_id
where class_name = 'A1';

select s.student_id, s.student_name, sub.sub_name, m.mark
from student as s
join mark as m on s.student_id = m.student_id
join subject as sub on m.sub_id = sub.sub_id
where sub.sub_name = 'CF';