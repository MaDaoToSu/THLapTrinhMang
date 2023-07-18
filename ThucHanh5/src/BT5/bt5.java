/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT5;

/**
 *
 * @author huyho
 */

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class bt5 {
    public static void main(String[] args) {
        try {
            // Đọc thông tin Socket máy cục bộ
            InetAddress localHost = InetAddress.getLocalHost();
            int localPort = getLocalPort();

            System.out.println("Thông tin Socket máy cục bộ: ");
            System.out.println("IP: " + localHost.getHostAddress());
            System.out.println("Port: " + localPort);

            // Đọc thông tin Socket máy từ xa trên cổng 80
            InetAddress remoteHost = InetAddress.getByName("example.com");
            int remotePort = 80;

            System.out.println("Thông tin Socket máy từ xa trên cổng 80: ");
            System.out.println("IP: " + remoteHost.getHostAddress());
            System.out.println("Port: " + remotePort);
        } catch (UnknownHostException e) {
            System.out.println("Không thể xác định địa chỉ máy từ xa.");
        }
    }

    private static int getLocalPort() {
        try (Socket s = new Socket()) {
            // Tạo socket và kết nối tới localhost để lấy thông tin máy cục bộ
            s.bind(null);
            return s.getLocalPort();
        } catch (IOException e) {
            System.out.println("Không thể kết nối tới localhost.");
        }
        return -1;
    }
}
