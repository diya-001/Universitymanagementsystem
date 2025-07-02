package university.management.system;
import javax.swing.*;
import java.awt.*;//color class available in awt package
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import net.proteanit.sql.DbUtils;//USED to directoly insert value in  table
public class Teacherleavedetails extends JFrame implements ActionListener{
    Choice cempid;//for drop down// create a object of choice
    JTable table;//it is used to create table
    JButton search,print,cancel;
    Teacherleavedetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Search by Employee Id");
        heading.setBounds(20,20,150,20);
        add(heading);

        cempid=new Choice();
        cempid.setBounds(190,20,150,20);
        add(cempid);
        //next step for add r oll number in drop down
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from teacherleave");
            while(rs.next()){
                cempid.add(rs.getString("empid"));//add table rolllnumber in crollno

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        table=new JTable();
        try{//for value insert in table
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));//DIRECTLY ADD DATA
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);//for scrollbar and we want add scrollbar on table so we pass table as argument
        jsp.setBounds(0,80,900,600);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(20,50,80,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(130,50,80,20);
        print.addActionListener(this);
        add(print);
    
        cancel=new JButton("Cancel");
        cancel.setBounds(240,50,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,680);
        setLocation(300,100);
        setVisible(true);//because the visibility is false  means hidden
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="Select * from teacherleave where rollnum ='"+cempid.getSelectedItem()+"'";//varchar written inside''
            try{
                Conn c=new Conn();//to show only the search data
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==print){//for print command
            try{
                table.print();
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
        Teacherleavedetails s=new   Teacherleavedetails();
    }

}

