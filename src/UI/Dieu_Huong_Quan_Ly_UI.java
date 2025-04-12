/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author tuntt
 */
public class Dieu_Huong_Quan_Ly_UI extends JPanel implements ActionListener, MouseListener {

    public static final int width = 250;
    public static final int height = 720;
    private JLabel labelAdmin;
    private Layout_UI layout;
    private Main_UI main;

    JButton buttonQLNV, buttonQLKH, buttonQLSP, buttonQLDH, buttonDoanhthu, buttonLuongNV, buttonTrangchu, buttonLogout, buttonSelected = null;

    private static final Color ColorButton = new Color(223, 228, 234);
    private static final Color ColorSelected = new Color(129, 236, 236);

    public Dieu_Huong_Quan_Ly_UI(Main_UI main, Layout_UI layout) {
        this.layout = layout;
        this.main = main;
        //this.layout = layout;

        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout());
        setBackground(new java.awt.Color(53, 59, 72));
        initDieu_Huong_Quan_Ly_UI();
    }

    public void initDieu_Huong_Quan_Ly_UI() {
        // logo admin
        JPanel panelAdmin = new JPanel();
        panelAdmin.setPreferredSize(new Dimension(width, 100));
        panelAdmin.setOpaque(false);// do dùng Flowlayout nên các thành phần có khoảng cách nhất định
        ImageIcon logoAdmin = new ImageIcon("D:\\Lap_Trinh_Java\\images\\admin.png");
        Image img = logoAdmin.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH); // Resize ảnh, width = 100px, height = 80px
        labelAdmin = new JLabel(new ImageIcon(img));
        panelAdmin.add(labelAdmin);
        this.add(panelAdmin);
        
        // khởi tạo icon
        
        ImageIcon iconTrangchu = new ImageIcon("D:\\Lap_Trinh_Java\\images\\home.png");
        Image imgTrangchu = iconTrangchu.getImage().getScaledInstance(50, 20, Image.SCALE_SMOOTH);
        
        ImageIcon iconQLNV = new ImageIcon("D:\\Lap_Trinh_Java\\images\\QLNV.png");
        Image imgQLNV = iconQLNV.getImage().getScaledInstance(50, 20, Image.SCALE_SMOOTH); // Resize ảnh, width = 50px, height = 20px

        ImageIcon iconQLKH = new ImageIcon("D:\\Lap_Trinh_Java\\images\\customer.png");
        Image imgQLKH = iconQLKH.getImage().getScaledInstance(50, 20, Image.SCALE_SMOOTH);

        ImageIcon iconQLSP = new ImageIcon("D:\\Lap_Trinh_Java\\images\\product.png");
        Image imgQLSP = iconQLSP.getImage().getScaledInstance(50, 20, Image.SCALE_SMOOTH);

        ImageIcon iconQLDH = new ImageIcon("D:\\Lap_Trinh_Java\\images\\order.png");
        Image imgQLDH = iconQLDH.getImage().getScaledInstance(50, 20, Image.SCALE_SMOOTH);

        ImageIcon iconLuongNV = new ImageIcon("D:\\Lap_Trinh_Java\\images\\salary.png");
        Image imgLuongNV = iconLuongNV.getImage().getScaledInstance(50, 20, Image.SCALE_SMOOTH);

        ImageIcon iconDoanhthu = new ImageIcon("D:\\Lap_Trinh_Java\\images\\revener.png");
        Image imgDoanhthu = iconDoanhthu.getImage().getScaledInstance(50, 20, Image.SCALE_SMOOTH);

        ImageIcon iconLogout = new ImageIcon("D:\\Lap_Trinh_Java\\images\\logout.png");
        Image imgLogout = iconLogout.getImage().getScaledInstance(50, 20, Image.SCALE_SMOOTH);

        buttonTrangchu = createButton("Trang Chủ",imgTrangchu);
        buttonQLNV = createButton("QL Nhân Viên",imgQLNV);
        buttonQLKH = createButton("QL Khách Hàng",imgQLKH);
        buttonQLSP = createButton("QL Sản Phẩm",imgQLSP);
        buttonQLDH = createButton("QL Đơn Hàng",imgQLDH);
        buttonLuongNV = createButton("Bảng Lương Nhân Viên", imgLuongNV);
        buttonDoanhthu = createButton("Thống Kê Doanh Thu",imgDoanhthu);
        buttonLogout = createButton("Đăng Xuất",imgLogout);

        this.add(buttonTrangchu);
        this.add(buttonQLNV);
        this.add(buttonQLKH);
        this.add(buttonQLSP);
        this.add(buttonQLDH);
        this.add(buttonLuongNV);
        this.add(buttonDoanhthu);
        this.add(buttonLogout);
    }

    private JButton createButton(String text, Image icon) {
        JButton button = new JButton(text, new ImageIcon(icon));
        button.setPreferredSize(new Dimension(width, 50));
        button.setForeground(Color.BLACK);
        button.setBackground(new java.awt.Color(223, 228, 234));
        button.setOpaque(true);
        button.setFocusPainted(false);
        button.addActionListener(this);
        button.addMouseListener(this);  // Thêm sự kiện chuột vào button
        return button;
    }
    
    private void ResetColor() {
        buttonTrangchu.setBackground(ColorButton);
        buttonQLNV.setBackground(ColorButton);
        buttonQLKH.setBackground(ColorButton);
        buttonQLSP.setBackground(ColorButton);
        buttonQLDH.setBackground(ColorButton);
        buttonLuongNV.setBackground(ColorButton);
        buttonDoanhthu.setBackground(ColorButton);
        buttonLogout.setBackground(ColorButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        ResetColor();
        button.setBackground(ColorSelected);
        buttonSelected = button;
        if (button == buttonTrangchu) {

        } else if (button == buttonQLNV) {
            System.out.println("giao diện nhan vien");
            //layout.setPanelCenter(new Nhan_Vien_UI());
        } else if (button == buttonQLKH) {
            System.out.println("giao dienj khach hang");
            layout.setPanelCenter(new Khach_Hang_UI());
        } else if (button == buttonQLSP) {
            System.out.println("giao dien san pham");
            //layout.setPanelCenter(new San_Pham_UI());
        } else if (button == buttonQLDH) {
            System.out.println("giao dien don hang");
            layout.setPanelCenter(new Don_Hang_UI());
        } else if (button == buttonLuongNV) {
            System.out.println("giao dien luong");

        } else if (button == buttonDoanhthu) {
            System.out.println("giao dien doanh thu");

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
        if (button != buttonSelected) {
            button.setBackground(ColorButton);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelected) {
            button.setBackground(ColorButton);
        } // Trở về màu cũ khi thả
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelected) {
            button.setBackground(Color.red);
        } // Đổi màu khi di chuột vào
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelected) {
            button.setBackground(ColorButton);
        }// Trở về màu cũ khi chuột rời đi
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {

    }
}
