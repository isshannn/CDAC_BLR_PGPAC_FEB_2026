/*
    WAP to find factorial of a number using function which returns the factorial value. 
    if a number is passed to the function return its factorial, else return 1
*/

#include <iostream>
using namespace std;    

// Function to calculate factorial
int factorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
} 

int main() {
    int number;
    cout << "Enter a number to find its factorial: ";
    cin >> number;

    if (number < 0) {
        cout << "Factorial is not defined for negative numbers." << endl;
    } else {
        int result = factorial(number);
        cout << "Factorial of " << number << " is: " << result << endl;
    }

    return 0;
}