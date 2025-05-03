# Sorting Algorithms

Sorting is a fundamental technique in computer science that arranges elements in an array in a specific order, typically ascending (smallest to largest) or descending (largest to smallest). This document provides a detailed explanation of five common sorting algorithms: Selection Sort, Bubble Sort, Insertion Sort, Merge Sort, and Quick Sort.

## Table of Contents
1. [Selection Sort](#1-selection-sort)
2. [Bubble Sort](#2-bubble-sort)
3. [Insertion Sort](#3-insertion-sort)
4. [Merge Sort](#4-merge-sort)
5. [Quick Sort](#5-quick-sort)
6. [Comparison of Sorting Algorithms](#comparison-of-sorting-algorithms)

## 1. Selection Sort

Selection sort works by repeatedly finding the minimum element from the unsorted portion of the array and placing it at the beginning of the unsorted part.

### Pseudocode

```
procedure selectionSort(array A)
    n = length of A
    
    for i = 0 to n-1 do
        min_index = i
        
        for j = i+1 to n-1 do
            if A[j] < A[min_index] then
                min_index = j
            end if
        end for
        
        swap A[i] and A[min_index]
    end for
end procedure
```

### Java Implementation

```java
public void selectionSort() {
    int arr[] = {10, 8, 4, 5, 7, 4, 2};
    int n = arr.length;
    int min = -1;
    int temp;
    
    // Iterator
    for (int i = 0; i < n; i++) {
        min = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min]) 
                min = j;
        }
        // Swap the found minimum element with the element at index i
        temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
    
    for (int i : arr) {
        System.out.print(i + "\t");
    }
}
```

### Dry Run and Workflow

Let's trace through the algorithm with the array `[10, 8, 4, 5, 7, 4, 2]`:

**Initial array:** `[10, 8, 4, 5, 7, 4, 2]`

**Iteration 1:**
- Find minimum in entire array: `2` at index `6`
- Swap with first element: `[2, 8, 4, 5, 7, 4, 10]`

**Iteration 2:**
- Find minimum in remaining array (index 1 to 6): `4` at index `2`
- Swap with second element: `[2, 4, 8, 5, 7, 4, 10]`

**Iteration 3:**
- Find minimum in remaining array (index 2 to 6): `4` at index `5`
- Swap with third element: `[2, 4, 4, 5, 7, 8, 10]`

**Iteration 4:**
- Find minimum in remaining array (index 3 to 6): `5` at index `3`
- Swap with fourth element (already in place): `[2, 4, 4, 5, 7, 8, 10]`

**Iteration 5:**
- Find minimum in remaining array (index 4 to 6): `7` at index `4`
- Swap with fifth element (already in place): `[2, 4, 4, 5, 7, 8, 10]`

**Iteration 6:**
- Find minimum in remaining array (index 5 to 6): `8` at index `5`
- Swap with sixth element (already in place): `[2, 4, 4, 5, 7, 8, 10]`

**Final sorted array:** `[2, 4, 4, 5, 7, 8, 10]`

### Time and Space Complexity

- **Time Complexity:** 
  - Best Case: O(n²)
  - Average Case: O(n²)
  - Worst Case: O(n²)
- **Space Complexity:** O(1) - Selection sort is an in-place sorting algorithm

## 2. Bubble Sort

Bubble sort repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

### Pseudocode

```
procedure bubbleSort(array A)
    n = length of A
    
    for i = 0 to n-2 do
        for j = 0 to n-i-2 do
            if A[j] > A[j+1] then
                swap A[j] and A[j+1]
            end if
        end for
    end for
end procedure
```

### Java Implementation

```java
public void bubbleSort() {
    int arr[] = {10, 2, 34, 45, 7, 32, 5, 67};
    int temp;
    
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j+1]) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    
    for (int i : arr) {
        System.out.print(i + "\t");
    }
}
```

### Dry Run and Workflow

Let's trace through the algorithm with the array `[10, 2, 34, 45, 7, 32, 5, 67]`:

**Initial array:** `[10, 2, 34, 45, 7, 32, 5, 67]`

**Iteration 1:**
- Compare and swap adjacent elements:
  - Compare 10 and 2: Swap → `[2, 10, 34, 45, 7, 32, 5, 67]`
  - Compare 10 and 34: No swap → `[2, 10, 34, 45, 7, 32, 5, 67]`
  - Compare 34 and 45: No swap → `[2, 10, 34, 45, 7, 32, 5, 67]`
  - Compare 45 and 7: Swap → `[2, 10, 34, 7, 45, 32, 5, 67]`
  - Compare 45 and 32: Swap → `[2, 10, 34, 7, 32, 45, 5, 67]`
  - Compare 45 and 5: Swap → `[2, 10, 34, 7, 32, 5, 45, 67]`
  - Compare 45 and 67: No swap → `[2, 10, 34, 7, 32, 5, 45, 67]`
- After first pass, largest element (67) is at the end

**Iteration 2:**
- Continue comparing adjacent elements up to the second last position
- After second pass: `[2, 10, 7, 32, 5, 34, 45, 67]`

**Continue iterations until no more swaps are needed**

**Final sorted array:** `[2, 5, 7, 10, 32, 34, 45, 67]`

### Time and Space Complexity

- **Time Complexity:**
  - Best Case: O(n) - When the array is already sorted
  - Average Case: O(n²)
  - Worst Case: O(n²) - When the array is sorted in reverse order
- **Space Complexity:** O(1) - Bubble sort is an in-place sorting algorithm

## 3. Insertion Sort

Insertion sort builds the final sorted array one item at a time. It takes an element from the unsorted part and places it at the correct position in the sorted part.

### Pseudocode

```
procedure insertionSort(array A)
    n = length of A
    
    for i = 1 to n-1 do
        key = A[i]
        j = i - 1
        
        while j >= 0 and A[j] > key do
            A[j+1] = A[j]
            j = j - 1
        end while
        
        A[j+1] = key
    end for
end procedure
```

### Java Implementation

```java
public void insertionSort() {
    int arr[] = {102, 3, 4, 43, 54, 34, 534};
    int j, temp;
    
    for (int i = 1; i < arr.length; i++) {
        j = i;
        while (j > 0 && arr[j-1] > arr[j]) {
            temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        }
    }
    
    for (int i : arr) {
        System.out.print(i + "\t");
    }
}
```

### Dry Run and Workflow

Let's trace through the algorithm with the array `[102, 3, 4, 43, 54, 34, 534]`:

**Initial array:** `[102, 3, 4, 43, 54, 34, 534]`

**Iteration 1 (i=1):**
- Element to insert: 3
- Compare with sorted part [102]:
  - 3 < 102, so swap: `[3, 102, 4, 43, 54, 34, 534]`

**Iteration 2 (i=2):**
- Element to insert: 4
- Compare with sorted part [3, 102]:
  - 4 > 3, no swap needed
  - 4 < 102, so swap: `[3, 4, 102, 43, 54, 34, 534]`

**Iteration 3 (i=3):**
- Element to insert: 43
- Compare with sorted part [3, 4, 102]:
  - 43 > 3, 43 > 4, 43 < 102
  - Swap with 102: `[3, 4, 43, 102, 54, 34, 534]`

**Iteration 4 (i=4):**
- Element to insert: 54
- Compare with sorted part [3, 4, 43, 102]:
  - 54 > 3, 54 > 4, 54 > 43, 54 < 102
  - Swap with 102: `[3, 4, 43, 54, 102, 34, 534]`

**Iteration 5 (i=5):**
- Element to insert: 34
- Compare with sorted part [3, 4, 43, 54, 102]:
  - 34 > 3, 34 > 4, 34 < 43
  - Swap progressively until correct position: `[3, 4, 34, 43, 54, 102, 534]`

**Iteration 6 (i=6):**
- Element to insert: 534
- Compare with sorted part [3, 4, 34, 43, 54, 102]:
  - 534 is greater than all elements in sorted part
  - No swaps needed: `[3, 4, 34, 43, 54, 102, 534]`

**Final sorted array:** `[3, 4, 34, 43, 54, 102, 534]`

### Time and Space Complexity

- **Time Complexity:**
  - Best Case: O(n) - When the array is already sorted
  - Average Case: O(n²)
  - Worst Case: O(n²) - When the array is sorted in reverse order
- **Space Complexity:** O(1) - Insertion sort is an in-place sorting algorithm

## 4. Merge Sort

Merge sort follows the divide-and-conquer paradigm. It divides the array into two halves, recursively sorts them, and then merges the sorted halves.

### Pseudocode

```
procedure mergeSort(array A, low, high)
    if low < high then
        mid = (low + high) / 2
        mergeSort(A, low, mid)
        mergeSort(A, mid+1, high)
        merge(A, low, mid, high)
    end if
end procedure

procedure merge(array A, low, mid, high)
    create temporary array temp[high - low + 1]
    left = low
    right = mid + 1
    k = 0
    
    while left <= mid and right <= high do
        if A[left] <= A[right] then
            temp[k] = A[left]
            left = left + 1
        else
            temp[k] = A[right]
            right = right + 1
        end if
        k = k + 1
    end while
    
    while left <= mid do
        temp[k] = A[left]
        left = left + 1
        k = k + 1
    end while
    
    while right <= high do
        temp[k] = A[right]
        right = right + 1
        k = k + 1
    end while
    
    for i = 0 to length(temp) - 1 do
        A[low + i] = temp[i]
    end for
end procedure
```

### Java Implementation

```java
public void mergeSort(int arr[], int low, int high) {
    if (low >= high) return;
    
    int mid = (low + high) / 2;
    
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    
    merge(arr, low, mid, high);
}

public void merge(int arr[], int low, int mid, int high) {
    // Create a temporary array to store merged result
    int temp[] = new int[high - low + 1];
    
    int left = low;      // Starting index of left subarray
    int right = mid + 1; // Starting index of right subarray
    int k = 0;           // Starting index for temp array
    
    // Compare elements from both subarrays and store the smaller element in temp
    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp[k] = arr[left];
            left++;
        } else {
            temp[k] = arr[right];
            right++;
        }
        k++;
    }
    
    // Copy remaining elements from left subarray, if any
    while (left <= mid) {
        temp[k] = arr[left];
        left++;
        k++;
    }
    
    // Copy remaining elements from right subarray, if any
    while (right <= high) {
        temp[k] = arr[right];
        right++;
        k++;
    }
    
    // Copy elements from temp array back to original array
    for (int i = 0; i < temp.length; i++) {
        arr[low + i] = temp[i];
    }
}
```

### Dry Run and Workflow

Let's trace through the merge sort algorithm with a small example array `[38, 27, 43, 3, 9, 82, 10]`:

**Division Phase:**

1. Initial array: `[38, 27, 43, 3, 9, 82, 10]`
2. Split into: `[38, 27, 43, 3]` and `[9, 82, 10]`
3. Split `[38, 27, 43, 3]` into: `[38, 27]` and `[43, 3]`
4. Split `[38, 27]` into: `[38]` and `[27]`
5. Single elements are sorted, merge `[38]` and `[27]` to get `[27, 38]`
6. Split `[43, 3]` into: `[43]` and `[3]`
7. Single elements are sorted, merge `[43]` and `[3]` to get `[3, 43]`
8. Merge `[27, 38]` and `[3, 43]` to get `[3, 27, 38, 43]`
9. Split `[9, 82, 10]` into: `[9]` and `[82, 10]`
10. Single element `[9]` is sorted
11. Split `[82, 10]` into: `[82]` and `[10]`
12. Single elements are sorted, merge `[82]` and `[10]` to get `[10, 82]`
13. Merge `[9]` and `[10, 82]` to get `[9, 10, 82]`

**Merge Phase:**

14. Merge `[3, 27, 38, 43]` and `[9, 10, 82]` to get `[3, 9, 10, 27, 38, 43, 82]`

**Final sorted array:** `[3, 9, 10, 27, 38, 43, 82]`

### Step-by-Step Merge Operation Example

Let's illustrate the merge operation for step 14 above:

**Merge `[3, 27, 38, 43]` and `[9, 10, 82]`:**

- Compare 3 and 9: 3 < 9, so add 3 to temp array: `[3]`
- Compare 27 and 9: 27 > 9, so add 9 to temp array: `[3, 9]`
- Compare 27 and 10: 27 > 10, so add 10 to temp array: `[3, 9, 10]`
- Compare 27 and 82: 27 < 82, so add 27 to temp array: `[3, 9, 10, 27]`
- Compare 38 and 82: 38 < 82, so add 38 to temp array: `[3, 9, 10, 27, 38]`
- Compare 43 and 82: 43 < 82, so add 43 to temp array: `[3, 9, 10, 27, 38, 43]`
- Add remaining element 82 to temp array: `[3, 9, 10, 27, 38, 43, 82]`
- Copy temp array back to original array

### Time and Space Complexity

- **Time Complexity:**
  - Best Case: O(n log n)
  - Average Case: O(n log n)
  - Worst Case: O(n log n)
- **Space Complexity:** O(n) due to the temporary array used in the merge operation

## 5. Quick Sort

Quick sort is another divide-and-conquer algorithm that picks an element as a pivot and partitions the array around the pivot.

### Pseudocode

```
procedure quickSort(array A, low, high)
    if low < high then
        pivot_index = partition(A, low, high)
        quickSort(A, low, pivot_index - 1)
        quickSort(A, pivot_index + 1, high)
    end if
end procedure

procedure partition(array A, low, high)
    pivot = A[high]
    i = low - 1
    
    for j = low to high - 1 do
        if A[j] <= pivot then
            i = i + 1
            swap A[i] and A[j]
        end if
    end for
    
    swap A[i + 1] and A[high]
    return i + 1
end procedure
```

### Java Implementation

```java
public void quickSort(int arr[], int low, int high) {
    if (low < high) {
        // Find the partition index
        int pivotIndex = partition(arr, low, high);
        
        // Recursively sort elements before and after partition
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
}

public int partition(int arr[], int low, int high) {
    // Select the rightmost element as pivot
    int pivot = arr[high];
    
    // Index of smaller element
    int i = low - 1;
    
    for (int j = low; j < high; j++) {
        // If current element is smaller than or equal to pivot
        if (arr[j] <= pivot) {
            i++;
            
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    // Swap arr[i+1] and arr[high] (put the pivot in its correct position)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    
    return i + 1;
}

public void sortArray() {
    int arr[] = {10, 7, 8, 9, 1, 5};
    quickSort(arr, 0, arr.length - 1);
    
    for (int i : arr) {
        System.out.print(i + "\t");
    }
}
```

### Dry Run and Workflow

Let's trace through the quick sort algorithm with the array `[10, 7, 8, 9, 1, 5]`:

**Initial array:** `[10, 7, 8, 9, 1, 5]`

**First partition:**
- Pivot = 5 (last element)
- Initialize i = -1
- Iterate through array:
  - j = 0: arr[0] = 10 > 5, do nothing
  - j = 1: arr[1] = 7 > 5, do nothing
  - j = 2: arr[2] = 8 > 5, do nothing
  - j = 3: arr[3] = 9 > 5, do nothing
  - j = 4: arr[4] = 1 < 5, increment i to 0, swap arr[0] and arr[4]: `[1, 7, 8, 9, 10, 5]`
- After loop, swap arr[i+1] (which is arr[1]) with pivot: `[1, 5, 8, 9, 10, 7]`
- Pivot index is 1

**Recursively sort left part [1] (indices 0 to 0):**
- Single element, already sorted

**Recursively sort right part [8, 9, 10, 7] (indices 2 to 5):**
- Pivot = 7 (last element)
- Initialize i = 1
- Iterate through array:
  - j = 2: arr[2] = 8 > 7, do nothing
  - j = 3: arr[3] = 9 > 7, do nothing
  - j = 4: arr[4] = 10 > 7, do nothing
- After loop, swap arr[i+1] (which is arr[2]) with pivot: `[1, 5, 7, 9, 10, 8]`
- Pivot index is 2

**Continue recursion for subarrays:**
- Sort `[1, 5]`: Already sorted
- Sort `[9, 10, 8]`:
  - Pivot = 8
  - After partition: `[1, 5, 7, 8, 10, 9]`
  - Sort `[9, 10]`: 
    - Pivot = 9
    - After partition: `[1, 5, 7, 8, 9, 10]`

**Final sorted array:** `[1, 5, 7, 8, 9, 10]`

### Time and Space Complexity

- **Time Complexity:**
  - Best Case: O(n log n) - When partition process always picks the middle element as pivot
  - Average Case: O(n log n)
  - Worst Case: O(n²) - When the array is already sorted and we always pick first or last element as pivot
- **Space Complexity:** O(log n) - Due to the recursive call stack

## Comparison of Sorting Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Space Complexity | Stable | Adaptive |
|-----------|-----------|--------------|------------|-----------------|--------|----------|
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No | No |
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes | Yes |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes | No |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No | No |

**Notes:**
- **Stable Sort**: A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input.
- **Adaptive Sort**: A sorting algorithm is said to be adaptive if it takes advantage of existing order in its input.

## When to Use Each Algorithm

1. **Selection Sort**:
   - Simple to implement
   - Good for small arrays
   - Performs well when memory write is a costly operation (makes only O(n) swaps)

2. **Bubble Sort**:
   - Very simple to understand and implement
   - Good when the array is nearly sorted
   - Not recommended for large datasets

3. **Insertion Sort**:
   - Efficient for small data sets
   - Good when the array is nearly sorted
   - Works well for continuous streams of data
   - Often used as part of more sophisticated algorithms

4. **Merge Sort**:
   - Efficient for large datasets
   - Stable sorting algorithm
   - Predictable performance (always O(n log n))
   - Good for external sorting (when data doesn't fit in memory)
   - Preferred for linked lists

5. **Quick Sort**:
   - Often the fastest in practice for arrays
   - Good cache locality
   - In-place sorting with O(log n) stack space
   - Usually the default choice in many programming language libraries
   - Not stable by default