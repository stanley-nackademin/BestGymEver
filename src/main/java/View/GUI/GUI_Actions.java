package View.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Actions extends JPanel implements ActionListener {

    private GUI_Panels GUIPanels;
    private JPanel mainPanel;


    public GUI_Actions(){

        GUIPanels = new GUI_Panels(this);
        mainPanel = GUIPanels.startSide();
        add(mainPanel);
        new GUI_Window(this);
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
        if(e.getSource().equals(GUIPanels.getLoginBtn()))
            changePanel(GUIPanels.logedIn());

    }

}



