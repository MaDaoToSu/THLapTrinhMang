/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th6.BT3.udpserver;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import th6.BT3.udpclient.frmClient;

/**
 *
 * @author huyho
 */
public class UdpServer {
    
    public static void main(String[] args) {
        frmClient app = new frmClient();
        app.setVisible(true);
        //doan nhan du lieu
        DatagramSocket socket;
        String strContent="";
        int PORT = 1234;
            try {
                byte[] buffer = new byte[1024];
                socket = new DatagramSocket (PORT);  
                boolean ktFinish=false;
                DatagramPacket receivePacket;
                String stReceive;
                while (ktFinish!=true) {
                    receivePacket = new DatagramPacket (buffer, buffer.length);
                    socket.receive(receivePacket);
                    stReceive = new String(receivePacket.getData(),0,receivePacket.getLength());
                    strContent = app.getContentChat();
                    strContent +="Nhan : " + stReceive;
                    app.setContentChat(strContent);
                    if (stReceive.equals("end.") || stReceive.equals("end.")) {
                        ktFinish = true; }
                }
            } catch (Exception ex) {
                Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
   
    } 

