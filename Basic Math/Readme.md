# Digit Extraction and Number Manipulation Techniques

This guide explains in depth how to extract and manipulate digits in a number, covering various functions and explaining the complete workflow for each approach.

## Digit Extraction: Core Concept

The foundation of all these techniques is understanding how to extract individual digits from a number. This is achieved through two key operations:

1. **Modulo (%)**: Extracts the last digit of a number
   - `number % 10` gives the last digit
   - Example: `564949 % 10 = 9`

2. **Integer Division (/)**:  Removes the last digit
   - `number / 10` removes the last digit (in integer division)
   - Example: `564949 / 10 = 56494`

By repeatedly applying these two operations, we can process each digit of a number from right to left.

## Sum of Digits

Let's analyze the function step by step:

```java
public static int sumOfDigits(int n) {
    int sum = 0;    // Initialize sum to 0
    int digit;      // Will store each extracted digit
    
    while (n > 0) {  // Continue until all digits are processed
        digit = n % 10;  // Extract the last digit
        sum += digit;    // Add digit to running sum
        n = n / 10;      // Remove the last digit
    }
    
    return sum;
}
```

**Workflow example with 564949:**
1. Initialize `sum = 0`
2. Is 564949 > 0? Yes, continue
   - Extract last digit: `digit = 564949 % 10 = 9`
   - Add to sum: `sum = 0 + 9 = 9`
   - Remove last digit: `n = 564949 / 10 = 56494`
3. Is 56494 > 0? Yes, continue
   - Extract last digit: `digit = 56494 % 10 = 4`
   - Add to sum: `sum = 9 + 4 = 13`
   - Remove last digit: `n = 56494 / 10 = 5649`
4. Continue until n becomes 0
5. Final result: `sum = 9 + 4 + 9 + 4 + 6 + 5 = 37`

## Count Digits

This function determines how many digits are in a number:

```java
public static int countDigit(int n) {
    int count = 0;       // Initialize counter
    
    while (n > 0) {      // Continue until number becomes 0
        count++;         // Increment counter for each digit
        n /= 10;         // Remove last digit (shorthand for n = n / 10)
    }
    
    return count;
}
```

**Workflow example with 564949:**
1. Initialize `count = 0`
2. Is 564949 > 0? Yes, continue
   - Increment: `count = 1`
   - Remove last digit: `n = 56494`
3. Is 56494 > 0? Yes, continue
   - Increment: `count = 2`
   - Remove last digit: `n = 5649`
4. Continue until n becomes 0
5. Final result: `count = 6` (564949 has 6 digits)

## Reverse Number

This function reverses the digits of a number:

```java
public static int reverseNumber(int n) {
    int rev = 0;     // Initialize reversed number
    int r;           // Will store each extracted digit
    
    while (n > 0) {
        r = n % 10;            // Extract last digit
        rev = rev * 10 + r;    // Add digit to reversed number
        n /= 10;               // Remove last digit
    }
    
    return rev;
}
```

**The key insight here is how digits are added to the reversed number:**
- Each time we extract a digit, we multiply the current reversed number by 10 (shifting left)
- Then add the extracted digit to the ones place

**Workflow example with 564949:**
1. Initialize `rev = 0`
2. Is 564949 > 0? Yes, continue
   - Extract last digit: `r = 564949 % 10 = 9`
   - Build reversed number: `rev = 0 * 10 + 9 = 9`
   - Remove last digit: `n = 56494`
3. Is 56494 > 0? Yes, continue
   - Extract last digit: `r = 56494 % 10 = 4`
   - Build reversed number: `rev = 9 * 10 + 4 = 94`
   - Remove last digit: `n = 5649`
4. Continue until n becomes 0
5. Final result: `rev = 949465` (reverse of 564949)

## Check Palindrome

A palindrome reads the same backward as forward (e.g., 12321). This function checks if a number is a palindrome:

```java
public static boolean isPalindrome(int n) {
    int temp = n;    // Store original number
    int rev = 0;     // Initialize reversed number
    int r;           // Will store each extracted digit
    
    while (temp > 0) {
        r = temp % 10;         // Extract last digit
        rev = rev * 10 + r;    // Build reversed number
        temp = temp / 10;      // Remove last digit
    }
    
    return (rev == n);         // Compare reversed with original
}
```

**Workflow:**
1. Store the original number
2. Reverse the number (using same technique as reverseNumber function)
3. Compare reversed number with original
   - If equal, it's a palindrome
   - If not equal, it's not a palindrome

For example:
- For 12321: Reversed = 12321, same as original → Palindrome
- For 564949: Reversed = 949465, different from original → Not a palindrome

## Armstrong Number

An Armstrong number equals the sum of its digits each raised to the power of the number of digits.
In the provided code, a special case of Armstrong numbers (sum of cubes of digits) is checked:

```java
public static boolean isArmstrong(int n) {
    int temp = n;    // Store original number
    int sum = 0;     // Initialize sum
    int cube;        // Will store cube of each digit
    
    while (temp > 0) {
        cube = n % 10;                 // Extract last digit (note: should be temp % 10)
        sum = sum + (cube * cube * cube);  // Add cube of digit to sum
        temp = temp / 10;              // Remove last digit
    }
    
    if (n == sum)
        return true;
    else
        return false;
}
```

**Note:** There's a bug in this function - it should use `temp % 10` instead of `n % 10` for extracting digits.

**Corrected workflow example with 153:**
1. For 153 (3-digit number)
2. Extract and cube each digit:
   - 3³ = 27
   - 5³ = 125
   - 1³ = 1
3. Sum = 27 + 125 + 1 = 153
4. Since 153 equals the sum, it's an Armstrong number

## Print All Divisions (Factors)

This function finds all factors of a number:

```java
public static List<Integer> printAllDivisions(int n) {
    int temp = n;                 // Store original number
    List<Integer> list = new ArrayList<>();  // To store factors
    
    for (int i = 1; i * i < temp; i++) {  // Only check up to square root
        if (temp % i == 0) {      // If i is a factor
            list.add(i);          // Add i to factors list
            if ((n / i) != i)     // Avoid duplicates for perfect squares
                list.add(n / i);  // Add corresponding factor
        }
    }
    
    Collections.sort(list);       // Sort the factors
    return list;
}
```

**Key insight:** By checking factors only up to the square root and adding both the factor and its pair, we optimize the algorithm.

**Workflow example with 36:**
1. Check i = 1: 36 % 1 = 0, add 1 and 36/1 = 36
2. Check i = 2: 36 % 2 = 0, add 2 and 36/2 = 18
3. Check i = 3: 36 % 3 = 0, add 3 and 36/3 = 12
4. Check i = 4: 36 % 4 = 0, add 4 and 36/4 = 9
5. Check i = 5: 36 % 5 ≠ 0, skip
6. Check i = 6: 36 % 6 = 0, add 6 and 36/6 = 6 (but since 6 = 6, add only once)
7. Result: [1, 2, 3, 4, 6, 9, 12, 18, 36]

## Prime Number Check

This function checks if a number is prime by looking for factors:

```java
public static boolean isPrime(int n) {
    int count = 0;
    for (int i = 2; i * i < n; i++) {  // Check only up to square root
        if (n % i == 0) {         // If i is a factor
            count++;              // Increment count
            if ((n / i) != i)     // Account for the pair factor
                count++;
        }
    }
    return (count > 0) ? false : true;  // If count > 0, not prime
}
```

**Workflow:**
1. Check each potential factor from 2 up to the square root
2. If any factors are found, the number is not prime
3. Return true only if no factors are found

**Example with 17:**
- Check i = 2: 17 % 2 ≠ 0, not a factor
- Check i = 3: 17 % 3 ≠ 0, not a factor
- Check i = 4: 17 % 4 ≠ 0, not a factor
- No factors found, so 17 is prime

## Greatest Common Divisor (GCD)

The function finds the largest number that divides both inputs with no remainder:

```java
public static int getGCD(int n1, int n2) {
    int gcd = 1;
    int min = Math.min(n1, n2);   // Find the smaller number
    
    for (int i = min; i > 1; i--) {  // Check from min down to 2
        if (n1 % i == 0 && n2 % i == 0) {  // If i divides both numbers
            gcd = i;
            return gcd;           // Return first (largest) common divisor
        }
    }
    
    return gcd;  // Return 1 if no other common divisor found
}
```

**Workflow example with 48 and 18:**
1. min = 18
2. Check i = 18: 48 % 18 ≠ 0, continue
3. Check i = 17 through i = 7: None divide both numbers
4. Check i = 6: 48 % 6 = 0 and 18 % 6 = 0, return 6

## Euclidean Algorithm for GCD

This is a more efficient algorithm for finding GCD:

```java
public static int gcd(int a, int b) {
    while (a > 0 && b > 0) {   // Continue until one becomes 0
        if (a > b)
            a = a % b;         // Replace larger with remainder
        else
            b = b % a;         // Replace larger with remainder
    }
    return (a == 0) ? b : a;   // Return the non-zero value
}
```

**This leverages the mathematical property that gcd(a,b) = gcd(b, a mod b).**

**Workflow example with 48 and 18:**
1. a = 48, b = 18
2. a > b, so a = 48 % 18 = 12
3. Now a = 12, b = 18
4. b > a, so b = 18 % 12 = 6
5. Now a = 12, b = 6
6. a > b, so a = 12 % 6 = 0
7. Now a = 0, b = 6
8. Since a = 0, return b = 6

The Euclidean algorithm is much more efficient for large numbers compared to the brute-force approach.

These techniques form the foundation for many numerical algorithms and can be combined to solve more complex problems involving digit manipulation.