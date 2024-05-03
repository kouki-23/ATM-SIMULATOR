package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JButton b;
    JRadioButton r1,r2;
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    String formno;
    Signup2(String formno){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l10 = new JLabel(i3);
        l10.setBounds(150, 0, 100, 100);
        add(l10);
        
        
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        l1 = new JLabel("Page 2: Additonal Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("CIN Number :");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Annual Income :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("Education :");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("Occupation :");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l6 = new JLabel("Phone Number :");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l7 = new JLabel("Existing Account :");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("Form No :");
        l8.setFont(new Font("Raleway", Font.BOLD, 13));
        
        l9 = new JLabel(formno);
        l9.setFont(new Font("Raleway", Font.BOLD, 13));
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
        
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c1 = new JComboBox(income);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c2 = new JComboBox(education);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c3 = new JComboBox(occupation);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        setLayout(null);
        
        l8.setBounds(700,10,80,30);
        add(l8);
        
        l9.setBounds(760,10,60,30);
        add(l9);
        
        l1.setBounds(280,30,600,40);
        add(l1);

        l2.setBounds(100,220,180,30);
        add(l2);
        
        t2.setBounds(350,220,320,30);
        add(t2);

        l5.setBounds(100,270,150,30);
        add(l5);
        
        c3.setBounds(350,270,320,30);
        add(c3);
        
        l3.setBounds(100,320,180,30);
        add(l3);
        
        c1.setBounds(350,320,320,30);
        add(c1);
        
        l4.setBounds(100,370,180,30);
        add(l4);
        
        c2.setBounds(350,370,320,30);
        add(c2);
        
        l6.setBounds(100,420,150,30);
        add(l6);
        
        t1.setBounds(350,420,320,30);
        add(t1);
        
        l7.setBounds(100,470,180,30);
        add(l7);
        
        r1.setBounds(350,470,100,30);
        add(r1);
        
        r2.setBounds(460,470,100,30);
        add(r2);
        
        b.setBounds(570,640,100,30);
        add(b);
        
        b.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,750);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String cin = t1.getText();
        String occupation = (String)c3.getSelectedItem();

        String income = (String)c1.getSelectedItem();
        String phone = t2.getText();

        String education = (String)c2.getSelectedItem();
        
        String eaccount = "";
        if(r1.isSelected()){ 
            eaccount = "Yes";
        }else if(r2.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(t2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Connectivity c1 = new Connectivity();
                String q1 = "insert into signup2 values('"+formno+"','"+income+"','"+education+"','"+occupation+"','"+cin+"','"+phone+"','"+eaccount+"')";
                c1.s.executeUpdate(q1);
                
                new Signup3(formno).setVisible(true);
                setVisible(false);
            }
                
      
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
    
               
    }
    
    
    public static void main(String[] args){
        new Signup2("").setVisible(true);
    }
}