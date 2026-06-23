import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    
    Scanner sc = new Scanner(System.in);
    
    // Helper method to handle connection and avoid repeating code
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/samvas_advjava", "root", "Samvas232");
    }
    
    public void InsertRecord() throws ClassNotFoundException, SQLException {
        Connection con = getConnection();

        System.out.println("Enter Student id : ");
        int s_id = sc.nextInt();
        sc.nextLine(); // Clear buffer after int!
        
        System.out.println("Enter Student Name : ");
        String s_name = sc.nextLine(); // Use nextLine() for names with spaces
        
        System.out.println("Course Enrolled : ");
        String s_course = sc.nextLine(); // Use nextLine()
        
        System.out.println("Marks Obtained : ");
        int s_marks = sc.nextInt();
        sc.nextLine(); // Clear buffer after int!
        
        System.out.println("City : ");
        String s_city = sc.nextLine(); // Use nextLine()
        
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
    
    public int UpdateRecord() throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        
        System.out.println("=====================================");
        System.out.println("Select which field to be updated");
        System.out.println("1: Student Id");
        System.out.println("2: Student Name");
        System.out.println("3: Course");
        System.out.println("4: Marks");
        System.out.println("5: City");
        System.out.print("Enter Choice : ");
        int updt_ch = sc.nextInt();
        sc.nextLine(); // Clear buffer after picking choice!
        
        int updt_id_ch = 0;
        if (updt_ch < 6 && updt_ch != 1) {
            System.out.println("Enter Student_id of the student record to be updated: ");
            updt_id_ch = sc.nextInt();                
            sc.nextLine(); // Clear buffer after getting the ID!
        }
        
        HashMap<Integer, String> updt_col = new HashMap<>();
        updt_col.put(1, "student_id");
        updt_col.put(2, "student_name");
        updt_col.put(3, "course");
        updt_col.put(4, "marks");
        updt_col.put(5, "city");
        
        // Ensure choice is within valid range
        if (!updt_col.containsKey(updt_ch)) {
            System.out.println("Incorrect input");
            con.close();
            return 0;
        }

        // Special handling for changing primary key (Case 1)
        if (updt_ch == 1) {
            System.out.println("Enter current student_id to target: ");
            int current_id = sc.nextInt();
            System.out.println("Enter updated student_id: ");
            int up_stud_id = sc.nextInt();
            
            PreparedStatement pmt_id = con.prepareStatement("update student set student_id = ? where student_id = ?");
            pmt_id.setInt(1, up_stud_id);
            pmt_id.setInt(2, current_id);
            
            System.out.println("Record updated with status " + pmt_id.executeUpdate());
            con.close();
            return 0;
        }

        // Construct SQL dynamically with the column name injected safely
        String columnName = updt_col.get(updt_ch);
        String sql = "UPDATE student SET " + columnName + " = ? WHERE student_id = ?";
        PreparedStatement pmt_upd = con.prepareStatement(sql);
        
        switch (updt_ch) {
            case 2: 
                System.out.println("Enter updated Student Name: ");
                String updt_name = sc.nextLine();
                pmt_upd.setString(1, updt_name);
                break;
                     
            case 3: 
                System.out.println("Enter updated Course enrolled: ");
                String updt_course = sc.nextLine();
                pmt_upd.setString(1, updt_course);
                break;
                     
            case 4: 
                System.out.println("Enter updated Marks: ");
                int updt_marks = sc.nextInt(); // Marks are ints!
                sc.nextLine(); // Clear buffer
                pmt_upd.setInt(1, updt_marks);
                break;
                     
            case 5: 
                System.out.println("Enter updated City: ");
                String updt_city = sc.nextLine();
                pmt_upd.setString(1, updt_city);
                break;
             
        }
        
        // Pass the target student ID to the WHERE clause (always parameter 2 now)
        pmt_upd.setInt(2, updt_id_ch);
        
                
        System.out.println("Record updated with status " + pmt_upd.executeUpdate());
        con.close();
        return 0;
    }

    public void DeleteRecord() throws ClassNotFoundException, SQLException {
    	Connection con = getConnection();
    	PreparedStatement pmt_del = con.prepareStatement("Delete from student where student_id = ?");
    	System.out.println("Enter the student_id of the record to be deleted: ");
    	int del_id = sc.nextInt();
    	sc.nextLine();
    	pmt_del.setInt(1, del_id);
    	System.out.println("Record updated with status " + pmt_del.executeUpdate());
    }

    public void DisplayRecord() throws ClassNotFoundException, SQLException {
    	Connection con = getConnection();
    	Statement smt = con.createStatement();
    	String sql_query = "Select * from student";
    	ResultSet rs = smt.executeQuery(sql_query);
    	
    	
    	System.out.println("ID\tName\tCourse\tMarks\tCity");
    	System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
    	while (rs.next()) {
    		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5));
    		System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
    	}
    }

    public void SearchbyID() throws ClassNotFoundException, SQLException {
    	Connection con = getConnection();
    	
    	System.out.println("Enter student_id to be searched: ");
    	int search_id = sc.nextInt();
    	PreparedStatement pmt_search = con.prepareStatement("Select * from student where student_id = ?");
    	pmt_search.setInt(1, search_id);
    	ResultSet rs = pmt_search.executeQuery();
    	System.out.println("ID\tName\tCourse\tMarks\tCity");
    	System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
    	while (rs.next()) {
    		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5));
    		System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
    	}
    }
    
}