package Sorting;

public class Sort{

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
    

public void mergeSort(int arr[],int low,int high){
    if(low>=high) return;
    int mid=(low+high)/2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid+1, high);
    merge(arr,low,mid,high);

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
    public static void main(String[] args) {
        Sort sort=new Sort();
        int arr[]={50,10,40,50,20,30};
        sort.mergeSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i+"\t");
            
        }
    }
}
