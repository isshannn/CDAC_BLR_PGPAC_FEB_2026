#include<iostream>

using namespace std;
int main(){
    cout<<"Enter a number: "<<endl;
    int n;
    cin>>n;
    int count=0;
    while(n!=0){
        n=n/10;
        count++;
    }
    cout<<"The number of digits in the given number is: "<<count<<endl;
    return 0;   
}