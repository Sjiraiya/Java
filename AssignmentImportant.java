package Assignment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AssignmentImportant extends JFrame {
    JLabel username,pass;
    JTextField txtusername;
    JPasswordField txtpass;
    JButton Nuser, b;

    AssignmentImportant (){
        JFrame frame =  new JFrame("Login");
        username = new JLabel("UserName: ");
        username.setBounds(10, 10, 150, 50);
        txtusername = new JTextField();
        txtusername.setBounds(150, 10, 150, 50);
        pass =  new JLabel("Password: ");
        pass.setBounds(10, 100, 150, 50);
        txtpass = new JPasswordField("");
        txtpass.setBounds(150, 100, 150, 50);

        b = new JButton("Submit");
        b.setBounds(80,200,100,50);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean matched = false;
                String u = txtusername.getText();
                String p = String.valueOf(txtpass.getPassword());

                try {
                    System.out.println(u+p+"Assignment/"+u+".txt");
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Assignment/"+u+".txt"));
                    User user = (User)objectInputStream.readObject();

                    if(!p.equals(user.getPass())){
                        JOptionPane.showMessageDialog(null ,"Password incorrect");
                    }else{
                        JOptionPane.showMessageDialog(null,"login successful");
                        matched = true;
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"username doesn't exists"+ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
//                try{
//                FileReader fr = new FileReader("Assignment.txt");
//                BufferedReader br = new BufferedReader(fr); //reads line by line
//                String line;
//                while ((line = br.readLine()) != null) {
//                    if (line.equals(u + "\tPassword: " + p)) {
//                        matched = true;
//                        break;
//                    }
//                }
//                fr.close();
//            }
//            catch(Exception weee){
//                    JFrame diagframe = new JFrame("EXCEPTION BRO");
//                    JOptionPane.showMessageDialog(diagframe,"OOPS EXCEPTION!");
//            }
                if(matched) { dispose(); new LoginFrame();}
                else {JOptionPane.showMessageDialog(null,"Please input valid username/password");}
            }
        });

        Nuser = new JButton("Register");
        Nuser.setBounds(200,200,100,50);
        Nuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registration();
                AssignmentImportant.this.dispose();
            }
        });

        setSize(400,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(username);
        add(txtusername);
        add(pass);
        add(txtpass);
        add(b);
        add(Nuser);
    }

    public static void main(String[] args) {
        new AssignmentImportant();
    }
}
