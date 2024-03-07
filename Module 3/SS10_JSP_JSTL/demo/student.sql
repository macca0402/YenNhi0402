create database student;
use student;
create table student(
 id int primary key auto_increment,
 name varchar(50),
 gender boolean,
 point float
);
select * from student;
update student set student.name="Lan",student.gender=1,student.point=10 where student.id=2;
select * from student where id=1;
INSERT into student(id,name,gender,point) values (7,"Khoa",0,4);
delete from student where student.id=6;

delimiter //
create procedure find_all()
begin
select * from student;
end //
delimiter ;

call find_all();


delimiter //
create procedure INSERT_SP(in NEW_NAME varchar(50),NEW_GENDER boolean,NEW_POINT float)
begin
INSERT into student(name,gender,point) values (NEW_NAME,NEW_GENDER,NEW_POINT);
end //
delimiter ;
CALL INSERT_SP("HÀ",1,3);


