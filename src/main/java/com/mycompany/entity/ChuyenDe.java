/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entity;


public class ChuyenDe {
    private String maCD, tenCD, hinh, moTa;
    private double hocPhi;
    private int thoiLuong;

    public ChuyenDe() {
    }

    public ChuyenDe(String maCD, String tenCD, String hinh, String moTa, double hocPhi, int thoiLuong) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.hinh = hinh;
        this.moTa = moTa;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    @Override
    public String toString() {
        return tenCD;
    }
    
    
}
