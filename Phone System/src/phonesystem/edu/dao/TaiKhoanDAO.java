/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import phonesystem.edu.entity.HoaDonChiTiet;
import phonesystem.edu.entity.TaiKhoan;
import phonesystem.edu.ultil.jdbcHelper;

/**
 *
 * @author HienTran
 */
public class TaiKhoanDAO extends PhoneSysDAO<TaiKhoan, String> {

    String INSERT_SQL = "INSERT INTO TaiKhoan(MaNhanVien,TenDangNhap,MatKhau,Quyen,GhiChu) values(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE TaiKhoan set TenDangNhap = ? , MatKhau = ? , Quyen = ? ,GhiChu = ? where  MaNhanVien = ?";
    String DELETE_SQL = "DELETE FROM TaiKhoan where MaNhanVien = ?";
    String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan";
    String SELECT_BY_ID_SQL = "SELECT * FROM TaiKhoan where MaNhanVien = ? ";

    @Override
    public void insert(TaiKhoan entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaNhanVien(),
                    entity.getTenDangNhap(),
                    entity.getMatKhau(),
                    entity.getQuyen(),
                    null
            );
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TaiKhoan entity) {
        try {
            jdbcHelper.update(UPDATE_SQL,
                    entity.getTenDangNhap(),
                    entity.getMatKhau(),
                    entity.getQuyen(),
                    null,
                    entity.getMaNhanVien()
            );
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String key) {
        try {
            jdbcHelper.update(DELETE_SQL, key);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TaiKhoan selectByid(String key) {
        List<TaiKhoan> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                TaiKhoan entity = new TaiKhoan();
                entity.setMaNhanVien(rs.getString("MaNhanVien"));
                entity.setTenDangNhap(rs.getString("TenDangNhap"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setQuyen(rs.getBoolean("Quyen"));
                entity.setGhiChu(rs.getString("GhiChu"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    String SELECT_BY_TenDangNhap_SQL = "SELECT * FROM TaiKhoan where TenDangNhap = ?";
    public TaiKhoan selectByTenDangNhap(String key) {
        List<TaiKhoan> list = this.selectBySql(SELECT_BY_TenDangNhap_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    String UPDATE_PASSWORD = "UPDATE TaiKhoan set MatKhau = ? WHERE TenDangNhap = ?";
    public TaiKhoan CapNhatMatKhau(String TenDangNhap,String MatKhau){
        return (TaiKhoan) this.selectBySql(UPDATE_PASSWORD);
    }

}
