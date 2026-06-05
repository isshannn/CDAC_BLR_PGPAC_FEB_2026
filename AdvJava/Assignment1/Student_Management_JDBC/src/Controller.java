import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller{
	public void InsertRecord() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student id : ");
		int s_id = sc.nextInt();
		System.out.println("Enter Student Name : ");
		String s_name = sc.next();
		System.out.println("Course Enrolled : ");
		String s_course = sc.next();
		System.out.println("Marks Obtained : ");
		float s_marks = sc.nextFloat();
		System.out.println("City : ");
		String s_city = sc.next();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =	DriverManager.getConnection("jdbc:mysql://localhost:3306/samvas_jdbc","root","cdacacts");
		
		Statement smt ;
		smt =  con.createStatement();
		String q;
	    q= "insert into student values(" + s_id + "," + s_name + "," + s_course + "," + s_marks + "," + s_city + ");";
	    
	    ResultSet rs=smt.executeQuery(q);
	}
	
}
