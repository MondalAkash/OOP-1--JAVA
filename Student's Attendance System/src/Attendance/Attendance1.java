package Attendance;
import DatabaseConnection.DataAccess;
import SubChoice.SubChoice;
import TeacherPanel.TeacherFrame;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Attendance1 extends JFrame implements ActionListener{
    String sub1 = null;
    DataAccess da = new DataAccess();
    JCheckBox []chk1 = new JCheckBox[100];
    ResultSet rs,rs1,rs2;
    String [] sid = new String[100];
    String [] sname = new String[100];
    int i = 0, p;
    //int ii = 0;
    JButton back = new JButton("Back");
    String s2,s3,ssid,ssname;
    JLabel showDate = new JLabel ();
    Calendar cal=new GregorianCalendar();
    JButton ref = new JButton("Refresh");
    String ss;
    public Attendance1(String s1, String s2, String s3){
        this.sub1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.setTitle(sub1);
        this.setBounds(550,200,380,300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.add(ref);
        this.add(back);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);
        month+=1;
        int year=cal.get(Calendar.YEAR);
        showDate.setText(day+"/"+month+"/"+year);
					add(showDate);
        String sql = "select id,name from st_course where course1='"+sub1+"'";
        rs = da.getData(sql);
        try {
            while(rs.next()){
                sid[i] = rs.getString("id");
                sname[i]=rs.getString("name");
                chk1[i] = new JCheckBox(sid[i]+" "+sname[i]);
                this.add(chk1[i]);
               //System.out.print(chk1[i].getName()); 
               
               i++;
   
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(Attendance2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        this.ss = showDate.getText();
        
            String sql30 = "select sid from teacher_student where tid='"+s3+"' and date='"+ss+"' and subject='"+sub1+"'";
            rs2 = da.getData(sql30);
            try {
                if(rs2.next()){
                    System.out.println("break");
                    
                }
                else{
                    for(p=0;p<5;p++){
                        if(sid[p].equals("")){
                            System.out.println("");
                        }
                        else{
                    String sql8 = "insert into teacher_student (did,tid,tname,sid,sname,subject,status,date) values(NULL,'"+s3+"','"+s2+"','"+sid[p]+"','"+sname[p]+"','"+sub1+"','','"+ss+"')";
                    int s = da.updateDB(sql8); }           
                }
            }  }catch (SQLException ex) {
                Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
            }
       
   
       
        
        
        ref.addActionListener(this);
        back.addActionListener(this);
        chk1[0].addActionListener(this);
        chk1[1].addActionListener(this);
        chk1[2].addActionListener(this);
        chk1[3].addActionListener(this);
        chk1[4].addActionListener(this);
        //chk1[5].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == back){
            TeacherFrame tf = new TeacherFrame(s2,s3);
            //SubChoice sc = new SubChoice(s2,s3);
            dispose();
        }
        else if(e.getSource() == chk1[0]){
                if(chk1[0].isSelected()){
                String sql119 = "update teacher_student set status='p' where sid='"+sid[0]+"' and tid='"+s3+"'and subject='"+sub1+"'";
                int h = da.updateDB(sql119);
                //System.out.println(chk1[0].getText());
                }
                else{
                    String sql120 = "update teacher_student set status='a' where sid='"+sid[0]+"' and tid='"+s3+"'and subject='"+sub1+"'";
                int o = da.updateDB(sql120);
                }
            
        }
        
            else if(e.getSource() == chk1[1]){
            if(chk1[1].isSelected()){
            String sql119 = "update teacher_student set status='p' where sid='"+sid[1]+"' and tid='"+s3+"'and subject='"+sub1+"'";
            int h = da.updateDB(sql119);
            //System.out.println(chk1[0].getText());
            }
            else{
                String sql120 = "update teacher_student set status='a' where sid='"+sid[1]+"' and tid='"+s3+"'and subject='"+sub1+"'";
            int o = da.updateDB(sql120);
            }
            
        }
            
        else if(e.getSource() == chk1[2]){
       if(chk1[2].isSelected()){
       String sql119 = "update teacher_student set status='p' where sid='"+sid[2]+"' and tid='"+s3+"'and subject='"+sub1+"'";
       int h = da.updateDB(sql119);
       //System.out.println(chk1[0].getText());
       }
       else{
           String sql120 = "update teacher_student set status='a' where sid='"+sid[2]+"' and tid='"+s3+"'and subject='"+sub1+"'";
       int o = da.updateDB(sql120);
       }

    } 
                else if(e.getSource() == chk1[3]){
                if(chk1[3].isSelected()){
                String sql119 = "update teacher_student set status='p' where sid='"+sid[3]+"' and tid='"+s3+"'and subject='"+sub1+"'";
                int h = da.updateDB(sql119);
                //System.out.println(chk1[0].getText());
                }
                else{
                    String sql120 = "update teacher_student set status='a' where sid='"+sid[3]+"' and tid='"+s3+"'and subject='"+sub1+"'";
                int o = da.updateDB(sql120);
                }
            
        }
                        else if(e.getSource() == chk1[4]){
                if(chk1[4].isSelected()){
                String sql119 = "update teacher_student set status='p' where sid='"+sid[4]+"' and tid='"+s3+"'and subject='"+sub1+"'";
                int h = da.updateDB(sql119);
                //System.out.println(chk1[0].getText());
                }
                else{
                    String sql120 = "update teacher_student set status='a' where sid='"+sid[4]+"' and tid='"+s3+"'and subject='"+sub1+"'";
                int o = da.updateDB(sql120);
                }
            
        }
                                else if(e.getSource() == chk1[5]){
                if(chk1[5].isSelected()){
                String sql119 = "update teacher_student set status='p' where sid='"+sid[5]+"' and tid='"+s3+"'and subject='"+sub1+"'";
                int h = da.updateDB(sql119);
                //System.out.println(chk1[0].getText());
                }
                else{
                    String sql120 = "update teacher_student set status='a' where sid='"+sid[5]+"' and tid='"+s3+"'and subject='"+sub1+"'";
                int o = da.updateDB(sql120);
                }
            
        }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        else if(e.getSource() == ref){
            for(i=0;i<5;i++){
           String sql77 = "select sid from teacher_student where status='p' and subject='"+sub1+"' and sid='"+sid[i]+"' and sname='"+sname[i]+"' and date='"+ss+"'";
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

