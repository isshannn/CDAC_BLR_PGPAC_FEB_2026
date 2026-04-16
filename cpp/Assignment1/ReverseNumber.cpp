#include<iostream>

using namespace std;
int main(){
    cout<<"Enter a number: "<<endl;
    int n;
    cin>>n;
    int reverse=0;
    while(n!=0){
        int digit=n%10;
        reverse=reverse*10+digit;
        n=n/10;
    }
    cout<<"The reverse of the given number is: "<<reverse<<endl;
    return 0;	
}