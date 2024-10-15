import java.util.*; 
import java.io.*; 
import java.lang.*; 

class ArrayOperation
{  
//  INSERT OPERATION

    // Method to insert an element into an array
    // Parameters:
    // arr[]: The array where the element will be inserted
    // n: Current number of elements in the array
    // x: Element to be inserted
    // cap: Capacity of the array
    // pos: Position where the element should be inserted (1-based index)
    static int insert(int arr[], int n, int x, int cap, int pos) 
    {
        // If array is full (number of elements equals the capacity), return the current size
        if(n == cap)
            return n;

        // Convert the 1-based position to 0-based index
        int idx = pos - 1;

        // Shift elements to the right starting from the last element (n-1) to the insertion position
        for(int i = n - 1; i >= idx; i--) 
        {
            arr[i + 1] = arr[i];  // Move the element one position to the right
        }

        // Insert the new element at the desired position
        arr[idx] = x;

        // Return the new size of the array (as one element has been added)
        return n + 1;
    } 

    // SEARCH OPRERATION

    static int search(int arr[],int n , int x){
        for(int i=0;i<n;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;

    }


    

    public static void main(String args[])  
    {  
        // Initialize an array of size 5, capacity is 5
        int arr[] = new int[5], cap = 5, n = 3;

        // Initial elements in the array
        arr[0] = 5; 
        arr[1] = 10; 
        arr[2] = 20;

        // Print the array before insertion
        System.out.println("Before Insertion"); 
        for(int i=0; i < n; i++) 
        {
            System.out.print(arr[i]+" ");  // Output: 5 10 20
        } 
        System.out.println();  // New line after printing the array

        // Element to be inserted
        int x = 7;

        // Position where the element will be inserted (1-based index)
        int pos = 2;

        // Call the insert method and update the size of the array
        n = insert(arr, n, x, cap, pos);

        // Print the array after insertion
        System.out.println("After Insertion"); 
        for(int i=0; i < n; i++) 
        {
            System.out.print(arr[i]+" ");  // Output after insertion: 5 7 10 20
        } 

        System.out.println();
        System.out.println("Element found at index: "+ search(arr,n,10));
    }  
}
