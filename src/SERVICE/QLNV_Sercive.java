/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import DAO.JDBC;

/**
 *
 * @author tuntt
 */
public final class QLNV_Sercive extends JPanel implements MouseListener {

    //private JLabel labelId, labelTen, labelGioitinh, labelNgaysinh, labelSDT, labelDiachi, labelMail, labelLuong, labelNgayvaolam;
    private JTextField textfieldId, textfieldTen, textfieldGioitinh, textfieldNgaysinh, textfieldSDT, textfieldDiachi, textfieldEmail, textfieldLuong, textfieldNgayvaolam, textfieldchucvu;
    private JButton buttonAdd, buttonDelete, buttonFix, buttonSearch;
    private JLabel labelPhoto;
    private JTable tableNV;
    private DefaultTableModel tablemodel;
    private JScrollPane scrollpane;

    public QLNV_Sercive() {
        setPreferredSize(new Dimension(1000, 720));
        setLayout(new BorderLayout());
        initQLNV();
        loadData();
    }

    private void initQLNV() {
        buttonAdd = new JButton("Thêm nhân viên");
        buttonAdd.setBackground(Color.pink);
        buttonAdd.setOpaque(true);
        buttonAdd.setFocusPainted(false);
        buttonFix = new JButton("Sửa nhân viên");
        buttonFix.setBackground(Color.pink);
        buttonFix.setOpaque(true);
        buttonFix.setFocusPainted(false);
        buttonDelete = new JButton("Xóa nhân viên");
        buttonDelete.setBackground(Color.pink);
        buttonDelete.setOpaque(true);
        buttonDelete.setFocusPainted(false);
        buttonSearch = new JButton("Tìm kiếm nhân viên");
        buttonSearch.setBackground(Color.pink);
        buttonSearch.setOpaque(true);
        buttonSearch.setFocusPainted(false);

        JPanel panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(1000, 50));
        panelTop.setBackground(new java.awt.Color(53, 59, 72));
        panelTop.setOpaque(true);
        panelTop.setLayout(new FlowLayout(1, 10, 5));
        panelTop.add(buttonAdd);
        panelTop.add(buttonFix);
        panelTop.add(buttonDelete);
        panelTop.add(buttonSearch);
        panelTop.setBorder(BorderFactory.createLineBorder(Color.black, 2));// đặt viền đen , 2px cho cả 4 cạnh

        add(panelTop, BorderLayout.NORTH);

        //Ảnh 
        JPanel panelLeft = new JPanel();
        labelPhoto = new JLabel();
        panelLeft.setPreferredSize(new Dimension(200, 300));
        panelLeft.add(labelPhoto);
        panelLeft.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.black));// đặt viền đen , 2px cho right

        add(panelLeft, BorderLayout.WEST);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new GridLayout(10, 2, 5, 5));
        panelRight.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.black));

        String[] labels = {" Mã nhân viên ", " Tên nhân viên ", " Giới tính ", " Số điện thoại ", " Địa chỉ ", " Ngày sinh ", " Email ", " Ngày vào làm ", " Lương ", "Chức vụ"};
        JTextField[] fields = new JTextField[10];
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            fields[i] = new JTextField(20);
            panelRight.add(label);
            panelRight.add(fields[i]);
        }
        // gán biến cụ thể , dễ thao tác hơn so với mảng fields
        textfieldId = fields[0];
        textfieldTen = fields[1];
        textfieldGioitinh = fields[2];
        textfieldSDT = fields[3];
        textfieldDiachi = fields[4];
        textfieldNgaysinh = fields[5];
        textfieldEmail = fields[6];
        textfieldNgayvaolam = fields[7];
        textfieldLuong = fields[8];
        textfieldchucvu = fields[9];

        add(panelRight, BorderLayout.CENTER);// căn giữa

        JPanel panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(1000, 370));
        panelBottom.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        tablemodel = new DefaultTableModel(new String[]{"Ảnh", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Số điện thoại", "Địa chỉ", "Ngày sinh", "Email", "Ngày vào làm", "Lương", "Chức vụ"}, 10) // 0 ở cuối cho biết chưa có dòng nào ban đầu   
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chỉnh sửa toàn bộ bảng
            }
        };
        tableNV = new JTable(tablemodel);
        tableNV.getColumnModel().getColumn(0).setCellRenderer(new Photo());// cột 0 có ảnh
        tableNV.getTableHeader().setReorderingAllowed(false);
        scrollpane = new JScrollPane(tableNV);// tạo bảng
        scrollpane.setPreferredSize(new Dimension(1000, 370));// cuộn lên xuống khi nhiều dữ liệu
        tableNV.addMouseListener(this);
        panelBottom.add(scrollpane, BorderLayout.CENTER);

        add(panelBottom, BorderLayout.SOUTH);
    }

    private void loadData() {
        String imagePath = null;
        Connection conn = JDBC.getJDBCConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "KHông thể kết nối JDBC", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        String query = " SELECT * FROM nhanvien";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();// thực hiện truy vấn và trả về kết quả dưới dạng ResultSet
            tablemodel.setRowCount(0);

            while (rs.next()) {// duyệt qua từng dòng trong rs
                imagePath = rs.getString("anhnhanvien");
                ImageIcon icon = null;

                if (imagePath != null && !imagePath.isEmpty()) {
                    Image img = new ImageIcon(imagePath).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(img);
                }
                String ngaysinhnv = rs.getString("ngaysinhnv");// lấy ngày sinh dưới dạng String rồi đổi lại Date trong java
                String ngayvaolam = rs.getString("ngayvaolam");
                tablemodel.addRow(new Object[]{// thêm từng dòng vào JTable
                    imagePath,
                    rs.getString("manhanvien"),
                    rs.getString("tennhanvien"),
                    rs.getString("gioitinhnv"),
                    rs.getString("sodienthoai"),
                    rs.getString("diachinv"),
                    ngaysinhnv,
                    rs.getString("emailnv"),
                    ngayvaolam,
                    rs.getString("luong"),
                    rs.getString("chucvu"),});
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int selectrow = tableNV.getSelectedRow();
        if (selectrow != -1) {
            // Lấy dữ liệu từ bảng, kiểm tra null trước khi chuyển thành chuỗi
            Object idValue = tableNV.getValueAt(selectrow, 1); // Cột 1 là Mã nhân viên
            Object tenValue = tableNV.getValueAt(selectrow, 2);
            Object gioitinhValue = tableNV.getValueAt(selectrow, 3);
            Object sdtValue = tableNV.getValueAt(selectrow, 4);
            Object diachiValue = tableNV.getValueAt(selectrow, 5);
            Object ngaysinhValue = tableNV.getValueAt(selectrow, 6);
            Object emailValue = tableNV.getValueAt(selectrow, 7);
            Object ngayvaolamValue = tableNV.getValueAt(selectrow, 8);
            Object luongValue = tableNV.getValueAt(selectrow, 9);
            Object chucvuValue = tableNV.getValueAt(selectrow, 10);

            // Kiểm tra null trước khi gán vào text field
            textfieldId.setText(idValue != null ? idValue.toString() : "");
            textfieldTen.setText(tenValue != null ? tenValue.toString() : "");
            textfieldGioitinh.setText(gioitinhValue != null ? gioitinhValue.toString() : "");
            textfieldSDT.setText(sdtValue != null ? sdtValue.toString() : "");
            textfieldDiachi.setText(diachiValue != null ? diachiValue.toString() : "");
            textfieldNgaysinh.setText(ngaysinhValue != null ? ngaysinhValue.toString() : "");
            textfieldEmail.setText(emailValue != null ? emailValue.toString() : "");
            textfieldNgayvaolam.setText(ngayvaolamValue != null ? ngayvaolamValue.toString() : "");
            textfieldLuong.setText(luongValue != null ? luongValue.toString() : "");
            textfieldchucvu.setText(chucvuValue != null ? chucvuValue.toString() : "");
            
            String image = tableNV.getValueAt(selectrow,0).toString();
            if (image != null && !image.isEmpty()) {
                ImageIcon imageicon = new ImageIcon(image);
                Image img  = imageicon.getImage().getScaledInstance(200,300,Image.SCALE_SMOOTH);
                labelPhoto.setIcon(new ImageIcon(img));
            }
            else {
                labelPhoto.setIcon(null); // Xóa ảnh nếu không có
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
