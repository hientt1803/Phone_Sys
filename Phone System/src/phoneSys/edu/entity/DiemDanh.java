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
public class DiemDanh {
    String MaNhanVien, CaLamViec;
    Date NgayLamViec;
    String GhiChu;

    public DiemDanh() {
    }

    public DiemDanh(String MaNhanVien, String CaLamViec, Date NgayLamViec, String GhiChu) {
        this.MaNhanVien = MaNhanVien;
        this.CaLamViec = CaLamViec;
        this.NgayLamViec = NgayLamViec;
        this.GhiChu = GhiChu;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
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
