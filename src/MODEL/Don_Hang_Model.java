/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Don_Hang_Model {
    private String madonhang;
    private String makhachhang;
    private String manhanvien;
    private String ngaymua;
    private double tongsotien;

    public Don_Hang_Model(String madonhang, String makhachhang, String manhanvien, String ngaymua, double tongsotien) {
        this.madonhang = madonhang;
        this.makhachhang = makhachhang;
        this.manhanvien = manhanvien;
        this.ngaymua = ngaymua;
        this.tongsotien = tongsotien;
    }

    public void setMadonhang(String madonhang) {
        this.madonhang = madonhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public void setTongsotien(double tongsotien) {
        this.tongsotien = tongsotien;
    }

    public String getMadonhang() {
        return madonhang;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public double getTongsotien() {
        return tongsotien;
    }
    
    
}
