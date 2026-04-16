/*
    Write a program using arrays and functions to find second largest element in an array.
*/

#include<iostream>
#include<array>

using namespace std;

int secondLargest(const array<int, 100>& arr, int size) {
    if (size < 2) {
        throw invalid_argument("Array must have at least two elements.");
    }

    int largest = arr[0];
    int secondLargest = 0;

    for (int i = 1; i < size; ++i) {
        if (arr[i] > largest) {
            secondLargest = largest;
            largest = arr[i];
        } else if (arr[i] > secondLargest && arr[i] != largest) {
            secondLargest = arr[i];
        }
    }

    if (secondLargest == 0) {   
        // This means there is no second largest element (all elements are the same)
        throw invalid_argument("There is no second largest element.");
    }

    return secondLargest;
}

int main() {
    array<int, 100> arr;
    int size;

    cout << "Enter the number of elements in the array (max 100): ";
    cin >> size;

    if (size < 1 || size > 100) {
        cerr << "Invalid size. Please enter a number between 1 and 100." << endl;
        return 1;
    }

    cout << "Enter " << size << " elements:" << endl;
    for (int i = 0; i < size; ++i) {
        cin >> arr[i];
    }

    try {
        int result = secondLargest(arr, size);
        cout << "The second largest element is: " << result << endl;
    } catch (const invalid_argument& e) {
        cerr << e.what() << endl;
    }

    return 0;
}