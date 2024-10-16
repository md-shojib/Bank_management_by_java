import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField  pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHIN");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(60,10,100,100);
        add(label);
        JLabel text= new JLabel("Welcome to ATM:");
        text.setFont(new Font("Osward",Font.BOLD, 38));
        text.setBounds(200, 40,400,40);
        add(text);
        JLabel cardno= new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD, 30));
        cardno.setBounds(200, 150, 200, 40);
        add(cardno);
        cardTextField=new JTextField();
        cardTextField.setBounds(420,158,250,30);
        add(cardTextField);
        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD, 30));
        pin.setBounds(200, 220,100,40);
        add(pin);
        pinTextField=new JPasswordField();
        pinTextField.setBounds(320,228,250,30);
        add(pinTextField);
        login=new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        clear=new JButton("Clear");
        clear.setBounds(440, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        signup=new JButton("SIGN UP");
        signup.setBounds(350, 350, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where card_number='"+cardnumber+"' and pin_number='"+pinnumber+"'";
            try {
               ResultSet rs = conn.statement.executeQuery(query);
               if(rs.next()){
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
               }else{
                JOptionPane.showMessageDialog(null,"Incorrect card number & pin number");
               }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }
    public static void main(String args[]){
        new Login();
    }
}