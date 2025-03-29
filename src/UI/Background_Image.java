/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author tuntt
 */
public class Background_Image extends JPanel {
    private Image background_image;
    
    public Background_Image( String image){
        background_image = new ImageIcon(image).getImage();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
    // Chuyển sang Graphics2D để vẽ ảnh sắc nét hơn
    Graphics2D g2d = (Graphics2D) g;
    
    // Bật chế độ khử răng cưa (Anti-aliasing) để ảnh không bị mờ
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    // Vẽ ảnh với kích thước tương ứng với JPanel
    g2d.drawImage(background_image, 0, 0, getWidth(), getHeight(), this);
    }
}
