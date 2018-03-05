import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

public class Animationen extends JComponent {
    static JPanel panel;
    static int column = 3;
    static int row = 195;
    static int number = 1;

    Animationen(JPanel panel) {
        this.panel = panel;
        setBounds(0, 0, panel.getWidth(), panel.getHeight());
    }

    public void paint(Graphics g) {
        ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("images/" + number + ".png")).getImage());
        g.drawImage(image.getImage(), column, row, 206, 356, null);
        g.setColor(Color.WHITE);
    }

    static Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                while (true) {
                    number++;
                    if (number == 8) {
                        number = 1;
                    }
                    panel.repaint();
                    column += 10;
                    thread.sleep(100);
                }
            } catch (java.lang.InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    };

    public static void move() {
        if (!thread.isAlive()) {
            thread.start();
        }
        column = 3;
    }
}

