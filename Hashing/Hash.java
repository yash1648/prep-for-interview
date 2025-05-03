import java.util.*;

public class Hash {
    
    public void countNumberOccuranceBruteForce(){
        
        int array[]={1,2,3,4,1,2};
        int count=0;


        //lets consider you have to find the number 1 occurance
        for(int i=0;i<array.length;i++){
            if(array[i]==1)
                count++;
        }
        System.out.println("Count of 1 is"+count);


    }

    public void countNumberOccuranceHashing(){
        
        int array[]={1,2,3,4,1,2};
        int count=0;

        //Precompiling a hash
        int hasharray[]=new int[13];
        for(int i=0;i<array.length;i++){
                hasharray[array[i]]+=1;
        }
        

        //lets consider you have find the occurance of 1 
        count=hasharray[1];
        System.out.println("Count of 1 is"+count);


    }

    public void charHashing(){
        
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your string");
        String str=sc.nextLine();

        System.out.println(str);
        

        //Pre comp
        int hash[]=new int[257];
        for(int i=0;i<str.length();i++){
            hash[str.charAt(i)]++;
        }

        System.out.println("Enter your character to fetch the count ");
        char ch=sc.next().charAt(0);
        System.out.println(hash[ch]);

    }

    
    public static void main(String[] args) {
            Hash h=new Hash();
            h.charHashing();
            
           
    }   
}