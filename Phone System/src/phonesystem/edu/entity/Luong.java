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
public class Luong {

    String maLuong;
    String MaNhanVien;
    float LuongTrenCa, TongCaLam;
    Float TienThuong;
    Date NgayNhan;
    String trangThai;
    String GhiChu;

    public Luong() {
    }

    public Luong(String maLuong, String MaNhanVien, float LuongTrenCa, float TongCaLam, Float TienThuong, Date NgayNhan, String trangThai, String GhiChu) {
        this.maLuong = maLuong;
        this.MaNhanVien = MaNhanVien;
        this.LuongTrenCa = LuongTrenCa;
        this.TongCaLam = TongCaLam;
        this.TienThuong = TienThuong;
        this.NgayNhan = NgayNhan;
        this.trangThai = trangThai;
        this.GhiChu = GhiChu;
    }

    public String getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public float getLuongTrenCa() {
        return LuongTrenCa;
    }

    public void setLuongTrenCa(float LuongTrenCa) {
        this.LuongTrenCa = LuongTrenCa;
    }

    public float getTongCaLam() {
        return TongCaLam;
    }

    public void setTongCaLam(float TongCaLam) {
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    

    

   
    @Override
    public String toString() {
        return "Luong{" + "maLuong=" + maLuong + ", MaNhanVien=" + MaNhanVien + ", LuongTrenCa=" + LuongTrenCa + ", TongCaLam=" + TongCaLam + ", TienThuong=" + TienThuong + ", NgayNhan=" + NgayNhan + '}';
    }

}
