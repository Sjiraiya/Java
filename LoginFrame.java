package Assignment;

import javax.swing.*;
import java.awt.*;
        public class LoginFrame extends JFrame{
            LoginFrame() {
                getContentPane().setBackground(Color.YELLOW);
                JLabel label = new JLabel("WELCOME");
                label.setBounds(50,100,100,50);
                add(label);
                setSize(400, 550);
                setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }

            public static void main(String[] args) {
                new LoginFrame();
            }
        }
