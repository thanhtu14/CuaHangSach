package do_an;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.util.Arrays;

public class SignUp_SignIn extends JFrame implements ActionListener, MouseListener {

    public static int LAYOUTWIDTH = 1200;
    public static int LAYOUTHEIGHT = 800;
    private JButton buttonLog_in;
    private JPanel panelCenter, panelTop, panelBottom;
    private JLabel labelId, labelpasswd;
    private JTextField textfieldId;
    private JPasswordField password;
    private JLabel labelTieuDe, labelQuenMatKhau;

    public static final int ngang = 350;
    public static final int doc = 450;

    public SignUp_SignIn() {
        setSize(LAYOUTWIDTH, LAYOUTHEIGHT);
        this.setLocationRelativeTo(null);
        this.setUndecorated(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initSignUp_SignIn();
    }

    private boolean CheckPassword(String Id, char[] Password) {
        Connection c = (Connection) JDBC.getJDBCConnection();
        String query = " SELECT ql.maquanly, tkql.matkhauquanly"
                + " FROM quanly ql"
                + " LEFT JOIN taikhoanquanly tkql ON ql.maquanly = tkql.tentaikhoanquanly "
                + " WHERE ql.maquanly = ?";// ? là 1 tham số động, cho phép có thể truền vào khi thực hiện chạy câu truy vấn 
        try {
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, Id);// truyền Id người đăng nhập vào trong câu lệnh để thực hiện truy vấn 
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String passwordDatabase = rs.getString("matkhauquanly");// lấy mật khẩu của người dùng trong database
                if (passwordDatabase != null && passwordDatabase.equals(new String(Password))) {
                    // không thể dùng (String) để ép kiểu trực tiếp vì 
                    // Password là 1 mảng kí tự, nhưng có thể dùng new String vì
                    // nó tạo 1 chuỗi mới từ mảng kí tự kiểu char                                                                                               
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void initSignUp_SignIn() {
        // Panel chứa form đăng nhập
        JPanel panel = new JPanel(new GridBagLayout()); // GridBagLayout giống GridLayout nhưng có thể tùy chỉnh co giãn cho từng ô
        panel.setBackground(Color.gray);

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
        RoundedPanel panelChua = new RoundedPanel(40, Color.black, 3, Color.green);
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
        textfieldId.addActionListener(this);

        labelpasswd = new JLabel("Password");
        labelpasswd.setPreferredSize(new Dimension(60, 20));

        password = new JPasswordField(20);
        password.addActionListener(this);

        conten.add(labelId);
        conten.add(textfieldId);
        conten.add(labelpasswd);
        conten.add(password);

        panelCenter.add(conten, gbc);

        panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(ngang, 100));
        panelBottom.setLayout(new FlowLayout(1, 5, 5));
        panelBottom.setOpaque(false);

        buttonLog_in = new JButton("Log in");
        buttonLog_in.setPreferredSize(new Dimension(250, 50));
        buttonLog_in.setBackground(Color.white);
        buttonLog_in.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        buttonLog_in.setFocusPainted(false);
        buttonLog_in.addActionListener(this);
        buttonLog_in.addMouseListener(this);

        labelQuenMatKhau = new JLabel("Quên mật khẩu");
        labelQuenMatKhau.setPreferredSize(new Dimension(100, 40));
        labelQuenMatKhau.setForeground(Color.blue);
        panelBottom.add(buttonLog_in);
        panelBottom.add(labelQuenMatKhau);

        // Thêm các panel con vào panelChua
        panelChua.add(panelTop, BorderLayout.NORTH);
        panelChua.add(panelCenter, BorderLayout.CENTER);
        panelChua.add(panelBottom, BorderLayout.SOUTH);

        panel.add(panelChua, gbc);// add vào
        this.setLayout(new BorderLayout()); // Đảm bảo SignUp_SignIn sử dụng BorderLayout
        this.add(panel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    // tháy đổi Panel khi đăng nhập cho từng vị trí
    public void setPanel(JPanel panel) {
        this.remove(panelCenter);  // Xóa panel hiện tại
        panelCenter = panel;
        this.add(panelCenter);
        this.revalidate(); // Cập nhật lại layout
        this.repaint();
    }

    public static void main(String[] args) {

        SignUp_SignIn s = new SignUp_SignIn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (textfieldId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID đăng nhập !", "Lỗi", JOptionPane.WARNING_MESSAGE);
            textfieldId.requestFocus();// forcus lại ô nhập ID
            return;
        }
        if (password.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập password !", "Lỗi", JOptionPane.WARNING_MESSAGE);
            password.requestFocus();
            return;
        }
        String id = textfieldId.getText();
        char[] ps = this.password.getPassword();

        if (e.getSource() == buttonLog_in) {
            if (CheckPassword(id, ps)) {
                // Đóng cửa sổ hiện tại
                this.dispose(); // Đóng cửa sổ đăng nhập

                // Mở cửa sổ mới chứa Layout
                JFrame layoutFrame = new JFrame();
                layoutFrame.setSize(LAYOUTWIDTH, LAYOUTHEIGHT);
                layoutFrame.setUndecorated(true);
                layoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                layoutFrame.setLocationRelativeTo(null);

                Layout layout = new Layout();
                layoutFrame.add(layout);

                layoutFrame.setVisible(true); // Hiển thị cửa sổ mới
            } else {
                JOptionPane.showMessageDialog(this, "ID hoặc mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
