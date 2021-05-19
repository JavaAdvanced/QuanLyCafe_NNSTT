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

create table tblTtNhanVien
(
	maNv varchar(6) primary key,
	tenNv nvarchar(50) not null,
	gioiTinh char(3) not null
		constraint tblTtNhanVien_gioiTinh_ck check(gioiTinh in ('NAM','N?')),
	SDT varchar(11) not null unique
		constraint tblTtNhanVien_SDTNV_ck
		check(SDT like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
		or SDT like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	diaChi nvarchar(100) not null,
	caLam int not null
)

drop table tblTtNhanVien


insert tblTtNhanVien (maNv,tenNv,gioiTinh,SDT,diaChi, caLam)
	 values ('NV01',N'Bùi V?n S?','NAM','0947895039',N'Gio linh- Qu?ng Tr?',1),
	        ('NV02',N'Nguy?n Thành Nhân','NAM','0947229374',N'H?i Châu - ?à N?ng',1),
			('NV03',N'Ph?m V?n Thiên','NAM','0973987640',N'Tam K? - Qu?ng Nam',2),
			('NV04',N'Nguy?n Minh Tu?n','NAM','0934873445',N'Gio linh- Qu?ng Tr?',2),
			('NV05',N'Nguy?n T?n N?m','NAM','0973984093',N'?i?n Bàn - Qu?ng Nam',1)

create table tblLoai 
(
	idLoai int identity primary key,
	tenLoai nvarchar(50) not null
)

insert tblLoai(tenLoai)
	values (N'Cafe'),(N'N??c Ép'),(N'Trà'),(N'Sinh t?')

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
	values(N'Cafe ?en',23000,1),
	(N'Cafe s?a',23000,1),
	(N'Cafe ch?n',23000,1),
	(N'Cafe nóng',23000,1),
	(N'Sinh t? táo',23000,4),
	(N'Sinh t? d?a h?u',30000,4),
	(N'Sinh t? l?u',30000,4),
	(N'Sinh t? nho',33000,4)

create table tblBan
(
	idBan int identity primary key,
	trangThai nvarchar(10) not null
	constraint ck_trangthai check(trangThai in (N'Tr?ng',N'?ã có')),
	tenBan varchar(3) not null
)


drop table tblBan

insert tblBan(trangThai,tenBan)
	values(N'Tr?ng','B1'),
	(N'Tr?ng','B2'),
	(N'Tr?ng','B3'),
	(N'Tr?ng','B4'),
	(N'Tr?ng','B5'),
	(N'Tr?ng','B6'),
	(N'?ã có','B7')

create table tblHoaDon
(
	maHD varchar(9) primary key,
	idBan int not null,
	ngay date not null
	CONSTRAINT fk_idban
	FOREIGN KEY (idBan)
	REFERENCES tblBan (idBan)
)

insert tblHoaDon(maHD,idBan,ngay)
	values ('HD01',2,'2021-05-20'),
	('HD02',2,'2021-05-20'),
	('HD03',3,'2021-05-19'),
	('HD04',4,'2021-05-20'),
	('HD05',5,'2021-05-20'),
	('HD06',7,'2021-05-20'),
	('HD07',6,'2021-05-20'),
	('HD08',4,'2021-05-19')

create table tblChiTietHoaDon
(
	maHD varchar(9) ,
	idMon int,
	primary key (maHD,idMon),
	soLuong int not null,
	maGiamGia int,
	thanhTien float
	CONSTRAINT fk_maHD
	FOREIGN KEY (maHD)
	REFERENCES tblHoaDon (maHD),
	CONSTRAINT fk_idMon
	FOREIGN KEY (idMon)
	REFERENCES tblHangHoa (idMon)
)
ALTER TABLE tblChiTietHoaDon
DROP CONSTRAINT idMon;
drop table tblChiTietHoaDon

insert tblChiTietHoaDon(maHD,idMon,soLuong,maGiamGia)
	values ('HD01',1,2,0),
	('HD01',2,2,0),
	('HD02',3,2,0),
	('HD02',1,2,0),
	('HD02',2,2,0),
	('HD03',4,2,0),
	('HD03',1,4,0)