package View.GUI;

import javax.swing.*;
import java.awt.*;

public class GUI_Window extends JFrame {


        private static final int WIDTH = 800;
        private static final int HEIGHT = 500;
        private static final Color BACKGROUND = new Color(96,101,80);


        GUI_Window(JPanel panel){
            super("Admin");

            panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            panel.setMaximumSize(new Dimension(WIDTH, HEIGHT));
            panel.setMinimumSize(new Dimension(WIDTH, HEIGHT));
            panel.setBackground(BACKGROUND);
            add(panel);
            pack();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

        }

    }


