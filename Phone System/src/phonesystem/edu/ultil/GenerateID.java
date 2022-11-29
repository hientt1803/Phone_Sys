package phonesystem.edu.ultil;

/**
 *
 * @author LAPTOP LENOVO
 */
public class GenerateID {

    public static String genareteID(String id) {
        String maCu = id;
        String maMoi_insert = "";
        String type = id.substring(0, 2);

        if (maCu.equals("")) {
            maCu = type + "01";
        }
        String maMoi_St = maCu.substring(2, maCu.length());

        int maMoi_int = Integer.parseInt(maMoi_St);
        maMoi_int++;

        if (maMoi_int < 10) {
            maMoi_insert = type+"0" + String.valueOf(maMoi_int);
        } else {
            maMoi_insert = type + String.valueOf(maMoi_int);
        }

        return maMoi_insert;
    }

}
