/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author tuntt
 */
public class Tai_Khoan_Model {
    private String madangnhap;
    private String tennhanvien;
    private String password;
    private String maquyen;
    private String tenquyen;
    private String machucnang;
    private String tenchucnang;
    private int xem;
    private int them;
    private int sua;
    private int xoa;
    private int tim;

    public Tai_Khoan_Model(String madangnhap, String tennhanvien, String password, String maquyen, String tenquyen, String machucnang, 
            String tenchucnang, int xem, int them, int sua, int xoa, int tim) {
        
        this.madangnhap = madangnhap;
        this.tennhanvien = tennhanvien;
        this.password = password;
        this.maquyen = maquyen;
        this.tenquyen = tenquyen;
        this.machucnang = machucnang;
        this.tenchucnang = tenchucnang;
        this.xem = xem;
        this.them = them;
        this.sua = sua;
        this.xoa = xoa;
        this.tim = tim;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public String getMadangnhap() {
        return madangnhap;
    }

    public String getPassword() {
        return password;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public String getTenquyen() {
        return tenquyen;
    }

    public String getMachucnang() {
        return machucnang;
    }

    public String getTenchucnang() {
        return tenchucnang;
    }

    public int getXem() {
        return xem;
    }

    public int getThem() {
        return them;
    }

    public int getSua() {
        return sua;
    }

    public int getXoa() {
        return xoa;
    }
    
    public int getTim() {
        return tim;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public void setMadangnhap(String madangnhap) {
        this.madangnhap = madangnhap;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }

    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }

    public void setMachucnang(String machucnang) {
        this.machucnang = machucnang;
    }

    public void setTenchucnang(String tenchucnang) {
        this.tenchucnang = tenchucnang;
    }

    public void setXem(int xem) {
        this.xem = xem;
    }

    public void setThem(int them) {
        this.them = them;
    }

    public void setSua(int sua) {
        this.sua = sua;
    }

    public void setXoa(int xoa) {
        this.xoa = xoa;
    }
    
    public void setTim(int tim) {
        this.tim = tim;
    }
    
    
    
}
