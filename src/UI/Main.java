package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import SERVICE.Tai_Khoan_Service;

public class Main extends JFrame implements ActionListener {

    private Tai_Khoan_Service tk_service = new Tai_Khoan_Service();
    private SignUp_SignIn_UI signUpSignInUI;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public Main() {
        setUndecorated(true);
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        signUpSignInUI = new SignUp_SignIn_UI();
        signUpSignInUI.buttonLog_in.addActionListener(this); // Lắng nghe sự kiện

        mainPanel.add(signUpSignInUI, "login");

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (signUpSignInUI.textfieldId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID đăng nhập !", "Lỗi", JOptionPane.WARNING_MESSAGE);
            signUpSignInUI.textfieldId.requestFocus();// forcus lại ô nhập ID
            return;
        }
        if (signUpSignInUI.password.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập password !", "Lỗi", JOptionPane.WARNING_MESSAGE);
            signUpSignInUI.password.requestFocus();
            return;
        }
        if (e.getSource() == signUpSignInUI.buttonLog_in) {
            String id = signUpSignInUI.textfieldId.getText();
            String pass = new String(signUpSignInUI.password.getPassword());

            if (tk_service.getPassword(id) != null) {
                // Tạo layout mới
                JPanel topPanel = new Tieu_De_UI();
                JPanel leftPanel;
                JPanel centerPanel = new JPanel();

                if (tk_service.getMachucvu(id).equals("QL")) {
                    leftPanel = new Dieu_Huong_Quan_Ly_UI();
                } else if (tk_service.getMachucvu(id).equals("BH")) {
                    leftPanel = new Dieu_Huong_Ban_Hang_UI();
                } else {
                    leftPanel = new Dieu_Huong_Kho_UI();

                }

                JPanel mainLayout = new JPanel(new BorderLayout());
                mainLayout.add(topPanel, BorderLayout.NORTH);
                mainLayout.add(leftPanel, BorderLayout.WEST);
                mainLayout.add(centerPanel, BorderLayout.CENTER);

                mainPanel.add(mainLayout, "mainLayout");
                cardLayout.show(mainPanel, "mainLayout");
            } else {
                JOptionPane.showMessageDialog(this, "ID hoặc mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
