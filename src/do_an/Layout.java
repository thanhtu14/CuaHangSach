package do_an;

import java.awt.*;
import javax.swing.*;

public class Layout extends JPanel {

    private JPanel panelTop, panelLeft, panelCenter;
    
    public static Color SETCOLOR = new Color(245, 246, 250);
    public Layout( ) {
        initLayout();
    }

    private void initLayout() {
        this.setSize(SignUp_SignIn.LAYOUTWIDTH, SignUp_SignIn.LAYOUTHEIGHT);    
        this.setLayout(new BorderLayout());
//        this.setLocationRelativeTo(null);
 //       this.setUndecorated(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelTop = new Tieu_De();
        panelLeft = new Dieu_Huong(this);// sử dụng this để truyền layout vào Dieu_Huong( this là đối tượng hiện hành của class)
        panelCenter = new JPanel();      // không thể tạo 1 đối tượng mới để truyền vào thay cho this vì khi đó sẽ có 1 Layout mới khác không phải layout đang chạy

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);

        this.setVisible(true);
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
