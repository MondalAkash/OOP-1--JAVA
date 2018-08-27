package RegistrationPanel;

import DatabaseConnection.DataAccess;
import StartingFrame.StartingFrame;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistrationFrame extends JFrame implements ActionListener{
    //String sId, sName;
    static int ii ;
    String choice = "";
    DataAccess da = new DataAccess();
    String g = "";
    Font f;
    JLabel name = new JLabel("Name: ");
    JTextField tname = new JTextField();
    JLabel email = new JLabel("Email-Id: ");
    JTextField temail = new JTextField();
    JLabel password = new JLabel("Password: ");
    JLabel id = new JLabel("ID: ");
    JTextField tid = new JTextField();
    
    JPasswordField tpass = new JPasswordField();
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");
    JLabel gender = new JLabel("Select Gender: ");
    Container c;
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    JRadioButton admin = new JRadioButton("Admin");
    JRadioButton student = new JRadioButton("Student");
    //JRadioButton admin = new JRadioButton("Admin");
    JLabel ch3 = new JLabel("Reg as: ");
    ButtonGroup bg = new ButtonGroup();
    ButtonGroup bg1 = new ButtonGroup();
    //Statement stmt = null;
    ResultSet rs, rs1 ;
    String ch5 = "";
   
    public RegistrationFrame(){
        this.setTitle("Registration Panel");
        this.setBounds(550,150,380,500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        f = new Font("Tahoma",Font.BOLD,15);
        
        ch3.setBounds(30,5,80,20);
        admin.setBounds(110,5,70,20);
        student.setBounds(180,5,70,20);
        
       id.setBounds(30,40,60,40);
       id.setFont(f);
       
        name.setBounds(30,85,60,40);
        name.setFont(f);
        
        email.setBounds(30,130,85,40);
        email.setFont(f);
        
        password.setBounds(30,175,85,40);
        password.setFont(f);
        
        gender.setBounds(30, 220, 150, 50);
        gender.setFont(f);
        
        tname.setBounds(110,90,200,30);
        temail.setBounds(110,135,200,30);
        tpass.setBounds(110, 180, 200, 30);
        tid.setBounds(110,40,200,30);
        
        int iii = ii+1;
        tid.setText("000-"+iii);
        tid.setEditable(false);
        
        submit.setBounds(25,300,150,40);
        back.setBounds(185,300,150,40);
        
        male.setBounds(35, 260,60,20);
        female.setBounds(95,260,80,20);
        
        c.add(ch3);
        c.add(admin);
        c.add(student);
        c.add(id);
        c.add(tid);
        c.add(name);
        c.add(tname);
        c.add(email);
        c.add(temail);
        c.add(password);
        c.add(tpass);
        c.add(gender);
        c.add(male);
        c.add(female);
        c.add(submit);
        c.add(back);
        bg.add(male);
        bg.add(female);
        bg1.add(admin);
        bg1.add(student);
        String sql5 = "select name from reg_admin where id is not null";
        rs1 = da.getData(sql5);
        try {
            if(rs1.next()){
                 admin.setVisible(false);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        
        admin.addActionListener(this);
        student.addActionListener(this);
        submit.addActionListener(this);
        back.addActionListener(this);
        male.addActionListener(this);
        female.addActionListener(this);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            
            String sName = tname.getText();
            String sEmail = temail.getText();
            String sPass = tpass.getText();
            String sId = tid.getText();
            String sGender = g;
            String sch8 = ch5;
            
            //this.sId = sId;
            //this.sName = sName;
            //int id;
            if(sName.equals("")){
                 JOptionPane.showMessageDialog(null,"Please Enter Your name","Warning",JOptionPane.WARNING_MESSAGE);      
            }
            else if(sEmail.equals("")){
                 JOptionPane.showMessageDialog(null,"Please Enter Your email","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(sPass.equals("")){
                 JOptionPane.showMessageDialog(null,"Please Enter Your password","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(sGender.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Select Gender","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(sch8.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Select Registration Type","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String sql2 = "INSERT INTO "+choice+" (id, name, email, password, gender) VALUES('"+sId+"','"+sName+"','"+sEmail+"','"+sPass+"','"+sGender+"')";
                int i = da.updateDB(sql2);
                ii++;
                
                //String sql1 = "select id from registration"";
                /*if(choice.equals("reg_student")){
                   String sql5 = "insert into st_course(id, name, course1, course2, course3, course4) values('"+sId+"', '"+sName+"',null, null, null, null)";
                 int x= da.updateDB(sql5);
                }*/
                JOptionPane.showMessageDialog(null,"ID: "+sId+"\nName: "+sName+"\nEmail: "+sEmail+"\nPassword: "+sPass+"\nGender: "+sGender);
                
                RegistrationFrame rf = new RegistrationFrame();
                dispose();
            }
        }
        else if(ae.getSource() == admin){
            this.choice = "reg_admin";
            this. ch5 = choice;
        }
        else if(ae.getSource() == student){
            this.choice = "reg_student";
            this. ch5 = choice;
            
            
        }
        else if(ae.getSource() == back){
            StartingFrame sf = new StartingFrame();
            dispose();
        }
        else if(ae.getSource() == male){
            String a = "Male";
            this.g = a;
        }
        else if(ae.getSource() == female){
            String a = "Female";
            this.g = a;
        }
        
    }
}