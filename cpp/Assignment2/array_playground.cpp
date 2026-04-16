/*
    AP using functions to
        i) initialize an array
        ii) display the array
        iii) find the sum of elements
        iv) find the maximum value in array
        v) find the minimum value in array

*/

#include<iostream>
using namespace std;

void initializeArray(int arr[], int size) {
    cout << "Enter " << size << " elements: ";
    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }
}

void displayArray(int arr[], int size) {
    cout << "Array elements: ";
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int sumArray(int arr[], int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        sum += arr[i];
    }
    return sum;
}

int maxArray(int arr[], int size) {
    int maxVal = arr[0]; // Assume first element is the maximum
    for (int i = 1; i < size; i++) {
        if (arr[i] > maxVal) {
            maxVal = arr[i]; // Update maxVal if current element is greater
        }
    }
    return maxVal;
}

int minArray(int arr[], int size) {
    int minVal = arr[0]; // Assume first element is the minimum
    for (int i = 1; i < size; i++) {
        if (arr[i] < minVal) {
            minVal = arr[i]; // Update minVal if current element is smaller
        }
    }
    return minVal;
}

int main() {
    const int SIZE = 5;
    int arr[SIZE];

    initializeArray(arr, SIZE);
    displayArray(arr, SIZE);
    cout << "Sum of elements: " << sumArray(arr, SIZE) << endl;
    cout << "Maximum value: " << maxArray(arr, SIZE) << endl;
    cout << "Minimum value: " << minArray(arr, SIZE) << endl;

    return 0;
}