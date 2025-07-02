package university.management.system;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class StudentLeave extends JFrame implements ActionListener{
    JDateChooser dcdate;
    Choice crollno,ctime;
    JButton submit ,cancel;
    StudentLeave(){
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel heading=new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        JLabel lblrollno=new JLabel("Search by Roll Number");
        lblrollno.setBounds(60,100,200,20);
        add(lblrollno);

        crollno=new Choice();
        crollno.setBounds(60,130,200,20);
        add(crollno);
        //next step for add r oll number in drop down
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from student");
            while(rs.next()){
                crollno.add(rs.getString("rollnum"));//add table rolllnumber in crollno

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel lbldate=new JLabel("Date");
        lbldate.setBounds(40,180,300,30);
        lbldate.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbldate);

        dcdate=new JDateChooser();
        dcdate.setBounds(60,210,200,30);
        add(dcdate);

        JLabel lbltime=new JLabel("Time Duration");
        lbltime.setBounds(40,250,200,20);
        lbltime.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbltime);

        ctime=new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("half Day");
        add(ctime);

        submit=new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,14));
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,14));
        add(cancel);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String rollnum=crollno.getSelectedItem();
            String date=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();
            String query="insert into studentleave values('"+rollnum+"','"+date+"','"+duration+"')";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }

    }

    public static void main(String args[]){
        new StudentLeave();

    }
}
