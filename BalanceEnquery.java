import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
public class BalanceEnquery extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    BalanceEnquery(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        back=new JButton("Back");
        back.setBounds(350,450,100,30);
        back.addActionListener(this);
        image.add(back);
        Conn conn=new Conn();
        int balance=0;
        try{
            ResultSet rs = conn.statement.executeQuery("select * from bank where pin_number='"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        JLabel text=new JLabel("Your Current Account Balance is TK "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);
        setSize(900,800);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquery("");
    }
}
