/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udpserver;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author Admin
 */
public class UDPServer {
    static final int PORT = 1234; // khai báo PORT sử dụng
    private DatagramSocket socket = null; // khai báo DatagramSocket để lưu kết nối
    public UDPServer() {
        try {
            socket = new DatagramSocket(PORT);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public void action() {
        InetAddress host = null;
        int port;
        String chuoi = ""; // khai báo biến để lưu chuỗi dữ liệu
        try {
            System.out.println("Server đang lắng nghe...");
            while(true) { // vòng lặp chờ
                DatagramPacket packet = receive(); // nhận dữ liệu từ Client truyền qua
                host = packet.getAddress(); // lấy thông tin địa chỉ của máy Client
                port = packet.getPort(); // lấy thông tin PORT của máy Client
                chuoi = new String(packet.getData()).trim(); // lấy dữ liệu của máy Client
                chuoi = chuoi.toUpperCase();
                if(!chuoi.equals(""))
                    send(chuoi, host, port);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            socket.close();
        }
                
    }

    private DatagramPacket receive() throws IOException {
        byte buffer[] = new byte[65507]; // khai báo mảng byte nhận
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet); //nhận dữ liệu
        return packet;
    }

    private void send(String chuoi, InetAddress host, int port) throws IOException {
        byte buffer[] = chuoi.getBytes(); // chuyển chuỗi thành dữ liệu byte
        // Sau đó đưa chuỗi truyền vào gói tin gửi đi
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, host, port);
        socket.send(packet);
    }
    
    public static void main(String[] args) {
        new UDPServer().action();
    }
}
