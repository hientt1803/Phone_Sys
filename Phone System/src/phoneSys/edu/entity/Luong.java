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
public class Luong {
    String MaNhanVien;
    float LuongTrenCa, TongCaLam;
    Float TienThuong;
    Date NgayNhan;

    public Luong() {
    }

    public Luong(String MaNhanVien, Float LuongTrenCa, Float TongCaLam, Float TienThuong, Date NgayNhan) {
        this.MaNhanVien = MaNhanVien;
        this.LuongTrenCa = LuongTrenCa;
        this.TongCaLam = TongCaLam;
        this.TienThuong = TienThuong;
        this.NgayNhan = NgayNhan;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Float getLuongTrenCa() {
        return LuongTrenCa;
    }

    public void setLuongTrenCa(Float LuongTrenCa) {
        this.LuongTrenCa = LuongTrenCa;
    }

    public Float getTongCaLam() {
        return TongCaLam;
    }

    public void setTongCaLam(Float TongCaLam) {
        this.TongCaLam = TongCaLam;
    }

    public Float getTienThuong() {
        return TienThuong;
    }

    public void setTienThuong(Float TienThuong) {
        this.TienThuong = TienThuong;
    }

    public Date getNgayNhan() {
        return NgayNhan;
    }

    public void setNgayNhan(Date NgayNhan) {
        this.NgayNhan = NgayNhan;
    }
    
    
}
