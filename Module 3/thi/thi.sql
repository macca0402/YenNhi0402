create
database thi;
use
thi;
create table hinh_thuc_thanh_toan(
ma_hinh_thuc_thanh_toan int primary key,
ten_hinh_thuc varchar(50)
);
create table tro(
ma_tro int primary key auto_increment,
ten_nguoi_thue_tro varchar(50),
so_dien_thoai varchar(50),
ngay_bat_dau_thue date,
ma_hinh_thuc_thanh_toan int,
  foreign key (ma_hinh_thuc_thanh_toan) references hinh_thuc_thanh_toan (ma_hinh_thuc_thanh_toan)

);
alter table tro add ghi_chu varchar(50);
select * from hinh_thuc_thanh_toan;
select * from tro;
SELECT * from hinh_thuc_thanh_toan where hinh_thuc_thanh_toan.ma_hinh_thuc_thanh_toan=1;
insert into tro(ten_nguoi_thue_tro,so_dien_thoai,ngay_bat_dau_thue,ma_hinh_thuc_thanh_toan,ghi_chu)
 values("Trần Trung","0905887711","2023-02-09",2,"có điều hòa");
 delimiter //
 create procedure tim_kiem(in tim_kiem varchar(50))
 begin
  select * from tro
 having tro.ten_nguoi_thue_tro like tim_kiem or tro.so_dien_thoai like tim_kiem;
 end //
 delimiter ;
 call tim_kiem("%Nguyễn%");
 
 
 
 select * from tro
 having tro.ten_nguoi_thue_tro like "Nguyễn %" or tro.so_dien_thoai="%89%";
