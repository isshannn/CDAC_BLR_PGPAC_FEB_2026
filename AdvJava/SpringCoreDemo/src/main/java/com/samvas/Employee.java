package com.samvas;

import com.samvas.Address;

public class Employee {
	private int empId;
    private String empName;
    private Address address;

    public Employee(int empId,
                    String empName,
                    Address address) {

        this.empId = empId;
        this.empName = empName;
        this.address = address;
    }

    public void display() {

        System.out.println("Employee Id   : " + empId);
        System.out.println("Employee Name : " + empName);

        address.display();
    }
}
