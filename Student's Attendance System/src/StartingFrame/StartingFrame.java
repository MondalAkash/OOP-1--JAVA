package StartingFrame;
import LoginPanel.LoginFrame;
import RegistrationPanel.RegistrationFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class StartingFrame extends JFrame implements ActionListener {
    JButton reg = new JButton("Registration");
    JButton log = new JButton("Login");
    Container c ;
    JLabel ask = new JLabel("Already Registered?Please Click Here: ");
    public StartingFrame(){
       
        this.setTitle("Student's Attendance System");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(550, 200, 380, 300);
        this.setVisible(true);
        this.setResizable(false);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        ask.setForeground(Color.WHITE);
        reg.setBounds(110, 50, 150, 50);
        ask.setBounds(65,115,300,20);
        log.setBounds(110,150,150,50);
        
        c.add(reg);
        c.add(ask);
        c.add(log);
        reg.addActionListener(this);
        log.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == reg){
            RegistrationFrame rf = new RegistrationFrame();
            dispose();
        }
        else if(ae.getSource() == log){
            LoginFrame lf = new LoginFrame();
            dispose();
        }
    }
}
