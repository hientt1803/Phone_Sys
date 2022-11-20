package phoneSys.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.JdbcRowSet;
import phoneSys.edu.entity.KhachHang;
import phoneSys.edu.ultil.jdbcHelper;

/**
 *
 * @author LAPTOP LENOVO
 */
public class KhachHangDAO extends PhoneSysDAO<KhachHang, String> {

    private String INSERT_SQL = "INSERT INTO KHACHHANG VALUES(?,?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE KHACHHANG SET TENKHACHHANG = ?, GIOITINH = ?, SDT = ?,  TRANGTHAI = ?,GHICHU = ? WHERE MAKHACHHANG = ?";
    private String DELETE_SQL = "UPDATE KHACHHANG SET TENKHACHHANG = ?, GIOITINH = ?, SDT = ?,  TRANGTHAI = ?,GHICHU = ? WHERE MAKHACHHANG = ?";

    private String SELECT_ALL_SQL = "SELECT * FROM KHACHHANG";
    private String SELECT_BY_ID_SQL = "SELECT * FROM KHACHHANG WHERE MAKHACHHANG = ?";

    @Override
    public void insert(KhachHang entity) {
        try {
            jdbcHelper.update(INSERT_SQL, entity.getMaKhachHang(), entity.getTenKhachHang(), entity.isGioiTinh(), entity.getSDT(), entity.isTrangThai(), entity.getGhiChu());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(KhachHang entity) {
        try {
            jdbcHelper.update(UPDATE_SQL, entity.getTenKhachHang(), entity.isGioiTinh(), entity.getSDT(), entity.isTrangThai(), entity.getGhiChu(), entity.getMaKhachHang());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(String key) {
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    KhachHang selectByid(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KhachHang> selectBySql(String sql, Object... args) {
         List<KhachHang> list = new ArrayList<KhachHang>();

        try {
            ResultSet rs = jdbcHelper.query(sql, args);

            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("MaKhachHang"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setSDT(rs.getString("SDT"));
                kh.setTrangThai(rs.getBoolean("TrangThai"));
                kh.setGhiChu(rs.getString("GhiChu"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
