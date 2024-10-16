import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.JFrame;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField namTextField,fnamTextField,emaTextField, addressTextField, staTextField, cityTextField;
    JRadioButton male, female, other, married, unmarried;
    JButton next;
    JDateChooser dobTextField;
    JPasswordField  pinTextField;
    String formno;
    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        random = Math.abs((ran.nextLong() %9000L)+1000L);
        JLabel formno=new JLabel("APPLICATION FORM NO: " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,700,40);
        add(formno);
        JLabel personDetails=new JLabel("Pase 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,25));
        personDetails.setBounds(240,80,400,40);
        add(personDetails);
        JLabel name=new JLabel("name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,120,100,30);
        add(name);
        namTextField = new JTextField();
        namTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        namTextField.setBounds(350,120,300,25);
        add(namTextField);
        JLabel fname=new JLabel("father's name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,170,200,30);
        add(fname);
        fnamTextField = new JTextField();
        fnamTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        fnamTextField.setBounds(350,170,300,25);
        add(fnamTextField);
        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);
        dobTextField = new JDateChooser();
        dobTextField.setBounds(350,220,120,25);
        add(dobTextField);
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,270,100,30);
        add(gender);
        male = new JRadioButton("male");
        male.setBounds(350,270,100,25);
        add(male);
        female = new JRadioButton("female");
        female.setBounds(470,270,100,25);
        add(female);
        other = new JRadioButton("other");
        other.setBounds(590,270,100,25);
        add(other);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,320,100,30);
        add(email);
        emaTextField = new JTextField();
        emaTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        emaTextField.setBounds(350,320,300,25);
        add(emaTextField);
        JLabel martial=new JLabel("Marital Status:");
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(100,370,200,30);
        add(martial);
        married = new JRadioButton("married");
        married.setBounds(350,370,100,25);
        add(married);
        unmarried = new JRadioButton("unmarried");
        unmarried.setBounds(470,370,120,25);
        add(unmarried);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,420,100,30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        addressTextField.setBounds(350,420,300,25);
        add(addressTextField);
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,470,100,30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        cityTextField.setBounds(350,470,300,25);
        add(cityTextField);
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,520,100,30);
        add(state);
        staTextField = new JTextField();
        staTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        staTextField.setBounds(350,520,300,25);
        add(staTextField);
        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,570,200,30);
        add(pincode);
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        pinTextField.setBounds(350,570,300,25);
        add(pinTextField);
        next=new JButton("NEXT");
        next.setBounds(450, 620, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        formno=""+random;
        String name=namTextField.getText();
        String fname= fnamTextField.getText();
        String dob=((JTextField)dobTextField.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }else if(female.isSelected()){
            gender="female";
        }else if(other.isSelected()){
            gender="other";
        }
        String email=emaTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        String address = addressTextField.getText();
        String city=cityTextField.getText();
        String state=staTextField.getText();
        String pin=pinTextField.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else{
                Conn c = new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.statement.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
         new SignupOne();       
    }
}
