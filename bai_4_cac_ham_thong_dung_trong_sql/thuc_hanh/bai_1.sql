use quan_ly_sinh_vien;

-- Hiển thị số lượng sinh viên ở từng nơi
select *, count(*) number_student
from student 
group by adress ;

-- Tính điểm trung bình các môn học của mỗi học viên
select student.student_id, student.student_Name, avg(mark)
from student
join mark on student.student_id = mark.student_id
group by student.student_id, student.student_Name;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select student.student_id, student.student_Name, avg(mark)
from student
join mark on student.student_id = mark.student_id
group by student.student_id, student.student_Name
having avg(mark)>15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select student.student_id, student.student_Name, avg(mark)
from student
join mark on student.student_id = mark.student_id
group by student.student_id, student.student_Name
HAVING AVG(Mark) >= ALL (SELECT AVG(mark) FROM mark GROUP BY mark.student_id);