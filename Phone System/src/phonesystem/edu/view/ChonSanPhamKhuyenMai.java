/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import phonesystem.edu.dao.KhuyenMaiDAO;
import phonesystem.edu.dao.SanPhamDAO;
import phonesystem.edu.entity.KhuyenMai;
import phonesystem.edu.entity.SanPham;
import phonesystem.edu.ultil.MsgBox;
import phonesystem.edu.ultil.XDate;

/**
 *
 * @author NP
 */
// hhhhh
public class ChonSanPhamKhuyenMai extends javax.swing.JDialog {

    public static String maSanPham = "";
    SanPhamDAO spDAO = new SanPhamDAO();
    DefaultTableModel tableModelSanPham_KhuyenMai;

    /**
     * Creates new form ChonKhuyenMai
     */
    public ChonSanPhamKhuyenMai(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void fillTable_SanPham_KhuyenMai() {
        tableModelSanPham_KhuyenMai = (DefaultTableModel) tbl_DanhSachSanPham_KhuyenMai.getModel();
        tableModelSanPham_KhuyenMai.setRowCount(0);
        try {
            List<SanPham> list = spDAO.selectSanPhamChuaCoKhuyenMai(Main_Frame.km.getTenKhuyenMai());
            for (SanPham sp : list) {
                Object[] row = {sp.getMaSanPham(), sp.getTenSanPham(), sp.getDonGia(), sp.getSoLuong(), sp.getHangSanXuat()};
                if (sp.isTrangThai() == true) {
                    tableModelSanPham_KhuyenMai.addRow(row);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_DanhSachSanPham_KhuyenMai = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tbl_DanhSachSanPham_KhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, "", null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Đơn Giá", "Số Lượng", "Hãng Sản xuất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_DanhSachSanPham_KhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DanhSachSanPham_KhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_DanhSachSanPham_KhuyenMai);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.fillTable_SanPham_KhuyenMai();
    }//GEN-LAST:event_formWindowOpened

    private void tbl_DanhSachSanPham_KhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DanhSachSanPham_KhuyenMaiMouseClicked
        int i = tbl_DanhSachSanPham_KhuyenMai.getSelectedRow();
        String maSP = "";
        if (evt.getClickCount() == 2) {
            maSP = tbl_DanhSachSanPham_KhuyenMai.getValueAt(i, 0).toString();
            Main_Frame.km.setMaSanPham(maSP);
            this.dispose();
        }

    }//GEN-LAST:event_tbl_DanhSachSanPham_KhuyenMaiMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChonSanPhamKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChonSanPhamKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChonSanPhamKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChonSanPhamKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChonSanPhamKhuyenMai dialog = new ChonSanPhamKhuyenMai(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_DanhSachSanPham_KhuyenMai;
    // End of variables declaration//GEN-END:variables
}
