/*
    A polling team stores votes received by candidates in an array. Write a program using functions to calculate total votes
    identify the winner, and find the vote difference between winner and runner-up.

*/

#include<iostream>
#include<array> 

using namespace std;

int main(){
    array<int,5> votes;
    for(int i=0;i<votes.size();i++)
        cin>>votes[i];
    
    // calculating total votes
    int total_votes=0;
    for(int i=0;i<votes.size();i++)
        total_votes+=votes[i];
    
    // finding the winner
    int winner_index=0;
    for(int i=1;i<votes.size();i++){
        if(votes[i]>votes[winner_index])
            winner_index=i;
    }
    
    // finding the runner-up
    int runner_up_index=-1;
    for(int i=0;i<votes.size();i++){
        if(i!=winner_index){
            if(runner_up_index==-1 || votes[i]>votes[runner_up_index])
                runner_up_index=i;
        }
    }
    
    cout<<"Total votes: "<<total_votes<<endl;
    cout<<"Winner: Candidate "<<winner_index+1<<" with "<<votes[winner_index]<<" votes"<<endl;
    cout<<"Runner-up: Candidate "<<runner_up_index+1<<" with "<<votes[runner_up_index]<<" votes"<<endl;
    cout<<"Vote difference between winner and runner-up: "<<votes[winner_index]-votes[runner_up_index]<<endl;
    
    return 0;
}