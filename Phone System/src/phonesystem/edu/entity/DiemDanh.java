/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.entity;

import java.util.Date;

/**
 *
 * @author NP
 */
public class DiemDanh {
    int MaDiemDanh;
    String MaNhanVien,TenNhanVien, CaLamViec;
    Date NgayLamViec;
    String GhiChu;

    public DiemDanh() {
    }

    public DiemDanh(int MaDiemDanh, String MaNhanVien, String TenNhanVien, String CaLamViec, Date NgayLamViec, String GhiChu) {
        this.MaDiemDanh = MaDiemDanh;
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.CaLamViec = CaLamViec;
        this.NgayLamViec = NgayLamViec;
        this.GhiChu = GhiChu;
    }

   

    public int getMaDiemDanh() {
        return MaDiemDanh;
    }

    public void setMaDiemDanh(int MaDiemDanh) {
        this.MaDiemDanh = MaDiemDanh;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getCaLamViec() {
        return CaLamViec;
    }

    public void setCaLamViec(String CaLamViec) {
        this.CaLamViec = CaLamViec;
    }

    public Date getNgayLamViec() {
        return NgayLamViec;
    }

    public void setNgayLamViec(Date NgayLamViec) {
        this.NgayLamViec = NgayLamViec;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
