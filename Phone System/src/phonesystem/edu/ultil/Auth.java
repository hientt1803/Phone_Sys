/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.ultil;

import phonesystem.edu.entity.NhanVien;
import phonesystem.edu.entity.TaiKhoan;

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
    
    public static String getIDNhanVien(){
        return nv.getMaNhanVien();
    }
    
    public static String getMatKhau_TaiKhoan(){
        return user.getMatKhau();
    }

}
