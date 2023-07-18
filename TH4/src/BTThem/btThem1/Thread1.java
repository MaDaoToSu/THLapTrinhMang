/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTThem.btThem1;

import java.util.Random;

/**
 *
 * @author huyho
 */
public class Thread1 extends Thread {
    private SharedData sharedData;
    
    public Thread1(SharedData sharedData) {
        this.sharedData = sharedData;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        int count = 0;
        
        while (count < 10) {
            synchronized (sharedData) {

                int randomNumber = random.nextInt(100) + 1;
                
                sharedData.setRandomNumber(randomNumber);
                
                try {
                    sharedData.notify();
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            count++;
        }
        

        synchronized (sharedData) {
            sharedData.setStopped(true);
            sharedData.notify();
        }
    }
}
