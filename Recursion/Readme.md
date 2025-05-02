# 🔄 Recursion

## 🔁 What is Recursion?

Recursion is a powerful programming technique where a function calls itself to solve a smaller sub-problem of the original task. This creates a self-referential loop that can elegantly solve complex problems with minimal code. For recursion to work properly, it must have:

- **A base case** – a terminating condition where recursion stops and returns a value without making another recursive call.
- **A recursive case** – where the function calls itself with modified parameters that bring it closer to the base case.
- **State management** – each recursive call maintains its own state in the call stack.

Without a proper base case or progress toward it, recursion would continue indefinitely, causing a stack overflow error.

## Go To [Recursion Problem](problems.md)




## 🔧 Functional Workflow of Recursion (Call Stack Simulation)

Let's examine a classic example:

```java
int factorial(int n) {
    if (n == 0) return 1;               // base case
    return n * factorial(n - 1);        // recursive call
}
```

When we call `factorial(3)`, here's the complete call chain and execution flow:

```
factorial(3)
  → 3 * factorial(2)
       → 2 * factorial(1)
            → 1 * factorial(0)
                 → returns 1 (base case reached)
            → returns 1 * 1 = 1
       → returns 2 * 1 = 2
  → returns 3 * 2 = 6
```

This demonstrates two fundamental phases of recursion:

1. **Winding phase** – recursive calls are made until the base case is reached
2. **Unwinding phase** – results propagate back up the call chain as each function returns

## 🧠 What Happens in Memory?

### 1. Call Stack Mechanics

The call stack is a Last-In-First-Out (LIFO) memory structure used by the computer to keep track of function calls. Think of it as a stack of plates - you can only add (push) or remove (pop) from the top.

When a function is called:

- Its execution context (variables, return address, parameters) is pushed onto the stack.
- When the function finishes, its context is popped off the stack.
- The program continues execution from where the function was called.

For `factorial(3)`, the stack evolves dynamically:

```
PUSH factorial(3)
  PUSH factorial(2)
    PUSH factorial(1)
      PUSH factorial(0) ← base case, returns 1
      POP factorial(0)
    POP factorial(1) ← returns 1
  POP factorial(2) ← returns 2
POP factorial(3) ← returns 6
```

### 🧱 Stack Frame Details

Each stack frame (layer in the call stack) contains:

- **Parameters** – the values passed to the function
- **Local variables** – variables declared within the function
- **Return address** – where to resume execution after the function completes
- **Saved registers** – CPU register values that need to be preserved
- **Return value space** – where the function's result will be stored

Example stack frame for `factorial(2)`:

```
Function: factorial
Parameter: n = 2
Local state: none in this simple example
Return to: factorial(3)'s multiplication operation
Return value: will be 2 (calculated as 2 * factorial(1))
```

### 🔥 Stack Overflow Error: The Recursion Pitfall

A stack overflow error occurs when recursion depth becomes too deep and exceeds the call stack's memory limits. Consider this dangerous example:

```java
void infiniteRecursion() {
    infiniteRecursion();  // No base case!
}
```

Calling `infiniteRecursion()` leads to:

```
PUSH infiniteRecursion
  PUSH infiniteRecursion
    PUSH infiniteRecursion
      ...thousands of frames later...
        💥 StackOverflowError
```

Most programming languages allocate a fixed amount of memory for the call stack:

- Java: Typically 1MB (~10,000 calls)
- Python: Default depth limit of 1000 calls
- C/C++: Depends on platform, usually several MB

## 🧮 Recursive vs Iterative Approaches

### Recursive Fibonacci Implementation:

```java
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

**Characteristics:**

- Calls grow exponentially: O(2^n) time complexity
- Memory usage: O(n) stack space
- Elegant and matches mathematical definition
- Extremely inefficient for larger values of n

### Iterative Fibonacci Implementation:

```java
int fib(int n) {
    if (n <= 1) return n;
    
    int a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
        int c = a + b;
        a = b;
        b = c;
    }
    return b;
}
```

**Characteristics:**

- Linear time complexity: O(n)
- Constant space complexity: O(1)
- More efficient but less intuitive
- No risk of stack overflow

### Performance Comparison:

|n|Recursive Time|Iterative Time|
|---|---|---|
|10|~1ms|<0.1ms|
|20|~10ms|<0.1ms|
|30|~20s|<0.1ms|
|40|~20min|<0.1ms|
|50|~13 days|<0.1ms|

This dramatic difference occurs because naive recursive Fibonacci calculates many values repeatedly.

## 🧰 Advanced Types of Recursion

### 1. Tail Recursion

In tail recursion, the recursive call is the final operation in the function with no pending operations afterward.

```java
// Non-tail recursive factorial
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);  // Multiplication happens after recursive call returns
}

// Tail recursive factorial
int tailFactorial(int n, int acc) {
    if (n == 0) return acc;
    return tailFactorial(n - 1, acc * n);  // No pending operations after recursion
}

// Usage: tailFactorial(5, 1)
```

**Benefits:**

- Can be optimized by compilers to eliminate stack frames (tail call optimization)
- Languages like Scala, Haskell, and some C/C++ compilers support this optimization
- Effectively becomes as efficient as iteration
- Prevents stack overflow for deep recursion

### 2. Head Recursion

The recursive call happens before any other operations in the function.

```java
void headRecursion(int n) {
    if (n == 0) return;
    headRecursion(n - 1);  // Recursive call first
    System.out.println(n); // Processing after recursion
}
```

This prints numbers in ascending order (1, 2, 3...) because processing happens during unwinding.

### 3. Tree Recursion

Each function call spawns multiple recursive calls, creating a tree-like call pattern.

```java
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2); // Two recursive calls
}
```

**Characteristics:**

- Call tree grows exponentially
- Useful for problems with branching paths (e.g., game trees)
- Often requires memoization to be efficient

### 4. Indirect Recursion (Mutual Recursion)

Multiple functions call each other in a circular pattern.

```java
boolean isEven(int n) {
    if (n == 0) return true;
    return isOdd(n - 1);
}

boolean isOdd(int n) {
    if (n == 0) return false;
    return isEven(n - 1);
}
```

This creates a chain: isEven → isOdd → isEven → ...

### 5. Nested Recursion

The parameter to a recursive call is itself a result of a recursive call.

```java
int nestedRecursion(int n) {
    if (n <= 10) return n;
    return nestedRecursion(nestedRecursion(n-1));
}
```

This creates extremely complex call patterns and should be used carefully.

## ⚡ Optimization Techniques

### 1. Memoization

Storing previously computed results to avoid redundant calculations.

```java
Map<Integer, Integer> memo = new HashMap<>();

int fibMemo(int n) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    
    int result = fibMemo(n - 1) + fibMemo(n - 2);
    memo.put(n, result);
    return result;
}
```

This reduces time complexity from O(2^n) to O(n).

### 2. Dynamic Programming

Bottom-up approach that eliminates recursion entirely while reusing previous results.

```java
int fibDP(int n) {
    if (n <= 1) return n;
    
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    return dp[n];
}
```

### 3. Tail Call Optimization (TCO)

Converting recursive algorithms to tail-recursive form for compiler optimization.

```java
// Original
int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);
}

// Tail-recursive version
int sumTail(int n, int acc) {
    if (n == 0) return acc;
    return sumTail(n - 1, acc + n);
}
```

## ⚠️ How to Avoid Stack Overflow?

1. **Identify the maximum recursion depth** needed for your problem
2. **Convert to tail recursion** when possible
3. **Use memoization** to eliminate redundant calls
4. **Consider iterative solutions** for deep recursion
5. **Increase stack size** if available in your language:
    - Java: `-Xss4m` JVM option
    - Python: `sys.setrecursionlimit(3000)`
6. **Use trampolining** technique in languages without TCO:
    
    ```java
    interface Trampoline<T> {    T get();    default boolean complete() { return true; }}
    ```
    

## 📊 When to Use Recursion

### ✅ Ideal Use Cases:

- **Tree traversals** (pre-order, in-order, post-order)
    
    ```java
    void traverse(Node node) {
        if (node == null) return;
        traverse(node.left);
        System.out.println(node.value);
        traverse(node.right);
    }
    ```
    
- **Graph algorithms** (DFS, pathfinding)
    
    ```java
    void dfs(Graph g, int node, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        for (int neighbor : g.getNeighbors(node)) {
            dfs(g, neighbor, visited);
        }
    }
    ```
    
- **Divide and conquer algorithms**
    
    ```java
    // Merge sort
    void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    ```
    
- **Backtracking problems** (n-queens, Sudoku)
    
    ```java
    boolean solveSudoku(int[][] board, int row, int col) {
        // Base case and recursive exploration
    }
    ```
    
- **Parsing and processing nested structures** (JSON, XML)
    

### 🚫 When to Avoid Recursion:

- When input size could be very large
- In memory-constrained environments
- For performance-critical applications
- When stack size is limited
- When the problem has a simple iterative solution

## 🔍 Visual Representation of factorial(3)

```
                      factorial(3)
                      /          \
                    /             \
           factorial(2)           * 
           /        \             |
         /           \            |
  factorial(1)       *            3
  /        \         |
/           \        |
factorial(0) *       2
    |        |
    |        |
    1        1
    
Returns: 6 (3 * 2 * 1)
```

## 🧩 Real-World Application: Directory Size Calculation

```java
long calculateDirSize(File dir) {
    if (!dir.isDirectory()) {
        return dir.length();
    }
    
    long size = 0;
    for (File file : dir.listFiles()) {
        size += calculateDirSize(file);
    }
    
    return size;
}
```

This elegantly handles the recursive structure of file systems without complex iteration.

## 🔄 Recursive Helper Functions

Sometimes public methods use private recursive helpers to hide implementation details:

```java
public static List<Integer> getPathToNode(TreeNode root, int target) {
    List<Integer> path = new ArrayList<>();
    findPath(root, target, path);
    return path;
}

private static boolean findPath(TreeNode node, int target, List<Integer> path) {
    if (node == null) return false;
    
    path.add(node.val);
    
    if (node.val == target) return true;
    
    if (findPath(node.left, target, path) || findPath(node.right, target, path)) {
        return true;
    }
    
    path.remove(path.size() - 1);  // Backtrack
    return false;
}
```

## 🎓 Learning Tips for Mastering Recursion

1. **Start small** - begin with simple recursive problems like factorial or sum
2. **Trace by hand** - draw the call stack for each example
3. **Trust the recursion** - assume recursive calls work correctly for smaller inputs
4. **Identify base cases first** - always start by defining when recursion should stop
5. **Look for self-similarity** - identify how the problem can be expressed in terms of itself
6. **Practice, practice, practice** - recursive thinking becomes natural with experience

## 🔄 Conclusion

Recursion is both a powerful programming technique and a distinct way of thinking about problems. By breaking complex tasks into simpler self-similar subproblems, recursion can lead to elegant and intuitive solutions. However, it comes with trade-offs in terms of performance and memory usage that must be carefully considered.

The best programmers know not just how to write recursive functions, but when to use recursion versus iteration, and how to optimize recursive algorithms when necessary. With practice, you'll develop an intuition for recognizing problems that are naturally suited for recursive solutions.

Remember the three key components of any recursive solution:

1. Identify the base case(s)
2. Define the recursive case
3. Ensure progress toward the base case
