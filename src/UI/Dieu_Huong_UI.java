/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import javax.swing.*;
import java.awt.*;
import SERVICE.Tai_Khoan_Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author tuntt
 */
public class Dieu_Huong_UI extends JPanel implements ActionListener, MouseListener {

    public static final int width = 250;
    public static final int height = 720;

    private static final Color ColorButton = new Color(223, 228, 234);
    private static final Color ColorSelected = new Color(129, 236, 236);

    private JButton buttonLogout, buttonSanpham, buttonNhanvien, buttonKhachhang, buttonDonhang, buttonNhacungcap, buttonNhaphang, buttonKhuyenmai,
            buttonQuyen, buttonChucnang, buttonselected = null;

   
    private JLabel labelAdmin;
    private Layout_UI layout;
    private Main_UI main;
    private Tai_Khoan_Service tai_Khoan_Service;
    private ArrayList<String> chuc_nang;

    private String maquyen;
    private ArrayList<String> ma_chuc_nang ;
        private ArrayList<String> ds_ma_chuc_nang ;


    public Dieu_Huong_UI(Main_UI main, Layout_UI layout, ArrayList<String> chuc_nang, ArrayList<String> ma_chuc_nang, String maquyen, ArrayList<String> ds_ma_chuc_nang) {
        this.main = main;
        this.layout = layout;
        this.chuc_nang = chuc_nang;
        this.ma_chuc_nang = ma_chuc_nang;
        this.maquyen = maquyen;
        this.ds_ma_chuc_nang = ds_ma_chuc_nang;
        //dsma_chuc_nang = tai_Khoan_Service.Ma_chuc_nang(this.maquyen);
        
        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout(1, 0, 5));
        setBackground(new java.awt.Color(53, 59, 72));
        initDieu_Huong();
    }

    public void initDieu_Huong() {
        for (int i = 0; i < ma_chuc_nang.size(); i++) {

            String ma = ma_chuc_nang.get(i);// dùng lấy các mã chức năng của người đăng nhập 
            String ten = chuc_nang.get(i);// lấy tên các chức năng để gán vào cho các button
            
            JButton btn = new JButton(ten);
            btn.setBackground(ColorButton);
            btn.setFocusPainted(false);
            btn.setOpaque(true);
            btn.setPreferredSize(new Dimension(width, 50));
            btn.addActionListener(this);
            btn.addMouseListener(this);  // Thêm sự kiện chuột vào button

            if( ma.trim().equals("0") ){
                buttonSanpham = btn;
                System.out.println("sản phẩm");
            }
            else if( ma.trim().equals("1")){
                buttonNhanvien = btn;
                System.out.println("nhân viên");
            }
            else if ( ma.trim().equals("2")){
                buttonKhachhang = btn;
            }
            else if( ma.trim().equals("3")){
                buttonDonhang = btn;
            }
            else if( ma.trim().equals("4")){
                buttonNhacungcap = btn;
            }
            else if( ma.trim().equals("5")){
                buttonNhaphang = btn;
            }
            else if( ma.trim().equals("6")){
                buttonKhuyenmai =btn;
            }
            else if( ma.trim().equals("7")){
                buttonQuyen = btn;
            }
            else {
                buttonChucnang = btn;
            }

            this.add(btn);
        }

        buttonLogout = new JButton("Log out");
        buttonLogout.setPreferredSize(new Dimension(width, 50));
        buttonLogout.setBackground(ColorButton);
        buttonLogout.setOpaque(true);
        buttonLogout.setFocusPainted(false);
        buttonLogout.addActionListener(this);
        buttonLogout.addMouseListener(this);

        this.add(buttonLogout);

    }

    private void Resetcolor() {
      // kiểm tra xem những button nào được tạo thì mới thực hiện thay đổi màu sau khi click chọn 
        if (buttonSanpham != null) {
            buttonSanpham.setBackground(ColorButton);
        }
        if (buttonNhanvien != null) {
            buttonNhanvien.setBackground(ColorButton);
        }
        if (buttonKhachhang != null) {
            buttonKhachhang.setBackground(ColorButton);
        }
        if (buttonDonhang != null) {
            buttonDonhang.setBackground(ColorButton);
        }
        if (buttonNhacungcap != null) {
            buttonNhacungcap.setBackground(ColorButton);
        }
        if (buttonNhaphang != null) {
            buttonNhaphang.setBackground(ColorButton);
        }
        if (buttonKhuyenmai != null) {
            buttonKhuyenmai.setBackground(ColorButton);
        }
        if (buttonQuyen != null) {
            buttonQuyen.setBackground(ColorButton);
        }
        if (buttonChucnang != null) {
            buttonChucnang.setBackground(ColorButton);
        }

        buttonLogout.setBackground(ColorButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        Resetcolor();
        button.setBackground(ColorSelected);
        buttonselected = button;
        if (button == buttonSanpham) {
            System.out.println("gia dien san pham");
            layout.setPanelCenter(new San_Pham_UI(maquyen,ds_ma_chuc_nang.get(0)));// lấy mã chức năng của  sản phẩm trong danh sách chức năng của hệ thống
        } else if (button == buttonNhanvien) {
            System.out.println("giao diện nhan vien");
            layout.setPanelCenter(new Nhan_Vien_UI(maquyen,ds_ma_chuc_nang.get(1)));//......
        } else if (button == buttonKhachhang) {
            System.out.println("giao dienj khach hang");
            layout.setPanelCenter(new Khach_Hang_UI(maquyen, ds_ma_chuc_nang.get(2)));//.......
        } else if (button == buttonDonhang) {
            System.out.println("giao dien don hang");
            layout.setPanelCenter(new Don_Hang_UI(maquyen, ds_ma_chuc_nang.get(3)));
        } else if (button == buttonNhacungcap) {
            System.out.println("giao dien nha cung cap");
            layout.setPanelCenter(new Nha_Cung_Cap_UI(maquyen, ds_ma_chuc_nang.get(4)));
        } else if (button == buttonNhaphang) {
            System.out.println("giao dien nhap hang");
            layout.setPanelCenter(new Nhap_Hang_UI(maquyen, ds_ma_chuc_nang.get(5)));
        } else if (button == buttonKhuyenmai) {
            System.out.println("giao dien khuyen mai");
            //layout.setPanelCenter(new Khuyen_Mai_UI());
        } else if (button == buttonQuyen) {
            System.out.println("giao dien quyen");
            //layout.setPanelCenter(new Quyen_UI());
        } else if (button == buttonChucnang) {
            System.out.println("giao dien chuc nang");
            //layout.setPanelCenter(new Chuc_Nang_UI());
        } else {

            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
            // this: thực hiện canh theo phần cha chứa nó,  null sẽ căng giữa màng h
            if (confirm == JOptionPane.YES_OPTION) {
                main.chuyen_layout_sign();
//                 layout.showLoginScreen();// Quay lại màn hình đăng nhập
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
        JButton button = (JButton) e.getSource();
        if (button != buttonselected) {
            button.setBackground(ColorButton);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
        JButton button = (JButton) e.getSource();
        if (button != buttonselected) {
            button.setBackground(ColorButton);
        } // Trở về màu cũ khi thả
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
        JButton button = (JButton) e.getSource();
        if (button != buttonselected) {
            button.setBackground(Color.red);
        } // Đổi màu khi di chuột vào
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
        JButton button = (JButton) e.getSource();
        if (button != buttonselected) {
            button.setBackground(ColorButton);
        }// Trở về màu cũ khi chuột rời đi
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {

    }

}
