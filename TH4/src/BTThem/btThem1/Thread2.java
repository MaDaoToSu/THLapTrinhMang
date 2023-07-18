/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTThem.btThem1;

/**
 *
 * @author huyho
 */
public class Thread2 extends Thread {
    private SharedData sharedData;
    
    public Thread2(SharedData sharedData) {
        this.sharedData = sharedData;
    }
    
    @Override
    public void run() {
        while (true) {
            synchronized (sharedData) {

                if (sharedData.isStopped())
                    break;

                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int randomNumber = sharedData.getRandomNumber();
                int square = randomNumber * randomNumber;
                System.out.println("Square of " + randomNumber + " is " + square);
             
                sharedData.notify();
            }
        }
    }
}