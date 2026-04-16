#include<iostream>

using namespace std;
int main(){
    cout<<"Enter two integers"<<endl;
    int a,b;
    cin>>a>>b;
    cout<<"Swapping without third variable"<<endl;
    cout<<"Before swapping: a = "<<a<<" b = "<<b<<endl;
    a = a + b;
    b = a - b;
    a = a - b;
    cout<<"After swapping: a = "<<a<<" b = "<<b<<endl;
    cout<<"Swapping with third variable"<<endl;
    cout<<"Before swapping: a = "<<a<<" b = "<<b<<endl;
    int temp;
    temp = a;
    a = b;
    b = temp;
    cout<<"After swapping: a = "<<a<<" b = "<<b<<endl;
    return 0;	
}