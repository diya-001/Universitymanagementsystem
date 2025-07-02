package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;//for random class
import com.toedter.calendar.JDateChooser;//FOR CALENDER for which we use jdatechooser which is available in package com.toedter.calendeer
public class AddTeacher extends JFrame implements ActionListener{
    JTextField tfname;
    JTextField tffname;
    JTextField tfaddress,tfnumber,tfemail,tfx,tfxII,tfan;
    JLabel labelempid;//so label not change
    JDateChooser dc;
    JComboBox ccource,bbranch;//for dropdown
    JButton submit,cancel;

    Random ran=new Random();//we want roll number autogenerate so we use random
    long first4=Math.abs((ran.nextLong()% 9000L)+1000L);
    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);//left top

        setLayout(null);
        JLabel heading=new JLabel("New Teacher Detail");
        heading.setBounds(310,30,500,50);//left,top,length,width
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name=new JLabel("Name");
        name.setBounds(50,100,100,30);//left,top,length,width
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        tfname=new JTextField();
        tfname.setBounds(200,100,150,30);
        add(tfname);

        JLabel fathername=new JLabel("Father's Name");
        fathername.setBounds(400,100,200,30);//left,top,length,width
        fathername.setFont(new Font("serif",Font.BOLD,20));
        add(fathername);

        tffname=new JTextField();
        tffname.setBounds(600,100,150,30);
        add(tffname);

        JLabel empid=new JLabel("Employee Id");
        empid.setBounds(50,150,200,30);//left,top,length,width
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);

        labelempid=new JLabel("101"+first4);
        labelempid.setBounds(200,150,200,30);//left,top,length,width
        labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);

        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(400,150,200,30);//left,top,length,width
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        dc=new JDateChooser();
        dc.setBounds(600,150,200,30);
        add(dc);

        JLabel address=new JLabel("Address");
        address.setBounds(50,200,100,30);//left,top,length,width
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        tfaddress=new JTextField();
        tfaddress.setBounds(200,200,150,30);
        add(tfaddress);

        JLabel phonenumber=new JLabel("Phone Number");
        phonenumber.setBounds(400,200,200,30);//left,top,length,width
        phonenumber.setFont(new Font("serif",Font.BOLD,20));
        add(phonenumber);

        tfnumber=new JTextField();
        tfnumber.setBounds(600,200,150,30);
        add(tfnumber);

        JLabel emailid=new JLabel("Email Id");
        emailid.setBounds(50,250,100,30);//left,top,length,width
        emailid.setFont(new Font("serif",Font.BOLD,20));
        add(emailid);

        tfemail=new JTextField();
        tfemail.setBounds(200,250,150,30);
        add(tfemail);

        JLabel x=new JLabel("Class X (%)");
        x.setBounds(400,250,200,30);//left,top,length,width
        x.setFont(new Font("serif",Font.BOLD,20));
        add(x);

        tfx=new JTextField();
        tfx.setBounds(600,250,150,30);
        add(tfx);

        JLabel xII=new JLabel("Class xII (%)");
        xII.setBounds(50,300,200,30);//left,top,length,width
        xII.setFont(new Font("serif",Font.BOLD,20));
        add(xII);

        tfxII=new JTextField();
        tfxII.setBounds(200,300,150,30);
        add(tfxII);

        JLabel adharnum=new JLabel("Aadhar Number");
        adharnum.setBounds(400,300,200,30);//left,top,length,width
        adharnum.setFont(new Font("serif",Font.BOLD,20));
        add(adharnum);

        tfan=new JTextField();
        tfan.setBounds(600,300,150,30);
        add(tfan);

        JLabel qualification=new JLabel("Qualification");
        qualification.setBounds(50,350,200,30);//left,top,length,width
        qualification.setFont(new Font("serif",Font.BOLD,20));
        add(qualification);

        String cource[]={"MCA","B.Tech","BBA","BALLB","MA","MSC","BA","BSC","LLB","MBA","MCom"};
        ccource=new JComboBox<>(cource);
        ccource.setBounds(200,350,200,30);
        ccource.setBackground(Color.WHITE);
        add(ccource);

        JLabel department=new JLabel("Department");
        department.setBounds(400,350,200,30);//left,top,length,width
        department.setFont(new Font("serif",Font.BOLD,20));
        add(department);

        String branch[]={"Computer Science","Mechanical","Electronics","Civil","IT"};
        bbranch=new JComboBox<>(branch);
        bbranch.setBounds(600,350,200,30);
        bbranch.setBackground(Color.WHITE);
        add(bbranch);

        submit=new JButton("Submit");
        submit.setBounds(270,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,14));
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(490,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,14));
        add(cancel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent a){
                if(a.getSource()==submit){
                    String name=tfname.getText();
                    String fathername=tffname.getText();
                    String empid=labelempid.getText();
                    String dob=((JTextField)dc.getDateEditor().getUiComponent()).getText();//typrcast wid jtextfield//getuicomponenet give access of that component
                    String address=tfaddress.getText();
                    String phonenumber=tfnumber.getText();
                    String emailid=tfemail.getText();
                    String x=tfx.getText();
                    String xII=tfxII.getText();
                    String adharnum=tfan.getText();
                    String qualification=(String)ccource.getSelectedItem();// but it give error becouse it return object we save it as a string so we  typecast it
                    String department=(String)bbranch.getSelectedItem();
                    try{
                        String query="insert into teacher values('"+name+"','"+fathername+"','"+empid+"','"+dob+"','"+address+"','"+phonenumber+"','"+emailid+"','"+x+"','"+xII+"','"+adharnum+"','"+qualification+"','"+department+"')";
                        Conn c=new Conn();
                        c.s.executeUpdate(query);//here we update the table
                        JOptionPane.showMessageDialog(null,"Teacher Details Insertetd Successfully");
                        setVisible(false);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }   
                else{
                    setVisible(false);
                }                        
    }
    public static void main(String args[]){
        AddTeacher s=new AddTeacher();
    }    
}
