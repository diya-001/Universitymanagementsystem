package university.management.system;//package inside package nd file inside system package
import javax.swing.*;//jframe available in javaextended
import java.awt.*;
public class Splash extends JFrame implements Runnable {
    Thread t;//declare thread of runnable thread
    Splash(){//constructure
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));//cLASS loader is used to pick a images from directory with its static method getsystemresource
        Image i2=i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);//image is at object i1 so we take it by using getimage this scaledimage is available in awt
        ImageIcon i3=new ImageIcon(i2);//we also pass i2 but directly pass is not possible
        JLabel image=new JLabel(i3);//we can't add component or image directly so we uses jlable component of jframe
        add(image);//add function is used to add component on frame
        t =new Thread(this);//object and pass current class refrence by this
        t.start();

        setVisible(true);//set visibility of window true becz when we run the class visiblity is false 
        int x=1;
        for(int i=2;i<=580;i+=4,x+=1){
        setLocation(580-((i+x)/2),350-(i/2));//(left ,top) location set when we open it open at left so we set this at center
        setSize((i+3*x),i+x/2);//window size fix here because window is smaller whenn we run so here we increase size
        try{
            Thread.sleep(10);
        }
        catch(Exception e){}
        
        }
        
    }
    public void run(){//this is unimplement method that we need to write to remove error on splash when implement thread
        try{
            Thread.sleep(7000);//used to remove the first frame
            setVisible(false);
            Log l1=new Log();
        }//next frame
        catch(Exception e){

        }    
        }
       
    public static void main(String args[]){
        Splash s=new Splash();

    }
}
