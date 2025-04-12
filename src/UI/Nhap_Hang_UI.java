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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import MODEL.Nhap_Hang_Model;
import SERVICE.Nhap_Hang_Service;
import java.util.Vector;

/**
 *
 * @author tuntt
 */
public class Nhap_Hang_UI extends JPanel implements  ActionListener, MouseListener{
    private JButton buttonAdd, buttonFix, buttonDelete, buttonSearch, buttonSelected = null;
    private JLabel labelmanhaphang, labelmancc, labelmanhanvien, labelngaynhap, labeltongtien;
    private JTextField textfieldmanhaphang, textfieldmancc, textfieldmanhanvien, textfieldngaynhap, textfieldtongtien;
    private JTable table;
    private DefaultTableModel model;

    private String maquyen;
    private String machucnang;

    private Tai_Khoan_Service tai_Khoan_Service = new Tai_Khoan_Service();
    private Nhap_Hang_Service nhap_Hang_Service = new Nhap_Hang_Service();

    public Nhap_Hang_UI(String maquyen, String machucnang) {
        
        this.maquyen = maquyen;
        this.machucnang = machucnang;

        setPreferredSize(new Dimension(1000, 720));
        setLayout(new BorderLayout());

        initNha_Cung_Cap_UI();
    }

    public void initNha_Cung_Cap_UI() {
        JPanel panelTop = new JPanel(new FlowLayout(1, 10, 10));
        panelTop.setBackground(new java.awt.Color(53, 59, 72));
        panelTop.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.black));

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

        JPanel panelcenter = new JPanel(new GridLayout(5, 2, 5, 5));
        panelcenter.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.black));

        // mã sách gồm 2 chữ và 3 số 
        // số trang > 0;
        // giá bán >0 ;
        // số lượng >= 0;
        //
        String[] labels = {"Mã đơn nhập hàng", "Mã nhà cung cấp", "Mã nhân viên kho", "Ngày nhập hàng", "Tổng tiền nhập hàng"};
        JTextField[] fields = new JTextField[5];
//        JTextField[] fields = {textfieldmancc, textfieldtenncc, textfielddiachincc, textfieldsdtncc,
//            textfieldquocgiancc, textfieldemail};// cách khai báo khởi tạo sẳng đối tượng , khi cần có thể dùng trực tiếp

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            fields[i] = new JTextField(20);
            panelcenter.add(label);
            panelcenter.add(fields[i]);
        }

        textfieldmanhaphang = fields[0];
        textfieldmancc = fields[1];
        textfieldmanhanvien = fields[2];
        textfieldngaynhap = fields[3];
        textfieldtongtien = fields[4];

        this.add(panelcenter, BorderLayout.CENTER);

        // Panel dưới chứa bảng danh sách sản phẩm
        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.setPreferredSize(new Dimension(1000, 370));
        panelBottom.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        model = new DefaultTableModel(new String[]{"Mã đơn nhập hàng", "Mã nhà cung cấp", "Mã nhân viên kho",  "Ngày nhập hàng", "Tổng tiền nhập hàng"}, 10) // 0 ở cuối cho biết chưa có dòng nào ban đầu   
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

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        
        table.setRowSorter(rowSorter);// bộ sắp xếp

        rowSorter.setSortable(0, true);//  cho sắp xếp cột 0 (mã)
        rowSorter.setSortable(1, true);//  cho sắp xếp cột 1 (ten)
        rowSorter.setSortable(2, false);//  không cho sắp xếp cột 2 (địa chỉ)
        rowSorter.setSortable(3, false);// không cho sắp xếp cột 3 (sdt)
        rowSorter.setSortable(4, false);// không cho sắp xếp cột 4 (quốc gia)
       

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

        this.add(panelBottom, BorderLayout.SOUTH);
    }
    private void outModel(DefaultTableModel model, ArrayList<Nhap_Hang_Model> nh) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        table.clearSelection(); // Bỏ chọn tất cả dòng
        for (Nhap_Hang_Model n : nh) {
            data = new Vector();
            data.add(n.getManhaphang());
            data.add(n.getManhacungcap());
            data.add(n.getManhanvien());
            data.add(n.getNgaynhaphang());
            data.add(n.getTongtiennhaphang());
            
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
        if (nhap_Hang_Service.getList() == null) {
            nhap_Hang_Service.list();
        }
        ArrayList<Nhap_Hang_Model> sp = nhap_Hang_Service.getList();
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
                

                textfieldmanhaphang.setText(val0 != null ? val0.toString() : "");
                textfieldmancc.setText(val1 != null ? val1.toString() : "");
                textfieldmanhanvien.setText(val2 != null ? val2.toString() : "");
                textfieldngaynhap.setText(val3 != null ? val3.toString() : "");
                textfieldtongtien.setText(val4 != null ? val4.toString() : "");
               
            }
        });
    }

    private void clearTextFields() {
        textfieldmanhaphang.setText("");
        textfieldmancc.setText("");
        textfieldmanhanvien.setText("");
        textfieldngaynhap.setText("");
        textfieldtongtien.setText("");
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
