/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSys.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import phoneSys.edu.entity.HoaDon;
import phoneSys.edu.ultil.jdbcHelper;

/**
 *
 * @author HienTran
 */
public class HoaDonDAO extends PhoneSysDAO<HoaDon, String> {

    String INSERT_SQL = "INSERT INTO HoaDon(MaHoaDon,MaKhachHang,MaNhanVien,NgayTao,GhiChu) values(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE HoaDon set MaKhachHang = ? , MaNhanVien = ? , NgayTao = ? , GhiChu = ? where MaHoaDon = ?";
    String DELETE_SQL = "DELETE FROM HoaDon where MaHoaDon = ?";
    String SELECT_ALL_SQL = "SELECT * FROM HoaDon";
    String SELECT_BY_ID_SQL = "SELECT * FROM HoaDon where MaHoaDon = ?";

    @Override
    public void insert(HoaDon entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaHoaDon(), entity.getMaKhachHang(), entity.getMaNhanVien(), entity.getNgayTao(), entity.getGhiChu()
            );
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HoaDon entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaKhachHang(), entity.getMaNhanVien(), entity.getNgayTao(), entity.getGhiChu(), entity.getMaHoaDon()
            );
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String key) {
        try {
            jdbcHelper.update(DELETE_SQL, key);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    HoaDon selectByid(String key) {
        List<HoaDon> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHoaDon(rs.getString("MaHoaDon"));
                entity.setMaKhachHang(rs.getString("MaKhachHang"));
                entity.setMaNhanVien(rs.getString("MaNhanVien"));
                entity.setNgayTao(rs.getDate("NgayTao"));
                entity.setGhiChu(rs.getString("GhiChu"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
