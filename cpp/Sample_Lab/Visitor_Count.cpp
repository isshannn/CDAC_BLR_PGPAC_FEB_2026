#include <iostream>
#include <string>

using namespace std;

class Visitor {
private:
    string visitorId;
    string visitorName;
    
    // Static variable shared by all objects to track the total count
    static int count; 

public:
    // Constructor - called automatically whenever a new object is created
    Visitor(string id, string name) {
        visitorId = id;
        visitorName = name;
        
        // Increment the shared count for every new object
        count++; 
        
        // Display the count immediately after creation as required
        displayCount();
    }

    // Function to display the current object count
    void displayCount() {
        cout << "Object created! Current total visitors: " << count << endl;
    }
};

// Definition and initialization of the static data member outside the class
int Visitor::count = 0;

int main() {
    cout << "--- Creating Visitor Objects ---" << endl;

    // Creating 1st object
    Visitor v1("V101", "Alice");

    // Creating 2nd object
    Visitor v2("V102", "Bob");

    // Creating 3rd object
    Visitor v3("V103", "Charlie");

    return 0;
}
