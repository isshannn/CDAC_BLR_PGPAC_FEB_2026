#include <iostream>
#include <string>

using namespace std;
class Employee{
    protected : 
        int emp_id;
        string name;
        double ba;

    public:
    // Function to accept base employee details
    void EmployeeBaseDetails() {
        cout << "Enter Employee ID: ";
        cin >> emp_id;
        cin.ignore(); // To clear the input buffer before reading string with spaces
        cout << "Enter Name: ";
        std::getline(cin, name);
        cout << "Enter Basic Salary: ";
        cin >> ba;
    }
};

class Manager : public Employee{
    protected:
        double hra,da,ga,b;

    public:
        void cal_Sal(double basic){
            hra = 0.2 * basic;
            da = 0.1 * basic;
            ga = hra + da + basic;
        }
        void cal_Sal(double basic, double bonus){
            hra = 0.2 * basic;
            da = 0.1 * basic;
            b = bonus;
            ga = hra + da + basic + b;
        }
    
        Manager(){
            EmployeeBaseDetails();
            cout << "Enter Bonus: ";
            cin >> b;
            cal_Sal(ba,b);
            cout<<"-----------------------------------\n";
        }

        void displayDetails() {
            cout << "Employee ID  : " << emp_id << endl;
            cout << "Name         : " << name << endl;
            cout << "Basic Salary : " << ba << endl;
            cout << "HRA          : " << hra << endl;
            cout << "DA           : " << da << endl;
            cout << "Bonus        : " << b << endl;
            cout << "Gross Salary : " << ga << endl;
            cout << "-----------------------------------\n";
        }
};

int main(){
    Manager m[3];

    cout << "\n--- Displaying Manager Salary Details ---\n\n";
    for (int i = 0; i < 3; i++) {
        m[i].displayDetails();
    }
    return 0;
}