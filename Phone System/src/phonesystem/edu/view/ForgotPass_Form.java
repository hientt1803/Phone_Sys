/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import phonesystem.edu.dao.NhanVienDAO;
import phonesystem.edu.ultil.Email;
import phonesystem.edu.ultil.MsgBox;

/**
 *
 * @author HienTran
 */
public class ForgotPass_Form extends javax.swing.JFrame {

    public static String email = "";

    /**
     * Creates new form Register_Form
     */
    public ForgotPass_Form() {
        initComponents();
        this.init();
    }

    private void init() {
        txtEmail.setBackground(new Color(0, 0, 0, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbl_GuiMail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(308, 519));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 519));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 519));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phonesystem/edu/img/ForgotPassword.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(300, 519));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 519));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel2.setText("<html>Quên mật khẩu?</html>");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 11, 160, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("<html>Đừng lo!! nó xảy ra. Vui lòng nhập địa chỉ Email được liên kết với tài khoản của bạn.!!</html>");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phonesystem/edu/img/icons8_at_sign_18px.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 146, -1, 21));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(113, 113, 113));
        txtEmail.setText("Email ID");
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(113, 113, 113)));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel3.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 146, 239, -1));

        lbl_GuiMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phonesystem/edu/img/ForgotPassbutton.png"))); // NOI18N
        lbl_GuiMail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_GuiMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_GuiMailMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_GuiMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 33));

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 299, 518));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_GuiMailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_GuiMailMouseClicked
        NhanVienDAO nvDAO = new NhanVienDAO();
        email = txtEmail.getText();
        if (txtEmail.getText().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập Email!!!");
            return;
        }
        try {
            if (nvDAO.kiemTraTrungEmail(txtEmail.getText()) == true) {
                if (Email.sendEmail(txtEmail.getText()) == true) {
                    MsgBox.alert(this, "Gửi Mail thành công. Vui lòng kiểm tra Email của bạn!!!");
                    new Enter_OPT_Form().setVisible(true);
                    this.dispose();
                }
            } else {
                MsgBox.alert(this, "Email này không có trong danh sách. Vui lòng nhập Email khác!!!");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPass_Form.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_lbl_GuiMailMouseClicked

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().equals("Email ID")) {
            txtEmail.setText("");
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().length() == 0) {
            txtEmail.setText("Email ID");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ForgotPass_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ForgotPass_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ForgotPass_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ForgotPass_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPass_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_GuiMail;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}