#include<iostream>

using namespace std;
int main(){
    cout<<"Bitwise Operators in C++"<<endl;
    cout<<"Enter two numbers: ";
    int a,b;
    cin>>a>>b;
    cout<<"a | b = "<<(a | b)<<endl;
    cout<<"a ^ 1 = "<<(a ^ 1)<<endl;
    cout<<"a & 1 = "<<(a & 1)<<endl;
    return 0;
}