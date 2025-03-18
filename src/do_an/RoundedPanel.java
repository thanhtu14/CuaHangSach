package do_an;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private int radius; // Bán kính bo tròn
    private Color borderColor;
    private Color backgroundColor;
    private int strokeWidth; // Độ dày viền

    // Constructor: nhận bán kính, màu viền và độ dày viền
    public RoundedPanel(int radius, Color borderColor, int strokeWidth, Color bgColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.strokeWidth = strokeWidth;
        setOpaque(false); // Để có thể vẽ nền bo tròn
        setBackground(bgColor); // Màu nền tùy chỉnh
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ nền bo tròn
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(strokeWidth));

        // Vẽ viền bo tròn
        int offset = strokeWidth / 2;
        g2.drawRoundRect(offset, offset, getWidth() - strokeWidth, getHeight() - strokeWidth, radius, radius);
        
        g2.dispose();
    }

    
}
