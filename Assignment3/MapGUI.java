/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kelas yang mepresentasikan panel map
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class MapGUI extends JPanel {
    private Map map;

    public MapGUI(Map map) {
        this.map = map;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    System.out.println(e.getX() + " " + e.getY());
                }
                if (SwingUtilities.isRightMouseButton(e)) {

                }
            }
        });
    }

    /**
     * Mewarnai panel dengan map dari map.txt
     * @param g grafik
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //MEMBUAT PAINT DARI MAP OWJEK
        for (int row = 0; row < Map.HEIGHT; row++) {
            for (int col = 0; col < Map.WIDTH; col++) {
                Color color;
                if (map.get(row, col) == '#')
                    color = Color.BLACK;
                else if (map.get(row, col) == '.')
                    color = Color.WHITE;
                else if (map.get(row, col) == 'S')
                    color = Color.BLUE;
                else if (map.get(row, col) == 'F')
                    color = Color.RED;
                else
                    color = Color.GREEN;
                g2d.setColor(color);
                g2d.fillRect(10 * col, 10 * row, 10, 10);
            }
        }
    }

    public void setMap(Map map) {
        this.map = map;
    }
}