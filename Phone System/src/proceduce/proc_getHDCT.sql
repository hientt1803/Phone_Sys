

create proc getHDCT
as 
begin
	select hd.MaHoaDon,sp.TenSanPham,sp.DonGia,sp.SoLuong,
	sum(sp.DonGia * hdct.SoLuong) as 'thanhtien'
	from HoaDon hd 
	join HoaDonChiTiet hdct on hd.MaHoaDon = hdct.MaHoaDon
	join SanPham sp on hdct.MaSanPham = sp.MaSanPham 
	group by hd.MaHoaDon,sp.TenSanPham,sp.DonGia,sp.SoLuong
end
