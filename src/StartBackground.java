import javax.swing.*;
import java.awt.*;

public class StartBackground extends JComponent{

    private static final Color backgroundColor = new Color(139, 131, 134);

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.setFont(new Font("Default", Font.PLAIN, 20));

        g2D.setColor(backgroundColor);
        g2D.fillRect(0, 0, 800, 600);
        g2D.setColor(Color.white);
        g2D.drawString("Start", 400,300);
    }
}

