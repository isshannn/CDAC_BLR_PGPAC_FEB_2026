import java.util.*;

public class ArrayClass{
    int n=7, ar[]=new int[n];
    //  int ar[]=
     void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++){  
            ar[i]=sc.nextInt();
        }
        
    }
    void display()
    {
        for(int i=0;i<n;i++){
            System.out.print(ar[i]+" ");
        }
        
    }
    void delete(int pos){
        
        for (int i = pos; i < ar.length; i++) {
            ar[i]=ar[i+1];
        }
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i]+" ");
        }

    }
    void search(int k)
    {
        boolean found=false;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]==k){
                found=true;
                break;
            }
            
        }
        if(found){
            System.out.println("Element found");
        }
        else{
            System.out.println("Element not found");
        }
    }

}
public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    // System.out.println("enter the size");
    // int n=sc.nextInt();
    ArrayClass ob=new ArrayClass();
    System.out.println("1.Input elements \n2.Display\n3.Delete\n4.Search\n5.Exit");
    System.out.println("Enter your choice");
    int ch=sc.nextInt();
    switch (ch) {
        case 1:
           ob.input();
            
            break;
        case 2:
            ob.display();
            break;
        case 3:
            System.out.println("Enter the position to delete");
            ob.delete(sc.nextInt());
            break;
            case 4:
                
            System.out.println("Enter the number to search");
            ob.search(sc.nextInt());

            
            break;
        case 5:
            System.exit(0);
            break;
        default:
            System.out.println("invalid choice");
            
    }
}