/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package remoteapp;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Admin
 */
public interface InterfaceCalc extends Remote {
    public int sum(int a, int b) throws RemoteException;
    public PhanSo sum(PhanSo a, PhanSo b) throws RemoteException;
}
