/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSys.edu.ultil;

import java.text.SimpleDateFormat;

/**
 *
 * @author HienTran
 */
public class getCaLam {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
        String dateFormat = format.format(XDate.now());
        System.out.println(dateFormat);

        String gio = dateFormat.substring(0, 2);
        String phut = dateFormat.substring(3, 5);
        boolean isAM = dateFormat.endsWith("AM");

        int intGio = Integer.parseInt(gio);
        int intPhut = Integer.parseInt(phut);

        if (isAM) {
            intGio = 7;
            intPhut = 30;
        }

        System.out.println(isAM);
        System.out.println(gio);
        System.out.println(phut);

        if ((Integer.parseInt(gio) <= 11 && Integer.parseInt(phut) <= 00)) {
            System.out.println("Ca sáng");
        } else {
            System.out.println("Ca tối");
        }
    }
}
