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
import phoneSys.edu.entity.HoaDonChiTiet;
import phoneSys.edu.ultil.jdbcHelper;

/**
 *
 * @author HienTran
 */
public class HoaDonChiTietDAO extends PhoneSysDAO<HoaDonChiTiet, String> {

    String INSERT_SQL = "";
    String UPDATE_SQL = "";
    String DELETE_SQL = "";
    String SELECT_ALL_SQL = "";
    String SELECT_BY_ID_SQL = "";

    @Override
    public void insert(HoaDonChiTiet entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaHoaDonChiTiet(), entity.getMaHoaDon(), entity.getMaSanPham(), entity.getSoLuong(), entity.getGhiChu()
            );
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaHoaDon(), entity.getMaSanPham(), entity.getSoLuong(), entity.getGhiChu(), entity.getMaHoaDonChiTiet()
            );
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String key) {
        try {
            jdbcHelper.update(DELETE_SQL, key);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    HoaDonChiTiet selectByid(String key) {
        List<HoaDonChiTiet> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setMaHoaDonChiTiet(rs.getInt("MaHoaDonChiTiet"));
                entity.setMaHoaDon(rs.getString("MaHoaDon"));
                entity.setMaSanPham(rs.getString("MaSanPham"));
                entity.setSoLuong(rs.getInt("SoLuong"));
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
