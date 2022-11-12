/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSys.edu.entity;

import java.util.Date;

/**
 *
 * @author NP
 */
public class KhuyenMai {
    String MaKhuyenMai, TenKhuyenMai;
    Date NgayBatDau, NgayKetThuc;
    float GiaGiam;
    String MaSanPham;
    Boolean TrangThai;
    String GhiChu;

    public KhuyenMai() {
    }

    public KhuyenMai(String MaKhuyenMai, String TenKhuyenMai, Date NgayBatDau, Date NgayKetThuc, float GiaGiam, String MaSanPham, Boolean TrangThai, String GhiChu) {
        this.MaKhuyenMai = MaKhuyenMai;
        this.TenKhuyenMai = TenKhuyenMai;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.GiaGiam = GiaGiam;
        this.MaSanPham = MaSanPham;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    public String getMaKhuyenMai() {
        return MaKhuyenMai;
    }

    public void setMaKhuyenMai(String MaKhuyenMai) {
        this.MaKhuyenMai = MaKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return TenKhuyenMai;
    }

    public void setTenKhuyenMai(String TenKhuyenMai) {
        this.TenKhuyenMai = TenKhuyenMai;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public float getGiaGiam() {
        return GiaGiam;
    }

    public void setGiaGiam(float GiaGiam) {
        this.GiaGiam = GiaGiam;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public Boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
