package UI;
//CÁCH 1 : DÙNG CARDLAYOUT ĐỂ THỰC HIỆN THAY ĐỔI GIAO DIỆN KHI ĐĂNG NHẬP
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import SERVICE.Tai_Khoan_Service;
//
//public class Main extends JFrame implements ActionListener {
//    
//    private Tai_Khoan_Service tk_service = new Tai_Khoan_Service();
//    private SignUp_SignIn_UI signUpSignInUI;
//    private JPanel mainPanel;
//    private CardLayout cardLayout;
//
//    public Main() {
//        setUndecorated(true);
//        setSize(1200, 800);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        cardLayout = new CardLayout();
//        mainPanel = new JPanel(cardLayout);
//
//        signUpSignInUI = new SignUp_SignIn_UI();
//        signUpSignInUI.buttonLog_in.addActionListener(this); // Lắng nghe sự kiện
//
//        mainPanel.add(signUpSignInUI, "login");
//
//        add(mainPanel);
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (signUpSignInUI.textfieldId.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID đăng nhập !", "Lỗi", JOptionPane.WARNING_MESSAGE);
//            signUpSignInUI.textfieldId.requestFocus();// forcus lại ô nhập ID
//            return;
//        }qlqlqq
//        if (signUpSignInUI.password.getPassword().length == 0) {
//            JOptionPane.showMessageDialog(null, " Vui lòng nhập password !", "Lỗi", JOptionPane.WARNING_MESSAGE);
//            signUpSignInUI.password.requestFocus();
//            return;
//        }
//        if (e.getSource() == signUpSignInUI.buttonLog_in) {
//            String id = signUpSignInUI.textfieldId.getText();
//            String pass = new String(signUpSignInUI.password.getPassword());
//
//            if (tk_service.getPassword(id) != null) {
//                // Tạo layout mới
//                JPanel topPanel = new Tieu_De_UI();
//                JPanel leftPanel;
//                JPanel centerPanel = new JPanel();
//
//                if (tk_service.getMachucvu(id).equals("QL")) {
//                    leftPanel = new Dieu_Huong_Quan_Ly_UI();
//                } else if (tk_service.getMachucvu(id).equals("BH")) {
//                    leftPanel = new Dieu_Huong_Ban_Hang_UI();
//                } else {
//                    leftPanel = new Dieu_Huong_Kho_UI();
//
//                }
//
//                JPanel mainLayout = new JPanel(new BorderLayout());
//                mainLayout.add(topPanel, BorderLayout.NORTH);
//                mainLayout.add(leftPanel, BorderLayout.WEST);
//                mainLayout.add(centerPanel, BorderLayout.CENTER);
//
//                mainPanel.add(mainLayout, "mainLayout");
//                cardLayout.show(mainPanel, "mainLayout");
//            } else {
//                JOptionPane.showMessageDialog(this, "ID hoặc mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new Main();
//    }
//}

// CÁCH 2: THỰC HIỆN VIỆC DÙNG HÀM VÀ DÙNG LỆNH SwingUtilities.invokeLater(Main::new) ĐỂ THAY ĐỔI GIAO DIỆN KHI ĐĂNG NHẬP
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import SERVICE.Tai_Khoan_Service;
import java.util.ArrayList;
import SERVICE.Chuc_Nang_Sevice;

public class Main_UI implements ActionListener {

    private Tai_Khoan_Service tk_service = new Tai_Khoan_Service();

    private JFrame frame;
    private SignUp_SignIn_UI sign;
    private Layout_UI layout;

    public Main_UI() {
        frame = new JFrame("Login Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);

        sign = new SignUp_SignIn_UI();
        frame.add(sign, BorderLayout.CENTER);

        // Đăng ký ActionListener đúng cách
        sign.buttonLog_in.addActionListener(this);

        frame.setVisible(true); // Đảm bảo frame hiển thị
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Ghi đè phương thức actionPerformed
        if (sign.textfieldId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID đăng nhập !", "Lỗi", JOptionPane.WARNING_MESSAGE);
            sign.textfieldId.requestFocus(); // Focus lại ô nhập ID
            return;
        }
        if (sign.password.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập password !", "Lỗi", JOptionPane.WARNING_MESSAGE);
            sign.password.requestFocus();
            return;
        }
        
        Chuc_Nang_Sevice chuc_Nang_Sevice = new Chuc_Nang_Sevice();
        ArrayList<String> ds_ma_chuc_nang = new ArrayList<>();
        ds_ma_chuc_nang = chuc_Nang_Sevice.so_luong_chuc_nang();// dùng để chứa danh sách các mã chức năng của cả hệ thống
        
        if (e.getSource() == sign.buttonLog_in) {
            String id = sign.textfieldId.getText();
            String pass = new String(sign.password.getPassword());

            if (tk_service.kiem_tra_mat_khau(id, pass) == true) {
                String ma_quyen = tk_service.ma_quyen(id);// là mã quyền của người đăng nhập vào

                Tai_Khoan_Service tk = new Tai_Khoan_Service();
                ArrayList<String> chuc_nang = new ArrayList<>();
                chuc_nang = tk.Ten_chuc_nang(ma_quyen);// dùng để chứa tên các chức năng của người đăng nhập
                ArrayList<String> ma_chuc_nang = new ArrayList<>();
                ma_chuc_nang= tk.Ma_chuc_nang(ma_quyen);// dùng để chứa danh sách các mã chức năng của mã quyền đang đăng nhập
               
                
                JPanel topPanel = new Tieu_De_UI();
                JPanel leftPanel = new JPanel();
                JPanel centerPanel = new JPanel();
                
                layout = new Layout_UI(topPanel, leftPanel, centerPanel); // Khởi tạo trước, nhưng chưa có leftPanel

                leftPanel = new Dieu_Huong_UI(this, layout, chuc_nang, ma_chuc_nang, ma_quyen,ds_ma_chuc_nang);

                layout.setPanelLeft(leftPanel);

                chuyen_sign_layout(layout);

            } else {
                JOptionPane.showMessageDialog(frame, "ID hoặc mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void reset_sign() {
        // Xóa nội dung của JTextField
        sign.textfieldId.setText("");
        sign.password.setText("");

        // Nếu muốn thay đổi trạng thái của JButton, bạn có thể thay đổi màu sắc hoặc trạng thái hiển thị
        sign.buttonLog_in.setBackground(Color.white);

    }

    private void chuyen_sign_layout(JPanel panelLayout) {
        // Xóa panel hiện tại và thêm panel làm việc
        frame.getContentPane().removeAll();
        frame.add(panelLayout, BorderLayout.CENTER);
        frame.revalidate(); // Cập nhật layout
        frame.repaint(); // Vẽ lại frame
    }

    public void chuyen_layout_sign() {
        // Xóa panel hiện tại và thêm panel đăng nhập
        frame.getContentPane().removeAll();
        reset_sign();
        frame.add(sign, BorderLayout.CENTER);
        frame.revalidate(); // Cập nhật layout
        frame.repaint(); // Vẽ lại frame
    }

    public static void main(String[] args) {
        new Main_UI();
    }
}
