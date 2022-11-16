/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSys.edu.entity;

/**
 *
 * @author NP
 */

//TEsst Comflig
public class TaiKhoan {
    String MaNhanVien, TenDangNhap, MatKhau;
    Boolean Quyen;
    String GhiChu;

    public TaiKhoan() {
    }

    public TaiKhoan(String MaNhanVien, String TenDangNhap, String MatKhau, Boolean Quyen, String GhiChu) {
        this.MaNhanVien = MaNhanVien;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.Quyen = Quyen;
        this.GhiChu = GhiChu;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public Boolean getQuyen() {
        return Quyen;
    }

    public void setQuyen(Boolean Quyen) {
        this.Quyen = Quyen;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "MaNhanVien=" + MaNhanVien + ", TenDangNhap=" + TenDangNhap + ", MatKhau=" + MatKhau + ", Quyen=" + Quyen + ", GhiChu=" + GhiChu + '}';
    }
    
    
}
