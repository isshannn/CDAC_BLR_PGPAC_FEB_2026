/*
    A company stores monthly sales of 4 products for 6 months in a 2D array. Write a program using functions to find product-wise and month-wise totals.
*/

#include <iostream> 
using namespace std;

void calculateTotals(int sales[4][6], int productTotals[4], int monthTotals[6]) {
    // Initialize totals to 0
    for (int i = 0; i < 4; i++) {
        productTotals[i] = 0;
    }
    for (int j = 0; j < 6; j++) {
        monthTotals[j] = 0;
    }

    // Calculate product-wise and month-wise totals
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 6; j++) {
            productTotals[i] += sales[i][j];
            monthTotals[j] += sales[i][j];
        }
    }
}

int main() {
    int sales[4][6];
    int productTotals[4];
    int monthTotals[6];

    // Input sales data
    cout << "Enter monthly sales for 4 products over 6 months:" << endl;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 6; j++) {
            cout << "Product " << i + 1 << ", Month " << j + 1 << ": ";
            cin >> sales[i][j];
        }
    }

    // Calculate totals
    calculateTotals(sales, productTotals, monthTotals);

    // Print product-wise totals
    cout << "\nProduct-wise Totals:" << endl;
    for (int i = 0; i < 4; i++) {
        cout << "Product " << i + 1 << ": " << productTotals[i] << endl;
    }

    // Print month-wise totals
    cout << "\nMonth-wise Totals:" << endl;
    for (int j = 0; j < 6; j++) {
        cout << "Month " << j + 1 << ": " << monthTotals[j] << endl;
    }

    return 0;
}