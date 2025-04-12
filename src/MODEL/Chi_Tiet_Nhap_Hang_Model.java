/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Chi_Tiet_Nhap_Hang_Model {
    private String manhaphang;
    private String masach;
    private int soluongnhap;
    private double gianhap;

    public Chi_Tiet_Nhap_Hang_Model(String manhaphang, String masach, int soluongnhap, double gianhap) {
        this.manhaphang = manhaphang;
        this.masach = masach;
        this.soluongnhap = soluongnhap;
        this.gianhap = gianhap;
    }

    public void setManhaphang(String manhaphang) {
        this.manhaphang = manhaphang;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    public String getManhaphang() {
        return manhaphang;
    }

    public String getMasach() {
        return masach;
    }

    public int getSoluongnhap() {
        return soluongnhap;
    }

    public double getGianhap() {
        return gianhap;
    }
    
    
}
