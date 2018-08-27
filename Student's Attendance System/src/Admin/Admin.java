
package Admin;

//import Admin.Assign.Assign;
import Admin.addTeacher.AddTeacher;
import Admin.assignTeacher.AssignTeacher;
import Admin.deleteTeacher.Delt;
import Admin.dels.Dels;
import StartingFrame.StartingFrame;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Admin extends JFrame implements ActionListener {
    JButton assign = new JButton("Assign Teacher");
    JButton delt = new JButton("Delete Teacher");
    JButton dels = new JButton("Delete Students");
    JButton addTeacher = new JButton("Add Teacher");
    JButton updateInfo = new JButton("Update Info");
    JButton back = new JButton("Log Out");
    Container c;
    public Admin(){
        this.setTitle("Admin Panel");
        this.setBounds(550,200,380,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        addTeacher.setBounds(20,40,150,40);
        c.add(addTeacher);
        
        assign.setBounds(180,40,150,40);
        c.add(assign);
        
        
        delt.setBounds(20,100,150,40);
        c.add(delt);
        
        dels.setBounds(180,100,150,40);
        c.add(dels);
        
       
        
        /*updateInfo.setBounds(20,160,150,40);
        c.add(updateInfo);*/
        
         back.setBounds(120,160,150,40);
        c.add(back);
        
        back.addActionListener(this);
        dels.addActionListener(this);
        addTeacher.addActionListener(this);
        delt.addActionListener(this);
        assign.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == dels){
            Dels d = new Dels();
            dispose();
        }
        else if(ae.getSource() == addTeacher){
            AddTeacher at = new AddTeacher();
            dispose();
            
        }
        else if(ae.getSource() == delt){
            Delt dt = new Delt();
            dispose();
        }
        else if(ae.getSource() == back){
            StartingFrame sf = new StartingFrame();
            dispose();
        }
        else if(ae.getSource() == assign){
            AssignTeacher at = new AssignTeacher();
            dispose();
            
        }
    }
    /*public static void main(String[] args) {
        Admin a = new Admin();
    }*/
}
