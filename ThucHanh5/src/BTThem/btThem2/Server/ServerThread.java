/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTThem.btThem2.Server;

import BTThem.btThem1.Server.*;
import TCPServer1.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huyho
 */
public class ServerThread implements Runnable{

    
    private Scanner in = null;
    private PrintWriter out = null;
    private Socket socket;
    private String name;
    
    public ServerThread(Socket socket, String name) {
        try {
            this.socket = socket;
            this.name = name;
            this.in = new Scanner(this.socket.getInputStream());
            this.out = new PrintWriter(this.socket.getOutputStream(),true);
            new Thread(this).start();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private boolean isStringInteger(String str) {
        // Kiểm tra xem chuỗi có chứa ký tự không phải là số hay không
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    

   
    public void run(){
        try {
            while (true) {       
                // nhan chuoi tu client va xu ly cat chuoi
                String chuoi = in.nextLine().trim();
                System.out.println("chuoi nhan duoc la : " + chuoi);
                if( isStringInteger(chuoi) == true){
                    int soNhanduoc = Integer.parseInt(chuoi);
                    String binaryString = Integer.toBinaryString(soNhanduoc);
                    out.println(binaryString);
                }else{
                    out.println("Không phải là số nguyên");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
