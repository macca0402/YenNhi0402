create database tro;
use tro;
create table danh_muc(
id_danh_muc int primary key auto_increment,
ten varchar(50)
);
create table san_pham(
id int primary key auto_increment,
ten varchar(50),
gia int ,
so_luong int,
mau varchar(50),
mo_ta varchar(50),
id_danh_muc int,
foreign key (id_danh_muc) references danh_muc(id_danh_muc)
);
insert into san_pham(ten,gia,so_luong,mau,mo_ta,id_danh_muc)
values("Nagawa",1000,100,"pink","cao",5);
select * from danh_muc;
select * from danh_muc where danh_muc.id_danh_muc=1;
select * from san_pham;
delete from san_pham where san_pham.id=4;

select * from san_pham where san_pham.id=1 or san_pham.gia=100 ;


delimiter //
create procedure tim_kiem( in tim_kiem varchar(50))
begin
select * from san_pham having san_pham.ten like tim_kiem or san_pham.gia like tim_kiem or san_pham.so_luong like tim_kiem or san_pham.mau like tim_kiem ;
end //
delimiter ;
call tim_kiem("100");

-- id int primary key auto_increment,
-- ten varchar(50),
-- gia int ,
-- so_luong int,
-- mau varchar(50),
-- mo_ta varchar(50),
-- id_danh_muc int,
update san_pham 
set 
ten="Nokia",gia=20000,so_luong=3,mau="Green",mo_ta="day",id_danh_muc=1
where san_pham.id=1;


