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
    private String masach;
    private String tensach;
    private String maNXB;
    private int sotrang;
    private float giaban;
    private int soluong;
    
    public San_Pham_Model(){
        this.masach = "";
        this.tensach = "";
        this.maNXB = "";
        this.sotrang = 0;
        this.giaban = 0;
        this.soluong = 0;
    }
    public San_Pham_Model( String ma, String ten, String maNXB, int sotrang, float gia, int soluong){
        this.masach = ma;
        this.tensach = ten;
        this.maNXB = maNXB;
        this.sotrang = sotrang;
        this.giaban = gia;
        this.soluong = soluong;
    }

    public String getMasach() {
        return masach;
    }

    public String getTensach() {
        return tensach;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public int getSotrang() {
        return sotrang;
    }

    public float getGiaban() {
        return giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public void setSotrang(int sotrang) {
        this.sotrang = sotrang;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
