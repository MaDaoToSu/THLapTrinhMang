/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package TCPServer2;

import java.net.*;

/**
 *
 * @author Admin
 */
public class TCPServer {
    static final int PORT = 1234;
    private ServerSocket server = null;

    public TCPServer() {
        try {
            server = new ServerSocket(PORT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void action() {
        Socket socket = null;
        int i = 0;
        System.out.println("Server listening...!");
        try {
            while ((socket = server.accept()) != null) {
                new ServerThread(socket, "Client#" + i);
                System.out.printf("Thread for Client#%d gererating....%n", i++);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TCPServer().action();
    }
}
