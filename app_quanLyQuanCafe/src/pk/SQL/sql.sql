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
		