/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Nhap_Hang_Model {
    private String manhaphang;
    private String manhacungcap;
    private String manhanvien;
    private String ngaynhaphang;
    private double tongtiennhaphang;

    public Nhap_Hang_Model(String manhaphang, String manhacungcap, String manhanvien, String ngaynhaphang, double tongtiennhaphang) {
        this.manhaphang = manhaphang;
        this.manhacungcap = manhacungcap;
        this.manhanvien = manhanvien;
        this.ngaynhaphang = ngaynhaphang;
        this.tongtiennhaphang = tongtiennhaphang;
    }

    public void setManhaphang(String manhaphang) {
        this.manhaphang = manhaphang;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public void setNgaynhaphang(String ngaynhaphang) {
        this.ngaynhaphang = ngaynhaphang;
    }

    public void setTongtiennhaphang(double tongtiennhaphang) {
        this.tongtiennhaphang = tongtiennhaphang;
    }

    public String getManhaphang() {
        return manhaphang;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public String getNgaynhaphang() {
        return ngaynhaphang;
    }

    public double getTongtiennhaphang() {
        return tongtiennhaphang;
    }
    
    
}
