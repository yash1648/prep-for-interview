
# Recursion Problems

Recursion is a programming technique where a function calls itself to solve a problem. This document explains several recursive functions from the original document, focusing on how each function works, its base case, recursive case, and execution flow.

## Go back
[Recursion](Readme.md)

## Basic Recursion Problems

### 1. Print Name 5 Times

```java
public void printName5Times(int itr, int count) {
    if (count < itr)
        return;
        
    System.out.println("Name");
    printName5Times(itr+1, count);
}
```

**Explanation:**

- **Base Case:** When `count < itr`, the function returns without doing anything.
- **Recursive Case:** Print "Name" and call the function again with `itr+1`.
- **How it works:**
    - If called with `printName5Times(1, 5)`, it will print "Name" 5 times.
    - In each recursive call, `itr` increases by 1.
    - When `itr` becomes 6 (exceeding `count`), the base case is triggered and recursion stops.
- **Note:** This implementation counts up from `itr` to `count`.

### 2. Print From 1 to N Numbers

```java
public void printFrom1ToN(int i, int n) {
    if (i > n)
        return;
    System.out.println(i++);
    printFrom1ToN(i, n);
}
```

**Explanation:**

- **Base Case:** When `i > n`, the function returns.
- **Recursive Case:** Print the current value of `i`, increment it, and call the function recursively.
- **How it works:**
    - If called with `printFrom1ToN(1, 5)`, it prints numbers 1 through 5.
    - Each recursive call increments `i` until it exceeds `n`.
    - The function prints the number before making the recursive call.

### 3. Print From N To 1 Numbers

```java
public void printFromNTo1(int start, int end) {
    if (start < end)
        return;
    System.out.println(start--);
    printFromNTo1(start, end);
}
```

**Explanation:**

- **Base Case:** When `start < end`, the function returns.
- **Recursive Case:** Print the current value of `start`, decrement it, and call the function recursively.
- **How it works:**
    - If called with `printFromNTo1(5, 1)`, it prints numbers 5 down to 1.
    - Each recursive call decrements `start` until it becomes less than `end`.
    - The function prints the number before making the recursive call.

## Recursion with Backtracking

Backtracking in recursion means that some operations happen after the recursive calls, on the way back up the call stack.

### 4. Print From 1 to N Numbers (Backtracking method)

```java
public void printFrom1ToNWithoutIncr(int start, int end) {
    if (start == end)
        return;
    printFrom1ToNWithoutIncr(--start, end);
    System.out.println(start);
}
```

**Explanation:**

- **Base Case:** When `start == end`, the function returns.
- **Recursive Case:** Decrement `start` and make a recursive call, then print `start`.
- **How it works:**
    - If called with `printFrom1ToNWithoutIncr(5, 0)`, it prints numbers 0 through 4.
    - This is counterintuitive! The function decrements `start` before the recursive call.
    - The print statement happens AFTER the recursive call completes (on the way back up).
    - The execution stack would look like:
        - `print(0)` (after all recursive calls have returned)
        - `print(1)` (after recursive calls for 0 have returned)
        - `print(2)` (after recursive calls for 1 have returned)
        - And so on...

### 5. Print From N To 1 Numbers (Backtracking method)

```java
public void backtrackPrintNTo1(int start, int end) {
    if (start == end)
        return;
    backtrackPrintNTo1(++start, end);
    System.out.println(start);
}
```

**Explanation:**

- **Base Case:** When `start == end`, the function returns.
- **Recursive Case:** Increment `start` and make a recursive call, then print `start`.
- **How it works:**
    - If called with `backtrackPrintNTo1(0, 5)`, it prints numbers 5 down to 1.
    - Again counterintuitive! The function increments `start` before the recursive call.
    - The print statement happens AFTER the recursive call completes.
    - This creates a reversed output compared to the input parameters.

## Parameterized and Functional Recursion

### 6. Sum of Digits (Parameterized Return)

```java
public void sumOfDigit(int n, int sum) {
    if (n == 0) {
        System.out.println(sum);
        return;
    }
    sumOfDigit(n-1, sum+n);
}
```

**Explanation:**

- **Base Case:** When `n == 0`, print the accumulated sum and return.
- **Recursive Case:** Call the function with `n-1` and `sum+n`.
- **How it works:**
    - This is "parameterized recursion" where the result is built up in a parameter (`sum`).
    - If called with `sumOfDigit(5, 0)`, it calculates 5+4+3+2+1 = 15.
    - Each recursive call decrements `n` and adds the current value to `sum`.
    - When `n` reaches 0, the final sum is printed.

### 7. Sum of Digits (Functional Return)

```java
public int sumOfDigit(int n) {
    if (n == 0)
        return n;
    return n + sumOfDigit(n-1);
}
```

**Explanation:**

- **Base Case:** When `n == 0`, return 0.
- **Recursive Case:** Return `n` plus the recursive call with `n-1`.
- **How it works:**
    - This is "functional recursion" where the result is calculated in the return value.
    - If called with `sumOfDigit(5)`, it calculates 5+4+3+2+1+0 = 15.
    - Each recursive call builds up the sum in the return chain.
    - The calculation is performed during the "unwinding" of the recursion.

## Complex Recursion Examples

### 8. Reverse an Array using Recursion

```java
public void swapArray(int arr[], int l, int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
}

public void reverseArray(int arr[], int l, int r) {
    if (l == r) return;
    swapArray(arr, l, r);
    reverseArray(arr, l+1, r-1);
}
```

**Explanation:**

- **Helper Function:** `swapArray` swaps elements at indices `l` and `r`.
- **Base Case:** When `l` equals `r` (or exceeds `r`), the function returns.
- **Recursive Case:** Swap elements at `l` and `r`, then call function with `l+1` and `r-1`.
- **How it works:**
    - If called with `reverseArray(arr, 0, arr.length-1)`, it reverses the array in-place.
    - The function swaps the outermost elements and then moves inward.
    - Recursion stops when pointers meet in the middle.

### 9. Check if a String is Palindrome or Not

Two implementations are provided:

```java
public boolean equalityCheck(char a, char b) {
    return (a == b) ? true : false;
}

public boolean checkPalindrome(String str, int i) {
    if (i == str.length()/2) return true;
    
    if (equalityCheck(str.charAt(i), str.charAt(str.length()-i-1)))
        return checkPalindrome(str, i+1);
    else
        return false;
}
```

**Explanation:**

- **Helper Function:** `equalityCheck` compares two characters.
- **Base Case:** When `i` reaches half the string length, return true.
- **Recursive Case:** Check if characters at positions `i` and `length-i-1` match.
- **How it works:**
    - If called with `checkPalindrome(str, 0)`, it checks if the string is a palindrome.
    - The function compares characters from both ends moving inward.
    - If any pair doesn't match, it returns false immediately.
    - If all pairs match until the middle is reached, it returns true.

Simplified version:

```java
public boolean checkPalindromeEasy(String str, int i) {
    if (i >= str.length()/2) return true;
    
    if (str.charAt(i) != str.charAt(str.length()-i-1))
        return false;
        
    return checkPalindromeEasy(str, i+1);
}
```

**Explanation:**

- This version accomplishes the same task but is more concise.
- It directly checks if characters don't match and returns false if so.
- Otherwise, it continues the recursion.

### 10. Fibonacci

```java
public int fibonacci(int n) {
    if (n <= 1) return n;
    
    return fibonacci(n-1) + fibonacci(n-2);
}
```

**Explanation:**

- **Base Case:** When `n` is 0 or 1, return `n`.
- **Recursive Case:** Return the sum of fibonacci for `n-1` and `n-2`.
- **How it works:**
    - The Fibonacci sequence is defined as: F(n) = F(n-1) + F(n-2) where F(0) = 0 and F(1) = 1.
    - This function directly implements this mathematical definition.
    - For `fibonacci(5)`, it calculates F(5) = F(4) + F(3) = (F(3) + F(2)) + (F(2) + F(1)) = ...
    - Note: This implementation has exponential time complexity O(2^n) because it recalculates values multiple times.

## Common Recursion Patterns

This document demonstrates several important recursion patterns:

1. **Linear Recursion**: Each function calls itself exactly once (examples 1-3, 6-7).
2. **Backtracking**: Operations happen after the recursive call completes (examples 4-5).
3. **Parameterized Recursion**: Results are accumulated in a parameter (example 6).
4. **Functional Recursion**: Results are built up in return values (examples 7, 9, 10).
5. **Multiple Recursion**: Function calls itself multiple times (example 10 - Fibonacci).
6. **Two-pointer Technique**: Using two indices that move toward each other (examples 8-9).

## Tips for Writing Recursive Functions

1. **Identify the Base Case**: Determine when to stop recursion.
2. **Define the Recursive Case**: How the function should call itself.
3. **Ensure Progress Toward Base Case**: Make sure each recursive call moves closer to the base case.
4. **Think About the Call Stack**: Understand the order of execution, especially with backtracking.
5. **Consider Time and Space Complexity**: Recursion can have significant overhead.