/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.entity;

/**
 *
 * @author NP
 */

//TEST COMFLICT

public class HoaDonChiTiet {
    String MaHoaDon, MaSanPham;
    int SoLuong,MaHoaDonChiTiet;
    String GhiChu;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHoaDon, String MaSanPham, int SoLuong, int MaHoaDonChiTiet, String GhiChu) {
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
        this.GhiChu = GhiChu;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getMaHoaDonChiTiet() {
        return MaHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(int MaHoaDonChiTiet) {
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    
    
}
