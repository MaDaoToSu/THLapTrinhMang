/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmiserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import remoteapp.InterfaceCalc;
import remoteapp.PhanSo;
/**
 *
 * @author Admin
 */
public class Calc extends UnicastRemoteObject implements InterfaceCalc{
    
    public Calc() throws RemoteException {}
    
    public int sum(int a, int b) throws RemoteException {
        int t = a + b;
        return t;
    }
    
    public PhanSo sum(PhanSo a, PhanSo b) throws RemoteException {
        return a.sum(b);
    }
}
