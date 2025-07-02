package university.management.system;
import javax.swing.*;
import java.awt.*;//color class available in awt package
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import net.proteanit.sql.DbUtils;//USED to directoly insert value in  table
public class Studentleavedetails extends JFrame implements ActionListener{
    Choice crollno;//for drop down// create a object of choice
    JTable table;//it is used to create table
    JButton search,print,cancel;
    Studentleavedetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        crollno=new Choice();
        crollno.setBounds(190,20,150,20);
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
        table=new JTable();
        try{//for value insert in table
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from studentleave");
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
            String query="Select * from studentleave where rollnum ='"+crollno.getSelectedItem()+"'";//varchar written inside''
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
        Studentleavedetails s=new Studentleavedetails();
    }

}
