/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package remoteapp;

import java.io.Serializable;
/**
 *
 * @author Admin
 */
public class PhanSo implements Serializable{
    int tu;
    int mau;
    
    public PhanSo() {
        tu = 0;
        mau = 1;
    }
    
    public PhanSo(int tu, int mau) {
        this.tu = tu;
        this.mau = mau;
    }
    
    public PhanSo sum(PhanSo b) {
        PhanSo c = new PhanSo();
        c.setTu(tu*b.getMau() + b.getTu()*mau);
        c.setMau(mau*b.getMau());
        return c;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }

    public void setMau(int mau) {
        this.mau = mau;
    }

    public int getTu() {
        return tu;
    }

    public int getMau() {
        return mau;
    }
    
}
