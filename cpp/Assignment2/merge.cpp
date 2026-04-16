/*
    Write a program using arrays and functions to merge two arrays into a third array.

*/
#include <iostream>
using namespace std;    
void merge(int arr1[], int arr2[], int merged[], int size1, int size2) {
    for (int i = 0; i < size1; i++) {
        merged[i] = arr1[i];
    }
    for (int j = 0; j < size2; j++) {
        merged[size1 + j] = arr2[j];
    }
}
int main() {
    int size1, size2;
    cout << "Enter the size of the first array: ";  
    cin >> size1;
    int arr1[size1];
    cout << "Enter elements of the first array: "; 
    for (int i = 0; i < size1; i++) {
        cin >> arr1[i];
    }
    cout << "Enter the size of the second array: ";
    cin >> size2;
    int arr2[size2];
    cout << "Enter elements of the second array: ";
    for (int i = 0; i < size2; i++) {
        cin >> arr2[i];
    }
    int merged[size1 + size2];
    merge(arr1, arr2, merged, size1, size2);
    cout << "Merged array: ";
    for (int i = 0; i < size1 + size2; i++)
        cout << merged[i] << " ";
    cout << endl;
    return 0;
}