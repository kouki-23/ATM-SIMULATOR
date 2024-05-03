
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(190,350,400,35);
        l3.add(l1);
        
        t1.setBounds(190,420,320,25);
        l3.add(t1);
        
        b1.setBounds(390,588,150,35);
        l3.add(b1);
        
        b2.setBounds(390,633,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(960,1080);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try {
    String amount = t1.getText();
    Date date = new Date(); // Get the current date
    
    // Format the date to match MySQL date format
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = sdf.format(date);
    
    if (ae.getSource() == b1) {
        if (t1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the Amount that you want to Deposit");
        } else {
            Connectivity c1 = new Connectivity();
            c1.s.executeUpdate("insert into bank values('"+pin+"', '"+formattedDate+"', 'Deposit', '"+amount+"')");
            JOptionPane.showMessageDialog(null, amount+"DT Deposited Successfully");
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    } else if (ae.getSource() == b2) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
} catch (Exception e) {
    e.printStackTrace(); 

}
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}