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
import phonesystem.edu.entity.HoaDon;
import phonesystem.edu.ultil.jdbcHelper;

/**
 *
 * @author HienTran
 */
public class HoaDonDAO extends PhoneSysDAO<HoaDon, String> {

    String INSERT_SQL = "INSERT INTO HoaDon(MaHoaDon,MaKhachHang,MaNhanVien,NgayTao,GhiChu) values(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE HoaDon set MaKhachHang = ? , MaNhanVien = ? , NgayTao = ? , GhiChu = ? where MaHoaDon = ?";
    String DELETE_SQL = "DELETE FROM HoaDon where MaHoaDon = ?";
    String SELECT_ALL_SQL = "{CALL getHD}";
    String SELECT_PROC_GIAGIAM_SQL = "{CALL getGiaGiam(?)}";
    String SELECT_BY_ID_SQL = "SELECT * FROM HoaDon where MaHoaDon = ?";
    String SELECT_LAST_ID = "select top 1 MaHoaDon from HoaDon order by MaHoaDon  desc";

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

    public String getID_HoaDon() {
        String id = "";

        try {
            ResultSet rs = jdbcHelper.query(SELECT_LAST_ID);
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public List<Object[]> getHoaDon() {
        String[] cols = {"MaHoaDon", "TenNhanVien", "TenKhachHang", "NgayTao", "ThanhTien"};
        return this.getListOfArray(SELECT_ALL_SQL, cols);
    }

    public List<Object[]> getGiaGiam(String tenSP) {
        String[] cols = {"GiaGiam"};
        return this.getListOfArray(SELECT_PROC_GIAGIAM_SQL, cols, tenSP);
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
    
    public List<HoaDon> selectByDateCreate(String key) {
        String sql = "SELECT * FROM HoaDon WHERE NgayTao like ?";
        return this.selectBySql(sql, "%"+key+"%");
    }

    public static void main(String[] args) {
        HoaDonDAO dao = new HoaDonDAO();
        List<Object[]> ls = dao.getHoaDon();
        for (Object[] l : ls) {
            System.out.println(l[0] + " " + " " + l[1] + " " + l[2] + " " + " " + l[3] + " " + " " + l[4]);
        }
        
//        String tenSP = "Iphone X";
//        List<Object[]> ls1 = dao.getGiaGiam(tenSP);
//        for (Object[] o : ls1) {
//            System.out.println(o[0]);
//        }
    }
}
