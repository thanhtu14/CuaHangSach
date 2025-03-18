/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an;

import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuntt
 */
public class QLKH extends JPanel {

    private JButton buttonAddKH, buttonFixKH, buttonDeleteKH, buttonSearchKH;
    private JLabel labelPhotoKH;
    private JTextField textfieldIdKH, textfieldTenKH, textfieldSDT, textfieldDiachi, textfieldGioitinh, textfieldEmail;
    private DefaultTableModel tablemodel;
    private JTable tableKH;
    private JScrollPane scrollpane;

    public QLKH() {
        setPreferredSize(new Dimension(1000, 720));
        setLayout(new BorderLayout());
        initQLKH();
        loadData();
    }
// đắng kí khách hàng khi làm thẻ thành viên

    private void initQLKH() {

        buttonAddKH = new JButton("Thêm khách hàng");
        buttonAddKH.setBackground(new java.awt.Color(255, 234, 167));
        buttonAddKH.setFocusPainted(false);
        buttonFixKH = new JButton("Sửa khách hàng");
        buttonFixKH.setBackground(new java.awt.Color(255, 234, 167));
        buttonFixKH.setFocusPainted(false);
        buttonDeleteKH = new JButton("Xóa khách hàng");
        buttonDeleteKH.setBackground(new java.awt.Color(255, 234, 167));
        buttonDeleteKH.setFocusPainted(false);
        buttonSearchKH = new JButton("Tìm khách hàng");// tìm theo tên khách hàng
        buttonSearchKH.setBackground(new java.awt.Color(255, 234, 167));
        buttonSearchKH.setFocusPainted(false);

        JPanel panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(1000, 50));
        panelTop.setLayout(new FlowLayout(2, 5, 5));
        panelTop.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        panelTop.add(buttonAddKH);
        panelTop.add(buttonFixKH);
        panelTop.add(buttonDeleteKH);
        panelTop.add(buttonSearchKH);

        add(panelTop, BorderLayout.NORTH);

        labelPhotoKH = new JLabel("Ảnh khách hàng");

        JPanel panelLeft = new JPanel();
        panelLeft.setPreferredSize(new Dimension(250, 300));
        panelLeft.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.black));
        panelLeft.add(labelPhotoKH);

        add(panelLeft, BorderLayout.WEST);

        JPanel panelRight = new JPanel();
        panelRight.setPreferredSize(new Dimension(750, 300));
        panelRight.setLayout(new GridLayout(6, 2, 10, 10));
        panelRight.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.black));

        String[] labels = {" Mã khách hàng ", " Tên khách hàng ", " Giới tính ", " Số điện thoại ", " Địa chỉ ", " Email "};
        //JTextField[] fields = {textfieldIdKH, textfieldTenKH, textfieldGioitinh, textfieldSDT, textfieldDiachi, textfieldEmail};
        JTextField[] fields = new JTextField[6];// khai báo 1 mảng 6 phần tử những chưa khỏi tạo đối tượng , các phần tử này đều là null
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            fields[i] = new JTextField(20);// khi sử dụng cần phải khởi tại như này trước mới sử dụng được , nếu không sẽ có lỗi
            panelRight.add(label);
            panelRight.add(fields[i]);
        }
        textfieldIdKH = fields[0];
        textfieldTenKH = fields[1];
        textfieldGioitinh = fields[2];
        textfieldSDT = fields[3];
        textfieldDiachi = fields[4];
        textfieldEmail = fields[5];

        add(panelRight, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(1000, 370));
        panelBottom.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        tablemodel = new DefaultTableModel(new String[]{"Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại", "Địa chỉ", "Email"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chỉnh sửa toàn bộ bảng
            }
        };
        tableKH = new JTable(tablemodel);
        scrollpane = new JScrollPane(tableKH);
        scrollpane.setPreferredSize(new Dimension(1000, 370)); // Chỉnh kích thước cho bảng hiện nội dung
        panelBottom.add(scrollpane, BorderLayout.CENTER);

        add(panelBottom, BorderLayout.SOUTH);
    }

    private void loadData() {
        Connection conn = JDBC.getJDBCConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, " lỗi kết nối JDBC ", " Lỗi ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String query = " SELECT * FROM khachhang";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            tablemodel.setRowCount(0);

            while (rs.next()) {
                tablemodel.addRow(new Object[]{
                    rs.getString("makhachhang"),
                    rs.getString("tenkhachhang"),
                    rs.getString("gioitinh"),
                    rs.getString("sodienthoai"),
                    rs.getString("diachikh"),
                    rs.getString("emailkh"),});
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
