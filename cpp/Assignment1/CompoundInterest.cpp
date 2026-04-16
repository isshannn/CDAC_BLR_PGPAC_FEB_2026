#include<iostream>
#include<cmath>

using namespace std;
int main(){
    double principal,rate,time,amount,compounding_frequency;
    cout<<"Enter the principal amount, rate of interest, time in years and compounding frequency"<<endl;
    cin>>principal>>rate>>time>>compounding_frequency;
    amount = principal * pow((1 + rate/(100*compounding_frequency)), compounding_frequency*time);
    cout<<"The compound interest is "<<amount - principal<<endl;
    return 0;	
}