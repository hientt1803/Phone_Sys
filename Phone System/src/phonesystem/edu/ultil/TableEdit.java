/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.ultil;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author HienTran
 */
public class TableEdit {

    public static void centerRendererTable(JTable tbl) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        int column = tbl.getColumnCount();
        for (int i = 0; i < column; i++) {
            tbl.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
}
}
