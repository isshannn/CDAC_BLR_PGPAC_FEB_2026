#include<iostream>

using namespace std;
int main(){
    cout<<"Enter the length of the rectangle: ";
    double length;
    cin>>length;
    cout<<"Enter the width of the rectangle: ";
    double width;
    cin>>width;
    double area = length * width;
    cout<<"The area of the rectangle is: "<<area<<endl;
    return 0;	
}