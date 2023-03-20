package Assignment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Registration implements Serializable {
    JLabel fname,address,lname,pass,cpass,username;
    JPasswordField txtpass,txtcpass;
    JTextField txtfname, txtlname, txtaddress,txtusername;
    JButton b;
    String sfname,slname,sadd,spass,susername;
    Registration(){
        JFrame frame = new JFrame("Register");
        fname = new JLabel("First Name: ");
        address = new JLabel("Address: ");
        lname = new JLabel("Last Name: ");
        pass= new JLabel("Password:");
        cpass = new JLabel("Confirm Password: ");
        username =  new JLabel("UserName: ");
        txtfname = new JTextField();
        txtlname = new JTextField();
        txtaddress = new JTextField();
        txtpass = new JPasswordField();
        txtcpass = new JPasswordField();
        txtusername= new JTextField();
        b = new JButton("Submit");
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(7,2));
        frame.add(fname);
        frame.add(txtfname);
        frame.add(lname);
        frame.add(txtlname);
        frame.add(address);
        frame.add(txtaddress);
        frame.add(pass);
        frame.add(txtpass);
        frame.add(cpass);
        frame.add(txtcpass);
        frame.add(username);
        frame.add(txtusername);

        JLabel space = new JLabel();
        frame.add(space);
        frame.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtpass.getText().equals(txtcpass.getText()) && !txtpass.getText().isEmpty()) {
                    sfname = txtfname.getText();
                    slname = txtlname.getText();
                    sadd = txtaddress.getText();
                    spass = txtpass.getText();
                    susername=txtusername.getText();

                    User userData = new User(sfname,slname,susername,spass,sadd);

                    try{
                        FileOutputStream fileOutputStream = new FileOutputStream("Assignment/"+susername+".txt");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        objectOutputStream.writeObject(userData);
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    }catch (Exception ep){
                        System.out.println(ep.getMessage());
                    }

                    JOptionPane.showMessageDialog(null, "Success!");
                    new AssignmentImportant();
                    frame.dispose();

//                    try{
//                    Writer output = new FileWriter("Assignment/Assignment.txt", true);
//                        byte[] array = sfname.getBytes();
//                    output.write("First Name: "+sfname+"    "+"Last Name: "+slname+"    "+"Address: "+sadd+"    "+"Username: "+susername+"    "+"Password: "+spass+"    "+"\n");
//                    output.close();
//                    }
//                    catch(Exception eee){
//                        JOptionPane.showMessageDialog(null, "Some error occured");
//                    }


                }
                else {
                    new Registration();
                    frame.dispose();
                    JOptionPane.showMessageDialog(null,"Password mismatch or Empty");
                }

            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Registration R1 = new Registration();


    }
}
