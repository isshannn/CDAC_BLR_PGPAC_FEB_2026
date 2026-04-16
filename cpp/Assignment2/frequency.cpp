/*
    Write a program using arrays and functions to count frequency of each element in an array.
*/

#include <iostream>

using namespace std;   

void countFrequency(int arr[], int size) {
    int frequency[size] = {0}; // Initialize frequency array to 0

    // Count frequency of each element
    for (int i = 0; i < size; i++) {
        frequency[arr[i]]++;
    }

    // Print the frequency of each element
    cout << "Element\tFrequency" << endl;
    for (int i = 0; i < size; i++) {
        if (frequency[i] > 0) {
            cout << i << "\t" << frequency[i] << endl;
        }
    }
}

int main() {
    int size;
    cout << "Enter the size of the array: ";
    cin >> size;
    int arr[size];
    cout << "Enter " << size << " elements:" << endl;
    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }
    countFrequency(arr, size);
    return 0;
}
