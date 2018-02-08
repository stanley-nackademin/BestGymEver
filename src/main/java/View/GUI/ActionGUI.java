package View.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionGUI extends JPanel implements ActionListener {

        private PanelsGUI GUIPanels;
        private JPanel mainPanel;

        public ActionGUI(){

            GUIPanels = new PanelsGUI(this);
            mainPanel = GUIPanels.startSide();
            add(mainPanel);
            new WindowGUI(this);
        }

        public void changePanel(JPanel panel)
        {
            remove(mainPanel);
            mainPanel = panel;
            add(mainPanel);
            validate();
            repaint();
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(GUIPanels.getLoginBtn())) {
                changePanel(GUIPanels.logedIn());


            }
        }

    }

