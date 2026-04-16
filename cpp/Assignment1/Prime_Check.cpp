#include<iostream>

using namespace std;
int main(){
    cout<<"Enter a number: "<<endl;
    int n;
    cin>>n;
    for(int i=2;i<n;i++){
        if(n%i==0){
            cout<<"Not a prime number"<<endl;
            return 0;
        }
    }
    cout<<"Prime number"<<endl;
    return 0;	
}