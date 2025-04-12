/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Tac_Gia_Model {
    private String matacgia;
    private String tentacgia;
    private String gioitinh;
    private String ngaysinh;
    private String sdttacgia;
    private String email;

    public Tac_Gia_Model(String matacgia, String tentacgia, String gioitinh, String ngaysinh, String sdt, String email) {
        this.matacgia = matacgia;
        this.tentacgia = tentacgia;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdttacgia = sdt;
        this.email = email;
    }

    public void setMatacgia(String matacgia) {
        this.matacgia = matacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setSdt(String sdt) {
        this.sdttacgia = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getMatacgia() {
        return matacgia;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getSdt() {
        return sdttacgia;
    }

    public String getEmail() {
        return email;
    }

   
    
}
