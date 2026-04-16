#include<iostream>

using namespace std;
int main(){
    cout<<"Leftshift operator (<<) is used to shift bits to the left."<<endl;
    cout<<"Rightshift operator (>>) is used to shift bits to the right."<<endl;
    cout<<"Example: "<<endl;
    int a = 5; // In binary: 0000 0101
    cout<<"Original value of a: "<<a<<endl;
    cout<<"a << 1 (Left shift by 1): "<<(a << 1)<<endl; // In binary: 0000 1010 (10 in decimal)
    cout<<"a >> 1 (Right shift by 1): "<<(a >> 1)<<endl; // In binary: 0000 0010 (2 in decimal)
    return 0;
}