#include <iostream>
#include <math.h>
using namespace std;
double area(double radius){
    return (3.14 * pow(radius,2));
}

double area(double length, double breadth){
    return (length * breadth);
}

double area(double base, double height, char shape){
    if (shape == 'T'){
        return (0.5 * base * height);
    }
    else{
        std::cout<<"Invalid Shape Entered, terminating calculation";
        return 0;
    }
}

bool validate(double a){
    if (a < 0) return true;
    else return false;
}
bool validate(double a,double b){
    if (a < 0 && b < 0) return true;
    else return false;
}

int main(){
    int ch = 1; 
    while (ch >0){
        std::cout<<"\n AREA CALCULATOR \n";
        std::cout<<"\n 1: Circle \n";
        std::cout<<"\n 2: Rectangle \n";
        std::cout<<"\n 3: Triangle \n";
        std::cout<<"\n 4: Exit \n";
        std::cout<<"\n Enter Choice : ";
        cin >> ch;
        switch(ch){
            case 1: cout<<"\n Enter radius :";
                    double r; cin >> r;
                    if (validate(r)){
                        cout<<"\n Input value < 0. Terminating Calculation";
                        break;
                    }
                    cout<<"\n Area of circle with radius "<<r<<" = "<<area(r);
                    break;
    
            case 2: cout<<"\n Enter length :";
                    double l; cin >> l;
                    cout<<"\n Enter breadth :";
                    double b; cin >> b;
                    if (validate(l,b)){
                        cout<<"\n Input value < 0. Terminating Calculation";
                        break;
                    }
                    cout<<"\n Area of rectangle with length "<<l<<" and breadth "<<b<<" = "<<area(l,b);
                    break;
    
            case 3: cout<<"\n Enter base :";
                    double ba; cin >> ba;
                    cout<<"\n Enter height :";
                    double h; cin >> h;
                    cout<<"\n Enter shape: ";
                    char s; cin >> s;
                    if (validate(ba) && validate(h)){
                        cout<<"\n Input value < 0. Terminating Calculation";
                        break;
                    }
                    if (! area(ba,h,s) == 0){
                        cout<<"\n Area of triangle with base "<<b<<" and height "<<"h"<<" = "<<area(ba,h,s);
                        break;
                    }
                    else break;
            
            case 4: ch = -1; break;
    
            default : cout<<"\n Invalid choice entered";
                      break;  
        }   
    }
}
