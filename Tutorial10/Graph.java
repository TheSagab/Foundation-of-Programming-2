import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by ASUS on 5/10/2017.
 */
public class Graph extends JPanel {
    private Function fx;
    private Function dx;

    public Graph(Function fx, Function dx) {
        this.fx = fx;
        this.dx = dx;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 600, 600);
        final int X_SCALE = 3;
        final int Y_SCALE = (int) Math.pow(10, fx.getYScale());
        for (int i = -500; i <= 500; i++) {
            g2d.setColor(Color.RED);
            g2d.fillOval(i*X_SCALE + 300, (-fx.getY(i)*X_SCALE / Y_SCALE + 300), 5, 5);
            g2d.setColor(Color.BLUE);
            g2d.fillOval(i*X_SCALE + 300, (-dx.getY(i)*X_SCALE / Y_SCALE + 300), 5, 5);
        }
    }
}
