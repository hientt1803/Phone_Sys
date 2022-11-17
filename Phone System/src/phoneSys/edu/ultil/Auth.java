/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSys.edu.ultil;

import phoneSys.edu.entity.NhanVien;
import phoneSys.edu.entity.TaiKhoan;

/**
 *
 * @author HienTran
 */
public class Auth {

    public static TaiKhoan user = null;
    public static NhanVien nv = new NhanVien();
    
    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static boolean isManager() {
        return Auth.isLogin() && user.getQuyen();
    }

    public static String getNameNhanVien(){
        return nv.getTenNhanVien();
    }
}
