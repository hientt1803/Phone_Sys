package phoneSys.edu.ultil;

/**
 *
 * @author LAPTOP LENOVO
 */
public class GenerateID {

    public String generate(String id) {
        String oldID = "";
        String oldIdSt = oldID.substring(2, oldID.length() - 1);

        String type = oldID.substring(0, 2);
        String insertID = "";
        int oldIDInt = Integer.parseInt(oldIdSt);
        if (oldID.equals("")) {
            oldID = type = "01";
        }
        int  newIDInt = oldIDInt + 1;

//        if (newIDInt<=) {
//
//        }

        return insertID;
    }

}
