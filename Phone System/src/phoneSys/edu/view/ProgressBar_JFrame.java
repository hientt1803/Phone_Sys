/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSys.edu.view;

import AppPackage.AnimationClass;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author HienTran
 */
public class ProgressBar_JFrame extends javax.swing.JFrame {

    AnimationClass ac = new AnimationClass();

    /**
     * Creates new form ProgressBar_JFrame
     */
    public ProgressBar_JFrame() {
        initComponents();
//        this.slideShow();
        this.init();
    }

    private synchronized void slideShow() {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int nb = 0;
                try {
                    while (true) {
                        switch (nb) {
                            case 0:
                                Thread.sleep(2000);
                                ac.jLabelXLeft(0, -700, 12, 10, img1);
                                ac.jLabelXLeft(700, 0, 12, 10, img2);
                                ac.jLabelXLeft(1000, 700, 12, 10, img3);
                                nb++;
                            case 1:
                                Thread.sleep(2000);
                                ac.jLabelXLeft(-700, -1000, 12, 10, img1);
                                ac.jLabelXLeft(0, -700, 12, 10, img2);
                                ac.jLabelXLeft(700, 0, 12, 10, img3);
                                nb++;
                            case 2:
                                Thread.sleep(2000);
                                ac.jLabelXRight(-1000, -700, 12, 10, img1);
                                ac.jLabelXRight(-700, 0, 12, 10, img2);
                                ac.jLabelXRight(0, 700, 12, 10, img3);
                                nb++;
                            case 3:
                                Thread.sleep(2000);
                                ac.jLabelXRight(-700, 0, 12, 10, img1);
                                ac.jLabelXRight(0, 700, 12, 10, img2);
                                ac.jLabelXRight(700, 1000, 12, 10, img3);
                                nb = 0;
                        }
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }) {

        };
        th1.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int nb = 0;
//                try {
//                    while (true) {
//                        switch (nb) {
//                            case 0:
//                                Thread.sleep(4000);
//                                ac.jLabelXLeft(0, -700, 12, 10, img1);
//                                ac.jLabelXLeft(700, 0, 12, 10, img2);
//                                ac.jLabelXLeft(1000, 700, 12, 10, img3);
//                                nb++;
//                            case 1:
//                                Thread.sleep(4000);
//                                ac.jLabelXLeft(-700, -1000, 12, 10, img1);
//                                ac.jLabelXLeft(0, -700, 12, 10, img2);
//                                ac.jLabelXLeft(700, 0, 12, 10, img3);
//                                nb++;
//                            case 2:
//                                Thread.sleep(4000);
//                                ac.jLabelXRight(-1000, -700, 12, 10, img1);
//                                ac.jLabelXRight(-700, 0, 12, 10, img2);
//                                ac.jLabelXRight(0, 700, 12, 10, img3);
//                                nb++;
//                            case 3:
//                                Thread.sleep(4000);
//                                ac.jLabelXRight(-700, 0, 12, 10, img1);
//                                ac.jLabelXRight(0, 700, 12, 10, img2);
//                                ac.jLabelXRight(700, 1000, 12, 10, img3);
//                                nb = 0;
//                        }
//                    }
//                } catch (InterruptedException ex) {
//                    JOptionPane.showMessageDialog(null, ex.getMessage());
//                }
//            }
//        }).start();
    }

    String check = "";

    private void init() {
        new Timer(50, (ActionEvent e) -> {
            setLocationRelativeTo(null);
            int value = jProgressBar1.getValue();
            int a = 0;

            if (value < 100) {
                jProgressBar1.setValue(value + 1);
                a = value + 1;
                lblPercent.setText(a + "%");

                if (value < 30) {
                    lblDetail.setText("Đang tải cơ sở dử liệu");
                }

                if (value > 70) {
                    lblDetail.setText("Chương trình đã sẵn sàng!");
                }

            } else {
                check += "Stop";
                check();
                ProgressBar_JFrame.this.dispose();
            }
        }).start();
        check();
    }

    void check() {
        if (check.equals("Stop")) {
            openWelcome();
        }
    }

    void openWelcome() {
        new Login_Frame().setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblPercent = new javax.swing.JLabel();
        lblDetail = new javax.swing.JLabel();
        lblLoading = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phoneSys/edu/view/img/logo_fpt_mini-size.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 60));
        jPanel2.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 620, -1));

        lblPercent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPercent.setForeground(new java.awt.Color(0, 51, 204));
        jPanel2.add(lblPercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 400, 50, 20));

        lblDetail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDetail.setForeground(new java.awt.Color(0, 51, 204));
        jPanel2.add(lblDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 180, 20));

        lblLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phoneSys/edu/view/img/Spinner-1s-44px.gif"))); // NOI18N
        jPanel2.add(lblLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phoneSys/edu/view/img/img1.jpg"))); // NOI18N
        jPanel2.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phoneSys/edu/view/img/img1.jpg"))); // NOI18N
        jPanel2.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 700, 450));

        img3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phoneSys/edu/view/img/img1.jpg"))); // NOI18N
        jPanel2.add(img3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 700, 450));

        container.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        getContentPane().add(container, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgressBar_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblPercent;
    // End of variables declaration//GEN-END:variables
}
