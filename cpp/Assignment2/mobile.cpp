/*
	A mobile shop stores prices of 15 phones in an array. Write a program using functions to sort the prices 
	and display the cheapest and costliest phone prices.
*/

#include<iostream>
#include<array>

using namespace std;

int main(){
	array<int,15> phn_price;
	for(int i=0;i<phn_price.size();i++)
		cin>>phn_price[i];
	// sorting the array
	for(int i=0;i<phn_price.size();i++){
		for(int j=0;j<phn_price.size()-i-1;j++){
			if(phn_price[j]>phn_price[j+1]){		
				int temp=phn_price[j];
				phn_price[j]=phn_price[j+1];
				phn_price[j+1]=temp;
			}
		}
	}
	cout<<"Cheapest phone price: "<<phn_price[0]<<endl;
	cout<<"Costliest phone price: "<<phn_price[phn_price.size()-1]<<endl;
	return 0;
}