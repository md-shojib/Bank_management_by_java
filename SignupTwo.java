import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField panField,aadanumfield;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    String formno;
    JComboBox relComboBox, categoryBox,incomBox,eduBox,occupationBox;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
        JLabel additiondetails=new JLabel("Pase 2: Additional Details");
        additiondetails.setFont(new Font("Raleway",Font.BOLD,25));
        additiondetails.setBounds(240,80,400,40);
        add(additiondetails);
        JLabel religion=new JLabel("religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,120,100,30);
        add(religion);
        String[] valreligion = {"Islam", "Cristian", "Hindu", "Shikh", "Other"};
        relComboBox=new JComboBox(valreligion);
        relComboBox.setBounds(350,120,300,25);
        relComboBox.setBackground(Color.WHITE);
        add(relComboBox);
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,170,200,30);
        add(category);
        String[] valcategory={"General","OBC","SC","ST","Other"};
        categoryBox=new JComboBox(valcategory);
        categoryBox.setBounds(350,170,300,25);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,220,200,30);
        add(income);
        String[] valincom={"null","<100000","<150000","<2000000","<250000"};
        incomBox=new JComboBox(valincom);
        incomBox.setBackground(Color.WHITE);
        incomBox.setBounds(350,220,300,25);
        add(incomBox);
        JLabel education=new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,270,150,30);
        add(education);
        JLabel qualification=new JLabel("Qualificational:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,300,200,30);
        add(qualification);
        String[] valeducation={"SSC","HSC","Honours","Masters","PHD"};
        eduBox=new JComboBox(valeducation);
        eduBox.setBackground(Color.WHITE);
        eduBox.setBounds(350,300,300,25);
        add(eduBox);
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,370,200,30);
        add(occupation);
        String[] valoccupatoin={"Salaried","Self-Employed","Bussiness","Students","Retired","Other"};
        occupationBox=new JComboBox(valoccupatoin);
        occupationBox.setBackground(Color.WHITE);
        occupationBox.setBounds(350,370,300,25);
        add(occupationBox);
        JLabel pannumber=new JLabel("PAN Number:");
        pannumber.setFont(new Font("Raleway",Font.BOLD,20));
        pannumber.setBounds(100,420,200,30);
        add(pannumber);
        panField = new JTextField();
        panField.setFont(new Font("Raleway",Font.BOLD, 14));
        panField.setBounds(350,420,300,25);
        add(panField);
        JLabel Addanumber=new JLabel("Adda Number:");
        Addanumber.setFont(new Font("Raleway",Font.BOLD,20));
        Addanumber.setBounds(100,470,200,30);
        add(Addanumber);
        aadanumfield = new JTextField();
        aadanumfield.setFont(new Font("Raleway",Font.BOLD, 14));
        aadanumfield.setBounds(350,470,300,25);
        add(aadanumfield);
        JLabel cityzen=new JLabel("Senior Citizen:");
        cityzen.setFont(new Font("Raleway",Font.BOLD,20));
        cityzen.setBounds(100,520,200,30);
        add(cityzen);
        syes=new JRadioButton("YES");
        syes.setBounds(350,520,100,25);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno=new JRadioButton("NO");
        sno.setBounds(470,520,100,25);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup seniorb=new ButtonGroup();
        seniorb.add(syes);
        seniorb.add(sno);
        JLabel exaccount=new JLabel("Existing Account:");
        exaccount.setFont(new Font("Raleway",Font.BOLD,20));
        exaccount.setBounds(100,570,200,30);
        add(exaccount);
        eyes=new JRadioButton("YES");
        eyes.setBounds(350,570,100,25);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno=new JRadioButton("NO");
        eno.setBounds(470,570,100,25);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup citezeButtonGroup=new ButtonGroup();
        citezeButtonGroup.add(eyes);
        citezeButtonGroup.add(eno);
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
        String religion=(String) relComboBox.getSelectedItem();
        String category= (String) categoryBox.getSelectedItem();
        String income=(String) incomBox.getSelectedItem();
        String eduaction= (String) eduBox.getSelectedItem();
        String occupation=(String) occupationBox.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }
        String pan = panField.getText();
        String aadhar=aadanumfield.getText();
        
        try{
            
            Conn c = new Conn();
            String query="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+eduaction+"','"+occupation+"','"+seniorcitizen+"','"+pan+"','"+aadhar+"','"+existingaccount+"')";
            c.statement.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
         new SignupTwo("");     
    }
}
