/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Kelas yang berisi main method untuk dijalankan
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setSize(1400, 550);
        //gui.pack();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setResizable(false);
    }
}
