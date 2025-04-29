class Basic4x4{
    public static void pattern1(int n){
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    
    public static void pattern2(int n){
        for (int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

     public static void pattern3(int n){
        for (int i=1;i<n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern4(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void pattern5(int n){
            for(int i=0;i<n;i++){

                for(int j=0;j<n-i;j++){
                    System.out.print("* ");
                }
                
                System.out.println();
            }
    }
    

    public static void pattern6(int n){
        for(int i=1;i<=n;i++){

            for(int j=1;j<=n-i+1;j++){
                System.out.print(j);
            }
            
            System.out.println();
        }
}

public static void pattern7(int n){
    for(int i=0;i<n;i++){

        for(int j=0;j<n-i-1;j++){
            System.out.print(" ");
        }

        for(int j=0;j<2*i+1;j++){
            System.out.print("*");
        }
        
        for (int j=0;j<n-1-i;j++){
            System.out.print(" ");
        }


        System.out.println();
    }
}

public static void pattern8(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            System.out.print(" ");
        }
        for(int j=0;j<(2*n-(2*i+1));j++){
            System.out.print("*");
        }
        for(int j=0;j<i;j++){
            System.out.print(" ");
        }
        System.out.println();

    }
}

public static void pattern9(int n){
    for(int i=0;i<=2*n-1;i++){
        int star=i;
        if (i>n) star=2*n-i;
        for(int j=0;j<star;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}


public static void pattern10(int n){
    int start=-1;
    for (int i=0;i<n;i++) {
        if(i%2==0) start=1;
        else start=0;
        for(int j=0;j<=i;j++){
            System.out.print(start );
            start=1-start;
        }
        System.out.println();
    }
}

public static void pattern11(int n) {
    int space=2*(n-1);    
        for(int i=1;i<n;i++){   

            for(int j=1;j<=i;j++){
                System.out.print(j);
            }

            for(int j=1;j<=space;j++){
                System.out.print(" ");
            }

            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
            space-=2;

        }
}


public static void pattern12(int n){
    int c=1;
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            System.out.print(c+" ");
            c++;
        }
        System.out.println();
    }
}


public static void pattern13(int n){
    char ch=65;
    for(int i=0;i<n;i++){
        for(char j=ch;j<=ch+i;j++){
            System.out.print(j+" ");
            
        }
        System.out.println();
    }
}
public static void pattern14(int n){
    char ch='A';
    for(int i=0;i<n;i++){
        for(char j=ch;j<=ch+(n-i-1);j++){
            System.out.print(j+" ");
            
        }
        System.out.println();
    }
}

public static void pattern15(int n){
    char ch='A';
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
                System.out.print(ch);
        
        }
        ch++;
        System.out.println();
    }
}


public static void pattern16(int n){
    char ch;
    int bpoint;
    for(int i=0;i<n;i++){
            
        for(int j=0;j<n-i-1;j++){
            System.out.print(" ");
        }

        
        ch='A';
        bpoint=(2*i+1)/2;
        for(int j=0;j<2*i+1;j++){
            System.out.print(ch);
            if(j<bpoint) ch++;
            else ch--;
        }



        for(int j=0;j<n-i-1;j++){
            System.out.print(" ");
        }

    System.out.println();
    }
}



public static void pattern17(int n){

    char ch = 'E';
    for (int i = 0; i < n; i++) {
        ch = (char)(ch - i);  
        for (char inner = (char)('E' - i); inner <= 'E'; inner++) {
            System.out.print(inner + " ");
        }
        System.out.println();
    }
    
}


public static void pattern18(int n){

    int init=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n-i;j++){
            System.out.print("*" );
        }

        for(int j=0;j<init;j++){
            System.out.print(" ");
        }


        for(int j=0;j<n-i;j++){
            System.out.print("*" );
        }

        init+=2;
        System.out.println();
    }

    init =2*n-2;
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            System.out.print("*");
        }

        for(int j=0;j<init;j++){
            System.out.print(" ");
        }

        for(int j=0;j<=i;j++){
            System.out.print("*");
        }

        init-=2;
        System.out.println();


    }
}


public static void pattern19(int n){

    int stars;
    int spaces=2*n-2;
    for(int i=1;i<=2*n-1;i++){
        stars=i;
        if (i>n) stars=2*n-i;

        for(int j=1;j<=stars;j++){
            System.out.print("*");
        }

        for(int j=1;j<=spaces;j++){
            System.out.print(" ");

        }

        for(int j=1;j<=stars;j++){
            System.out.print("*");
        }

        System.out.println();
        if(i<n) spaces-=2;
        else spaces+=2;

    }   
    
}

public static void pattern20(int n){
    for (int i = 0; i < n; i++) {
        for(int j=0;j<n;j++){
            if(j==0 || j==n-1||i==0||i==n-1){
                System.out.print("*");
            }
            else System.out.print(" ");
        }        
        System.out.println();
    }
}

public static void pattern21(int n) {
    int top;
    int bottom;
    int left;
    int right;
    for(int i=0;i<2*n-1;i++){
        for(int j=0;j<2*n-1;j++){
            top=i;
            left=j;
            right=(2*n-2)-j;
            bottom=(2*n-2)-i;
            int min=Math.min(Math.min(top,bottom),Math.min(left,right));
            System.out.print(n-min);
        }
        System.out.println();
    }
}

public static void main(String args[]){
        int n=5;
        pattern21(n);
     
    }
}
