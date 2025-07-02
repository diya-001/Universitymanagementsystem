package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener{
    Project(){
        setSize(1600,830);
      
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));//cLASS loader is used to pick a images from directory with its static method getsystemresource
        Image i2=i1.getImage().getScaledInstance(1600,750,Image.SCALE_DEFAULT);//image is at object i1 so we take it by using getimage this scaledimage is available in awt
        ImageIcon i3=new ImageIcon(i2);//we also pass i2 but directly pass is not possible
        JLabel image=new JLabel(i3);//we can't add component or image directly so we uses jlable component of jframe
        add(image);//add function is used to add component on frame

        JMenuBar mb=new JMenuBar();//it is used to add menu bar
        JMenu newInformation=new JMenu("New Information");//this is a menu we want to add in menu bar
        newInformation.setForeground(Color.BLUE);//Change the color of text

        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        mb.add(newInformation);

        JMenu details=new JMenu("View Details");//this is a menu we want to add in menu bar
        details.setForeground(Color.RED);//Change the color of text

        JMenuItem facultyDetails=new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails=new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);
        mb.add(details);

        JMenu leave =new JMenu("Leave");
        leave.setForeground(Color.BLUE);
        
        JMenuItem facultyLeave=new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        
        JMenuItem studentLeave=new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        mb.add(leave);
        JMenu leaveDetails=new JMenu("Leave Deatils");
        leaveDetails.setForeground(Color.RED);

        JMenuItem faculityleaveDetail=new JMenuItem("Faculty Leave Details");
        faculityleaveDetail.setBackground(Color.WHITE);
        faculityleaveDetail.addActionListener(this);
        leaveDetails.add(faculityleaveDetail);
        
        JMenuItem studentleaveDetail=new JMenuItem("Student Leave Details");
        studentleaveDetail.setBackground(Color.WHITE);
        studentleaveDetail.addActionListener(this);
        leaveDetails.add(studentleaveDetail);

        mb.add(leaveDetails);
        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLUE);

        JMenuItem examinationDetail=new JMenuItem("Examination Result");
        examinationDetail.setBackground(Color.WHITE);
        examinationDetail.addActionListener(this);
        exam.add(examinationDetail);
        
        JMenuItem entermarks=new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        mb.add(exam);
        JMenu updateInfo=new JMenu("Update");
        updateInfo.setForeground(Color.RED);

        JMenuItem updatefaculityinfo=new JMenuItem("Update Faculty Details");
        updatefaculityinfo.setBackground(Color.WHITE);
        updatefaculityinfo.addActionListener(this);
        updateInfo.add(updatefaculityinfo);
        
        JMenuItem updatestudentdetail=new JMenuItem("Update Student Details");
        updatestudentdetail.setBackground(Color.WHITE);
        updatestudentdetail.addActionListener(this);
        updateInfo.add(updatestudentdetail);

        mb.add(updateInfo);
        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);

        JMenuItem feestructure=new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenuItem feeform=new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);
        mb.add(fee);

        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.RED);

        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        mb.add(utility);
        JMenu about=new JMenu("About");
        about.setForeground(Color.BLUE);

        JMenuItem ab=new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        mb.add(about);

        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.RED);

        JMenuItem ex=new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        mb.add(exit);
        setJMenuBar(mb);
        setVisible(true);//firstly add image then show visible
    }
    public void actionPerformed(ActionEvent e){
        String msg=e.getActionCommand();//it is used to detect string like exit,notepad 
        if(msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
            try{//calculator not in project so we use try catch block
                Runtime.getRuntime().exec("calc.exe");//getruntime run file whose extension is exe
            }catch(Exception a){

            }
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");//getruntime run file whose extension is exe
            }catch(Exception a){

            }
        }
        else if(msg.equals("New Faculty Information")){
            new AddTeacher();//object of class so add information
        }
        else if(msg.equals("New Student Information")){
            new Addstudent();
        }
        else if(msg.equals("View Faculty Details")){
            new Teacherdetails();
        }
        else if(msg.equals("View Student Details")){
            new Studentdetails();
        }else if(msg.equals("Student Leave")){
            new StudentLeave();
        }
        else if(msg.equals("Faculty Leave")){
            new Teacherleave();
        }
        else if(msg.equals("Update Student Details")){
            new Updatestudent();
        }
        else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }
        else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }
          else if(msg.equals("Examination Result")){
            new ExaminationDetails();
        }
         else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
        else if(msg.equals("About")){
            new About();
        }
        else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }else if(msg.equals("Student Leave Details")){
            new Studentleavedetails();
        }else if(msg.equals("Faculty Leave Details")){
            new Teacherleavedetails();
        }
    }
    public static void main(String args[]){
        Project p1=new Project();
    }
}
