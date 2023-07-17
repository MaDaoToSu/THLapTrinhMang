/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTThem.btThem2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Thread2 extends Thread{
    ShareData shareData;
    
    public Thread2(ShareData shareData) {
        this.shareData = shareData;
    }
    
    @Override
    public void run() {
        for(int i = 0; i < shareData.addressList.length; i ++) {
            synchronized (shareData) {
                
                shareData.notifyAll();
                
                //Điều kiện dừng Thread 2
                try {
                    shareData.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("Address: " + shareData.addressList[i]);
            }
        }
    }
}
