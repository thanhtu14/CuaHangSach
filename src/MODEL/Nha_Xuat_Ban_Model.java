/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Nha_Xuat_Ban_Model {
    private String manhaxuatban;
    private String tennhaxuatban;
    private String sdtnhaxuatban;
    private String diachinhaxuatban;
    private String quocgianhaxuatban;

    public Nha_Xuat_Ban_Model(String manhaxuatban, String tennhaxuatban, String sdt, String diachi, String quocgia) {
        this.manhaxuatban = manhaxuatban;
        this.tennhaxuatban = tennhaxuatban;
        this.sdtnhaxuatban = sdt;
        this.diachinhaxuatban = diachi;
        this.quocgianhaxuatban = quocgia;
    }

    public void setManhaxuatban(String manhaxuatban) {
        this.manhaxuatban = manhaxuatban;
    }

    public void setTennhaxuatban(String tennhaxuatban) {
        this.tennhaxuatban = tennhaxuatban;
    }

    public void setSdt(String sdt) {
        this.sdtnhaxuatban = sdt;
    }

    public void setDiachi(String diachi) {
        this.diachinhaxuatban = diachi;
    }

    public void setQuocgia(String quocgia) {
        this.quocgianhaxuatban = quocgia;
    }

    public String getManhaxuatban() {
        return manhaxuatban;
    }

    public String getTennhaxuatban() {
        return tennhaxuatban;
    }

    public String getSdt() {
        return sdtnhaxuatban;
    }

    public String getDiachi() {
        return diachinhaxuatban;
    }

    public String getQuocgia() {
        return quocgianhaxuatban;
    }
    
}
