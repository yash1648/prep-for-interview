
public class problems {
    
    
    public void printName5Times(int itr,int count){
		if(count<itr)
			return;
			
		System.out.println("Name");
		printName5Times(++itr,count);
	}

    public void printFrom1ToN(int i,int n){
        if(i>n)
            return;
        
        System.out.println(i++);
        printFrom1ToN(i, n);
    }


    public void printFromNTo1(int start,int end){
        if(start<end)
            return;
        
        System.out.println(start--);
         
        printFromNTo1(start,end);
    }

    public void printFrom1ToNWithoutIncr(int start,int end){
        if (start==end)
            return;
        printFrom1ToNWithoutIncr(--start, end);
        System.out.println(start);
    }

    public void backtrackPrintNTo1(int start,int end){
        if(start==end)
            return;

        backtrackPrintNTo1(++start, end);
        System.out.println(start);
    }

    public void sumOfDigit(int n,int sum){
        if(n==0)
            {
                System.out.println(sum);
                return;
            }
        sumOfDigit(n-1, sum+n);

    }

    public int sumOfDigitParam(int n){
        if(n==0)
            return 0;
        return n+sumOfDigitParam(n-1);
    }

    public void swapArray(int arr[],int l,int r){
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }

    public void reverseArray(int arr[],int l,int r){
        if(l==r) return;

        swapArray(arr, l, r);
        reverseArray(arr, l+1, r-1);
    }

    public void reverseArrayUsing1Var(int arr[],int i){
        if (i==arr.length/2) return;
        swapArray(arr, i, arr.length-i-1);
        reverseArrayUsing1Var(arr, i+1);

    }

    public boolean equalityCheck(char a,char b){
        return (a==b)?true:false;
    }

    public boolean checkPalindrome(String str,int i){
            if(i==str.length()/2) return true;

            if(equalityCheck(str.charAt(i), str.charAt(str.length()-i-1)))
                return checkPalindrome(str, i+1);
            else
                return false;
    }

    public boolean checkPalindromeEasy(String str,int i){
            if(i>=str.length()/2) return true;
            if(str.charAt(i)!=str.charAt(str.length()-i-1))
                return false;
            return checkPalindromeEasy(str, i+1);
    }

    public int fibonacci(int n){
        if (n<=1) return n;

        return fibonacci(n-1)+fibonacci(n-2);
    }

public static void main(String[] args) {
            problems p=new problems();
            int n=6;
            System.out.println(p.fibonacci(n));

    }
}
