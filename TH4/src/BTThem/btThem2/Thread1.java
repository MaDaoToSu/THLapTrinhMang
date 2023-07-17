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
public class Thread1 extends Thread{
    ShareData shareData;
    
    public Thread1(ShareData shareData) {
        this.shareData = shareData;
    }
    
    @Override
    public void run() {
        for(int i = 0; i < shareData.nameList.length; i ++) {
            synchronized (shareData) {
                System.out.println("Full name:" + shareData.nameList[i]);
                
                shareData.notifyAll();
                
                //Điều kiện dừng Thread 1
                if(i < shareData.nameList.length - 1) {
                    try {
                        shareData.wait();
                    } catch(InterruptedException ex) {
                        Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
