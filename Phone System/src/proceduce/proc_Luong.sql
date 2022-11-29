-- query info luong

create procedure getLuong @MaNhanVien varchar(10)
as 
begin 
select nv.TenNhanVien, tk.Quyen, count(dd.MaNhanVien)  as N'Tổng ca' from 
NhanVien nv  join TaiKhoan tk  on nv.MaNhanVien = tk.MaNhanVien join Luong lg 
on lg.MaNhanVien = nv.MaNhanVien join DiemDanh dd on dd.MaNhanVien = nv.MaNhanVien 
where  dd.MaNhanVien = @MaNhanVien
group by nv.TenNhanVien, tk.Quyen
end 


execute getLuong 'NV01'
select * from Luong

select * from DiemDanh

select * from NhanVien

--query fill table luong
create procedure getAllLuong 
as 
begin

select lg.MaLuong, lg.MaNhanVien, nv.TenNhanVien, lg.TongCaLam, lg.LuongTrenCa, lg.TienThuong,(lg.LuongTrenCa * lg.TongCaLam) + lg.TienThuong as N'Tong luong' ,
lg.NgayNhan, lg.TrangThai, lg.GhiChu from  Luong lg join NhanVien nv on 
lg.MaNhanVien = nv.MaNhanVien
end
execute getAllLuong