import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class Controller{
	
	Scanner sc = new Scanner(System.in);
	
	
	public void InsertRecord() throws ClassNotFoundException, SQLException {
	
//		Initialize Driver and open the connection
		try {
			// This dynamically loads the MySQL driver class into memory
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL JDBC Driver successfully loaded!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found! Check your build path/classpath setup.");
			e.printStackTrace();
			System.exit(1);
		}

//		Connection string for Samvas_Asus
		Connection con =	DriverManager.getConnection("jdbc:mysql://localhost:3306/samvas_advjava","root","Samvas232");
		

		System.out.println("Enter Student id : ");
		int s_id = sc.nextInt();
		System.out.println("Enter Student Name : ");
		String s_name = sc.next();
		System.out.println("Course Enrolled : ");
		String s_course = sc.next();
		System.out.println("Marks Obtained : ");
		int s_marks = sc.nextInt();
		System.out.println("City : ");
		String s_city = sc.next();
		
		


		
//		Prepare statement and pass it into the connection
		PreparedStatement pmt = con.prepareStatement("insert into student values(?, ?, ?, ?, ?)");
		pmt.setInt(1, s_id);
		pmt.setString(2, s_name);
		pmt.setString(3, s_course);
		pmt.setInt(4, s_marks);
		pmt.setString(5, s_city);
		
		int ins_stat = pmt.executeUpdate();
		
		System.out.println("Record Inserted " + ins_stat);
		con.close();
	}
	
	public void UpdateRecord() throws SQLException {

//		Initialize Driver and open the connection
		try {
			// This dynamically loads the MySQL driver class into memory
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL JDBC Driver successfully loaded!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found! Check your build path/classpath setup.");
			e.printStackTrace();
			System.exit(1);
		}
		
//		Connection string for Samvas_Asus
		Connection con =	DriverManager.getConnection("jdbc:mysql://localhost:3306/samvas_advjava","root","Samvas232");
		
		System.out.println("=====================================");
		System.out.println("Select which field to be updated");
		System.out.println("1: Student Id");
		System.out.println("2: Student Name");
		System.out.println("3: Course");
		System.out.println("4: Marks");
		System.out.println("5: City");
		System.out.println("Enter Choice : ");
		int updt_ch = sc.nextInt();
		
		
		if(updt_ch<6 && updt_ch != 1 ) {
			System.out.println("Enter Student_id of the student record to be updated");
			int updt_id_ch = sc.nextInt();				
		}
		
		HashMap<Integer,String> updt_col = new HashMap<>();
		updt_col.put(1, "student_id");
		updt_col.put(2, "student_name");
		updt_col.put(3, "course");
		updt_col.put(4, "marks");
		updt_col.put(5, "city");
		
		PreparedStatement pmt = con.prepareStatement("update student set  ?  = ? where ? = ?");
		
		switch(updt_ch) {
			case 1 : PreparedStatement pmt_id = con.prepareStatement("update student set student_id = ?");
					 System.out.println("Enter updated student_id: ");
					 int up_stud_id = sc.nextInt();
					 pmt_id.setInt(1,up_stud_id);
					 System.out.println("Record updated with status "+ pmt_id.executeUpdate());
					 break;
			
			case 2 : System.out.println("Enter updated Student Name: ");
					 String updt_name = sc.nextLine();
					 pmt.setString(1,updt_col.get(2));
					 pmt.getString(2,updt_name);
					 
					
					
		}
	}
	
}
