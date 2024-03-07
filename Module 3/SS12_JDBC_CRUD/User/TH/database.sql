create database if not exists ss12;
use ss12;

create table users(
id int(3) primary key not null auto_increment,
name varchar(120) not null,
email varchar(220) not null,
country varchar(120)
);
create table user_permision(
id_user int(11) primary key auto_increment,
id_permision int(11),
foreign key (id_user) references users(id),
foreign key (id_permision) references permision(id_permision)
);
create table permision(
id_permision int(11) primary key auto_increment,
name varchar(50)
);

insert into permision (id_permision,name) values(1,"add");
insert into permision (id_permision,name) values(2,"edit");
insert into permision (id_permision,name) values(3,"delete");
insert into permision (id_permision,name) values(4,"view");

insert into user_permision(id_user,id_permision) values (8,1);


insert into users(name,email,country) values('Minh','minh@codegym.vn','VietNam');
insert into users(name,email,country) values('Kante','kante@che.uk','Kenia');

select * from users where users.id=1;
delete from users where id=1;
update users set users.name="Nhi",users.email="yennhi@gmail.com",users.country="da nang" where id=2;


delimiter //
create procedure find_all()
begin
select * from users;
end
//
delimiter ; 
call find_all();

delimiter //
create procedure updateInfo(in NEW_ID int,NEW_NAME varchar(120),NEW_EMAIL varchar(220),NEW_COUNTRY varchar(120))
begin
update users set users.name=NEW_NAME,users.email=NEW_EMAIL,users.country=NEW_COUNTRY where id=NEW_ID;
end
//
delimiter ;

CALL updateInfo(7,"Lan","lan@gmail.com","NewYork");

-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user


delimiter //
create procedure deleteUser(in new_id int)
begin
delete from users where users.id=new_id;
end
// 
delimiter ;
call deleteUser(13);


-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng tìm user theo id
-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng thêm mới user

delimiter //
create procedure find_user_by_id(in new_id int)
begin
select * from users where users.id=8;
end
//
delimiter ;


call find_user_by_id(8);