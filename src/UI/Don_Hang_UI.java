/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import SERVICE.Don_Hang_Service;
import MODEL.Don_Hang_Model;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author tuntt
 */
public class Don_Hang_UI extends JPanel {

    private JPanel paneltop, panelcenter, panelbottom;
    private JLabel labeltacvu, labelmadonhang, labeltenkhachhang, labeltennhanvien, labeltensachmua, labelsoluong, labeldongia, labeltongtien, labelngaymua;
    private JTextField textfieldmadonhang, textfieldtenkhachhang, textfieldtennhanvien, textfieldtensachmua, textfieldsoluong, textfielddongia,
            textfieldtongtien, textfieldngaymua, textfieldtimkiem;
    private JButton buttontimkiem, buttonselected = null;

    private DefaultTableModel model;
    private JTable table;
    private Don_Hang_Service don_Hang_Service = new Don_Hang_Service();

    private static final Color ColorButton = Color.PINK;
    private static final Color ColorSelected = Color.orange;
    
    private String maquyen;
    private String machucnang;

    public Don_Hang_UI(String maquyen, String machucnang) {
        
        this.maquyen = maquyen;
        this.machucnang = machucnang;
        
        setPreferredSize(new Dimension(950, 720));
        setLayout(new BorderLayout());
        init_Don_Hang_UI();
    }

    public void init_Don_Hang_UI() {

        // panel chứa nội dung tác vụ( Đơn hàng) và phương thức tìm kiếm đơn hàng theo ngày
        paneltop = new JPanel();
        paneltop.setPreferredSize(new Dimension(950, 50));
        paneltop.setBackground(Color.CYAN);
        paneltop.setLayout(new FlowLayout(0, 0, 0));

        JPanel paneltacvu = new JPanel();
        paneltacvu.setPreferredSize(new Dimension(400, 40));
        paneltacvu.setLayout(new FlowLayout(0, 20, 10));

        labeltacvu = new JLabel("Quản lý đơn hàng");
        labeltacvu.setFont(new Font("Segoe UI", Font.BOLD, 18));
        paneltacvu.add(labeltacvu);

        JPanel paneltimkiem = new JPanel();
        paneltimkiem.setPreferredSize(new Dimension(550, 40));
        paneltimkiem.setLayout(new FlowLayout(0, 5, 5));

        buttontimkiem = new JButton("Tìm kiếm");

        textfieldtimkiem = new JTextField(20);

        paneltimkiem.add(buttontimkiem);
        paneltimkiem.add(textfieldtimkiem);

        paneltop.add(paneltacvu);
        paneltop.add(paneltimkiem);

        // panel chứa các label và textfield
        panelcenter = new JPanel();
        panelcenter.setPreferredSize(new Dimension(950, 300));
        panelcenter.setBackground(Color.GREEN);
        panelcenter.setLayout(new BorderLayout());

        // panelleft chứa các thông tin của Đơn hàng
        JPanel panelleft = new JPanel();
        panelleft.setLayout(new BorderLayout());
        panelleft.setPreferredSize(new Dimension(400, 270));

        JPanel panellabel = new JPanel();
        panellabel.setPreferredSize(new Dimension(180, 260));
        panellabel.setLayout(new FlowLayout(0, 15, 30));

        labelmadonhang = new JLabel("Mã đơn hàng");
        labeltenkhachhang = new JLabel("Mã khách hàng");
        labeltennhanvien = new JLabel("Mã nhân viên thành toán");
        labelngaymua = new JLabel("Ngày mua hàng");
        labeltongtien = new JLabel("Tổng tiền thanh toán");

        panellabel.add(labelmadonhang);
        panellabel.add(labeltenkhachhang);
        panellabel.add(labeltennhanvien);
        panellabel.add(labelngaymua);
        panellabel.add(labeltongtien);

        JPanel paneltext = new JPanel();
        paneltext.setPreferredSize(new Dimension(220, 270));
        paneltext.setLayout(new FlowLayout(0, 15, 28));

        textfieldmadonhang = new JTextField(20);
        textfieldtenkhachhang = new JTextField(20);
        textfieldtennhanvien = new JTextField(20);
        textfieldngaymua = new JTextField(20);
        textfieldtongtien = new JTextField(20);

        paneltext.add(textfieldmadonhang);
        paneltext.add(textfieldtenkhachhang);
        paneltext.add(textfieldtennhanvien);
        paneltext.add(textfieldngaymua);
        paneltext.add(textfieldtongtien);


        panelleft.add(panellabel, BorderLayout.WEST);
        panelleft.add(paneltext, BorderLayout.EAST);
        // panelright chứa các thông tin của Chi tiết đơn hàng

        JPanel panelright = new JPanel();
        panelright.setLayout(new FlowLayout(0, 5, 5));

        panelcenter.add(panelleft, BorderLayout.WEST);
        panelcenter.add(panelright, BorderLayout.EAST);

        // panel chứa thông tin từ DAO
        panelbottom = new JPanel();
        panelbottom.setLayout(new BorderLayout());
        panelbottom.setPreferredSize(new Dimension(950, 400));
        
        model = new DefaultTableModel(new String[]{"Mã đơn hàng", "Mã khách hàng", "Mã nhân viên thanh toán", "Ngày mua hàng", "Tổng số tiền"}, 0) // 0 ở cuối cho biết chưa có dòng nào ban đầu   
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
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(250);

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

        panelbottom.add(scroll, BorderLayout.CENTER);
        
        add(paneltop, BorderLayout.NORTH);
        add(panelcenter, BorderLayout.CENTER);
        add(panelbottom, BorderLayout.SOUTH);

    }

    private void outModel(DefaultTableModel model, ArrayList<Don_Hang_Model> dh) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        table.clearSelection(); // Bỏ chọn tất cả dòng
        for (Don_Hang_Model n : dh) {
            data = new Vector();
            data.add(n.getMadonhang());
            data.add(n.getMakhachhang());
            data.add(n.getManhanvien());
            data.add(n.getNgaymua());
            data.add(n.getTongsotien());

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
        if (don_Hang_Service.getList() == null) {
            don_Hang_Service.list();
        }
        ArrayList<Don_Hang_Model> sp = don_Hang_Service.getList();
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

                textfieldmadonhang.setText(val0 != null ? val0.toString() : "");
                textfieldtenkhachhang.setText(val1 != null ? val1.toString() : "");
                textfieldtennhanvien.setText(val2 != null ? val2.toString() : "");
                textfieldngaymua.setText(val3 != null ? val3.toString() : "");
                textfieldtongtien.setText(val4 != null ? val4.toString() : "");
            }
        });
    }

    private void clearTextFields() {
        textfieldmadonhang.setText("");
        textfieldtenkhachhang.setText("");
        textfieldtennhanvien.setText("");
        textfieldngaymua.setText("");
        textfieldtongtien.setText("");
    }

}
