create database quanLyQuanCafe
go 
use quanLyQuanCafe
go
create table tblTaiKhoan
(
	idTk int identity primary key,
	usename varchar(10) not null,
	passWords varchar(10) not null,
	capDo int not null
)

insert tblTaiKhoan(usename,passWords, capDo)
	values ('adsy','sy123',1),
		   ('nvthien','thien123',2),
		   ('nvnhan','nhan123',2),
		   ('nvnam','nam123',2),
		   ('nvtuan','tuan123',2)

select *from tblTaiKhoan

--DROP FUNCTION AUTO_MANV;
go
CREATE FUNCTION AUTO_MANV()
RETURNS VARCHAR(6)
AS
BEGIN
	DECLARE @ID VARCHAR(6)
	IF (SELECT COUNT(maNV) FROM tblTtNhanVien) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(maNV, 3)) FROM tblTtNhanVien
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'NV000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'NV00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
go
go
CREATE FUNCTION AUTO_MAHD()
RETURNS VARCHAR(6)
AS
BEGIN
	DECLARE @ID VARCHAR(6)
	IF (SELECT COUNT(maHD) FROM tblHoaDon) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(maHD, 3)) FROM tblHoaDon
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'HD000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'HD00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
go
create table tblTtNhanVien
(
	maNv varchar(6) primary key CONSTRAINT maNv DEFAULT DBO.AUTO_MANV(),
	tenNv nvarchar(50) not null,
	gioiTinh char(3) not null
		constraint tblTtNhanVien_gioiTinh_ck check(gioiTinh in ('NAM','NU')),
	SDT varchar(11) not null unique
		constraint tblTtNhanVien_SDTNV_ck
		check(SDT like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
		or SDT like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	diaChi nvarchar(100) not null,
	caLam int not null,
	tienLuong int not null
)




insert tblTtNhanVien (tenNv,gioiTinh,SDT,diaChi, caLam,tienLuong)
	 values-- (N'Bùi Van Sy','NAM','0947895039',N'Gio linh- Quang Tri',1,2000000),
	       -- (N'Nguyen Thành Nhân','NAM','0947229374',N'Hai Châu - Dà Nang',1,2000000),
			--(N'Pham Van Thiên','NAM','0973987640',N'Tam Ky - Quang Nam',2,2000000),
			(N'Nguyen Minh Tuan','NAM','0934873445',N'Gio linh- Quang Tri',2,2000000)
			--(N'Nguyen Tan Nam','NAM','0973984093',N'Dien Bàn - Quang Nam',1,2000000)

select * from tblTtNhanVien
insert tblTtNhanVien (tenNv,gioiTinh,SDT,diaChi, caLam,tienLuong)
	 values (N'Bùi Van Sy','NAM','0947895039',N'Gio linh- Quang Tri',1,2000000)
--drop table tblTtNhanVien

create table tblLoai 
(
	idLoai int identity primary key,
	tenLoai nvarchar(50) not null
)

insert tblLoai(tenLoai)
	values (N'Cafe'),(N'Nước Ép'),(N'Trà'),(N'Sinh tố')

select *from tblLoai

create table tblHangHoa
(
	idMon int identity primary key,
	tenMon nvarchar(50) not null,
	donGia float not null,
	idLoai int not null,
	CONSTRAINT fk_idLoai
	FOREIGN KEY (idLoai)
	REFERENCES tblLoai (idLoai)
)

insert tblHangHoa(tenMon,donGia,idLoai)
	values(N'Cafe đen',23000,1),
	(N'Cafe sửa',23000,1),
	(N'Cafe chin',23000,2),
	(N'Cafe nóng',23000,3),
	(N'Sinh tố táo',23000,4),
	(N'Sinh tố dứa hau',30000,4),
	(N'Sinh tố lựu',30000,4),
	(N'Sinh tố nho',33000,4)

create table tblBan
(
	idBan int identity primary key,
	trangThai nvarchar(10) not null
	constraint ck_trangthai check(trangThai in (N'Trống',N'Đã có')),
	tenBan varchar(3) not null
)


--drop table tblBan

insert tblBan(trangThai,tenBan)
	values(N'Trống','B1'),
	(N'Trống','B2'),
	(N'Trống','B3'),
	(N'Trống','B4'),
	(N'Trống','B5'),
	(N'Trống','B6'),
	(N'Đã có','B7')

create table tblHoaDon
(
	maHD varchar(6) primary key CONSTRAINT maHD DEFAULT DBO.AUTO_MAHD(),
	idBan int not null,
	ngay date not null
	CONSTRAINT fk_idban
	FOREIGN KEY (idBan)
	REFERENCES tblBan (idBan),
	tongTien float null
)

set dateformat YMD  insert tblHoaDon(idBan,ngay)
	values (2,'2021-05-20')
	set dateformat YMD  insert tblHoaDon(idBan,ngay)values
	(2,'2021-05-20')
	set dateformat YMD  insert tblHoaDon(idBan,ngay)values
	(3,'2021-05-19')
	set dateformat YMD  insert tblHoaDon(idBan,ngay)values
	(4,'2021-05-20')
	set dateformat YMD  insert tblHoaDon(idBan,ngay)values
	(5,'2021-05-20')
	set dateformat YMD  insert tblHoaDon(idBan,ngay)values
	(7,'2021-05-20')
	set dateformat YMD  insert tblHoaDon(idBan,ngay)values
	(6,'2021-05-20')
	set dateformat YMD  insert tblHoaDon(idBan,ngay)values
	(4,'2021-05-19')

create table tblChiTietHoaDon
(
	maHD varchar(6) ,
	idMon int,
	primary key (maHD,idMon),
	CONSTRAINT fk_maHD
	FOREIGN KEY (maHD)
	REFERENCES tblHoaDon (maHD),
	CONSTRAINT fk_idMon
	FOREIGN KEY (idMon)
	REFERENCES tblHangHoa (idMon),
	maGiamGia float,
	soLuong int not null,
	thanhTien float
)
--ALTER TABLE tblChiTietHoaDon
--DROP CONSTRAINT idMon;
--drop table tblChiTietHoaDon
go
Create TRIGGER tg_Iser_ChitietDonHang
on tblChitietHoaDon
after insert 
as 
begin 
update tblChitietHoaDon
set tblChitietHoaDon.ThanhTien = tblHangHoa.donGia*inserted.soLuong
from inserted , tblHangHoa
where tblChitietHoaDon.idMon = inserted.idMon 
					and tblChitietHoaDon.idMon = tblHangHoa.idMon
					and tblChitietHoaDon.maHD = inserted.maHD
							
end 

go 





--delete tblChiTietHoaDon 
insert  tblChiTietHoaDon(maHD,idMon,soLuong,maGiamGia,thanhTien)
	values ('HD0001',1,2,0,0),
	('HD0001',2,2,0,0),
	('HD0002',3,2,0,0),
	('HD0002',1,2,0,0),
	('HD0002',2,2,0,0),
	('HD0003',4,2,0,0),
	('HD0003',1,4,0,0)
go
Create TRIGGER tg_upd_tblChiTietDonHang
on tblChitietHoaDon
after update 
as
begin
update tblChitietHoaDon 
set tblChitietHoaDon.thanhTien = dongia*  tblChitietHoaDon.soLuong
from  inserted as i, deleted as d , tblhangHoa
where tblChitietHoaDon.idMon = i.idMon 
			and tblChitietHoaDon.idMon=tblhanghoa.idMon 
			and d.idMon = i.idMon
			and tblChitietHoaDon.maHD = i.maHD
end 
update tblHoaDon set TongTien = 5000 
where maHD = 'HD0001'

SELECT maHD, MAX(RIGHT(maHD, 3)) 
FROM tblHoaDon
group by maHD
                	having MAX(RIGHT(maHD, 3)) in (SELECT distinct  top(1) MAX(RIGHT(maHD, 3))
					FROM tblHoaDon
               	where idban = 2)
	Select * From tblban