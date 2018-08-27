
package Admin.deleteTeacher;

import Admin.Admin;
import Admin.dels.Dels;
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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Delt extends JFrame implements ActionListener{
    DataAccess da = new DataAccess();
    Container c;
    JLabel id = new JLabel("ID: ");
    JTextField tid = new JTextField();
    JTextField tname = new JTextField();
    JLabel name = new JLabel("Name: ");
    JButton del = new JButton("DELETE");
    JButton ser = new JButton("Search");
    JButton back = new JButton("Back");
    ResultSet rs;
    
    public Delt(){
        this.setTitle("Delete Teacher");
        this.setBounds(550,200,380,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        id.setBounds(10,10,50,50);
        c.add(id);
        tid.setBounds(60,20,200,30);
        c.add(tid);
        name.setBounds(10,70,50,50);
        c.add(name);
        tname.setBounds(60,80,200,30);
        c.add(tname);
        tname.setEditable(false);
        ser.setBounds(270,13,80,40);
        c.add(ser);
        del.setBounds(90,150,150,40);
        c.add(del);
        back.setBounds(90, 195, 150, 40);
        c.add(back);
        ser.addActionListener(this);
        del.addActionListener(this);
        back.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
       String sid = tid.getText();
        if(ae.getSource() == ser){
             
            String sql = "select name from teacher where id = '"+sid+"'";
            //int i = da.updateDB(sql);
            rs=da.getData(sql);
            try {
                if(rs.next()){
                    String name = rs.getString("name");
                    tname.setText(name);
                    //System.out.println(name);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No User Found", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Dels.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource() == del){
           int c = JOptionPane.showConfirmDialog(null, "Do You Want to Delete?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if(c == JOptionPane.YES_OPTION){
                String sql1 = "delete from teacher where id='"+sid+"'";
                int i = da.updateDB(sql1);
               
                
                
                String sql15 = "update teacher_course set id='',name='' where id='"+sid+"'";
                int o =da.updateDB(sql15);
                
                String sql55="update teacher_student set tid='',tname='' where tid='"+sid+"'";
                int j = da.updateDB(sql55);
            }
            else if(c == JOptionPane.NO_OPTION){
                tname.setText("");
                tid.setText("");
            }
        }
        else if(ae.getSource() == back){
            Admin a = new Admin();
            dispose();
        }
    }
    
}
