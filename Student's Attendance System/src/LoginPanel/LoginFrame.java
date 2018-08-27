package LoginPanel;
import Admin.Admin;
import DatabaseConnection.DataAccess;
import StartingFrame.StartingFrame;
import StudentFrame.StudentFrame;
import TeacherPanel.TeacherFrame;
import java.awt.Color;
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

public class LoginFrame extends JFrame implements ActionListener{
    DataAccess da = new DataAccess();
    String ch1 = "";
    Font f;
    JLabel username = new JLabel("User Id: ");
    JLabel password = new JLabel("Password: ");
    JTextField uname = new JTextField();
    JPasswordField pass = new JPasswordField();
    JButton log = new JButton("Login");
    JButton cl = new JButton("Clear");
    JButton back = new JButton("Back");
    Container c;
    ResultSet rs = null;
    JLabel ch = new JLabel("Login as: ");
    JRadioButton admin = new JRadioButton("Admin");
    JRadioButton student = new JRadioButton("Student");
    JRadioButton teacher = new JRadioButton("Teacher");
    ButtonGroup bg = new ButtonGroup();
    
    String passID;
    String passName;
    
    public LoginFrame(){
        
        this.setTitle("Login Panel");
        this.setBounds(550,200,380,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        c = this.getContentPane();
        //c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(null);
        
        f = new Font("Arial",Font.BOLD,12);
        
        ch.setBounds(30, 5, 80, 20);
        admin.setBounds(110,5,70,20);
        student.setBounds(180,5,70,20);
        teacher.setBounds(250,5,90,20);
        
        username.setBounds(30,20,60,80);
        username.setFont(f);
        
        password.setBounds(30, 75, 80, 80);
        password.setFont(f);
        
        uname.setBounds(100, 45, 200, 30);
        pass.setBounds(100, 100, 200, 30);
        
        log.setBounds(25, 150, 100, 40);
        cl.setBounds(135,150,100,40);
        back.setBounds(245,150,100,40);
        //uname.setText("000-");
        c.add(ch);
        c.add(admin);
        c.add(student);
        c.add(teacher);
        c.add(username);
        c.add(uname);
        c.add(password);
        c.add(pass);
        c.add(log);
        c.add(cl);
        c.add(back);
        bg.add(admin);
        bg.add(student);
        bg.add(teacher);
        
        log.addActionListener(this);
        cl.addActionListener(this);
        back.addActionListener(this);
        admin.addActionListener(this);
        student.addActionListener(this);
        teacher.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == log){
            String sId = uname.getText();
            String sPassword = pass.getText();
            String sCh = ch1;
            if(sId.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Enter UserName","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(sPassword.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Enter Password","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(sCh.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Enter Login Type","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String sql = "select name from "+ch1+" where id='"+sId+"' and password='"+sPassword+"'";
                //String sql3 = "select id from "+ch1+" where "
                rs = da.getData(sql);
                try {
                    if(rs.next()){
                        String name = rs.getString("name");
                        this.passName = name;
                        this.passID = sId;
                        
                        JOptionPane.showMessageDialog(null,name+", You Have Successfully Logged in!!");
                        
                        if(ch1.equals("reg_student")){
    
                            StudentFrame sf = new StudentFrame(passName, passID);
                            dispose();
                        }
                        else if(ch1.equals("reg_admin")){
                            Admin ad = new Admin();
                            dispose();
                        }
                        else if(ch1.equals("teacher")){
                           TeacherFrame tp = new TeacherFrame(passName, passID);
                           dispose();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please Enter Correct ID & PASSWORD");
                    }
                    //JOptionPane.showMessageDialog(null, "UserName: "+sId+"\nPassword: "+sPassword);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                /*if(ch1.equals("reg_student")){
    
                    StudentFrame sf = new StudentFrame(sId);
                    dispose();
                }*/
            }
            
        }
        else if(ae.getSource() == admin){
            this.ch1 = "reg_admin";
        }
        else if(ae.getSource() == student){
            this.ch1 = "reg_student";
        }
        else if(ae.getSource() == teacher){
            this.ch1 = "teacher";
        }
        else if(ae.getSource() == cl){
            uname.setText("");
            pass.setText("");
        }
        else if(ae.getSource() == back){
            StartingFrame sf = new StartingFrame();
            dispose();
        }
    }
}
