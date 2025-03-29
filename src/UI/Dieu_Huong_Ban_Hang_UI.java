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
public class Dieu_Huong_Ban_Hang_UI extends JPanel implements ActionListener, MouseListener {

    private JLabel labelSell;
    private Layout_UI layout;

    private JButton buttonThanhtoan, buttonTimkiemsanpham, buttonThongtinkhachhang, buttonKhuyenmai, buttonBaocao, buttonLogout, buttonSelected = null;

    public static final int width = 250;
    public static final int height = 720;

    private static final Color ColorButton = new Color(223, 228, 234);
    private static final Color ColorSelected = new Color(129, 236, 236);

    public Dieu_Huong_Ban_Hang_UI() {
        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout());
        setBackground(new java.awt.Color(53, 59, 72));
        initDieu_Huong_Ban_Hang_UI();
    }

    public void initDieu_Huong_Ban_Hang_UI() {
        // logo bán hàng
        JPanel panelSell = new JPanel();
        panelSell.setPreferredSize(new Dimension(width, 100));
        panelSell.setOpaque(false);// do dùng Flowlayout nên các thành phần có khoảng cách nhất định
        ImageIcon logoAdmin = new ImageIcon("D:\\Lap_Trinh_Java\\images\\sell.png");
        Image img = logoAdmin.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH); // Resize ảnh, width = 100px, height = 80px
        labelSell = new JLabel(new ImageIcon(img));
        panelSell.add(labelSell);
        this.add(panelSell);

        buttonThanhtoan = createButton("Thanh Toán");

        buttonTimkiemsanpham = createButton("Tìm Kiếm Sách");

        buttonThongtinkhachhang = createButton("Thông Tin Khách Hàng");

        buttonKhuyenmai = createButton("Khuyến Mãi");

        buttonBaocao = createButton("Báo Cáo");

        buttonLogout = createButton("Đăng Xuất");

        this.add(buttonThanhtoan);
        this.add(buttonTimkiemsanpham);
        this.add(buttonThongtinkhachhang);
        this.add(buttonKhuyenmai);
        this.add(buttonBaocao);
        this.add(buttonLogout);

    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
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
        buttonThanhtoan.setBackground(ColorButton);
        buttonTimkiemsanpham.setBackground(ColorButton);
        buttonThongtinkhachhang.setBackground(ColorButton);
        buttonKhuyenmai.setBackground(ColorButton);
        buttonBaocao.setBackground(ColorButton);
        buttonLogout.setBackground(ColorButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        ResetColor();
        button.setBackground(ColorSelected);
        buttonSelected = button;
        if (button == buttonThanhtoan) {
            
        } else if (button == buttonThongtinkhachhang) {

        } else if (button == buttonTimkiemsanpham) {

        } else if (button == buttonKhuyenmai) {

        } else if (button == buttonBaocao) {

        } else{
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
            // this: thực hiện canh theo phần cha chứa nó,  null sẽ căng giữa màng hình
            if (confirm == JOptionPane.YES_OPTION) {
               SwingUtilities.getWindowAncestor(this).dispose(); // Đóng cửa sổ hiện tại
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelected) {
            button.setBackground(ColorButton);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelected) {
            button.setBackground(ColorButton);
        } // Trở về màu cũ khi thả
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelected) {
            button.setBackground(Color.red);
        } // Đổi màu khi di chuột vào
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelected) {
            button.setBackground(ColorButton);
        }// Trở về màu cũ khi chuột rời đi
    }

}
