package phoneSys.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.spec.PSource;
import phoneSys.edu.entity.HoaDon;
import phoneSys.edu.entity.Luong;
import phoneSys.edu.ultil.jdbcHelper;

/**
 *
 * @author LAPTOP LENOVO
 */
public class LuongDAO extends PhoneSysDAO<Luong, String> {

    String SELECT_ALL_SQL = "SELECT * FROM Luong";

    @Override
    public void insert(Luong entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Luong entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Luong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    Luong selectByid(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Luong> selectBySql(String sql, Object... args) {
        List<Luong> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Luong entity = new Luong();
                entity.setMaLuong(rs.getString("MaLuong"));
                entity.setMaNhanVien(rs.getString("MaNhanVien"));
                entity.setLuongTrenCa(rs.getInt("LuongTrenCa"));
                entity.setTongCaLam(rs.getInt("TongCaLam"));
                entity.setTienThuong(rs.getFloat("TienThuong"));
                entity.setNgayNhan(rs.getDate("NgayNhan"));
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

    public static void main(String[] args) {
        LuongDAO dao = new LuongDAO();
        List<Luong> ls = dao.selectAll();
        for (Luong l : ls) {
            System.out.println(l);
        }
    }

}
