/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package th6.BT4.udpclient;

import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 *
 * @author huyho
 */
public class frmChat extends javax.swing.JFrame implements Runnable {

    private InetAddress group;
    private int port;
    private String nick;

    private Thread mythread;
    private MulticastSocket socket;
    private DatagramPacket truyen, nhan;

    /**
     * Creates new form frmChat
     */
    public frmChat() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtgroup = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtport = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnick = new javax.swing.JTextField();
        btnketnoi = new javax.swing.JButton();
        btndong = new javax.swing.JButton();
        txtnoidung = new javax.swing.JTextField();
        btnsend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtchat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhập địa chỉ multicast");

        txtgroup.setText("239.0.0.36");

        jLabel2.setText("Port");

        txtport.setText("1234");

        jLabel3.setText("Nick");

        txtnick.setText("Ma Đạo Tổ Sư");

        btnketnoi.setText("Kết nối");
        btnketnoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnketnoiActionPerformed(evt);
            }
        });

        btndong.setText("Đóng");
        btndong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndongActionPerformed(evt);
            }
        });

        btnsend.setText("SEND");
        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });

        txtchat.setColumns(20);
        txtchat.setRows(5);
        jScrollPane1.setViewportView(txtchat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtnick, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnketnoi)
                    .addComponent(btndong))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtnoidung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsend))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsend, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtgroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)
                        .addComponent(btnketnoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndong)
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnketnoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnketnoiActionPerformed
        // TODO add your handling code here:

        if (btnketnoi.getText().equals("Kết nối")) {
            //Khi nhấn nút kết nối
            btnketnoi.setText("Ngắt kết nối");
            //chuyển nút kết nối thành nút ngắt kết nối
            txtchat.setEnabled(true);
            txtnoidung.setEnabled(true);
            btnsend.setEnabled(true);
            txtgroup.setEnabled(false);
            txtport.setEnabled(false);
            txtnick.setEnabled(false);
            try {
                group = InetAddress.getByName(txtgroup.getText());
                if (group.isMulticastAddress()) {
                    //Kiểm tra xem địa chỉ nhóm có phải địa chỉ multicast hay không
                    nick = txtnick.getText();
                    port = Integer.parseInt(txtport.getText());
                    if (mythread == null) {
                        //Tạo ra và thiết lập ban đầu cho các đối tượng mạng
                        socket = new MulticastSocket(port);
                        socket.setTimeToLive(1);
                        //Thiết lập đường đi cho gói tin
                        socket.joinGroup(group);
                        //Đăng ký với router là chương trình máy mình đăng ký vào nhóm group
                        truyen = new DatagramPacket(new byte[1], 1, group, port);
                        nhan = new DatagramPacket(new byte[65507], 65507);
                        //Tạo ra thread xử lý dữ liệu truyền đến
                        mythread = new Thread(this);
                        mythread.start();
                        //Bắt đầu nhận dữ liệu - Lúc này hàm run sẽ dược gọi để thực thi
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Địa chỉ nhập sai rồi!!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            //Sự kiện nhấn nút ngắt kết nối
            txtchat.setEnabled(false);
            txtnoidung.setEnabled(false);
            btnsend.setEnabled(false);
            txtgroup.setEnabled(true);
            txtport.setEnabled(true);
            txtnick.setEnabled(true);
            btnketnoi.setText("Kết nối");
            //chuyển nút ngắt kết nối thành nút kết nối
            if (mythread != null) {
                mythread.interrupt();
                //dừng việc nhận dữ liệu
                mythread = null;
                try {
                    socket.leaveGroup(group);//Ra khỏi group
                } catch (IOException e) {
                }
                socket.close();
            }
        }
    }//GEN-LAST:event_btnketnoiActionPerformed
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {//Kiểm tra xem thread có bị ngắt chưa
                nhan.setLength(nhan.getData().length);//thiết lập số byte của buffer
                socket.receive(nhan);//nhận dữ liệu
                String message = new String(nhan.getData(), 0, nhan.getLength(), "UTF8");
                txtchat.append(message + "\n");//hiển thì dữ liệu nhận được lên màn hình
            }
        } catch (IOException e) {//Các thao tác thu dọn bộ nhớ khi có lỗi xảy ra
            if (mythread != null) {
                txtchat.append(e + "\n");
                txtnoidung.setVisible(false);
                this.validate();
                if (mythread != Thread.currentThread()) {
                    mythread.interrupt();
                }
                mythread = null;
                try {
                    socket.leaveGroup(group);
                } catch (IOException ignored) {
                       socket.close();
                }
             
            }
        }
    }
    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed
        // TODO add your handling code here:
        try {
            byte[] utf = (nick + ": " + txtnoidung.getText()).getBytes("UTF8");//Chuyển dữ liệu thành chuỗi byte
            truyen.setData(utf);// gán dữ liệu cho datagrampackage
            truyen.setLength(utf.length);//thiết lập số lượng byte cho buffer
            socket.send(truyen);//bắt đầu truyền dữ liệu đi
            txtnoidung.setText("");//cho nội dung của txtnoidung là rỗng
        } catch (IOException e) {//Các xử lý dọn dẹp bộ nhớ khi có lỗi
            if (mythread != null) {
                txtchat.append(e + "\n");
                txtnoidung.setVisible(false);
                this.validate();
                if (mythread != Thread.currentThread()) {
                    mythread.interrupt();
                }
                mythread = null;
                try {
                    socket.leaveGroup(group);
                } catch (IOException ignored) {
                     socket.close();
                }
            }
        }
             
               
    }//GEN-LAST:event_btnsendActionPerformed

    private void btndongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndongActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btndongActionPerformed

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
            java.util.logging.Logger.getLogger(frmChat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmChat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmChat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmChat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndong;
    private javax.swing.JButton btnketnoi;
    private javax.swing.JButton btnsend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtchat;
    private javax.swing.JTextField txtgroup;
    private javax.swing.JTextField txtnick;
    private javax.swing.JTextField txtnoidung;
    private javax.swing.JTextField txtport;
    // End of variables declaration//GEN-END:variables

}
