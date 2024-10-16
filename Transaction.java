import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdraw,ministatement,pinchange,fastcash,exit,balanceenquiry;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(150, 200, 500, 35);
        text.setForeground(Color.WHITE);
        image.add(text);
        deposit= new JButton("Deposit");
        deposit.setBounds(120, 250, 120, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        withdraw= new JButton("Withdraw");
        withdraw.setBounds(280, 250, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(120, 300, 120, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement= new JButton("Mini Statement");
        ministatement.setBounds(280, 300, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange= new JButton("Pin Change");
        pinchange.setBounds(120, 350, 120, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceenquiry= new JButton("Balance Enquiry");
        balanceenquiry.setBounds(280, 350, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        exit= new JButton("Exit");
        exit.setBounds(200, 400, 120, 30);
        exit.addActionListener(this);
        image.add(exit);
        setSize(1000,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquery(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
