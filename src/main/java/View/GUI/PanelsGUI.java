package View.GUI;

import javax.swing.*;
import java.awt.*;

public class PanelsGUI {


        private ActionGUI action;
        private JTextField aNamnTxFd = new JTextField();
        private JTextField losenTxFd = new JTextField();
        private JButton loginBtn = new JButton("Logga in");
        private JButton regBtn = new JButton("Nytt konto");
        private JTextField nameIDTxFx = new JTextField();
        private JTextField passIDTxFx = new JTextField();
        private JButton checkBtn = new JButton("Checka in person");
        private JButton listaBtn = new JButton("Lista alla incheckade");


        public PanelsGUI(ActionGUI action){
            this.action = action;
        }

        public JPanel startSide() {

            JPanel startSide = new JPanel();
            startSide.setLayout(new GridLayout(0,1, 70, 5));
            startSide.setBackground(new Color(96,101,80));
            JLabel loginLabel = new JLabel("Administration");
            loginLabel.setFont(new Font("", Font.PLAIN, 35));
            loginLabel.setForeground(Color.white);

            JLabel usernameLabel = new JLabel("Användarnamn");
            usernameLabel.setForeground(Color.white);
            usernameLabel.setFont(new Font("", Font.PLAIN, 20));

            JLabel passwordLabel = new JLabel("Lösenord");
            passwordLabel.setForeground(Color.white);
            passwordLabel.setFont(new Font("", Font.PLAIN, 20));

            startSide.setLayout(new GridLayout(0,1, 70, 5));

            JPanel btnHolder = new JPanel();
            btnHolder.add(loginBtn);
            btnHolder.setBackground(new Color(96,101,80));
            loginBtn.addActionListener(action);

            startSide.add(new JLabel(""));
            startSide.add(loginLabel);
            startSide.add(new JLabel(""));
            startSide.add(usernameLabel);
            startSide.add(aNamnTxFd);
            startSide.add(passwordLabel);
            startSide.add(losenTxFd);

            startSide.add(btnHolder);

            return startSide;
        }

        public JPanel logedIn() {
            JPanel logedIn = new JPanel();
            logedIn.setLayout(new GridLayout(0,1, 70, 5));
            logedIn.setBackground(new Color(96,101,80));
            JLabel welcomeLabel = new JLabel("Välkommen " + getANamnFromTxFd().getText());
            welcomeLabel.setFont(new Font("", Font.PLAIN, 30));
            welcomeLabel.setForeground(Color.white);
            JLabel infoLabel = new JLabel("Checka in en kund på ett pass");
            infoLabel.setFont(new Font("", Font.PLAIN, 20));
            infoLabel.setForeground(Color.white);

            JLabel checkaIn = new JLabel("Kund ID:");
            checkaIn.setForeground(Color.white);
            checkaIn.setFont(new Font("", Font.PLAIN, 20));
            JLabel passIn = new JLabel("Pass ID:");
            passIn.setForeground(Color.white);
            passIn.setFont(new Font("", Font.PLAIN, 20));



            JPanel btnHolder = new JPanel();
            btnHolder.setLayout(new GridLayout(0,2, 70, 5));
            btnHolder.setBackground(new Color(96,101,80));
            btnHolder.add(checkBtn);
            btnHolder.add(listaBtn);

            logedIn.add(new JLabel(""));
            logedIn.add(welcomeLabel);
            logedIn.add(infoLabel);
            logedIn.add(checkaIn);
            logedIn.add(nameIDTxFx);
            logedIn.add(passIn);
            logedIn.add(passIDTxFx);

            logedIn.add(btnHolder);


            return logedIn;

        }

        public JButton getLoginBtn(){
            return loginBtn;
        }

        public JTextField getANamnFromTxFd(){
            return aNamnTxFd;
        }

    }







