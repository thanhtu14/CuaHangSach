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

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void setLayout_UI(JPanel top, JPanel left) {
        this.removeAll();// xóa tất cả 

        this.add(top, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        //this.add(panelCenter, BorderLayout.CENTER);

        this.revalidate(); // Cập nhật lại layout
        this.repaint();
    }
    // Phương thức để cập nhật nội dung panelCenter

    public void setPanelCenter(JPanel panel) {
        this.remove(panelCenter);  // Xóa panel hiện tại
        panelCenter = panel;
        this.add(panelCenter, BorderLayout.CENTER);
        this.revalidate(); // Cập nhật lại layout
        this.repaint();
    }

    
}
