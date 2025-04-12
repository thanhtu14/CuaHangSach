/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import SERVICE.Nhan_Vien_Sercive;
import MODEL.Nhan_Vien_Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import SERVICE.Tai_Khoan_Service;
//import javax.swing.border.LineBorder;

/**
 *
 * @author tuntt
 */
public class Nhan_Vien_UI extends JPanel implements ActionListener, MouseListener {
    //private JLabel labelId, labelTen, labelGioitinh, labelNgaysinh, labelSDT, labelDiachi, labelMail, labelLuong, labelNgayvaolam;

    private JTextField textfieldId, textfieldTen, textfieldGioitinh, textfieldNgaysinh, textfieldSDT, textfieldDiachi, textfieldEmail, textfieldLuong, textfieldNgayvaolam, textfieldchucvu;
    private JButton buttonAdd, buttonDelete, buttonFix, buttonSearch, buttonSelect = null;
    private JLabel labelPhoto;
    private JTable table;
    private DefaultTableModel tablemodel;
    private JScrollPane scrollpane;

    private Nhan_Vien_Sercive nhan_Vien_Sercive = new Nhan_Vien_Sercive();
    private Tai_Khoan_Service tai_Khoan_Service = new Tai_Khoan_Service();

    private String maquyen;
    private String machucnang;

    private static final Color ColorButton = Color.PINK;
    private static final Color ColorSelected = Color.orange;

    public Nhan_Vien_UI(String maquyen, String machucnang) {

        this.maquyen = maquyen;
        this.machucnang = machucnang;

        setPreferredSize(new Dimension(950, 720));
        setLayout(new BorderLayout());
        init_Nhan_Vien_UI();

    }

    private void init_Nhan_Vien_UI() {

        JPanel panelTop = new JPanel();
        //panelTop.setPreferredSize(new Dimension(950, 50));
        panelTop.setBackground(new java.awt.Color(53, 59, 72));
        panelTop.setOpaque(true);
        panelTop.setLayout(new FlowLayout(1, 10, 5));

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

        JPanel panelcenter = new JPanel();
        panelcenter.setPreferredSize(new Dimension(950, 300));
        panelcenter.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        panelcenter.setLayout(new BorderLayout());

        //Ảnh 
        JPanel panelLeft = new JPanel();
        labelPhoto = new JLabel("Ảnh nhân viên");
        panelLeft.setPreferredSize(new Dimension(300, 300));
        panelLeft.add(labelPhoto);
        panelLeft.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.black));// đặt viền đen , 2px cho right

        this.add(panelLeft, BorderLayout.WEST);

        JPanel panelRight = new JPanel();
        panelRight.setPreferredSize(new Dimension(60, 300));
        panelRight.setLayout(new GridLayout(10, 2, 5, 5));
        //panelRight.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.black));

        String[] labels = {" Mã nhân viên ", " Tên nhân viên ", " Giới tính ", " Số điện thoại ", " Địa chỉ ", " Ngày sinh ", " Email ", " Ngày vào làm ", " Lương ", "Chức vụ"};
        JTextField[] fields = new JTextField[10];
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setHorizontalAlignment(SwingConstants.CENTER);         // Đảm bảo căn giữa cho các label
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

        panelcenter.add(panelLeft, BorderLayout.WEST);
        panelcenter.add(panelRight, BorderLayout.CENTER);

        this.add(panelcenter, BorderLayout.CENTER);// căn giữa

        // phần bảng nội dung hiện bên dưới 
        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new BorderLayout());
        panelBottom.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        tablemodel = new DefaultTableModel(new String[]{"Ảnh", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Số điện thoại", "Địa chỉ", "Ngày sinh", "Email", "Ngày vào làm", "Lương", "Chức vụ"}, 11) // 0 ở cuối cho biết chưa có dòng nào ban đầu   
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chỉnh sửa nội dung toàn bộ bảng
            }
        };

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(tablemodel);
        table = new JTable(tablemodel);
        table.getTableHeader().setReorderingAllowed(false);// làm cho bảng không thể chuyển đổi giữa các cột trong bảng

        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(100);
        table.getColumnModel().getColumn(9).setPreferredWidth(100);
        table.getColumnModel().getColumn(10).setPreferredWidth(100);

        table.setRowSorter(rowSorter);// bộ sắp xếp
        rowSorter.setSortable(0, false);// không cho sắp xếp cột 0 (ảnh)
        rowSorter.setSortable(1, true);//  cho sắp xếp cột 1 (ma)
        rowSorter.setSortable(2, true);//  cho sắp xếp cột 2 (tên)
        rowSorter.setSortable(3, false);// không cho sắp xếp cột 3 (giói tính)
        rowSorter.setSortable(4, false);// không cho sắp xếp cột 4 (sdt)
        rowSorter.setSortable(5, false);// không cho sắp xếp cột 5 (địa chỉ)
        rowSorter.setSortable(6, false);// không cho sắp xếp cột 6 (ngày sinh)
        rowSorter.setSortable(7, false);// không cho sắp xếp cột 7 (email)
        rowSorter.setSortable(8, false);// không cho sắp xếp cột 8 (ngày vào làm)
        rowSorter.setSortable(9, true);//  cho sắp xếp cột 9(lương)
        rowSorter.setSortable(10, false);// không cho sắp xếp cột 10 (mã chức vụ)

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

    private void ResetColor() {
        if (buttonAdd != null) {
            buttonAdd.setBackground(ColorButton);
        }
        if (buttonFix != null) {
            buttonFix.setBackground(ColorButton);
        }
        if (buttonDelete != null) {
            buttonDelete.setBackground(ColorButton);
        }
        if (buttonSearch != null) {
            buttonSearch.setBackground(ColorButton);
        }
    }

    private void outModel(DefaultTableModel model, ArrayList<Nhan_Vien_Model> kh) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        table.clearSelection(); // Bỏ chọn tất cả dòng
        for (Nhan_Vien_Model n : kh) {
            data = new Vector();
            data.add(n.getAnhnhanvien());
            data.add(n.getManhanvien());
            data.add(n.getTennhanvien());
            data.add(n.getGioitinhnhanvien());
            data.add(n.getNgaysinhnhanvien());
            data.add(n.getSdtnhanvien());
            data.add(n.getDiachinhanvien());
            data.add(n.getEmailnhanvien());
            data.add(n.getNgayvaolamnhanvien());
            data.add(n.getLuongnhanvien());
            data.add(n.getMachucvunhanvien());

            model.addRow(data);
        }
        //model.fireTableDataChanged();
        table.setModel(model);
    }

    @Override
    public void list() // Chép ArrayList lên table
    {
        tablemodel.setRowCount(0);
        //model.fireTableDataChanged();  
        if (nhan_Vien_Sercive.getList() == null) {
            nhan_Vien_Sercive.list();
        }
        ArrayList<Nhan_Vien_Model> nv = nhan_Vien_Sercive.getList();
        outModel(tablemodel, nv);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelect) {
            button.setBackground(ColorButton);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelect) {
            button.setBackground(ColorButton);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelect) {
            button.setBackground(new Color(255, 51, 51));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button != buttonSelect) {
            button.setBackground(ColorButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        ResetColor();
        button.setBackground(ColorSelected);
        buttonSelect = button;
        if (button == buttonAdd) {
            System.out.println("chon them nhan vien");
        } else if (button == buttonFix) {
            System.out.println("chon sua nhan vien");
        } else if (button == buttonDelete) {
            System.out.println("chon xoa nhan vien");
        } else {
            System.out.println("chon tim kiem nhan vien");
        }

    }

}
