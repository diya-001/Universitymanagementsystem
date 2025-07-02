package university.management.system;
import javax.swing.*;
import java.awt.*;//this is import for color class in awt color class is available
import java.awt.event.*;//this is import for a actionlistener 
import java.sql.*;//this  is for result set where the table is store
public class Log extends JFrame implements ActionListener{
    JButton Login,Cancel;//globally declare
    JTextField tfusername;
    JPasswordField uspassword;
    Log(){
        getContentPane().setBackground(Color.WHITE);//set the background color of white
        setLayout(null);//we want to adjust by itself so null
        JLabel lblusername=new JLabel("username");//jlable main use is to write something on window
        lblusername.setBounds(40,20,100,20);//setbound used to adjust loaction by itself distance from left ,top,label width,lable height
        add(lblusername);
        tfusername=new JTextField();//this is for taking username as ainput from user
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        JLabel password=new JLabel("password");
        password.setBounds(40,70,100,20);
        add(password);
        uspassword=new JPasswordField();//password show the password we write in password in password form so it cannot seen by other
        uspassword.setBounds(150,70,150,20);
        add(uspassword);

        Login=new JButton("Login");
        Login.setBounds(40,140,120,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        Login.setFont(new Font("Tahoma",Font.BOLD,14));
        add(Login);

        Cancel=new JButton("Cancel");
        Cancel.setBounds(180,140,120,30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Tahoma",Font.BOLD,14));
        add(Cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));//cLASS loader is used to pick a images from directory with its static method getsystemresource
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);//image is at object i1 so we take it by using getimage this scaledimage is available in awt
        ImageIcon i3=new ImageIcon(i2);//we also pass i2 but directly pass is not possible
        JLabel image=new JLabel(i3);//we can't add component or image directly so we uses jlable component of jframe
        image.setBounds(350,0,200,200);
        add(image);//add function is used to add component on frame

        setSize(600,300);
        setLocation(500,250);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){//this method in actionlistener so we override it otherwise error occur in class log
        if(e.getSource()==Login){
            String username=tfusername.getText();
            String password=uspassword.getText();
            String query="select * from login where username='"+username+"'and password='"+password+"'";
            try{
                Conn c=new Conn();//to execute query create a object of class conn it create connection automatically
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){// if username and pass are available in resultset then do this
                    setVisible(false);//current frame close
                    new Project();//next frame open if pass correct

                }else{//if not available means incorrect pass username
                    JOptionPane.showMessageDialog(null, "Invalid username and password");//FOR POPPUP msg we use joption in static methd showmesg in which  argument(formatting,string show on poppup)
                    setVisible(false);

                }
            }catch(Exception ae){//try amnd catch  use  becz we r working with mysql so there is a chance of error
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==Cancel){
            setVisible(false);
        }
    }

    public static void main(String args[]){
        Log l1=new Log();
    }
    
}
