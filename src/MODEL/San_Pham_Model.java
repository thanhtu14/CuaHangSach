/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class San_Pham_Model {
    private String anh;
    private String masach;
    private String tensach;
    private String tentacgia;
    private String theloai;
    private int sotrang;
    private double giaban;
    private int soluong;

    public San_Pham_Model(String anh, String masach, String tensach, String tentacgia, String theloai, int sotrang, double giaban, int soluong) {
        this.anh = anh;
        this.masach = masach;
        this.tensach = tensach;
        this.tentacgia = tentacgia;
        this.theloai = theloai;
        this.sotrang = sotrang;
        this.giaban = giaban;
        this.soluong = soluong;
    }
    public String getAnh(){
        return anh;
    }
    public String getMasach() {
        return masach;
    }

    public String getTensach() {
        return tensach;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public String getTheloai() {
        return theloai;
    }

    public int getSotrang() {
        return sotrang;
    }

    public double getGiaban() {
        return giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setAnh(String anh){
        this.anh = anh;
    }
    
    public void setMasach(String masach) {
        this.masach = masach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public void setSotrang(int sotrang) {
        this.sotrang = sotrang;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
   
}
