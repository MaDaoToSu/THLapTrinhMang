/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPServer2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ServerThread implements Runnable{
    private Socket socket;
    private String name;
    private PrintWriter out = null;  // viết hoặc đẩy đi
    private Scanner in = null;      // đọc hoặc nhận vào
    
    public ServerThread(Socket socket, String name) throws IOException{
        this.socket = socket;
        this.name = name;
        this.in = new Scanner(this.socket.getInputStream());
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        new Thread(this).start(); //thừa kết từ interface Runnable
    }
    
    public void run() {
        try {
            while (true) {                
                String chuoi = in.nextLine().trim();
                Scanner sc = new Scanner(chuoi);
                sc.useDelimiter("@");
                int so1 = sc.nextInt();
                String phepToan = sc.next();
                int so2 = sc.nextInt();
                if(phepToan.equals("+")) {
                    out.println(so1 + so2);
                } else if(phepToan.equals("-")) {
                    out.println(so1 - so2);
                } else if(phepToan.equals("*")) {
                    out.println(so1 * so2);
                } else if(phepToan.equals("/")) {
                    out.println((float)so1 / so2);
                }
            }
        } catch(Exception ex) {
            System.out.println("");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {}
        }
    }
}
