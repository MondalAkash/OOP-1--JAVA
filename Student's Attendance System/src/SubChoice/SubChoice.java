
package SubChoice;

import Attendance.Attendance1;
import Attendance.Attendance2;
import Attendance.Attendance3;
import Attendance.Attendance4;
import Attendance.Attendance5;
import DatabaseConnection.DataAccess;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;


public class SubChoice extends JFrame implements ActionListener{
    DataAccess da = new DataAccess();
    JButton sub1 = new JButton("Programming Language 1 (C)");
     JButton sub2 = new JButton("Programming Language 2 (C++)");
      JButton sub3 = new JButton("Object Oriented Programming 1 (JAVA)");
       JButton sub4 = new JButton("Object Oriented Programming 2 (C#)");
        JButton sub5 = new JButton("PHP");
        String name, id;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5;
        ResultSet rs = null;
        
    public SubChoice(String name, String id){
        this.name = name;
        this.id = id;
        this.setTitle("Subject Choice");
        this.setBounds(550,200,380,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        /*sub1.setBounds(10,10,350,40);
        this.add(sub1);
        sub1.setVisible(false);
        sub2.setBounds(10,60,350,40);
        this.add(sub2);
        sub2.setVisible(false);
        sub3.setBounds(10,110,350,40);
        this.add(sub3);
        sub3.setVisible(false);
        sub4.setBounds(10,160,350,40);
        this.add(sub4);
        sub4.setVisible(false);
        sub5.setBounds(10,210,350,40);
        this.add(sub5);
        sub5.setVisible(false);*/
        String sql = "select course1,course2,course3,course4,course5 from teacher_course where id='"+id+"'";
        rs = da.getData(sql);
        try {
            while(rs.next()){
                this.s1 = rs.getString("course1");
                this.s2 = rs.getString("course2");
                this.s3 = rs.getString("course3");
                this.s4 = rs.getString("course4");
                this.s5 = rs.getString("course5");
                if(s1.isEmpty()){
                    sub1.setVisible(false);
                }
                else {
                    sub1.setPreferredSize(new Dimension(350,40));
                    this.add(sub1);
                    sub1.setVisible(true);
                    
                }
                
                if(s2.isEmpty()){
                    sub2.setVisible(false);
                }
                else {
                    
                    sub2.setPreferredSize(new Dimension(350,40));
                    this.add(sub2);
                    sub2.setVisible(true);
                }
                
                if(s3.isEmpty()){
                    sub3.setVisible(false);
                }
                else {
                    sub3.setPreferredSize(new Dimension(350,40));
                    this.add(sub3);
                    sub3.setVisible(true);
                }
                
                if(s4.isEmpty()){
                    sub4.setVisible(false);
                }
                else {
                    sub4.setPreferredSize(new Dimension(350,40));
                    this.add(sub4);
                    sub4.setVisible(true);
                }
                
                if(s5.isEmpty()){
                    sub5.setVisible(false);
                }
                else {
                    sub5.setPreferredSize(new Dimension(350,40));
                    this.add(sub5);
                    sub5.setVisible(true);
                }
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubChoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        sub1.addActionListener(this);
        sub2.addActionListener(this);
        sub3.addActionListener(this);
        sub4.addActionListener(this);
        sub5.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sub1){
           
            Attendance1 a1 = new Attendance1(s1,name,id);
             dispose();
        }
        else if(e.getSource() == sub2){
           
            Attendance2 a2 = new Attendance2(s2,name,id);
             dispose();
            
        }
        else if(e.getSource() == sub3){
            
            Attendance3 a3 = new Attendance3(s3,name,id);
            dispose();
            
        }
        else if(e.getSource() == sub4){
            
            Attendance4 a4 = new Attendance4(s4,name,id);
            dispose();
            
        }
        else if(e.getSource() == sub5){
            
            Attendance5 a5 = new Attendance5(s5,name,id);
            dispose();
            
        }
        
        
    }
    
}
