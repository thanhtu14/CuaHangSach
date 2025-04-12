package UI;

import java.awt.*;
import javax.swing.*;

public class Layout_UI extends JPanel {

    private JPanel panelTop, panelLeft, panelCenter;

    public static Color SETCOLOR = new Color(245, 246, 250);

    public Layout_UI(JPanel top, JPanel left, JPanel center) {
        this.panelTop = top;
        this.panelLeft = left;
        this.panelCenter = center;

        setPreferredSize(new Dimension(SignUp_SignIn_UI.LAYOUTWIDTH, SignUp_SignIn_UI.LAYOUTHEIGHT));
        initLayout();

    }

    private void initLayout() {
        this.setSize(SignUp_SignIn_UI.LAYOUTWIDTH, SignUp_SignIn_UI.LAYOUTHEIGHT);
        this.setLayout(new BorderLayout());

        // không thể tạo 1 đối tượng mới để truyền vào thay cho this vì khi đó sẽ có 1 Layout mới khác không phải layout đang chạy
        // panelCenter = new JPanel();
        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);

        this.setVisible(true);
    }

    // Phương thức để cập nhật nội dung panelCenter
    public void setPanelCenter(JPanel panel) {
        System.out.println("panel center");
        this.remove(panelCenter);  // Xóa panel hiện tại
        this.panelCenter = panel;
        this.add(panelCenter, BorderLayout.CENTER);
        this.revalidate(); // Cập nhật lại layout
        this.repaint();
       // SwingUtilities.updateComponentTreeUI(this); // Cập nhật toàn bộ giao diện

    }
    public void setPanelLeft(JPanel panel) {
        System.out.println("panle dieu huong");
        this.remove(panelLeft);  // Xóa panel hiện tại
        this.panelLeft = panel;
        this.add(panelLeft, BorderLayout.WEST);
        this.revalidate(); // Cập nhật lại layout
        this.repaint();
        //SwingUtilities.updateComponentTreeUI(this); // Cập nhật toàn bộ giao diện

    }

}
