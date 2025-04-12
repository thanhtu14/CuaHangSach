/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Khach_Hang_Model {
    private String makhachhang;
    private String tenkhachhang;
    private String gioitinhkhachhang;
    private String sdtkhachhang;
    private String diachikhachhang;
    private String emailkhachhang;

    public Khach_Hang_Model(String makhachhang, String tenkhachhang, String gioitinhkhachhang, String sdtkhachhang, String diachikhachhang, String emailkhachhang) {
        this.makhachhang = makhachhang;
        this.tenkhachhang = tenkhachhang;
        this.gioitinhkhachhang = gioitinhkhachhang;
        this.sdtkhachhang = sdtkhachhang;
        this.diachikhachhang = diachikhachhang;
        this.emailkhachhang = emailkhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public void setGioitinhkhachhang(String gioitinhkhachhang) {
        this.gioitinhkhachhang = gioitinhkhachhang;
    }

    public void setSdtkhachhang(String sdtkhachhang) {
        this.sdtkhachhang = sdtkhachhang;
    }

    public void setDiachikhachhang(String diachikhachhang) {
        this.diachikhachhang = diachikhachhang;
    }

    public void setEmailkhachhang(String emailkhachhang) {
        this.emailkhachhang = emailkhachhang;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public String getGioitinhkhachhang() {
        return gioitinhkhachhang;
    }

    public String getSdtkhachhang() {
        return sdtkhachhang;
    }

    public String getDiachikhachhang() {
        return diachikhachhang;
    }

    public String getEmailkhachhang() {
        return emailkhachhang;
    }
    
}
