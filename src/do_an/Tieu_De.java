package do_an;

import java.awt.*;
import javax.swing.*;

public class Tieu_De extends JPanel {

    private JLabel labelLogo, labelSearch;
    private JButton buttonSignUp, buttonSignIn, buttonMinimize, buttonMaximize, buttonClose;
    private JTextField textfieldSearch;

    public Tieu_De() {
        setPreferredSize(new Dimension(1200, 80));
        setLayout(new BorderLayout());
        setBackground(new java.awt.Color(210, 218, 226));

        initComponents();
    }

    private void initComponents() {
        // Panel trái chứa Logo + Search
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setOpaque(false);

        // Logo
        JPanel panelLogo = new JPanel();
        panelLogo.setPreferredSize(new Dimension(200, 80));
        panelLogo.setBackground(new java.awt.Color(210, 218, 226));
        ImageIcon logoIcon = new ImageIcon("D:\\Lap_Trinh_Java\\images\\logo1.png");
        Image img = logoIcon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH); // Resize ảnh, width = 100px, height = 80px
        labelLogo = new JLabel(new ImageIcon(img));                                     // Image.SCALE_SMOOTH: làm mịn hình ảnh sau chỉnh sửa
        panelLogo.add(labelLogo);

        // Search
        JPanel panelSearch = new JPanel();
        panelSearch.setPreferredSize(new Dimension(300, 80));
        panelSearch.setBackground(new java.awt.Color(210, 218, 226));
        labelSearch = new JLabel("SEARCH");
        textfieldSearch = new JTextField(20);
        panelSearch.add(labelSearch);
        panelSearch.add(textfieldSearch);

        leftPanel.add(panelLogo, BorderLayout.WEST);
        leftPanel.add(panelSearch, BorderLayout.EAST);

        // Panel phải chứa Sign In + Close, Min, Max
        JPanel rightPanel = new JPanel(new BorderLayout(80, 500));
        rightPanel.setOpaque(false);

        // Sign In - Sign Up
        JPanel panelSign = new JPanel();
        panelSign.setPreferredSize(new Dimension(200, 80));
        panelSign.setOpaque(false);
        buttonSignUp = new JButton("Sign Up");
        buttonSignUp.setBackground(new java.awt.Color(255, 255, 255));
        buttonSignUp.setLayout(new FlowLayout(1, 5, 5));
        buttonSignUp.setPreferredSize(new Dimension(90, 40));
        buttonSignIn = new JButton("Sign In");
        buttonSignIn.setBackground(new java.awt.Color(255, 255, 255));
        buttonSignIn.setPreferredSize(new Dimension(90, 40));
        panelSign.add(buttonSignUp);
        panelSign.add(buttonSignIn);

        // Close, Min, Max buttons
        ImageIcon iconclose = new ImageIcon("D:\\Lap_Trinh_Java\\images\\close1.png");
        Image imgclose = iconclose.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        ImageIcon iconmax = new ImageIcon("D:\\Lap_Trinh_Java\\images\\maximize1.png");
        Image imgmax = iconmax.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Resize ảnh, width = 20px, height = 20px

        ImageIcon iconmin = new ImageIcon("D:\\Lap_Trinh_Java\\images\\minimize1.png");
        Image imgmin = iconmin.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        JPanel panelControls = new JPanel();
        panelControls.setPreferredSize(new Dimension(200, 80));
        panelControls.setOpaque(false);
        buttonClose = new JButton(new ImageIcon(imgclose));
        buttonMaximize = new JButton(new ImageIcon(imgmax));
        buttonMinimize = new JButton(new ImageIcon(imgmin));
        
        buttonMinimize.setBackground(new java.awt.Color(255, 255, 255));
        buttonMinimize.setFocusPainted(false);
        buttonMinimize.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (parentFrame != null) {
                parentFrame.setState(JFrame.ICONIFIED);
            }
        });
        
        buttonMaximize.setBackground(new java.awt.Color(255, 255, 255));
        buttonMaximize.setFocusPainted(false);
        buttonMaximize.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (parentFrame != null) {
                if (parentFrame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    parentFrame.setExtendedState(JFrame.NORMAL);
                } else {
                    parentFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        });
        
        buttonClose.setBackground(new java.awt.Color(235, 59, 90));
        buttonClose.setFocusPainted(false);
        buttonClose.addActionListener(e -> System.exit(0));

        panelControls.add(buttonMinimize);
        panelControls.add(buttonMaximize);
        panelControls.add(buttonClose);

        rightPanel.add(panelSign, BorderLayout.WEST);
        rightPanel.add(panelControls, BorderLayout.EAST);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }
}
