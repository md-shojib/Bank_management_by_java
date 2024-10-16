import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.*;
public class Withdraw extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    Withdraw(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        JLabel text=new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 15));
        text.setBounds(120,300,400,20);
        image.add(text);
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(120, 350, 320, 25);
        image.add(amount);
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(250,400,100,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        back=new JButton("Back");
        back.setBounds(120,400,100,30);
        back.addActionListener(this);
        image.add(back);
        setSize(800,800);
        setLocation(200,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String number=amount.getText();
            Date date= new Date();

            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
            }else{
                try{
                    Conn conn =new Conn();
                    String query="insert into bank value('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Taka "+ number+ " Withdraw Successfully");
                    new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdraw("");
    }
}
