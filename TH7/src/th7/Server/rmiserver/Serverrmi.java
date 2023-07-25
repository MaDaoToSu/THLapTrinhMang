/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmiserver;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Admin
 */
public class Serverrmi {
    public static void main(String[] args) {
        try {
            Calc c = new Calc();
            Registry r = LocateRegistry.createRegistry(3456);
            r.bind("rmiCalc", c);
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
}
