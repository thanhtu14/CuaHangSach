/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an;

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
public class Dieu_Huong extends JPanel implements ActionListener, MouseListener {

    public static final int width = 250;
    public static final int height = 720;
    private JLabel labelAdmin;
    private Layout layout;
    JButton buttonQLNV, buttonQLKH, buttonQLSP, buttonQLDH, buttonDoanhthu, buttonLuongNV,buttonQLAdmin, buttonLogout, buttonSelected = null;
    
    private static final Color ColorButton = new Color(223, 228, 234);
    private static final Color ColorSelected = new Color(129, 236, 236);
    

    public Dieu_Huong(Layout layout) {
        this.layout = layout;
        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout());
        setBackground(new java.awt.Color(53, 59, 72));
        initDieu_Huong();
    }

    public void initDieu_Huong() {
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
        
        buttonQLAdmin = new JButton("QL Admin");
        buttonQLAdmin.setPreferredSize(new Dimension(width,50));
        buttonQLAdmin.setForeground(Color.black);
        buttonQLAdmin.setBackground(ColorButton);
        buttonQLAdmin.setOpaque(true);
        buttonQLAdmin.setFocusPainted(false);
        buttonQLAdmin.addActionListener(this);
        buttonQLAdmin.addMouseListener(this);
        
        this.add(buttonQLAdmin);
        
        // all button
        buttonQLNV = new JButton("QL Nhân Viên", new ImageIcon(imgQLNV));
        buttonQLNV.setPreferredSize(new Dimension(width, 50));
        //buttonQLNV.setBorderPainted(true); // Bật viền cho JButton
        //buttonQLNV.setBorder(new RoundedBorder(30)); // Viền bo tròn 30px
        buttonQLNV.setForeground(Color.black);
        buttonQLNV.setBackground(ColorButton);
        buttonQLNV.setOpaque(true);
        buttonQLNV.setFocusPainted(false);// bỏ viền nhỏ bên trong button khi click chọn
        buttonQLNV.addActionListener(this);
        buttonQLNV.addMouseListener(this);
        this.add(buttonQLNV);

        buttonQLKH = new JButton("QL Khách Hàng", new ImageIcon(imgQLKH));
        buttonQLKH.setPreferredSize(new Dimension(width, 50));
        //buttonQLNV.setBorderPainted(true); // Bật viền cho JButton
        //buttonQLKH.setBorder(new RoundedBorder(30)); // Viền bo tròn 30px
        buttonQLKH.setForeground(Color.black);
        buttonQLKH.setBackground(ColorButton);
        buttonQLKH.setOpaque(true);
        buttonQLKH.setFocusPainted(false);
        buttonQLKH.addActionListener(this);
        buttonQLKH.addMouseListener(this);
        
        this.add(buttonQLKH);

        buttonQLSP = new JButton("QL Sản Phẩm", new ImageIcon(imgQLSP));
        buttonQLSP.setPreferredSize(new Dimension(width, 50));
        //buttonQLNV.setBorderPainted(true); // Bật viền cho JButton
        //buttonQLSP.setBorder(new RoundedBorder(30)); // Viền bo tròn 30px
        buttonQLSP.setForeground(Color.black);
        buttonQLSP.setBackground(ColorButton);
        buttonQLSP.setOpaque(true);
        buttonQLSP.setFocusPainted(false);
        buttonQLSP.addActionListener(this);
        buttonQLSP.addMouseListener(this);
        this.add(buttonQLSP);

        buttonQLDH = new JButton("QL Đơn Hàng", new ImageIcon(imgQLDH));
        buttonQLDH.setPreferredSize(new Dimension(width, 50));
        //buttonQLNV.setBorderPainted(true); // Bật viền cho JButton
        //buttonQLDH.setBorder(new RoundedBorder(30)); // Viền bo tròn 30px
        buttonQLDH.setForeground(Color.black);
        buttonQLDH.setBackground(ColorButton);
        buttonQLDH.setOpaque(true);
        buttonQLDH.setFocusPainted(false);
        buttonQLDH.addActionListener(this);
        buttonQLDH.addMouseListener(this);
        this.add(buttonQLDH);

        buttonLuongNV = new JButton("Bảng Lương Nhân Viên", new ImageIcon(imgLuongNV));
        buttonLuongNV.setPreferredSize(new Dimension(width, 50));
        //buttonQLNV.setBorderPainted(true); // Bật viền cho JButton
        //buttonLuongNV.setBorder(new RoundedBorder(30)); // Viền bo tròn 30px
        buttonLuongNV.setForeground(Color.black);
        buttonLuongNV.setBackground(ColorButton);
        buttonLuongNV.setOpaque(true);
        buttonLuongNV.setFocusPainted(false);
        buttonLuongNV.addActionListener(this);
        buttonLuongNV.addMouseListener(this);
        this.add(buttonLuongNV);

        buttonDoanhthu = new JButton("Thống Kê Doanh Thu", new ImageIcon(imgDoanhthu));
        buttonDoanhthu.setPreferredSize(new Dimension(width, 50));
        //buttonQLNV.setBorderPainted(true); // Bật viền cho JButton
        //buttonDoanhthu.setBorder(new RoundedBorder(30)); // Viền bo tròn 30px
        buttonDoanhthu.setForeground(Color.black);
        buttonDoanhthu.setBackground(ColorButton);
        buttonDoanhthu.setOpaque(true);
        buttonDoanhthu.setFocusPainted(false);
        buttonDoanhthu.addActionListener(this);
        buttonDoanhthu.addMouseListener(this);        
        this.add(buttonDoanhthu);

        buttonLogout = new JButton("Đăng Xuất", new ImageIcon(imgLogout));
        buttonLogout.setPreferredSize(new Dimension(width, 50));
        //buttonQLNV.setBorderPainted(true); // Bật viền cho JButton
        //buttonLogout.setBorder(new RoundedBorder(30)); // Viền bo tròn 30px
        buttonLogout.setForeground(Color.black);
        buttonLogout.setBackground(ColorButton);
        buttonLogout.setOpaque(true);
        buttonLogout.setFocusPainted(false);
        buttonLogout.addActionListener(this);
        buttonLogout.addMouseListener(this);
        this.add(buttonLogout);

//        buttonQLNV = createButton("QL Nhân Viên");
//        buttonQLKH = createButton("QL Khách Hàng");
//        buttonQLSP = createButton("QL Sản Phẩm");
//        buttonQLDH = createButton("QL Đơn Hàng");
//        buttonLuongNV = createButton("Bảng Lương Nhân Viên");
//        buttonDoanhthu = createButton("Thống Kê Doanh Thu");
//        buttonLogout = createButton("Đăng Xuất");
//
//        this.add(buttonQLNV);
//        this.add(buttonQLKH);
//        this.add(buttonQLSP);
//        this.add(buttonQLDH);
//        this.add(buttonLuongNV);
//        this.add(buttonDoanhthu);
//        this.add(buttonLogout);

    }

//    private JButton createButton(String text) {
//        JButton button = new JButton(text);
//        button.setPreferredSize(new Dimension(width, 50));
//        button.setForeground(Color.BLACK);
//        button.setBackground(new java.awt.Color(223, 228, 234));
//        button.setOpaque(true);
//        button.setFocusPainted(false);
//        button.addActionListener(this);
//        button.addMouseListener(this);  // Thêm sự kiện chuột vào button
//        return button;
//    }
    private void ResetColor(){
        buttonQLAdmin.setBackground(ColorButton);
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
        if(button == buttonQLAdmin){
            
        }
        else if (button== buttonQLNV) {
            layout.setPanelCenter(new QLNV());
        } else if (button== buttonQLKH) {
            layout.setPanelCenter(new QLKH());
        } else if (button == buttonQLSP) {
            layout.setPanelCenter(new QLSP(this));
        } else if (button == buttonQLDH) {
            layout.setPanelCenter(new QLDH());
        } else if (button == buttonLuongNV) {

        } else if (button == buttonDoanhthu) {

        } else {

        }
    }

   
    @Override
    public void mousePressed(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if( button != buttonSelected){
            button.setBackground(ColorButton);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if( button != buttonSelected){
            button.setBackground(ColorButton);
        } // Trở về màu cũ khi thả
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if( button != buttonSelected){
            button.setBackground(Color.red);
        } // Đổi màu khi di chuột vào
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if( button != buttonSelected){
            button.setBackground(ColorButton);
        }// Trở về màu cũ khi chuột rời đi
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }
}
