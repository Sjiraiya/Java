package Assignment;

import javax.swing.*;
import java.io.Serializable;

public class User implements Serializable {
    String fname;
    String lname;

    public String getUsername() {
        return this.username;
    }

    public String getPass() {
        return this.pass;
    }

    public String getAddress() {
        return this.address;
    }

    public String getName(){
        return this.fname+" "+this.lname;
    }

    String username;
    String pass;
    String address;
    User(){

    }
    User(String fname,String lname, String username, String pass, String address){
        this.fname=fname;
        this.lname=lname;
        this.username=username;
        this.pass=pass;
        this.address=address;
    }

}
