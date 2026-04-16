#include<iostream>

using namespace std;
int main(){
    cout<<"Enter three numbers: ";
    int a,b,c;
    cin>>a>>b>>c;
    int largest = (a>b) ? ((a>c) ? a : c) : ((b>c) ? b : c);
    cout<<"The largest number is: "<<largest<<endl;
    return 0;
}