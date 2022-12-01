/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.dao;

import java.awt.image.SampleModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import phonesystem.edu.entity.DiemDanh;
import phonesystem.edu.entity.KhuyenMai;
import phonesystem.edu.entity.SanPham;
import phonesystem.edu.ultil.jdbcHelper;

/**
 *
 * @author NP
 */
public class KhuyenMaiDAO extends PhoneSysDAO<KhuyenMai, String> {

    String INSERT_SQL = "INSERT INTO KhuyenMai(MaSanPham,TenKhuyenMai,NgayBatDau,NgayKetThuc,GiaGiam,TrangThai,GhiChu) values(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE KhuyenMai set NgayBatDau = ?, NgayKetThuc = ?, GiaGiam = ?, TrangThai = ?, GhiChu = ? WHERE TenKhuyenMai = ?";
    String SELECT_ALL_SQL = "SELECT * FROM KhuyenMai";
    String SELECT_TENSP_SQL = "SELECT sp.TenSanPham FROM SanPham sp JOIN KhuyenMai km ON sp.MaSanPham = km.MaSanPham WHERE km.MaSanPham = ?";
    String SELECT_BY_TENKM_SQL = "SELECT * FROM KhuyenMai WHERE TenKhuyenMai = ?";
    String SELECT_SP_NOTIN_KHUYENMAI = "select TenKhuyenMai,GiaGiam,NgayBatDau,NgayKetThuc,TrangThai,GhiChu from KhuyenMai\n" +
"where TenKhuyenMai not in (select TenKhuyenMai from KhuyenMai where MaSanPham = ?)\n" +
"group by TenKhuyenMai,GiaGiam,NgayBatDau,NgayKetThuc,TrangThai,GhiChu";
    String SELECT_KHUYENMAI_BY_MASP = "SELECT * FROM KhuyenMai WHERE MaSanPham = ?";
    String SELECT_KHUYENMAI = "SELECT TenKhuyenMai,GiaGiam,NgayBatDau,NgayKetThuc,TrangThai,GhiChu FROM KhuyenMai\n"
            + "group by TenKhuyenMai,GiaGiam,NgayBatDau,NgayKetThuc,TrangThai,GhiChu";

    @Override
    public void insert(KhuyenMai entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaSanPham(), entity.getTenKhuyenMai(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getGiaGiam(), entity.getTrangThai(),
                    entity.getGhiChu()
            );
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KhuyenMai entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KhuyenMai> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhuyenMai selectByid(String key) {
        List<KhuyenMai> list = (List<KhuyenMai>) selectBySql(SELECT_BY_TENKM_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhuyenMai entity = new KhuyenMai();
                entity.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
                entity.setMaSanPham(rs.getString("MaSanPham"));
                entity.setGiaGiam(rs.getFloat("GiaGiam"));
                entity.setNgayBatDau(rs.getDate("NgayBatDau"));
                entity.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                entity.setGhiChu(rs.getString("GhiChu"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String selectByTenSanPham(String masp) {
        String ma = "";
        try {
            ResultSet rs = jdbcHelper.query(SELECT_TENSP_SQL, masp);
            while (rs.next()) {
                ma = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ma;
    }

    public List<KhuyenMai> selectKhuyenMai() {
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(SELECT_KHUYENMAI);
            while (rs.next()) {
                KhuyenMai entity = new KhuyenMai();
                entity.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
                entity.setGiaGiam(rs.getFloat("GiaGiam"));
                entity.setNgayBatDau(rs.getDate("NgayBatDau"));
                entity.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                entity.setGhiChu(rs.getString("GhiChu"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
     public List<KhuyenMai> selectSanPhamNotInKhuyenMai(String maSP) {
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(SELECT_SP_NOTIN_KHUYENMAI,maSP);
            while (rs.next()) {
                KhuyenMai entity = new KhuyenMai();
                entity.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
                entity.setGiaGiam(rs.getFloat("GiaGiam"));
                entity.setNgayBatDau(rs.getDate("NgayBatDau"));
                entity.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                entity.setGhiChu(rs.getString("GhiChu"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public List<KhuyenMai> selectSanPhamNotInKhuyenMai(String masp) {
//        return this.selectBySql(SELECT_SP_NOTIN_KHUYENMAI, masp);
//    }

    public List<KhuyenMai> selectKhuyenMaiByMaSP(String masp) {
        return this.selectBySql(SELECT_KHUYENMAI_BY_MASP, masp);
    }

    public List<KhuyenMai> selectLenTextFielKhuyenMaiByTenKM(String tenKM) {
        return this.selectBySql(SELECT_BY_TENKM_SQL, tenKM);
    }
    
}
