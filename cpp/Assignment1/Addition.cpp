#include<iostream>
#include<string.h>
#include<bitset> 
using namespace std;

int main(){
	cout<<"Enter two integers"<<endl;
	int a,b;
	cin>>a>>b;
	cout<<"Sum of the two integers entered = "<<a+b<<endl;
	cout<<"Enter two binary numbers "<<endl;
	string b1,b2;
	cin>>b1>>b2;
	bitset<32> bs1(b1);
	bitset<32> bs2(b2);
	bitset<32> sum = bs1.to_ulong() + bs2.to_ulong();
	cout<<"Sum of the two binary numbers entered = "<<sum.to_string()<<endl;
	cout<<"Enter two characters "<<endl;
	char c1,c2;
	cin>>c1>>c2;
	cout<<"Sum of the two characters entered = "<<(int)c1+(int)c2<<endl;
	return 0;	
}
