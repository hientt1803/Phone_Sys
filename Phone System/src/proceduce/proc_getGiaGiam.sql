create proc getGiaGiam (@tenSP NVARCHAR(MAX))
as
begin
select sum(km.giagiam) as'GiaGiam' from KhuyenMai km 
JOIN sanpham sp on km.MaSanPham = sp.MaSanPham
where tenSanPham = @tenSP;
END


execute getGiaGiam