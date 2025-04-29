# Java Digit-Based Number Algorithms

This document explains core digit-based number algorithms in Java, including detailed explanations of concepts and sample code.

---

## 🔢 Digit Concept

To extract digits from an integer (e.g., `564949`):

- `n % 10` gives the **last digit**.
    
- `n / 10` removes the last digit.
    

This is the foundational logic for all digit-based algorithms.

---

## 1️⃣ Sum of Digits

```java
public static int sumOfDigits(int n) {
    int sum = 0;
    int digit;
    while(n > 0) {
        digit = n % 10;
        sum += digit;
        n = n / 10;
    }
    return sum;
}
```

**Explanation**:

- Extracts digits from right to left.
    
- Adds them to a cumulative `sum`.
    
- Time Complexity: O(log₁₀(n))
    

---

## 2️⃣ Count the Digits

```java
public static int countDigit(int n) {
    int count = 0;
    while(n > 0) {
        count++;
        n /= 10;
    }
    return count;
}
```

**Explanation**:

- Increments `count` for each digit extracted.
    
- Ideal for finding the number of digits.
    

---

## 3️⃣ Reverse a Number

```java
public static int reverseNumber(int n) {
    int rev = 0;
    int r;
    while(n > 0) {
        r = n % 10;
        rev = rev * 10 + r;
        n /= 10;
    }
    return rev;
}
```

**Explanation**:

- Builds the reverse by appending digits to the left.
    

---

## 4️⃣ Check Palindrome

```java
public static boolean isPalindrome(int n) {
    int temp = n;
    int rev = 0;
    int r;
    while(temp > 0) {
        r = temp % 10;
        rev = rev * 10 + r;
        temp = temp / 10;
    }
    return (rev == n);
}
```

**Explanation**:

- Compares the reversed number to the original.
    

---

## 5️⃣ Armstrong Number (3-digit)

```java
public static boolean isArmstrong(int n) {
    int temp = n;
    int sum = 0;
    int cube;
    while(temp > 0) {
        cube = temp % 10;
        sum += cube * cube * cube;
        temp = temp / 10;
    }
    return (n == sum);
}
```

**Explanation**:

- Checks if the number equals the sum of the cubes of its digits.
    

---

## 6️⃣ Print All Divisions (Factors)

```java
public static List<Integer> printAllDivisions(int n) {
    List<Integer> list = new ArrayList<>();
    for(int i = 1; i * i <= n; i++) {
        if(n % i == 0) {
            list.add(i);
            if((n / i) != i)
                list.add(n / i);
        }
    }
    Collections.sort(list);
    return list;
}
```

**Explanation**:

- Adds factor pairs and sorts the result.
    

---

## 7️⃣ Check Prime Number

```java
public static boolean isPrime(int n) {
    if (n <= 1) return false;
    for(int i = 2; i * i <= n; i++) {
        if(n % i == 0)
            return false;
    }
    return true;
}
```

**Explanation**:

- Efficient prime check using trial division up to √n.
    

---

## 8️⃣ GCD (Brute Force)

```java
public static int getGCD(int n1, int n2) {
    int gcd = 1;
    int min = Math.min(n1, n2);
    for(int i = min; i > 1; i--) {
        if(n1 % i == 0 && n2 % i == 0)
            return i;
    }
    return gcd;
}
```

**Explanation**:

- Checks downward from the smaller number.
    

---

## 9️⃣ Euclidean Algorithm (Efficient GCD)

```java
public static int gcd(int a, int b) {
    while(a > 0 && b > 0) {
        if(a > b) a = a % b;
        else b = b % a;
    }
    return (a == 0) ? b : a;
}
```

**Explanation**:

- Uses modulo operations to reduce size quickly.
    
- Time Complexity: O(log(min(a, b)))
    

---