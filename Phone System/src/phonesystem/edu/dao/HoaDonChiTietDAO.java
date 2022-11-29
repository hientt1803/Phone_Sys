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
import phonesystem.edu.ultil.jdbcHelper;

/**
 *
 * @author HienTran
 */
public class HoaDonChiTietDAO extends PhoneSysDAO<HoaDonChiTiet, String> {

    String INSERT_SQL = "INSERT INTO HoaDonChiTiet(MaHoaDonChiTiet,MaHoaDon,MaSanPham,SoLuong,GhiChu) values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE HoaDonChiTiet set MaHoaDon = ? , MaSanPham = ? , SoLuong = ? , GhiChu = ?";
    String DELETE_SQL = "DELETE FROM HoaDonChiTiet where MaHoaDonChiTiet = ?";
    String SELECT_ALL_SQL = "select hd.MaHoaDon,sp.TenSanPham,sp.DonGia,sp.SoLuong,\n"
            + "sum(sp.DonGia * hdct.SoLuong) as 'thanhtien'\n"
            + "from HoaDon hd \n"
            + "join HoaDonChiTiet hdct on hd.MaHoaDon = hdct.MaHoaDon\n"
            + "join SanPham sp on hdct.MaSanPham = sp.MaSanPham \n"
            + "group by hd.MaHoaDon,sp.TenSanPham,sp.DonGia,sp.SoLuong";
    String SELECT_BY_ID_SQL = "SELECT * FROM HoaDonChiTiet where MaHoaDonChiTiet = ? ";
    String SELECT_BY_PROC = "{CALL getHDCT(?)}";

    @Override
    public void insert(HoaDonChiTiet entity) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    entity.getMaHoaDon(), entity.getMaSanPham(), entity.getSoLuong(), entity.getGhiChu()
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
    
    public List<Object[]> getHoaDonChiTiet(String maHD) {
        String[] cols = {"MaHoaDon", "TenSanPham", "DonGia", "SoLuong", "ThanhTien"};
        return this.getListOfArray(SELECT_BY_PROC, cols,maHD);
    }

    public List<Object[]> getListOfArray(String sql, String[] cols, Object... agrs) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, agrs);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
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
