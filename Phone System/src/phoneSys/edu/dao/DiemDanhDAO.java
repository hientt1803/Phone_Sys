/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSys.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import phoneSys.edu.entity.DiemDanh;
import phoneSys.edu.ultil.jdbcHelper;

/**
 *
 * @author NP
 */
public class DiemDanhDAO extends PhoneSysDAO<DiemDanh, String> {

    String INSERT_SQL = "INSERT INTO DiemDanh(MaNhanVien, CaLamViec, NgayLamViec,GhiChu) values(?,?,?,?)";
    String SELECT_ALL_SQL = "SELECT dd.STT,dd.MaNhanVien,nv.TenNhanVien,dd.CaLamViec,dd.NgayLamViec,dd.GhiChu FROM DiemDanh dd JOIN NhanVien nv ON dd.MaNhanVien = nv.MaNhanVien";
    String SELECT_LOC_NGAY_SQL = "SELECT dd.STT,dd.MaNhanVien,nv.TenNhanVien,dd.CaLamViec,dd.NgayLamViec,dd.GhiChu FROM DiemDanh dd JOIN NhanVien nv ON dd.MaNhanVien = nv.MaNhanVien WHERE NgayLamViec = ?";
    String SELECT_LOC_CA_SQL = "SELECT dd.STT,dd.MaNhanVien,nv.TenNhanVien,dd.CaLamViec,dd.NgayLamViec,dd.GhiChu FROM DiemDanh dd JOIN NhanVien nv ON dd.MaNhanVien = nv.MaNhanVien WHERE CaLamViec = ?";
    String SELECT_TENNV_SQL = "SELECT nv.TenNhanVien FROM NhanVien nv JOIN TaiKhoan tk ON nv.MaNhanVien = tk.MaNhanVien WHERE tk.MaNhanVien = ?";
    String SELECT_MANHAVIENB_SQL = "select distinct MaNhanVien from DiemDanh";

    @Override
    public void insert(DiemDanh entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaNhanVien(), entity.getCaLamViec(), entity.getNgayLamViec(), entity.getGhiChu()
            );
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DiemDanh entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DiemDanh> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    DiemDanh selectByid(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DiemDanh> selectBySql(String sql, Object... args) {
        List<DiemDanh> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                DiemDanh entity = new DiemDanh();
                entity.setMaDiemDanh(rs.getInt("STT"));
                entity.setMaNhanVien(rs.getString("MaNhanVien"));
                entity.setTenNhanVien(rs.getString("TenNhanVien"));
                entity.setCaLamViec(rs.getString("CaLamViec"));
                entity.setNgayLamViec(rs.getDate("NgayLamViec"));
                entity.setGhiChu(rs.getString("GhiChu"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DiemDanh> selectAll_TheoNgayVaoLam(Date ngay) {
        return (List<DiemDanh>) this.selectBySql(SELECT_LOC_NGAY_SQL, ngay);
    }

    public List<DiemDanh> selectAll_TheoCaLamViec(String ca) {
        return (List<DiemDanh>) this.selectBySql(SELECT_LOC_CA_SQL, ca);
    }

    public String selectByTenNhanVien(String manv) {
        String ma = "";
        try {
            ResultSet rs = jdbcHelper.query(SELECT_TENNV_SQL, manv);
            while (rs.next()) {
                ma = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ma;
    }

    public List<String> getMaNhanVien() {

        List<String> ls = new ArrayList<>();

        try {
            ResultSet rs = jdbcHelper.query(SELECT_MANHAVIENB_SQL);
            while (rs.next()) {
                ls.add(rs.getString(1));
            }
            rs.getStatement().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public static void main(String[] args) {
        DiemDanhDAO dao = new DiemDanhDAO();
        List<String> ls = dao.getMaNhanVien();
        for (String l : ls) {
            System.out.println(l);
        }
    }
}
