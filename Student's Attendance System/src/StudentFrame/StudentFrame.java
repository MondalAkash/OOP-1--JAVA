
package StudentFrame;

import DatabaseConnection.DataAccess;
import StartingFrame.StartingFrame;
import StudentCourses.Courses;
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

public class StudentFrame extends JFrame implements ActionListener{
    DataAccess da = new DataAccess();
    JButton addCourse = new JButton("Add Courses");
    JButton viewRecords = new JButton("View Records");
    JButton back = new JButton("Log Out");
    JLabel l1 = new JLabel();
     Container c;
     String passName, passID;
     ResultSet rs = null;
    public StudentFrame(String passName, String passID){
        
        this.passName = passName;
        this.passID = passID;
       
        this.setTitle("Student's Section");
        this.setBounds(550,200,380,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        addCourse.setBounds(80,100,150,50);
        //viewRecords.setBounds(195,100,150,50);
        back.setBounds(120,160,150,50);
        l1.setBounds(10,10,150,50);
         l1.setText("Welcome, "+passName);
         c.add(l1);
        c.add(addCourse);
        //c.add(viewRecords);
        c.add(back);
        addCourse.addActionListener(this);
        //viewRecords.addActionListener(this);
        back.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addCourse){
            
           
            try {
                String sql2 = "select name from st_course where id= '"+passID+"'";
                //int a =da.updateDB(sql2);
                rs = da.getData(sql2);
                if(rs.next()){
                    
                    Courses cr = new Courses(passName, passID);
                    dispose();
                }
                
                
                else{
                    String sql = "INSERT INTO st_course (`did`, `id`, `name`, `course1`, `course2`, `course3`, `course4`, `course5`) VALUES (NULL, '"+passID+"', '"+passName+"', '', '', '', '','') ";
                    int i = da.updateDB(sql);
                    Courses cr = new Courses(passName, passID);
                    dispose();}
            } catch (SQLException ex) {
                Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*else if(ae.getSource() == viewRecords){
            View v = new View(passID);
            dispose();
            //JOptionPane.showMessageDialog(null,"Your id is: "+sId);
        }*/
        else if(ae.getSource() == back){
            StartingFrame sf = new StartingFrame();
            dispose();
        }
    }
}
