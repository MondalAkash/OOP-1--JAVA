package TeacherPanel;


import LoginPanel.LoginFrame;
import SubChoice.SubChoice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TeacherFrame extends JFrame implements ActionListener{
    JButton att = new JButton("Attendance");
    JButton back = new JButton("Log Out");
    String name,id;
    public TeacherFrame(String name, String id){
        this.name = name;
        this.id = id;
        this.setTitle("Teacher's Panel");
        this.setBounds(550,200,380,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        att.setBounds(100,100,150,40);
        back.setBounds(100, 160, 150, 40);
        this.add(att);
        this.add(back);
        this.setLayout(null);
        att.addActionListener(this);
        back.addActionListener(this);
        //System.out.println(name+id);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == att){
            // Attendance a = new Attendance();
            SubChoice sc = new SubChoice(name,id);
            dispose();
        }
        else if(e.getSource() == back){
            LoginFrame lf = new LoginFrame();
            dispose();
        }
    }
    
}
