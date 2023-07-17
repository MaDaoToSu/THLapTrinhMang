/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTThem.btThem1;


/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        
        Thread1 t1 = new Thread1(sharedData);
        Thread2 t2 = new Thread2(sharedData);
        
        t1.start();
        t2.start();
    }
}
