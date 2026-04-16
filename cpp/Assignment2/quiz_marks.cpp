/*
    A teacher stores quiz marks of students in an array. Write a program using functions to display marks, sort them, and assign ranks.
*/

#include<iostream>
#include<array> 

using namespace std;

int main(){
    array<int,10> quiz_marks;
    for(int i=0;i<quiz_marks.size();i++)
        cin>>quiz_marks[i];
    
    // sorting the array
    for(int i=0;i<quiz_marks.size();i++){
        for(int j=0;j<quiz_marks.size()-i-1;j++){
            if(quiz_marks[j]>quiz_marks[j+1]){        
                int temp=quiz_marks[j];
                quiz_marks[j]=quiz_marks[j+1];
                quiz_marks[j+1]=temp;
            }
        }
    }
    cout<<"Marks in sorted order: ";
    for(int i=0;i<quiz_marks.size();i++)
        cout<<quiz_marks[i]<<" ";
    cout<<endl;
    cout<<"Ranks: ";
    for(int i=0;i<quiz_marks.size();i++)
        cout<<i+1<<" ";
    cout<<endl;
    return 0;
}