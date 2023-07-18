/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTThem.btThem1.Server;

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
    public  void giaiPTBac2(float a, float b, float c) {
        // kiểm tra các hệ số
        String chuoi = null;
        if (a == 0) {
            if (b == 0) {
                chuoi = "Phương trình vô nghiệm!";
            } else {
               chuoi = ("Phương trình có một nghiệm: "
                        + "x = " + (-c / b));
            }
            return;
        }
        // tính delta
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            chuoi = ("Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
           chuoi = ("Phương trình có nghiệm kép: "
                    + "x1 = x2 = " + x1);
        } else {
            chuoi = ("Phương trình vô nghiệm!");
        }
        out.println(chuoi);
    }
    
    public void run(){
        try {
            while (true) {       
                // nhan chuoi tu client va xu ly cat chuoi
                String chuoi = in.nextLine().trim();
                System.out.println("chuoi nhan duoc la : " + chuoi);
                String[] str = chuoi.split("/");
                System.out.println(str[0] +"-" +str[1]+ "-" +str[2]);
                // bat dau xu ly 
                float a = Float.parseFloat(str[0]);
                float b = Float.parseFloat(str[1]);
                float c = Float.parseFloat(str[2]);
                giaiPTBac2(a,b,c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
