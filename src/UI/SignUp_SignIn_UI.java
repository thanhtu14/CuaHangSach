package UI;

import SERVICE.Tai_Khoan_Service;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import SERVICE.RoundedPanel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class SignUp_SignIn_UI extends JPanel implements MouseListener {

    private Tai_Khoan_Service tk_service = new Tai_Khoan_Service();

    public static int LAYOUTWIDTH = 1200;
    public static int LAYOUTHEIGHT = 800;
    JButton buttonLog_in;
    private JPanel panelCenter, panelTop, panelBottom;
    private JLabel labelId, labelpasswd;
    JTextField textfieldId;
    JPasswordField password;
    private JLabel labelTieuDe, labelCancel;

    public static final int ngang = 350;
    public static final int doc = 450;

    public SignUp_SignIn_UI() {
        this.setPreferredSize(new Dimension(LAYOUTWIDTH, LAYOUTHEIGHT));

        initSignUp_SignIn();
    }

    public void initSignUp_SignIn() {
        Background_Image panel_background = new Background_Image("D:\\Lap_Trinh_Java\\Images\\background_login.jpg");
        // Panel chứa form đăng nhập

        panel_background.setLayout(new GridBagLayout());
        panel_background.setPreferredSize(new Dimension(LAYOUTWIDTH, LAYOUTHEIGHT));// cập nhật cho kích thước cho vì nó chứa những panel khác

        // Sử dụng GridBagConstraints để đặt panelChua vào giữa
        //GridBagConstraints là một lớp trong Java giúp định vị các thành phần (components)
        //bên trong GridBagLayout. Mỗi thành phần khi thêm vào GridBagLayout đều có một GridBagConstraints
        //để quy định cách nó hiển thị.
        GridBagConstraints gbc = new GridBagConstraints();// khởi tạo
        gbc.gridx = 0;//định cột đầu tiên cho panelChua ( cột 0)
        gbc.gridy = 0;// định hàng đầu tiên cho panelChua( hàng 0)
        gbc.weightx = 1;// cho phép panelChua mở rộng cheo chiều ngang
        gbc.weighty = 1;// cho phép panelChua mổ rộng theo chiều dọc
        gbc.anchor = GridBagConstraints.CENTER;// Căn giữa panelChua nằm giữa ô (0,0)    (CENTER, NORTH, SOUTH, EAST, WEST)

        // Panel chứa nội dung
        RoundedPanel panelChua = new RoundedPanel(40, Color.black, 3, new java.awt.Color(248, 239, 186));
        panelChua.setLayout(new BorderLayout());
        panelChua.setPreferredSize(new Dimension(ngang, doc));

        // Các panel con bên trong panelChua
        panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(ngang, 50));
        panelTop.setOpaque(false);// cho phép hiện màu nên bên dưới
        labelTieuDe = new JLabel("WELCOME");
        labelTieuDe.setFont(new Font(" Arial", Font.BOLD, 25));
        panelTop.add(labelTieuDe);

        panelCenter = new JPanel();
        panelCenter.setPreferredSize(new Dimension(ngang, 300));
        panelCenter.setOpaque(false);
        panelCenter.setLayout(new GridBagLayout());

        RoundedPanel conten = new RoundedPanel(30, Color.black, 2, Color.yellow);
        conten.setPreferredSize(new Dimension(300, 200));
        conten.setLayout(new FlowLayout(1, 10, 50));

        labelId = new JLabel("ID");
        labelId.setPreferredSize(new Dimension(60, 20));

        textfieldId = new JTextField(20);

        labelpasswd = new JLabel("Password");
        labelpasswd.setPreferredSize(new Dimension(60, 20));

        password = new JPasswordField(20);

        conten.add(labelId);
        conten.add(textfieldId);
        conten.add(labelpasswd);
        conten.add(password);

        panelCenter.add(conten, gbc);

        panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(ngang, 100));
        panelBottom.setLayout(new FlowLayout(1, 5, 5));
        panelBottom.setOpaque(false);

        buttonLog_in = new JButton("LogIn");
        buttonLog_in.setPreferredSize(new Dimension(270, 50));
        buttonLog_in.setBackground(Color.white);
        buttonLog_in.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        buttonLog_in.setFocusPainted(false);
        buttonLog_in.addMouseListener(this);

        labelCancel = new JLabel("Cancel",SwingConstants.CENTER);
        labelCancel.setPreferredSize(new Dimension(100, 40));
        labelCancel.setForeground(Color.blue);
        labelCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Đổi con trỏ khi di chuột lên JLabel
        labelCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);                // Hành động khi JLabel được click
                JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(labelCancel), "JLabel clicked!");
            }
        });
        panelBottom.add(buttonLog_in);
        panelBottom.add(labelCancel);

        // Thêm các panel con vào panelChua
        panelChua.add(panelTop, BorderLayout.NORTH);
        panelChua.add(panelCenter, BorderLayout.CENTER);
        panelChua.add(panelBottom, BorderLayout.SOUTH);

        panel_background.add(panelChua, gbc);// add vào

        this.add(panel_background);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.yellow);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.blue);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.yellow);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.white);
    }

}
