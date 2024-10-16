import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
public class PinChange extends JFrame implements ActionListener{
    JPasswordField pinTextField, repinTextField;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.png"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        JLabel text=new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(240,210,500,25);
        image.add(text);
        JLabel pintext=new JLabel("New Pin:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(160,270,150,25);
        image.add(pintext);
        pinTextField=new JPasswordField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,25));
        pinTextField.setBounds(325, 270, 180, 25);
        image.add(pinTextField);
        JLabel repintext=new JLabel("Re-Enter Pin:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(160,330,160,35);
        image.add(repintext);
        repinTextField=new JPasswordField();
        repinTextField.setFont(new Font("Raleway",Font.BOLD,25));
        repinTextField.setBounds(325, 330, 180, 25);
        image.add(repinTextField);
        change=new JButton("Change");
        change.setBounds(300,400,100,30);
        change.addActionListener(this);
        image.add(change);
        back=new JButton("Back");
        back.setBounds(300,460,100,30);
        back.addActionListener(this);
        image.add(back);
        setSize(900,800);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){    
            try{
                String pin=pinTextField.getText();
                String rpin=repinTextField.getText();
                if(!pin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-Enter New PIN");
                    return;
                }
                Conn conn=new Conn();
                String query="update bank set pin_number ='"+rpin+"' where pin_number='"+pinnumber+"'" ;
                String query1="update login set pin_number ='"+rpin+"' where pin_number='"+pinnumber+"'" ;
                String query2="update signupthree set pin_number ='"+rpin+"' where pin_number='"+pinnumber+"'" ;
                conn.statement.executeUpdate(query);
                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
