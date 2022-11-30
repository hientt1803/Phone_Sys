
-- Tạo database PhoneSys
CREATE DATABASE PhoneSys;
go
USE PhoneSys;
go
-- Tạo table NhanVien
CREATE TABLE NhanVien (
	MaNhanVien varchar(10) NOT NULL PRIMARY KEY,
	TenNhanVien nvarchar(50) NOT NULL,
	NgaySinh date NOT NULL,
	GioiTinh bit NOT NULL,
	CCCD varchar(20) NOT NULL,
	SDT varchar(10) NOT NULL,
	DiaChi nvarchar(255) NOT NULL,
	Email varchar(50) NOT NULL,
	TrangThai BIT NOT NULL,
	HinhAnh varchar(100) NOT NULL,
	GhiChu nvarchar(50) NULL
);
go
-- Taọ table DiemDanh
CREATE TABLE DiemDanh (
	 STT int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	 MaNhanVien varchar(10) NOT NULL,
	 CaLamViec nvarchar(50) NOT NULL,
	 NgayLamViec date  NOT NULL,
	 GhiChu nvarchar(50) NULL
);
go
-- Tạo table TaiKhoan
CREATE TABLE TaiKhoan (
	 MaNhanVien varchar(10) NOT NULL,
	 TenDangNhap nvarchar(50) NOT NULL,
	 MatKhau nvarchar(10) NOT NULL,
	 Quyen bit NOT NULL,
	 GhiChu nvarchar(50) NULL,
	 CONSTRAINT PK_TaiKhoan PRIMARY KEY (MaNhanVien)
);
go
-- Tạo table Luong
CREATE TABLE Luong (
	 MaLuong int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	 MaNhanVien varchar (10) NULL,
	 LuongTrenCa float NOT NULL,
	 TongCaLam float NOT NULL,
	 TienThuong float NOT NULL,
	 NgayNhan date NULL,
	 TrangThai nvarchar(50) NOT NULL,
	 GhiChu nvarchar(50) NULL
);
go
-- Tạo table KhachHang
CREATE TABLE KhachHang (
	 MaKhachHang varchar(10) NOT NULL PRIMARY KEY,
	 TenKhachHang nvarchar(50) NOT NULL,
	 GioiTinh bit NOT NULL,
	 SDT varchar(10) NOT NULL,
	 TrangThai bit NOT NULL,
	 GhiChu nvarchar(50) NULL
);
go
-- Tạo table SanPham (
CREATE TABLE SanPham (
	 MaSanPham varchar(10) NOT NULL PRIMARY KEY,
	 TenSanPham nvarchar(50) NOT NULL,
	 HangSanXuat nvarchar (50) NOT NULL,
	 XuatXu nvarchar (50) NOT NULL,
	 MauSac nvarchar (50) NOT NULL,
	 SoLuong int  NOT NULL,
	 DonGia float  NOT NULL,
	 HinhAnh varchar(100) NOT NULL,
	 TrangThai bit NOT NULL,
	 GhiChu nvarchar(50) NULL
);
go

-- Tạo table KhuyenMai
CREATE TABLE KhuyenMai (
	 TenKhuyenMai nvarchar(50) NOT NULL,
	 MaSanPham varchar(10) NOT NULL,
	 NgayBatDau date NOT NULL,
	 NgayKetThuc date NOT NULL,
	 GiaGiam float NOT NULL,
	 TrangThai bit NOT NULL,
	 GhiChu nvarchar(50) NULL,
	 CONSTRAINT PK_KhuyenMai PRIMARY KEY (TenKhuyenMai,MaSanPham)
);

-- Tạo table HoaDon
CREATE TABLE HoaDon (
	 MaHoaDon varchar (10) NOT NULL PRIMARY KEY,
	 MaKhachHang varchar (10) NOT NULL,
	 MaNhanVien varchar (10) NOT NULL,
	 NgayTao date NOT NULL,
	 GhiChu nvarchar(50) NULL
);
go
-- Tạo table HoaDonChiTiet 
CREATE TABLE HoaDonChiTiet (
	 MaHoaDonChiTiet int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	 MaHoaDon varchar (10) NOT NULL,
	 MaSanPham varchar (10) NOT NULL,
	 SoLuong int NOT NULL,
	 GhiChu nvarchar(50) NULL
);
go
-- Tạo khóa ngoại (MaNhanVien) cho table DiemDanh
ALTER TABLE DiemDanh
ADD CONSTRAINT FK_MaNhanVien_DiemDanh
FOREIGN KEY(MaNhanVien)
REFERENCES NhanVien(MaNhanVien);
go
-- Tạo khóa ngoại (MaNhanVien) cho table TaiKhoan
ALTER TABLE TaiKhoan
ADD CONSTRAINT FK_MaNhanVien_TaiKhoan
FOREIGN KEY(MaNhanVien)
REFERENCES NhanVien(MaNhanVien);
go
-- Tạo khóa ngoại (MaNhanVien) cho table Luong
ALTER TABLE Luong
ADD CONSTRAINT FK_MaNhanVien_Luong
FOREIGN KEY(MaNhanVien)
REFERENCES NhanVien(MaNhanVien);
go
-- Tạo khóa ngoại (MaSanPham) cho table KhuyenMai
ALTER TABLE KhuyenMai
ADD CONSTRAINT FK_MaSanPham_KhuyenMai
FOREIGN KEY(MaSanPham)
REFERENCES SanPham(MaSanPham);
go
-- Tạo khóa ngoại (MaKhachHang) cho table HoaDon
ALTER TABLE HoaDon
ADD CONSTRAINT FK_MaKhachHang_HoaDon
FOREIGN KEY(MaKhachHang)
REFERENCES KhachHang(MaKhachHang);
go

-- Tạo khóa ngoại (MaNhanVien) cho table HoaDon
ALTER TABLE HoaDon
ADD CONSTRAINT FK_MaNhanVien_HoaDon
FOREIGN KEY(MaNhanVien)
REFERENCES NhanVien(MaNhanVien);
go
-- Tạo khóa ngoại (MaSanPham) cho table HoaDonChiTiet
ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_MaSanPham_HoaDonChiTiet
FOREIGN KEY(MaSanPham)
REFERENCES SanPham(MaSanPham);
go
-- Tạo khóa ngoại (MaHoaDon) cho table HoaDonChiTiet
ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_MaHoaDon_HoaDonChiTiet
FOREIGN KEY(MaHoaDon)
REFERENCES HoaDon(MaHoaDon);
go

-- INSERT DỮ LIỆU VÀO TABLE

--Insert dữ liệu vào table NhanVien
INSERT INTO NhanVien
VALUES
('NV01',N'Trần Trọng Hiến','2003-11-27','True','687543268','0723855478',N'Bạc Liêu','hientt@2003','False','D:\Anh',null),
('NV02',N'Nguyễn Hoài Nam','2003-09-15','True','687073268','0773455478',N'Sóc Trăng','namnh@2003','False','D:\Anh1',null),
('NV03',N'Lê Minh Dương','2003-03-19','False','687545468','0776855478',N'Hậu Giang','duonglm@2003','False','D:\Anh2',null);
go
-- Insert dữ liệu vào table DiemDanh
INSERT INTO DiemDanh
VALUES
('NV01',N'Ca Sáng','2022-10-10',null),
('NV02',N'Ca Chiều','2022-10-11',null),
('NV02',N'Ca Sáng','2022-10-12',null),
('NV03',N'Ca Sáng','2022-10-13',null);
go
-- Insert dữ liệu vào table TaiKhoan
INSERT INTO TaiKhoan
VALUES
('NV01',N'hientrantrong',N'hien123','True',null),
('NV02',N'namnguyenhoai',N'nam123','True',null),
('NV03',N'duongminhle',N'duong123','False',null);
go
-- Insert dữ liệu vào table Luong
INSERT INTO Luong
VALUES
('NV01',200000,3,0,'2022-11-27',N'Đã nhận',null),
('NV02',200000,4,0,'2022-11-27',N'Chưa nhận',null),
('NV03',100000,2,0,null,N'Đã nhận',null);
go
-- Insert dữ liệu vào table KhachHang
INSERT INTO KhachHang
VALUES
('KH01',N'Trần Khánh Dư','True','0987654865','True',''),
('KH02',N'Nguyễn Văn Hiệp','True','0988234865','True',''),
('KH03',N'Trần Mỹ Nhân','False','0987601265','False','');
go

-- Insert dữ liệu vào table SanPham
INSERT INTO SanPham
VALUES
('SP01',N'Apple A51',N'Apple',N'Trung Quốc',N'Xanh',8,1500000,'D:\Anh5','True',null),
('SP02',N'SamSung J4',N'SamSung',N'Hàn Quốc',N'Vàng',5,4500000,'D:\Anh7','True',null),
('SP03',N'Iphone X',N'Iphone',N'Trung Quốc',N'Tím',8,2500000,'D:\Anh8','True',null);
go
-- Insert dữ liệu vào table KhuyenMai
INSERT INTO KhuyenMai
VALUES
(N'Noel an lành','SP01','2022-10-10','2022-11-11',500000,'True',null),
(N'Tết vui vẻ','SP02','2022-12-01','2022-12-30',550000,'True',null),
(N'Mùa đông không lạnh','SP03','2022-09-10','2022-10-10',400000,'True',null);
go
-- Insert dữ liệu vào table HoaDon
INSERT INTO HoaDon
VALUES
('HD01','KH01','NV01','2022-11-27',null),
('HD02','KH02','NV02','2022-11-17',null),
('HD03','KH03','NV03','2022-11-20',null),
('HD04','KH01','NV01','2022-11-26',null);
go
-- Insert dữ liệu vào table HoaDonChiTiet
INSERT INTO HoaDonChiTiet
VALUES
('HD01','SP01',2,null),
('HD02','SP02',5,null),
('HD03','SP03',1,null),
('HD04','SP02',3,null);
go
