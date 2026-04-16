/*
    WAP to find the maximum of 3 values that can either be integer, float or char using function overloading.
*/

#include <iostream>
using namespace std;

// Function to find maximum of 3 integers
int max(int a, int b, int c) {
    int maxVal = a; // Assume a is the maximum
    if (b > maxVal) {
        maxVal = b; // Update maxVal if b is greater
    }
    if (c > maxVal) {
        maxVal = c; // Update maxVal if c is greater
    }
    return maxVal;
}   

// Function to find maximum of 3 floats
float max(float a, float b, float c) {
    float maxVal = a; // Assume a is the maximum
    if (b > maxVal) {
        maxVal = b; // Update maxVal if b is greater
    }
    if (c > maxVal) {
        maxVal = c; // Update maxVal if c is greater
    }
    return maxVal;
}   

// Function to find maximum of 3 characters
char max(char a, char b, char c) {
    char maxVal = a; // Assume a is the maximum
    if (b > maxVal) {       
        maxVal = b; // Update maxVal if b is greater
    }
    if (c > maxVal) {
        maxVal = c; // Update maxVal if c is greater
    }
    return maxVal;
}

int main() {
    // Test with integers
    int int1 = 10, int2 = 20, int3 = 15;
    cout << "Maximum of " << int1 << ", " << int2 << ", and " << int3 << " is: " << max(int1, int2, int3) << endl;

    // Test with floats
    float float1 = 5.5, float2 = 3.3, float3 = 7.7;
    cout << "Maximum of " << float1 << ", " << float2 << ", and " << float3 << " is: " << max(float1, float2, float3) << endl;

    // Test with characters
    char char1 = 'A', char2 = 'C', char3 = 'B';
    cout << "Maximum of '" << char1 << "', '" << char2 << "', and '" << char3 << "' is: '" << max(char1, char2, char3) << "'" << endl;

    return 0;
}