
import StartingFrame.StartingFrame;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;


public class St extends JFrame implements ActionListener{
    JButton clic = new JButton("Click Here To Start");
    JLabel imbl;
    Container c;
    ImageIcon ic;
    JLabel l1 = new JLabel("Prepared By, ");
    JLabel l2 = new JLabel("Akash Mondal  ID:- 15-28764-1");
    JLabel l3 = new JLabel("Anika Azad  ID:- 15-28662-1");
    JLabel l4 = new JLabel("M Tanzeeb Rubaiat Haque  ID:- 15-28809-1");
    JLabel l5 = new JLabel("SAS, v_2017.0.1");
    Font f;
    public St(){
        this.setTitle("SAS, v_2017.0.1");
        f = new Font("Algerian", Font.ITALIC, 16);
        
        c = this.getContentPane();
        
        ic = new ImageIcon(getClass().getResource("main.gif"));
        imbl = new JLabel(ic);
        imbl.setBounds(0,0,641,59);
        clic.setBounds(200,130,200,80);
        l1.setBounds(290, 220, 200, 50);
        l2.setBounds(290,240,300,50);
        l3.setBounds(290,260,300,50);
        l4.setBounds(290,280,400,50);
        l5.setBounds(550,330,100,50);
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        c.add(imbl);
        c.add(clic);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.setLayout(null);
        clic.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == clic){
          StartingFrame sf = new StartingFrame();
          sf.setDefaultCloseOperation(EXIT_ON_CLOSE);
          dispose();
       }
    }
    
}
