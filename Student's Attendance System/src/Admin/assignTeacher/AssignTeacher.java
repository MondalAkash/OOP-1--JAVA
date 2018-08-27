
package Admin.assignTeacher;

import Admin.Admin;
import Admin.courselist.CourseList;
import DatabaseConnection.DataAccess;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AssignTeacher extends JFrame implements ActionListener {
    DataAccess da = new DataAccess();
    JTextField tid = new JTextField();
    JTextField tname = new JTextField();
    JButton search = new JButton("Search");
    JLabel name = new JLabel("Teacher's Name: ");
    JLabel id = new JLabel("Teacher's ID: ");
    JButton srch = new JButton("Search");
    JButton back = new JButton("Back");
    JButton ass = new JButton("Assign Courses");
    
    Container c;
    ResultSet rs, rs1;
    String ssname = null;String ssid = null;
    public AssignTeacher(){
        this.setTitle("Assign Teacher");
        this.setBounds(550,200,450,400);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        id.setBounds(10,10,100,30);
        c.add(id);
        tid.setBounds(130,10,200,30);
        c.add(tid);
        srch.setBounds(130,65,150,50);
        c.add(srch);
        name.setBounds(10,150,100,30);
        c.add(name);
        tname.setBounds(130,150,200,30);
        c.add(tname);
        tname.setEditable(false);
        ass.setBounds(10,200,150,50);
        c.add(ass);
        back.setBounds(180,200,150,50);
        c.add(back);
        srch.addActionListener(this);
        ass.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == srch){
            String sid = tid.getText();
            String sql = "select name from teacher where id = '"+sid+"'";
            rs = da.getData(sql);
            try {
                if(rs.next()){
                    String name = rs.getString("name");
                    tname.setText(name);
                    this.ssname = name;
                    this.ssid = sid;
                    
                    /**/
                }
                else{
                    JOptionPane.showMessageDialog(null,"There is no valid teacher for this id","Warning", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AssignTeacher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == ass){
            if(ssname==null){
                JOptionPane.showMessageDialog(null,"Check Again", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if(ssid==null){
                JOptionPane.showMessageDialog(null,"Check Again", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                String sql5 = "select id from teacher_course where id = '"+ssid+"'";
                rs1=da.getData(sql5);
                try {
                    if(rs1.next()){
                        JOptionPane.showMessageDialog(null, "Please Assign Courses");
                        CourseList cl = new CourseList(ssid,ssname);
                        dispose();
                    }
                    else{
                    String sql2 = "insert into teacher_course (did, id, name, course1, course2, course3, course4, course5) values(NULL, '"+ssid+"', '"+ssname+"', '', '', '', '', '')";
                    int i = da.updateDB(sql2);
                    JOptionPane.showMessageDialog(null, "Assign Courses now");
                    CourseList cl = new CourseList(ssid,ssname);
                    dispose();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AssignTeacher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(e.getSource() == back){
            Admin a = new Admin();
            dispose();
        }
    }
    
}
