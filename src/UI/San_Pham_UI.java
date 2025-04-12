/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import MODEL.San_Pham_Model;
import SERVICE.San_Pham_Service;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import SERVICE.Tai_Khoan_Service;

/**
 *
 * @author tuntt
 */
public class San_Pham_UI extends JPanel implements ActionListener {

    private JLabel labelPhotoSP;
    private JButton buttonAddSP, buttonFixSP, buttonDeleteSP, buttonSearchSP;
    private JTextField textfieldIdSP, textfieldTenSP, textfieldSoluongSP, textfieldSotrang, textfieldGiaban, textfieldAnhSP = new JTextField(), textfieldTheloai, textfieldTacgia;
    private DefaultTableModel modelTable;
    private JTable tableSP;

    private String maquyen;
    private String machucnang;

    private San_Pham_Service san_Pham_Service = new San_Pham_Service();
    private Tai_Khoan_Service tai_Khoan_Service = new Tai_Khoan_Service();

    public San_Pham_UI(String maquyen, String machucnang) {

        this.maquyen = maquyen;
        this.machucnang = machucnang;

        setPreferredSize(new Dimension(1000, 720));
        setLayout(new BorderLayout());
        init_San_Pham_UI();

    }

    private void init_San_Pham_UI() {

        JPanel panelTop = new JPanel(new FlowLayout(1, 10, 10));
        panelTop.setBackground(new java.awt.Color(53, 59, 72));
        panelTop.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.black));

        int[] hanh_dong;

        hanh_dong = tai_Khoan_Service.Hanh_dong_cua_chuc_nang(maquyen, machucnang);

        for (int i = 0; i < 5; i++) {
            System.out.println(hanh_dong[i]);
        }

        if (hanh_dong[1] == 1) {
            buttonAddSP = new JButton("Thêm");
            buttonAddSP.setFocusPainted(false);
            buttonAddSP.addActionListener(this);
            panelTop.add(buttonAddSP);

        }
        if (hanh_dong[2] == 1) {
            buttonFixSP = new JButton("Sửa");
            buttonFixSP.setFocusPainted(false);
            buttonFixSP.addActionListener(this);
            panelTop.add(buttonFixSP);

        }
        if (hanh_dong[3] == 1) {
            buttonDeleteSP = new JButton("Xóa");
            buttonDeleteSP.setFocusPainted(false);
            buttonDeleteSP.addActionListener(this);
            panelTop.add(buttonDeleteSP);

        }
        if (hanh_dong[4] == 1) {
            buttonSearchSP = new JButton("Tìm kiếm");
            buttonSearchSP.setFocusPainted(false);
            buttonSearchSP.addActionListener(this);
            panelTop.add(buttonSearchSP);

        }

        if (buttonAddSP != null || buttonFixSP != null || buttonDeleteSP != null || buttonSearchSP != null) {
            add(panelTop, BorderLayout.NORTH);
        }

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
        String[] labels = {"Mã sách", "Tên sách", "Thể loại", "Tác giả", "Số trang", "Giá bán", "Số lượng"};
        JTextField[] fields = {textfieldIdSP, textfieldTenSP, textfieldTheloai, textfieldTacgia,
            textfieldSotrang, textfieldGiaban, textfieldSoluongSP};// cách khai báo khởi tạo sẳng đối tượng , khi cần có thể dùng trực tiếp

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

        add(panelRight, BorderLayout.CENTER);

        // Panel dưới chứa bảng danh sách sản phẩm
        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.setPreferredSize(new Dimension(1000, 370));
        panelBottom.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        modelTable = new DefaultTableModel(new String[]{"Ảnh ", "Mã sách", "Tên sách", "Tên tác giả", "Thể loại", "Số trang", "Giá bán", "Số lượng"}, 10) // 0 ở cuối cho biết chưa có dòng nào ban đầu   
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chỉnh sửa nội dung toàn bộ bảng
            }
        };

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(modelTable);
        tableSP = new JTable(modelTable);
        
         // THỰC HIỆN VIỆC CLICK CHỌN DÒNG NÀO ĐƯỢC CHỌN VÀ KHÔNG CHỌN DÒNG NÀO
        tableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = tableSP.rowAtPoint(e.getPoint());
                if (row == -1) {
                    tableSP.clearSelection();
                    clearTextFields();
                }
            }
        });

        themSuKienClickTable();// tải nội dung lên textfield khi được click

        tableSP.getTableHeader().setReorderingAllowed(false);// làm cho bảng không thể chuyển đổi giữa các cột trong bảng

        tableSP.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableSP.getColumnModel().getColumn(1).setPreferredWidth(70);
        tableSP.getColumnModel().getColumn(2).setPreferredWidth(150);
        tableSP.getColumnModel().getColumn(3).setPreferredWidth(100);
        tableSP.getColumnModel().getColumn(4).setPreferredWidth(100);
        tableSP.getColumnModel().getColumn(5).setPreferredWidth(100);
        tableSP.getColumnModel().getColumn(6).setPreferredWidth(100);
        tableSP.getColumnModel().getColumn(7).setPreferredWidth(100);

        tableSP.setRowSorter(rowSorter);// bộ sắp xếp
        
        rowSorter.setSortable(0, false);// không cho sắp xếp cột 0 (ảnh)
        rowSorter.setSortable(1, true);//  cho sắp xếp cột 1 (ma)
        rowSorter.setSortable(2, true);//  cho sắp xếp cột 2 (tên)
        rowSorter.setSortable(3, false);// không cho sắp xếp cột 3 (tên tác giả)
        rowSorter.setSortable(4, false);// không cho sắp xếp cột 4 (thể loại)
        rowSorter.setSortable(5, false);// không cho sắp xếp cột 5 (số trang)
        rowSorter.setSortable(6, true);// không cho sắp xếp cột 6 (giá bán)
        rowSorter.setSortable(7, true);// không cho sắp xếp cột 7 (số lượng)

        list(); //Đọc từ database lên table
        // ------------------canh giữa tiêu đề của jtable---------
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();

        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa
        headerRenderer.setBackground(Color.lightGray);
        headerRenderer.setOpaque(true);
        headerRenderer.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.red));
        //headerRenderer.setBorder(new LineBorder(Color.BLACK, 2));
        tableSP.setShowGrid(true); // Hiển thị lưới
        tableSP.setGridColor(Color.black); // Màu của đường kẻ
        for (int i = 0; i < tableSP.getColumnModel().getColumnCount(); i++) {
            tableSP.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        // Custom table
        tableSP.setFocusable(false);
        tableSP.setIntercellSpacing(new Dimension(0, 0));// xóa khoảng cách giữa các ô  trong bảng(ngang và dọc)
        tableSP.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tableSP.setRowHeight(30);// tạo chiều cao mỗi dòng là 30 px
        tableSP.setShowVerticalLines(true);  // kẻ ngang của bảng            
        tableSP.getTableHeader().setOpaque(false);
        tableSP.setFillsViewportHeight(true);// chỉnh bảng luôn kéo dài để lắp đầy 
        tableSP.getTableHeader().setBackground(new Color(232, 57, 99));
        tableSP.getTableHeader().setForeground(Color.black);
        tableSP.setSelectionBackground(new Color(52, 152, 219));// màu khi chọn dòng trên table

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tableSP);

        scroll.setBackground(null);

        panelBottom.add(scroll, BorderLayout.CENTER);

        this.add(panelBottom, BorderLayout.SOUTH);

    }

    private void outModel(DefaultTableModel model, ArrayList<San_Pham_Model> kh) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        tableSP.clearSelection(); // Bỏ chọn tất cả dòng
        for (San_Pham_Model n : kh) {
            data = new Vector();
            data.add(n.getAnh());
            data.add(n.getMasach());
            data.add(n.getTensach());
            data.add(n.getTentacgia());
            data.add(n.getTheloai());
            data.add(n.getSotrang());
            data.add(n.getGiaban());
            data.add(n.getSoluong());

            model.addRow(data);
        }
        //model.fireTableDataChanged();
        tableSP.setModel(model);
    }

    @Override
    public void list() // Chép ArrayList lên table
    {
        modelTable.setRowCount(0);
        //model.fireTableDataChanged();  
        if (san_Pham_Service.getList() == null) {
            san_Pham_Service.list();
        }
        ArrayList<San_Pham_Model> sp = san_Pham_Service.getList();
        outModel(modelTable, sp);
    }

    private void themSuKienClickTable() {
        tableSP.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tableSP.getSelectedRow();
                if (selectedRow == -1) {
                    clearTextFields(); // Nếu không chọn dòng nào thì clear
                    return;
                }

                int modelRow = tableSP.convertRowIndexToModel(selectedRow);

                Object val0 = modelTable.getValueAt(modelRow, 0);
                Object val1 = modelTable.getValueAt(modelRow, 1);
                Object val2 = modelTable.getValueAt(modelRow, 2);
                Object val3 = modelTable.getValueAt(modelRow, 3);
                Object val4 = modelTable.getValueAt(modelRow, 4);
                Object val5 = modelTable.getValueAt(modelRow, 5);
                Object val6 = modelTable.getValueAt(modelRow, 6);
                Object val7 = modelTable.getValueAt(modelRow, 7);

                textfieldAnhSP.setText(val0 != null ? val0.toString() : "");
                textfieldIdSP.setText(val1 != null ? val1.toString() : "");
                textfieldTenSP.setText(val2 != null ? val2.toString() : "");
                textfieldTheloai.setText(val3 != null ? val3.toString() : "");
                textfieldTacgia.setText(val4 != null ? val4.toString() : "");
                textfieldSotrang.setText(val5 != null ? val5.toString() : "");
                textfieldGiaban.setText(val6 != null ? val6.toString() : "");
                textfieldSoluongSP.setText(val7 != null ? val7.toString() : "");
            }
        });
    }

    private void clearTextFields() {
        textfieldAnhSP.setText("");
        textfieldIdSP.setText("");
        textfieldTenSP.setText("");
        textfieldTheloai.setText("");
        textfieldTacgia.setText("");
        textfieldSotrang.setText("");
        textfieldGiaban.setText("");
        textfieldSoluongSP.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
