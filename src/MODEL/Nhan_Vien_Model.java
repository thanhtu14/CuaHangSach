/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Nhan_Vien_Model {

    private String manhanvien;
    private String tennhanvien;
    private String gioitinhnhanvien;
    private String ngaysinhnhanvien;
    private String sdtnhanvien;
    private String diachinhanvien;
    private String emailnhanvien;
    private String ngayvaolamnhanvien;
    private float luongnhanvien;
    private String machucvunhanvien;

    public Nhan_Vien_Model() {
        this.manhanvien = "";
        this.tennhanvien = "";
        this.gioitinhnhanvien = "";
        this.ngaysinhnhanvien = "";
        this.sdtnhanvien = "";
        this.diachinhanvien = "";
        this.emailnhanvien = "";
        this.luongnhanvien = 0;
        this.machucvunhanvien = "";                
    }
  public Nhan_Vien_Model( String ma, String ten, String gioitinh, String ngaysinh, String sdt, String diachi, String email, float luong, String machucvu){
         this.manhanvien = ma;
        this.tennhanvien = ten;
        this.gioitinhnhanvien = gioitinh;
        this.ngaysinhnhanvien = ngaysinh;
        this.sdtnhanvien = sdt;
        this.diachinhanvien = diachi;
        this.emailnhanvien = email;
        this.luongnhanvien = luong;
        this.machucvunhanvien = machucvu;    
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public void setGioitinhnhanvien(String gioitinhnhanvien) {
        this.gioitinhnhanvien = gioitinhnhanvien;
    }

    public void setNgaysinhnhanvien(String ngaysinhnhanvien) {
        this.ngaysinhnhanvien = ngaysinhnhanvien;
    }

    public void setSdtnhanvien(String sdtnhanvien) {
        this.sdtnhanvien = sdtnhanvien;
    }

    public void setDiachinhanvien(String diachinhanvien) {
        this.diachinhanvien = diachinhanvien;
    }

    public void setEmailnhanvien(String emailnhanvien) {
        this.emailnhanvien = emailnhanvien;
    }

    public void setNgayvaolamnhanvien(String ngayvaolamnhanvien) {
        this.ngayvaolamnhanvien = ngayvaolamnhanvien;
    }

    public void setLuongnhanvien(float luongnhanvien) {
        this.luongnhanvien = luongnhanvien;
    }

    public void setMachucvunhanvien(String machucvunhanvien) {
        this.machucvunhanvien = machucvunhanvien;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public String getGioitinhnhanvien() {
        return gioitinhnhanvien;
    }

    public String getNgaysinhnhanvien() {
        return ngaysinhnhanvien;
    }

    public String getSdtnhanvien() {
        return sdtnhanvien;
    }

    public String getDiachinhanvien() {
        return diachinhanvien;
    }

    public String getEmailnhanvien() {
        return emailnhanvien;
    }

    public String getNgayvaolamnhanvien() {
        return ngayvaolamnhanvien;
    }

    public float getLuongnhanvien() {
        return luongnhanvien;
    }

    public String getMachucvunhanvien() {
        return machucvunhanvien;
    }

}
