/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import MODEL.Khach_Hang_Model;
import SERVICE.Khach_Hang_Service;
import SERVICE.Tai_Khoan_Service;

/**
 *
 * @author tuntt
 */
public class Khach_Hang_UI extends JPanel implements ActionListener {

    private JButton buttonAdd, buttonFix, buttonDelete, buttonSearch;
    private JLabel labelPhotoKH;
    private JTextField textfieldIdKH, textfieldTenKH, textfieldSDT, textfieldDiachi, textfieldGioitinh, textfieldEmail;

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollpane;

    private Khach_Hang_Service khach_Hang_Service = new Khach_Hang_Service();
    private Tai_Khoan_Service tai_Khoan_Service = new Tai_Khoan_Service();

    private String maquyen;
    private String machucnang;
    
    public Khach_Hang_UI( String maquyen, String machucnang) {
        
        this.maquyen = maquyen;
        this.machucnang = machucnang;
        
        setPreferredSize(new Dimension(1000, 720));
        setLayout(new BorderLayout());
        init_Khach_Hang_UI();
    }

    private void init_Khach_Hang_UI() {
        

        JPanel panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(1000, 50));
        panelTop.setLayout(new FlowLayout(2, 5, 5));
        panelTop.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
       
        int[] hanh_dong;

        hanh_dong = tai_Khoan_Service.Hanh_dong_cua_chuc_nang(maquyen, machucnang);

        for (int i = 0; i < 5; i++) {
            System.out.println(hanh_dong[i]);
        }

        if (hanh_dong[1] == 1) {
            buttonAdd = new JButton("Thêm");
            buttonAdd.setFocusPainted(false);
            buttonAdd.addActionListener(this);
            panelTop.add(buttonAdd);

        }
        if (hanh_dong[2] == 1) {
            buttonFix = new JButton("Sửa");
            buttonFix.setFocusPainted(false);
            buttonFix.addActionListener(this);
            panelTop.add(buttonFix);

        }
        if (hanh_dong[3] == 1) {
            buttonDelete = new JButton("Xóa");
            buttonDelete.setFocusPainted(false);
            buttonDelete.addActionListener(this);
            panelTop.add(buttonDelete);

        }
        if (hanh_dong[4] == 1) {
            buttonSearch = new JButton("Tìm kiếm");
            buttonSearch.setFocusPainted(false);
            buttonSearch.addActionListener(this);
            panelTop.add(buttonSearch);

        }

        if (buttonAdd != null || buttonFix != null || buttonDelete != null || buttonSearch != null) {
            add(panelTop, BorderLayout.NORTH);
        }

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
        panelBottom.setLayout(new BorderLayout());
        panelBottom.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        model = new DefaultTableModel(new String[]{"Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại", "Địa chỉ khách hàng", "Email khách hàng"}, 0) // 0 ở cuối cho biết chưa có dòng nào ban đầu   
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chỉnh sửa nội dung toàn bộ bảng
            }
        };

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        table = new JTable(model);

        // THỰC HIỆN VIỆC CLICK CHỌN DÒNG NÀO ĐƯỢC CHỌN VÀ KHÔNG CHỌN DÒNG NÀO
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row == -1) {
                    table.clearSelection();
                    clearTextFields();
                }
            }
        });

        themSuKienClickTable();// tải nội dung lên textfield khi được click

        table.getTableHeader().setReorderingAllowed(false);// làm cho bảng không thể chuyển đổi giữa các cột trong bảng

        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);

        table.setRowSorter(rowSorter);// bộ sắp xếp

        rowSorter.setSortable(0, false);//  không cho sắp xếp cột 1 (ma)
        rowSorter.setSortable(1, false);//  không cho sắp xếp cột 2 (tên khách hàng)
        rowSorter.setSortable(2, false);// không cho sắp xếp cột 3 (tên nhân viên thanh toán)
        rowSorter.setSortable(3, true);//  cho sắp xếp cột 4 (ngày mua)
        rowSorter.setSortable(4, false);// không cho sắp xếp cột 5 (tổng tiền)

        list(); //Đọc từ database lên table
        // ------------------canh giữa tiêu đề của jtable---------
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();

        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa
        headerRenderer.setBackground(Color.lightGray);
        headerRenderer.setOpaque(true);
        headerRenderer.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.red));
        //headerRenderer.setBorder(new LineBorder(Color.BLACK, 2));
        table.setShowGrid(true); // Hiển thị lưới
        table.setGridColor(Color.black); // Màu của đường kẻ
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        // Custom table
        table.setFocusable(false);
        table.setIntercellSpacing(new Dimension(0, 0));// xóa khoảng cách giữa các ô  trong bảng(ngang và dọc)
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        table.setRowHeight(30);// tạo chiều cao mỗi dòng là 30 px
        table.setShowVerticalLines(true);  // kẻ ngang của bảng            
        table.getTableHeader().setOpaque(false);
        table.setFillsViewportHeight(true);// chỉnh bảng luôn kéo dài để lắp đầy 
        table.getTableHeader().setBackground(new Color(232, 57, 99));
        table.getTableHeader().setForeground(Color.black);
        table.setSelectionBackground(new Color(52, 152, 219));// màu khi chọn dòng trên table

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(table);

        scroll.setBackground(null);

        panelBottom.add(scroll, BorderLayout.CENTER);

        add(panelBottom, BorderLayout.SOUTH);
    }

    private void outModel(DefaultTableModel model, ArrayList<Khach_Hang_Model> kh) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        table.clearSelection(); // Bỏ chọn tất cả dòng
        for (Khach_Hang_Model n : kh) {
            data = new Vector();
            data.add(n.getMakhachhang());
            data.add(n.getTenkhachhang());
            data.add(n.getGioitinhkhachhang());
            data.add(n.getSdtkhachhang());
            data.add(n.getDiachikhachhang());
            data.add(n.getEmailkhachhang());

            model.addRow(data);
        }
        //model.fireTableDataChanged();
        table.setModel(model);
    }

    @Override
    public void list() // Chép ArrayList lên table
    {
        model.setRowCount(0);
        //model.fireTableDataChanged();  
        if (khach_Hang_Service.getList() == null) {
            khach_Hang_Service.list();
        }
        ArrayList<Khach_Hang_Model> sp = khach_Hang_Service.getList();
        outModel(model, sp);
    }

    private void themSuKienClickTable() {
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    clearTextFields(); // Nếu không chọn dòng nào thì clear
                    return;
                }

                int modelRow = table.convertRowIndexToModel(selectedRow);

                Object val0 = model.getValueAt(modelRow, 0);
                Object val1 = model.getValueAt(modelRow, 1);
                Object val2 = model.getValueAt(modelRow, 2);
                Object val3 = model.getValueAt(modelRow, 3);
                Object val4 = model.getValueAt(modelRow, 4);
                Object val5 = model.getValueAt(modelRow, 5);

                textfieldIdKH.setText(val0 != null ? val0.toString() : "");
                textfieldTenKH.setText(val1 != null ? val1.toString() : "");
                textfieldGioitinh.setText(val2 != null ? val2.toString() : "");
                textfieldSDT.setText(val3 != null ? val3.toString() : "");
                textfieldDiachi.setText(val4 != null ? val4.toString() : "");
                textfieldEmail.setText(val5 != null ? val5.toString() : "");
            }
        });
    }

    private void clearTextFields() {
        textfieldIdKH.setText("");
        textfieldTenKH.setText("");
        textfieldGioitinh.setText("");
        textfieldSDT.setText("");
        textfieldDiachi.setText("");
        textfieldEmail.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
