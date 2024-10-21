import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

// Time Complexity (TC): O((n + m) * log(n + m))
// Space Complexity (SC): O(n + m)

class UnionOfArray {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        HashSet<Integer> s = new HashSet<>();
        
        // Add elements from first array to HashSet
        for (int i = 0; i < n; i++) {
            s.add(arr1[i]);
        }
        
        // Add elements from second array to HashSet
        for (int j = 0; j < m; j++) {
            s.add(arr2[j]);
        }

 // Why Not Sort the HashSet Directly?
// A HashSet does not have an inherent order, so you can't sort it directly. That's why the 
// conversion to ArrayList is necessary before applying the Collections.sort() method.
       
// Convert HashSet to ArrayList
        ArrayList<Integer> unionList = new ArrayList<>(s);
        
        // Sort the ArrayList
        Collections.sort(unionList);
        
        return unionList;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 6, 7};
        ArrayList<Integer> result1 = findUnion(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Union of arrays 1 and 2: " + result1);
        
        // Example 2
        int[] arr3 = {2, 2, 3, 4, 5};
        int[] arr4 = {1, 1, 2, 3, 4};
        ArrayList<Integer> result2 = findUnion(arr3, arr4, arr3.length, arr4.length);
        System.out.println("Union of arrays 3 and 4: " + result2);
    }
}
