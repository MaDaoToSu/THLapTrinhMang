/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpchat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class ThreadChat implements Runnable{
    private Scanner in = null;      // đọc hoặc nhận vào
    private Socket socket;
    public frmClient chat = null;
    ServerSocket server = null;
    
    public ThreadChat(){
        try {
            //Tạo ra SERVER SOCKET mới nhận PORT 1234 là tham số
            server = new ServerSocket(1234);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        new Thread(this).start(); //thừa kết từ interface Runnable
    }
    
    public void run() {
        try {
            while (true) {                
                while ((socket = server.accept()) != null) { //Chấp nhận kết nối từ máy khác đến                    
                    this.in = new Scanner(this.socket.getInputStream());
                    String chuoi = in.nextLine().trim(); //nhận chuỗi
                    chat.hienThi(chuoi + "\n"); //Hiển thị chuỗi ra màn hình
                }
            }
        } catch(Exception ex) {
            
        } finally {
            try {
                socket.close();
            } catch (IOException e) {}
        }
    }
}
