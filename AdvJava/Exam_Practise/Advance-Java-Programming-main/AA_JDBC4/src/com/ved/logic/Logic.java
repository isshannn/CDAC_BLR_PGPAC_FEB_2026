package com.ved.logic;

import java.sql.SQLException;
import java.util.Scanner;

import com.ved.DTO.EmployeeDTO;
import com.ved.crud.Crud;

public class Logic {

    private final int INSERT_DATA = 1;
    private final int READ_DATA = 2;
    private final int UPDATE_DATA = 3;
    private final int DELETE_DATA = 4;
    private final int DISPLAY_ALL_DATA = 5;
    private final int EXIT_DATA = 0;
    
	private int salary;
	private String username;
	private String password;
	private String fullname;
	private String address;
	
    private Crud crud;

    public Logic() {
    	crud = new Crud();
    }
    
    public void doStart() throws SQLException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU AA_JDBC04 =====");
            System.out.println("1. Insert Data");
            System.out.println("2. Read Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Display All Data");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            int n;

            try {
                n = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Only Integer Allowed!");
                sc.nextLine();
                continue;
            }

            switch (n) {
            case INSERT_DATA:
        	    System.out.println("Insert Method Called");
        	    System.out.println("Enter Username:");
        	    username = sc.next();
        	    System.out.println("Enter Password:");
        	    password = sc.next();
        	    System.out.println("Enter Full Name:");
        	    fullname = sc.next();
        	    System.out.println("Enter Address:");
        	    address = sc.next();
        	    System.out.println("Enter Salary:");
        	    salary = sc.nextInt();
        	    
        	    EmployeeDTO employeeDTO = new EmployeeDTO(username, password, fullname, address, salary);
                crud.insert(employeeDTO);
                break;

            case READ_DATA:
                System.out.println("Enter Username:");
                username = sc.next();
                System.out.println("Enter Password:");
                password = sc.next();
                crud.read(username, password);
                break;
                
            case UPDATE_DATA:
                System.out.println("Enter The Username For Update:");
                username = sc.next();
                System.out.println("Enter The New Salary:");
                salary = sc.nextInt();   
                crud.update(username, salary);
                break;

            case DELETE_DATA:
            	System.out.println("Enter The UserName: ");
            	username = sc.next();
                crud.delete(username);
                break;
                
            case DISPLAY_ALL_DATA:
            	crud.displayAll();
                break;

            case EXIT_DATA:
                System.out.println("Thank You!");
                sc.close();
                System.exit(0);
                break;

            default:
                System.out.println("Select Valid Option!");
            }
        }
    }
}