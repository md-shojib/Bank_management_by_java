import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdraw,ministatement,pinchange,fastcash,exit,balanceenquiry;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(150, 200, 500, 35);
        text.setForeground(Color.WHITE);
        image.add(text);
        deposit= new JButton("TK 100");
        deposit.setBounds(150, 250, 120, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        withdraw= new JButton("TK 200");
        withdraw.setBounds(300, 250, 120, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        fastcash= new JButton("TK 500");
        fastcash.setBounds(150, 300, 120, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement= new JButton("TK 1000");
        ministatement.setBounds(300, 300, 120, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange= new JButton("TK 5000");
        pinchange.setBounds(150, 350, 120, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceenquiry= new JButton("10000");
        balanceenquiry.setBounds(300, 350, 120, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        exit= new JButton("Back");
        exit.setBounds(250, 400, 120, 30);
        exit.addActionListener(this);
        image.add(exit);
        setSize(900,900);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn conn=new Conn();
            try{
                ResultSet rs = conn.statement.executeQuery("select * from bank where pin_number='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date =new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "TK "+amount+" Debite Succefully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
