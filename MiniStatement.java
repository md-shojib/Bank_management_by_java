import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.*;
public class MiniStatement extends JFrame{
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setLayout(null);
        JLabel text=new JLabel();
        add(text);
        JLabel bank=new JLabel("Islami Bank");
        bank.setBounds(150,20,150,20);
        add(bank);
        JLabel card=new JLabel();
        card.setBounds(20,80,600,20);
        add(card);
        JLabel balance=new JLabel();
        balance.setBounds(20,400,400,30);
        add(balance);
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.statement.executeQuery("select * from login where pin_number='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("card_number").substring(0,4)+"xxxxxxxx"+rs.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try{
            Conn conn= new Conn();
            int bal=0;
            ResultSet rs= conn.statement.executeQuery("select * from bank where pin_number='"+pinnumber+"'");
            while(rs.next()){
                text.setText(text.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is TK "+bal);
        } catch (Exception e) {
            System.out.println(e);
        }
        text.setBounds(20,120,400,100);
        setSize(600,600);
        setLocation(100,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
