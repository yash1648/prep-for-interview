# Java Pattern Generation Workflows

This document provides a detailed workflow analysis for each pattern function in the Basic4x4.java file.

## Table of Contents
- [Pattern 1: Square Pattern](#pattern-1-square-pattern)
- [Pattern 2: Right Triangle Pattern](#pattern-2-right-triangle-pattern)
- [Pattern 3: Number Right Triangle (Values = Column Number)](#pattern-3-number-right-triangle-values--column-number)
- [Pattern 4: Number Right Triangle (Values = Row Number)](#pattern-4-number-right-triangle-values--row-number)
- [Pattern 5: Inverted Right Triangle](#pattern-5-inverted-right-triangle)
- [Pattern 6: Inverted Number Right Triangle](#pattern-6-inverted-number-right-triangle)
- [Pattern 7: Pyramid Pattern](#pattern-7-pyramid-pattern)
- [Pattern 8: Inverted Pyramid Pattern](#pattern-8-inverted-pyramid-pattern)
- [Pattern 9: Diamond Pattern](#pattern-9-diamond-pattern)
- [Pattern 10: Alternating 0-1 Triangle Pattern](#pattern-10-alternating-0-1-triangle-pattern)
- [Pattern 11: Palindrome Pattern](#pattern-11-palindrome-pattern)
- [Pattern 12: Number Sequence Triangle](#pattern-12-number-sequence-triangle)
- [Pattern 13: Alphabetic Right Triangle (A-Z)](#pattern-13-alphabetic-right-triangle-a-z)
- [Pattern 14: Inverted Alphabetic Right Triangle](#pattern-14-inverted-alphabetic-right-triangle)
- [Pattern 15: Same-Letter Rows Triangle](#pattern-15-same-letter-rows-triangle)
- [Pattern 16: Alphabetic Pyramid](#pattern-16-alphabetic-pyramid)
- [Pattern 17: Decreasing Alphabet Triangle](#pattern-17-decreasing-alphabet-triangle)
- [Pattern 18: Butterfly Pattern](#pattern-18-butterfly-pattern)
- [Pattern 19: Hourglass Pattern](#pattern-19-hourglass-pattern)
- [Pattern 20: Hollow Square/Rectangle](#pattern-20-hollow-squarerectangle)
- [Pattern 21: Number Pattern](#pattern-21-number-pattern)

## Pattern 1: Square Pattern

### Function
```java
public static void pattern1(int n){
    for(int i=0;i<n;i++){
        for (int j=0;j<n;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}
```

### Workflow
1. Takes an integer parameter `n` that determines the size of the square pattern
2. Uses two nested loops:
   - Outer loop (i): Controls the number of rows (from 0 to n-1)
   - Inner loop (j): Controls the number of columns (from 0 to n-1)
3. For each position in the grid, prints a "*" character
4. After completing each row, moves to a new line with `System.out.println()`

### Example Output (n=5)
```
*****
*****
*****
*****
*****
```

### Time Complexity
- O(n²) - where n is the input size

### Space Complexity
- O(1) - only constant extra space is needed

---

## Pattern 2: Right Triangle Pattern

### Function
```java
public static void pattern2(int n){
    for (int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            System.out.print("* ");
        }
        System.out.println();
    }
}
```

### Workflow
1. Takes an integer parameter `n` that determines the height of the triangle
2. Uses two nested loops:
   - Outer loop (i): Controls the number of rows (from 0 to n-1)
   - Inner loop (j): Controls the number of columns in each row, increasing with row number (from 0 to i)
3. For each position in the pattern, prints a "* " (star followed by space)
4. After completing each row, moves to a new line

### Example Output (n=5)
```
* 
* * 
* * * 
* * * * 
* * * * * 
```

### Time Complexity
- O(n²) - as the number of stars printed is 1+2+3+...+n = n(n+1)/2

### Space Complexity
- O(1) - only constant extra space is needed

---

## Pattern 3: Number Right Triangle (Values = Column Number)

### Function
```java
public static void pattern3(int n){
    for (int i=1;i<n;i++){
        for(int j=1;j<=i;j++){
            System.out.print(j);
        }
        System.out.println();
    }
}
```

### Workflow
1. Takes an integer parameter `n`
2. Loops from i=1 to n-1 (note this starts at 1, not 0)
3. For each row i:
   - Inner loop prints numbers from 1 to i
   - Each printed value equals the column number (j)
4. Moves to a new line after each row is complete

### Example Output (n=6)
```
1
12
123
1234
1234
```

### Notes
- Starts at i=1 instead of i=0
- Doesn't print spaces between numbers
- Values correspond to column position (j value)

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 4: Number Right Triangle (Values = Row Number)

### Function
```java
public static void pattern4(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            System.out.print(i);
        }
        System.out.println();
    }
}
```

### Workflow
1. Takes an integer parameter `n`
2. Loops from i=1 to n (inclusive)
3. For each row i:
   - Inner loop runs from j=1 to i
   - Always prints the current row number (i) regardless of column
4. Moves to a new line after each row

### Example Output (n=5)
```
1
22
333
4444
55555
```

### Notes
- Outer loop runs from 1 to n (inclusive)
- All numbers in the same row have the same value (row number)

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 5: Inverted Right Triangle

### Function
```java
public static void pattern5(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<n-i;j++){
            System.out.print("* ");
        }
        System.out.println();
    }
}
```

### Workflow
1. Takes an integer parameter `n`
2. Outer loop runs from i=0 to n-1
3. For each row i:
   - Inner loop runs from j=0 to (n-i-1)
   - Prints "* " for each iteration of the inner loop
4. Moves to a new line after each row

### Example Output (n=5)
```
* * * * * 
* * * * 
* * * 
* * 
* 
```

### Notes
- Number of stars decreases by 1 with each row
- First row has n stars, last row has 1 star

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 6: Inverted Number Right Triangle

### Function
```java
public static void pattern6(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n-i+1;j++){
            System.out.print(j);
        }
        System.out.println();
    }
}
```

### Workflow
1. Takes an integer parameter `n`
2. Outer loop runs from i=1 to n (inclusive)
3. For each row i:
   - Inner loop runs from j=1 to (n-i+1)
   - Prints the current column number (j)
4. Moves to a new line after each row

### Example Output (n=5)
```
12345
1234
123
12
1
```

### Notes
- First row prints numbers 1 to n
- Each subsequent row prints one fewer number
- Numbers always start from 1 and represent the column position

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 7: Pyramid Pattern

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Outer loop runs from i=0 to n-1
3. For each row i:
   - First inner loop: Print (n-i-1) spaces (leading spaces)
   - Second inner loop: Print (2*i+1) stars (the pyramid pattern)
   - Third inner loop: Print (n-1-i) spaces (trailing spaces)
     - Note: The third loop is not necessary for the visual appearance but is included in the code
4. Moves to a new line after each row

### Example Output (n=5)
```
    *    
   ***   
  *****  
 ******* 
*********
```

### Notes
- The number of stars follows the formula (2*i+1)
- Leading spaces decrease with each row
- The pattern forms a centered pyramid shape

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 8: Inverted Pyramid Pattern

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Outer loop runs from i=0 to n-1
3. For each row i:
   - First inner loop: Print i spaces (leading spaces increasing with each row)
   - Second inner loop: Print (2*n-(2*i+1)) stars (decreasing with each row)
   - Third inner loop: Print i spaces (trailing spaces increasing with each row)
     - Note: Like pattern 7, the third loop is not necessary for the visual appearance
4. Moves to a new line after each row

### Example Output (n=5)
```
*********
 *******
  *****
   ***
    *
```

### Notes
- First row has (2*n-1) stars
- Each subsequent row has 2 fewer stars
- Leading and trailing spaces increase with each row

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 9: Diamond Pattern

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Outer loop runs from i=0 to 2*n-1 (total of 2*n rows)
3. For each row i:
   - Calculate number of stars:
     - If i ≤ n: star = i (increasing)
     - If i > n: star = 2*n-i (decreasing)
   - Inner loop: Print the calculated number of stars
4. Moves to a new line after each row

### Example Output (n=5)
```
*
**
***
****
*****
****
***
**
*
```

### Notes
- The pattern increases to n stars, then decreases back
- Forms a left-aligned diamond shape
- No spaces are printed, only stars
- Total number of rows is 2*n-1

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 10: Alternating 0-1 Triangle Pattern

### Function
```java
public static void pattern10(int n){
    int start=-1;
    for (int i=0;i<n;i++) {
        if(i%2==0) start=1;
        else start=0;
        for(int j=0;j<=i;j++){
            System.out.print(start);
            start=1-start;
        }
        System.out.println();
    }
}
```

### Workflow
1. Takes an integer parameter `n`
2. Initializes start=-1 (will be updated before use)
3. Outer loop runs from i=0 to n-1
4. For each row i:
   - Determine the starting value for this row:
     - If i is even (i%2==0): start=1
     - If i is odd: start=0
   - Inner loop runs from j=0 to i
     - Print the current value (start)
     - Toggle the value using start=1-start (0 becomes 1, 1 becomes 0)
5. Moves to a new line after each row

### Example Output (n=5)
```
1
01
101
0101
10101
```

### Notes
- Even-indexed rows start with 1, odd-indexed rows start with 0
- Within each row, the values alternate between 0 and 1
- Forms a triangle with alternating binary values

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 11: Palindrome Pattern

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Initializes space=2*(n-1) for the spaces between numbers
3. Outer loop runs from i=1 to n-1
4. For each row i:
   - First inner loop: Print numbers from 1 to i (ascending)
   - Second inner loop: Print 'space' number of spaces
   - Third inner loop: Print numbers from i down to 1 (descending)
   - Decrease space by 2 for the next row
5. Moves to a new line after each row

### Example Output (n=5)
```
1      1
12    21
123  321
12344321
```

### Notes
- Each row is a palindrome of numbers
- The spaces between the ascending and descending parts decrease by 2 each row
- Forms a pattern where the middle has the largest numbers
- Note that the function prints only n-1 rows

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 12: Number Sequence Triangle

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Initializes counter c=1
3. Outer loop runs from i=0 to n-1
4. For each row i:
   - Inner loop runs from j=0 to i
   - Print the current counter value followed by a space
   - Increment the counter after each print
5. Moves to a new line after each row

### Example Output (n=5)
```
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
```

### Notes
- Forms a triangle with a continuous sequence of numbers
- Each number is one more than the previous
- The counter continues across rows without resetting

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 13: Alphabetic Right Triangle (A-Z)

### Function
```java
public static void pattern13(int n){
    char ch=65;
    for(int i=0;i<n;i++){
        for(char j=ch;j<=ch+i;j++){
            System.out.print(j+" ");
        }
        System.out.println();
    }
}
```

### Workflow
1. Takes an integer parameter `n`
2. Initializes ch=65 (ASCII for 'A')
3. Outer loop runs from i=0 to n-1
4. For each row i:
   - Inner loop with char j running from ch to ch+i
   - Print the current character followed by a space
5. Moves to a new line after each row

### Example Output (n=5)
```
A 
A B 
A B C 
A B C D 
A B C D E 
```

### Notes
- Uses ASCII values (65 is 'A', 66 is 'B', etc.)
- Each row starts with 'A' and continues sequentially
- Row i has i+1 letters

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 14: Inverted Alphabetic Right Triangle

### Function
```java
public static void pattern14(int n){
    char ch='A';
    for(int i=0;i<n;i++){
        for(char j=ch;j<=ch+(n-i-1);j++){
            System.out.print(j+" ");
        }
        System.out.println();
    }
}
```

### Workflow
1. Takes an integer parameter `n`
2. Initializes ch='A'
3. Outer loop runs from i=0 to n-1
4. For each row i:
   - Inner loop with char j running from ch to ch+(n-i-1)
   - Print the current character followed by a space
5. Moves to a new line after each row

### Example Output (n=5)
```
A B C D E 
A B C D 
A B C 
A B 
A 
```

### Notes
- Each row starts with 'A'
- Number of characters decreases with each row
- First row has n characters, last row has 1

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 15: Same-Letter Rows Triangle

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Initializes ch='A'
3. Outer loop runs from i=0 to n-1
4. For each row i:
   - Inner loop runs from j=0 to i
   - Print the current character (ch) repeatedly
   - Increment the character after completing the row
5. Moves to a new line after each row

### Example Output (n=5)
```
A
BB
CCC
DDDD
EEEEE
```

### Notes
- Each row contains the same letter repeated
- First row uses 'A', second row 'B', etc.
- The number of characters in each row equals the row number + 1

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 16: Alphabetic Pyramid

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Outer loop runs from i=0 to n-1
3. For each row i:
   - First inner loop: Print (n-i-1) leading spaces
   - Initialize ch='A' and the breakpoint bpoint=(2*i+1)/2
   - Second inner loop for the characters (from j=0 to 2*i):
     - Print the current character (ch)
     - If j < bpoint: Increment ch
     - Otherwise: Decrement ch
   - Third inner loop: Print (n-i-1) trailing spaces
4. Moves to a new line after each row

### Example Output (n=5)
```
    A    
   ABA   
  ABCBA  
 ABCDCBA 
ABCDEDCBA
```

### Notes
- Forms a pyramid of letters
- Each row is palindromic (same forward and backward)
- Letters increase from 'A' up to the middle point, then decrease back to 'A'
- The middle character of each row is calculated using the formula (i+1+'A'-1)

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 17: Decreasing Alphabet Triangle

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Initializes ch='E' (hardcoded starting letter)
3. Outer loop runs from i=0 to n-1
4. For each row i:
   - Sets ch to 'E'-i (starting character for this row)
   - Inner loop with char inner running from ('E'-i) to 'E'
   - Print each character followed by a space
5. Moves to a new line after each row

### Example Output (n=5)
```
E 
D E 
C D E 
B C D E 
A B C D E 
```

### Notes
- This pattern is hardcoded to start with 'E' and work backward
- Each row starts with a character that's i positions before 'E'
- Each row ends with 'E'
- The length of each row increases with each iteration

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 18: Butterfly Pattern

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. The function has two main parts that create the upper and lower halves of the butterfly

#### Upper Half:
3. Initializes init=0 (spaces between stars)
4. First outer loop runs from i=0 to n-1
5. For each row i:
   - First inner loop: Print (n-i) stars on the left
   - Second inner loop: Print 'init' spaces in the middle
   - Third inner loop: Print (n-i) stars on the right
   - Increment init by 2 for the next row
6. Moves to a new line after each row

#### Lower Half:
7. Resets init=2*n-2 (maximum spaces)
8. Second outer loop runs from i=0 to n-1
9. For each row i:
   - First inner loop: Print (i+1) stars on the left
   - Second inner loop: Print 'init' spaces in the middle
   - Third inner loop: Print (i+1) stars on the right
   - Decrement init by 2 for the next row
10. Moves to a new line after each row

### Example Output (n=4)
```
**** ****
***   ***
**     **
*       *
*       *
**     **
***   ***
**** ****
```

### Notes
- Forms a butterfly pattern with empty spaces in the middle
- The upper half has decreasing stars on each side
- The lower half has increasing stars on each side
- The spaces in the middle increase in the upper half and decrease in the lower half

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 19: Hourglass Pattern

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Initializes spaces=2*n-2
3. Outer loop runs from i=1 to 2*n-1
4. For each row i:
   - Calculate stars:
     - If i ≤ n: stars = i (increasing)
     - If i > n: stars = 2*n-i (decreasing)
   - First inner loop: Print 'stars' number of stars on the left
   - Second inner loop: Print 'spaces' number of spaces in the middle
   - Third inner loop: Print 'stars' number of stars on the right
   - Adjust spaces for next row:
     - If i < n: spaces -= 2 (decreasing)
     - Otherwise: spaces += 2 (increasing)
5. Moves to a new line after each row

### Example Output (n=5)
```
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *
```

### Notes
- Forms an hourglass pattern
- The number of stars on each side increases to n, then decreases
- The spaces follow the opposite pattern
- The middle row has 2*n stars with no spaces

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 20: Hollow Square/Rectangle

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Outer loop runs from i=0 to n-1 (rows)
3. Inner loop runs from j=0 to n-1 (columns)
4. For each position (i,j):
   - If it's on any edge (j==0 || j==n-1 || i==0 || i==n-1): Print "*"
   - Otherwise: Print a space
5. Moves to a new line after each row

### Example Output (n=5)
```
*****
*   *
*   *
*   *
*****
```

### Notes
- Creates a hollow square/rectangle pattern
- Only the border/perimeter has stars
- Interior of the square is filled with spaces

### Time Complexity
- O(n²)

### Space Complexity
- O(1)

---

## Pattern 21: Number Pattern

### Function
```java
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
```

### Workflow
1. Takes an integer parameter `n`
2. Outer loop runs from i=0 to 2*n-2 (rows)
3. Inner loop runs from j=0 to 2*n-2 (columns)
4. For each position (i,j):
   - Calculate distances to each edge:
     - top = i (distance from top edge)
     - left = j (distance from left edge)
     - right = (2*n-2)-j (distance from right edge)
     - bottom = (2*n-2)-i (distance from bottom edge)
   - Find the minimum of these four distances
   - Print (n-min) as the value for this position
5. Moves to a new line after each row

### Example Output (n=4)
```
4444444
4333334
4322234
4321234
4322234
4333334
4444444
```

Notes

Creates a concentric pattern of numbers
The outermost layer has all n's
Each inner layer decreases by 1
The centermost value is 1
Forms a complete square with sides of length 2*n-1
Uses the "minimum distance to any edge" to determine the number at each position

Mathematical Logic
The pattern uses a creative approach to generate concentric squares by calculating:

Distance from each position to each of the four boundaries
Taking the minimum of these distances
Subtracting this minimum from n to get the value at each position

This creates "layers" of numbers where positions equidistant from any edge get the same value, forming concentric squares.
Time Complexity

O(n²) because we iterate through (2n-1)² positions

Space Complexity

O(1) - only constant extra space is needed


Implementation Techniques Across Patterns
Common Loop Structures

Square/Rectangle Patterns: Use two nested loops with same bounds (i: 0 to n-1, j: 0 to n-1)
Triangle Patterns: Inner loop bound depends on outer loop value (j: 0 to i)
Inverted Triangles: Inner loop bound is n minus some function of i
Diamond/Pyramid Patterns: Use multiple inner loops for spaces and symbols

Variable Types

Most patterns use integer loop counters
Character patterns (13-17) use char variables, leveraging ASCII arithmetic
Some patterns use helper variables (start, init, spaces, etc.) to track state

Printing Techniques

Print-then-newline approach: Build each row with print() then end with println()
Space calculations: Many patterns calculate leading/trailing spaces for alignment
Special values: Several patterns print values based on position (row/column numbers)

Pattern Design Approaches

Layer-based: Pattern 21 uses distance to calculate "layers"
Direction-based: Patterns 7-9 build shapes by changing direction halfway
Mathematical: Several patterns use math formulas to determine values
Character arithmetic: Uses ASCII values to generate alphabetic patterns

Optimization Considerations

Many patterns could combine multiple loops into one with conditional printing
Some redundant calculations could be eliminated (e.g., pattern 7's third loop)
Variable reuse across iterations could be improved in several patterns

Error Handling
The current implementation doesn't include input validation. For production code, consider:

Checking for negative values of n
Setting reasonable upper limits on n to prevent excessive output
Handling potential overflow in calculations involving large values of n

Display Considerations

Spacing is inconsistent across patterns (some use spaces between characters, others don't)
Terminal width limitations may affect how patterns appear with large n values
Consider platform-specific line ending differences when implemented cross-platform