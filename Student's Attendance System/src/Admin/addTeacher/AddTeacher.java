
package Admin.addTeacher;

import Admin.Admin;
import DatabaseConnection.DataAccess;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddTeacher extends JFrame implements ActionListener {
    String s1 = "-1";
    DataAccess da = new DataAccess();
    String [] d = {"CSE", "COE", "CSSE", "SE"};
    String [] course ;
    JLabel name = new JLabel("Name: ");
    JLabel dept = new JLabel("Dept: ");
    JLabel pass = new JLabel("Password: ");
    JTextField tname = new JTextField();
     //JTextField tdept = new JTextField();
      JPasswordField tpass = new JPasswordField();
      JComboBox tdept = new JComboBox(d);
      JButton submit = new JButton("Add");
      JButton back = new JButton("Back");
      ResultSet rs;
    public AddTeacher(){
        this.setTitle("Add Teacher");
        this.setBounds(550,200,380,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        name.setBounds(10,10,50,50);
        this.add(name);
        tname.setBounds(60,20,200,30);
        this.add(tname);
        dept.setBounds(10,60,50,50);
        this.add(dept);
        pass.setBounds(10,110, 100, 50);
        this.add(pass);
        tpass.setBounds(90,120,200,30);
        this.add(tpass);
        submit.setBounds(10,180,150,40);
        this.add(submit);
        back.setBounds(180,180,150,40);
        this.add(back);
        tdept.setBounds(60, 60, 100,40);
        this.add(tdept);
        tdept.setSelectedIndex(-1);
        
        submit.addActionListener(this);
        back.addActionListener(this);
        tdept.addActionListener(this);
       
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == tdept){
            String s2 = tdept.getSelectedItem().toString();
            this.s1 = s2;
            
        }
        else if(ae.getSource() == submit){
            String sname = tname.getText();
            String spass = tpass.getText();
           // String s5 = s1;
            if(sname.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter name","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(spass.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter password","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(s1.equals("-1")){
                JOptionPane.showMessageDialog(null,"Please Select your Dept","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
            String sql = "INSERT INTO `teacher` (`id`, `name`, `password`, `dept`) VALUES (NULL, '"+sname+"', '"+spass+"', '"+s1+"')";
            int i = da.updateDB(sql);
            String sql2 = "select id from teacher where name='"+sname+"' and password='"+spass+"' ";
            rs = da.getData(sql2);
                try {
                    if(rs.next()){
                        String id = rs.getString("id");
                        JOptionPane.showMessageDialog(null,"Your id is: "+id);
                    }   } catch (SQLException ex) {
                    Logger.getLogger(AddTeacher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(ae.getSource() == back){
            Admin a =new Admin();
            dispose();
        }
    }
   /* public static void main(String[] args) {
        AddTeacher at = new AddTeacher();
        dispose();
    }*/
}
