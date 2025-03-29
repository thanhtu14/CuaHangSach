package SERVICE;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import UI.Dieu_Huong_Quan_Ly_UI;
import DAO.JDBC;

public class QLSP_Service extends JPanel implements ActionListener {

    private Dieu_Huong_Quan_Ly_UI DieuduongQL;
    private JLabel labelPhotoSP;
    private JButton buttonAddSP, buttonFixSP, buttonDeleteSP, buttonSearchSP;
    private JTextField textfieldIdSP, textfieldTenSP, textfieldSoluongSP, textfieldSotrang, textfieldGiaban, textfieldTenNXB, textfieldTheloai, textfieldTacgia;
    private DefaultTableModel modelTable;
    private JTable tableSP;
    private JScrollPane scrollPane;

    public QLSP_Service(Dieu_Huong_Quan_Ly_UI DieuhuongQL) {
        setPreferredSize(new Dimension(1000, 720));
        setLayout(new BorderLayout());
        this.DieuduongQL = DieuhuongQL;
        initQLSP();
        loadData();
    }

    private void initQLSP() {
        // Panel trên cùng chứa các nút chức năng
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panelTop.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        buttonAddSP = new JButton("Thêm sản phẩm");
        buttonAddSP.setFocusPainted(false);
        buttonFixSP = new JButton("Sửa sản phẩm");
        buttonFixSP.setFocusPainted(false);
        buttonDeleteSP = new JButton("Xóa sản phẩm");
        buttonDeleteSP.setFocusPainted(false);
        buttonSearchSP = new JButton("Tìm sản phẩm");// tìm theo tên sp
        buttonSearchSP.setFocusPainted(false);

        buttonAddSP.addActionListener(this);
        buttonFixSP.addActionListener(this);
        buttonDeleteSP.addActionListener(this);
        buttonSearchSP.addActionListener(this);

        panelTop.add(buttonAddSP);
        panelTop.add(buttonFixSP);
        panelTop.add(buttonDeleteSP);
        panelTop.add(buttonSearchSP);
        add(panelTop, BorderLayout.NORTH);

        // Panel trái chứa ảnh sản phẩm
        JPanel panelLeft = new JPanel();
        panelLeft.setPreferredSize(new Dimension(250, 300));
        panelLeft.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.black));
        labelPhotoSP = new JLabel("Ảnh sản phẩm");
        panelLeft.add(labelPhotoSP);
        add(panelLeft, BorderLayout.WEST);

        // Panel giữa chứa thông tin sản phẩm
        JPanel panelRight = new JPanel(new GridLayout(9, 2, 5, 5));
        panelRight.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.black));

        // mã sách gồm 2 chữ và 3 số 
        // số trang > 0;
        // giá bán >0 ;
        // số lượng >= 0;
        //
        String[] labels = {"Mã sách", "Tên sách", "Thể loại", "Tác giả", "Số trang", "Giá bán", "Số lượng", "Tên NXB"};
        JTextField[] fields = {textfieldIdSP, textfieldTenSP, textfieldTheloai, textfieldTacgia,
            textfieldSotrang, textfieldGiaban, textfieldSoluongSP, textfieldTenNXB};// cách khai báo khởi tạo sẳng đối tượng , khi cần có thể dùng trực tiếp

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            fields[i] = new JTextField(20);
            panelRight.add(label);
            panelRight.add(fields[i]);
        }

        textfieldIdSP = fields[0];
        textfieldTenSP = fields[1];
        textfieldTheloai = fields[2];
        textfieldTacgia = fields[3];
        textfieldSotrang = fields[4];
        textfieldGiaban = fields[5];
        textfieldSoluongSP = fields[6];
        textfieldTenNXB = fields[7];

        add(panelRight, BorderLayout.CENTER);

        // Panel dưới chứa bảng danh sách sản phẩm
        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.setPreferredSize(new Dimension(1000, 370));
        panelBottom.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        modelTable = new DefaultTableModel(new String[]{"Ảnh ", "Mã sách", "Tên sách", "Thể loại", "Tác giả", "Số trang", "Giá bán", "Số lượng", "Tên NXB"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chỉnh sửa toàn bộ bảng
            }
        };
        tableSP = new JTable(modelTable);
        tableSP.getTableHeader().setReorderingAllowed(false);// không thể di chuyển , thay đổi vị trí các cột trong bảng
        tableSP.getColumnModel().getColumn(0).setCellRenderer(new Photo());// cột 0 có ảnh
        scrollPane = new JScrollPane(tableSP);
        panelBottom.add(scrollPane, BorderLayout.CENTER);

        add(panelBottom, BorderLayout.SOUTH);
    }

    private void loadData() {
        Connection conn = JDBC.getJDBCConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối CSDL!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // câu truy vấn cho database
        String query = "SELECT s.anhsach, s.masach, s.tensach, tl.tentheloai, tg.tentacgia, s.sotrang, s.giaban, s.soluong, nxb.tennhaxuatban "
                + "FROM sach s "
                + " LEFT JOIN nhaxuatban nxb ON s.manhaxuatban = nxb.manhaxuatban "
                + " LEFT JOIN sach_tacgia stg ON s.masach = stg.masach "
                + " LEFT JOIN tacgia tg ON stg.matacgia = tg.matacgia "
                + " LEFT JOIN sach_theloai stl ON s.masach = stl.masach"
                + " LEFT JOIN theloai tl ON stl.matheloai = tl.matheloai ";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);// truyền vào
            ResultSet rs = stmt.executeQuery();
            modelTable.setRowCount(0); // Xóa dữ liệu cũ trước khi load mới

            while (rs.next()) {
                String imagePath = rs.getString("anhsach");
                ImageIcon icon = null;

                if (imagePath != null && !imagePath.isEmpty()) {
                    Image img = new ImageIcon(imagePath).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(img);
                }
                modelTable.addRow(new Object[]{
                    icon,
                    rs.getString("masach"),// các tên này phải giống với tên đã khai báo ở trên String query( tên các cột)
                    rs.getString("tensach"),
                    rs.getString("tentheloai"),
                    rs.getString("tentacgia"),
                    rs.getInt("sotrang"),
                    rs.getDouble("giaban"),
                    rs.getInt("soluong"),
                    rs.getString("tennhaxuatban")
                });
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addsp() {

    }

    private void deletesp() {

    }

    private void fixsp() {

    }

    private void searchsp() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAddSP) {
            JOptionPane.showMessageDialog(this, "Chức năng thêm sản phẩm chưa triển khai!");
        } else if (e.getSource() == buttonFixSP) {
            JOptionPane.showMessageDialog(this, "Chức năng sửa sản phẩm chưa triển khai!");
        } else if (e.getSource() == buttonDeleteSP) {
            JOptionPane.showMessageDialog(this, "Chức năng xóa sản phẩm chưa triển khai!");
        } else if (e.getSource() == buttonSearchSP) {
            JOptionPane.showMessageDialog(this, "Chức năng tìm kiếm sản phẩm chưa triển khai!");
        }
    }
}
