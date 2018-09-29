/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Kelas yang mepresentasikan frame GUI Owjek
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class GUI extends JFrame{
    private JRadioButton regularButton;
    private JRadioButton sportyButton;
    private JRadioButton exclusiveButton;
    private JTextField fromField;
    private JTextField toField;
    private JButton goButton;
    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel owjekLabel;
    private JTextArea infoText;
    private MapGUI mapGUI;
    private Owjek ojek;
    private Map map;

    public GUI(){
        super("Owjek");
        map = new Map();
        mapGUI = new MapGUI(map);
        JPanel controlPanel = createControlPanel();
        add(controlPanel, BorderLayout.WEST);
        add(mapGUI, BorderLayout.CENTER);
    }

    /**
     * Membuat panel berisi gambar logo
     * @return panel gambar
     */
    JPanel insertPicture() {
        try {
            JPanel panel = new JPanel();
            BufferedImage myPicture = ImageIO.read(new File("assets/owjek2.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            panel.add(picLabel);
            return panel;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Membuat panel berisi kotak teks info
     * @return panel berisi kotak teks info
     */
    JPanel createInfoBox(){
        infoText = new JTextArea("Owjek App\nVersion 1.0\nCopyright © 2017 TheSagab. All rights reserved       \n\n\n\n");
        infoText.setEditable(false);
        infoText.setBorder(BorderFactory.createTitledBorder("Information"));
        infoText.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JPanel panel = new JPanel();
        panel.add(infoText);
        return panel;
    }

    /**
     * Membuat panel berisi control panel
     * @return panel
     */
    JPanel createControlPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        panel.add(insertPicture(), g);
        g.gridx = 0;
        g.gridy = 1;
        g.gridheight = 3;
        panel.add(createMenu(), g);
        g.gridx = 0;
        g.gridy = 4;
        g.gridheight = 2;
        panel.add(createInfoBox(), g);
        return panel;
    }

    /**
     * Membuat panel berisi menu input
     * @return panel gambar
     */
    JPanel createMenu(){
        regularButton = new JRadioButton("Regular");
        sportyButton = new JRadioButton("Sporty");
        exclusiveButton = new JRadioButton("Exclusive");
        regularButton.setSelected(true);

        owjekLabel = new JLabel("Owjek Type: ");
        ButtonGroup group = new ButtonGroup();
        group.add(regularButton);
        group.add(sportyButton);
        group.add(exclusiveButton);

        fromField = new JTextField(20);
        toField = new JTextField(20);

        fromLabel = new JLabel("From: ");
        toLabel = new JLabel("To: ");

        goButton = new JButton("Go!");
        // Action listener untuk memulai perjalanan
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map = Pathfinding.getMap();
                if(regularButton.isSelected())
                    ojek = new OwjekRegular(2014, 100, 250);
                if(sportyButton.isSelected())
                    ojek = new OwjekSporty(2016, 140, 300);
                if(exclusiveButton.isSelected())
                    ojek = new OwjekExclusive(2016, 180, 500);
                String from = fromField.getText();
                String to = toField.getText();
                int dist = Pathfinding.calculateDistance(from, to);
                if(dist == -1 || dist == -3){
                    JOptionPane.showMessageDialog(null, from + " is not a valid coordinate!", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(dist == -2 || dist == -4){
                    JOptionPane.showMessageDialog(null, to + " is not a valid coordinate!", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                mapGUI.setMap(map);
                infoText.setText("");
                infoText.append(ojek.stringBiaya(dist));
                mapGUI.repaint();
                Pathfinding.resetMap();
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Menambahkan ke panel tiap komponen
        c.gridx = 0;
        c.gridy = 0;
        panel.add(owjekLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(regularButton,c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(sportyButton,c);
        c.gridx = 2;
        c.gridy = 1;
        panel.add(exclusiveButton,c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(fromLabel, c);
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        panel.add(fromField,c);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(toLabel, c);
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 3;
        panel.add(toField,c);
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 4;
        panel.add(goButton,c);
        panel.setBorder(BorderFactory.createTitledBorder("Menu"));
        return panel;
    }

}
