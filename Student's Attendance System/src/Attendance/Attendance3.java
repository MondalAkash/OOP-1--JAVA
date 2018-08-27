
package Attendance;

import DatabaseConnection.DataAccess;
import TeacherPanel.TeacherFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Attendance3 extends JFrame implements ActionListener{
    DataAccess da = new DataAccess();
    String sub3 = null;
    JCheckBox []chk1 = new JCheckBox[100];
    ResultSet rs,rs1,rs2;
    String [] sid = new String[100];
    String [] sname = new String[100];
    int i = 0, p;
    String name,id;
    JButton back = new JButton("Back");
    String s2,s3,ssid,ssname;
    JLabel showDate = new JLabel ();
    Calendar cal=new GregorianCalendar();
    JButton ref = new JButton("Refresh");
    public Attendance3(String s3, String s1, String s2){
        this.sub3 = s3;
        this.name = s1;
        this.id = s2;
        this.setTitle(sub3);
        this.setBounds(550,200,380,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.add(back);
         this.add(ref);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);
        month+=1;
        int year=cal.get(Calendar.YEAR);
        showDate.setText(day+"/"+month+"/"+year);
					add(showDate);
        String sql = "select id,name from st_course where course3='"+sub3+"'";
        rs = da.getData(sql);
        try {
            while(rs.next()){
                sid[i] = rs.getString("id");
                sname[i]=rs.getString("name");
                chk1[i] = new JCheckBox(sid[i]+" "+sname[i]+"\n");
                this.add(chk1[i]);
                
                i++;
                //chk1[i].addActionListener(this);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Attendance2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String ss = showDate.getText();
       
            String sql30 = "select sid from teacher_student where tid='"+id+"' and date='"+ss+"' and subject='"+sub3+"'";
            rs2 = da.getData(sql30);
            try {
                if(rs2.next()){
                    System.out.println("break");
                    
                }
                else{
                     for(p=0;p<5;p++){
                         if(sid[p].equals("")){}
                         else{
                    String sql89 = "insert into teacher_student (did,tid,tname,sid,sname,subject,status,date) values(NULL,'"+id+"','"+name+"','"+sid[p]+"','"+sname[p]+"','"+sub3+"','','"+ss+"')";
                    int s = da.updateDB(sql89);}}
                }
            } catch (SQLException ex) {
                Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        back.addActionListener(this);
        ref.addActionListener(this);
        chk1[0].addActionListener(this);
        chk1[1].addActionListener(this);
        chk1[2].addActionListener(this);
        chk1[3].addActionListener(this);
        chk1[4].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            TeacherFrame tf = new TeacherFrame(name,id);
            dispose();
        }
        else if(e.getSource() == chk1[0]){
                if(chk1[0].isSelected()){
                String sql119 = "update teacher_student set status='p' where sid='"+sid[0]+"' and tid='"+id+"'and subject='"+sub3+"'";
                int h = da.updateDB(sql119);
                //System.out.println(chk1[0].getText());
                }
                else{
                    String sql120 = "update teacher_student set status='a' where sid='"+sid[0]+"' and tid='"+id+"'and subject='"+sub3+"'";
                int o = da.updateDB(sql120);
                }
            
        }
        
            else if(e.getSource() == chk1[1]){
            if(chk1[1].isSelected()){
            String sql119 = "update teacher_student set status='p' where sid='"+sid[1]+"' and tid='"+id+"'and subject='"+sub3+"'";
            int h = da.updateDB(sql119);
            //System.out.println(chk1[0].getText());
            }
            else{
                String sql120 = "update teacher_student set status='a' where sid='"+sid[1]+"' and tid='"+id+"'and subject='"+sub3+"'";
            int o = da.updateDB(sql120);
            }
            
        }
            
        else if(e.getSource() == chk1[2]){
       if(chk1[2].isSelected()){
       String sql119 = "update teacher_student set status='p' where sid='"+sid[2]+"' and tid='"+id+"'and subject='"+sub3+"'";
       int h = da.updateDB(sql119);
       //System.out.println(chk1[0].getText());
       }
       else{
           String sql120 = "update teacher_student set status='a' where sid='"+sid[2]+"' and tid='"+id+"'and subject='"+sub3+"'";
       int o = da.updateDB(sql120);
       }

    } 
                else if(e.getSource() == chk1[3]){
                if(chk1[3].isSelected()){
                String sql119 = "update teacher_student set status='p' where sid='"+sid[3]+"' and tid='"+id+"'and subject='"+sub3+"'";
                int h = da.updateDB(sql119);
                //System.out.println(chk1[0].getText());
                }
                else{
                    String sql120 = "update teacher_student set status='a' where sid='"+sid[3]+"' and tid='"+id+"'and subject='"+sub3+"'";
                int o = da.updateDB(sql120);
                }
            
        }
                        else if(e.getSource() == chk1[4]){
                if(chk1[4].isSelected()){
                String sql119 = "update teacher_student set status='p' where sid='"+sid[4]+"' and tid='"+id+"'and subject='"+sub3+"'";
                int h = da.updateDB(sql119);
                //System.out.println(chk1[0].getText());
                }
                else{
                    String sql120 = "update teacher_student set status='a' where sid='"+sid[4]+"' and tid='"+id+"'and subject='"+sub3+"'";
                int o = da.updateDB(sql120);
                }
            
        }
                                else if(e.getSource() == chk1[5]){
                if(chk1[5].isSelected()){
                String sql119 = "update teacher_student set status='p' where sid='"+sid[5]+"' and tid='"+id+"'and subject='"+sub3+"'";
                int h = da.updateDB(sql119);
                //System.out.println(chk1[0].getText());
                }
                else{
                    String sql120 = "update teacher_student set status='a' where sid='"+sid[5]+"' and tid='"+id+"'and subject='"+sub3+"'";
                int o = da.updateDB(sql120);
                }
            
        }
        else if(e.getSource() == ref){
            for(i=0;i<5;i++){
           String sql77 = "select sid from teacher_student where status='p' and subject='"+sub3+"' and sid='"+sid[i]+"' and sname='"+sname[i]+"'";
            rs1 = da.getData(sql77);
            try {
                if(rs1.next()){
                    chk1[i].setSelected(true);
                }
                else{
                    chk1[i].setSelected(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        }
    }
    
}
