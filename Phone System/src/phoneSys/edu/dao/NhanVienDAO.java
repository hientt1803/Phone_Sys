package phoneSys.edu.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phoneSys.edu.entity.NhanVien;
import phoneSys.edu.ultil.jdbcHelper;

/**
 *
 * @author LAPTOP LENOVO
 */
public class NhanVienDAO extends PhoneSysDAO<NhanVien, String> {

    private String INSERT_SQL = "INSERT INTO NHANVIEN VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
    private String UPDATE_SQL = "";
    private String DELETE_SQL = "";
    private String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    private String SELECT_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MANHANVIEN = ?";

    @Override
    public void insert(NhanVien entity) {

        try {
            jdbcHelper.update(INSERT_SQL, entity.getTenNhanVien(), entity.getNgaySinh(), entity.getGioiTinh(), entity.getCCCD(),
                                          entity.getSDT(), entity.getDiaChi(), entity.getEmail(), entity.getTrangThai(), entity.getHinhAnh(), entity.getGhiChu());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhanVien> selectAll() {

        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectByid(String id) {

        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {

        List<NhanVien> list = new ArrayList<NhanVien>();

        try {
            ResultSet rs = jdbcHelper.query(sql, args);

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString("MaNhanVien"));
                nv.setTenNhanVien(rs.getString("TenNhanVien"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setCCCD(rs.getString("cccd"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSDT(rs.getString("SDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setTrangThai(rs.getBoolean("TrangThai"));
                nv.setHinhAnh(rs.getString("HinhAnh"));
                nv.setGhiChu(rs.getString("GhiChu"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        NhanVienDAO dao = new NhanVienDAO();

//        dao.insert(new NhanVien("NV04", "Nguyen Van Teo", "2000-10-12", Boolean.TRUE, CCCD, DiaChi, SDT, Email, Boolean.TRUE, HinhAnh, GhiChu));
        
       
    }
}
