package university.management.system;
import java.sql.*;
public class Conn {
    Connection c;//refrence variable of connection
    Statement s;

    Conn(){
        try{//we need sql here and sql not available in project so we uses try catch
            Class.forName("com.mysql.cj.jdbc.Driver");//register driver by using Class who has static forename method in which we reg. the class
                          //package name...where driver class (Driver)available
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","Diyathakur__01@");//connection string means mention the information of database  
                                            //method through which we connect the database:name of database://where it is run:port(mysqldefaultport)/nameofdataba
            s=c.createStatement();//we can execute my sql query by this
        }
        catch(Exception e){
            e.printStackTrace();//PRINT Exception
        }
    }  
}