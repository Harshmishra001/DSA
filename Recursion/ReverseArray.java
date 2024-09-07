import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

      //Function to print array  Time Complexity: O(n) Space Complexity: O(1)
      // static void printArray(int arr[], int n) {
      //    System.out.print("Reversed array is:- \n");
      //    for (int i = 0; i < n; i++) {
      //       System.out.print(arr[i] + " ");
      //    }
      // }
      // //Function to reverse array using recursion
      // static void reverseArray(int arr[], int start, int end) {
      //    if (start < end) {  //swap krna shuru krdia start wale ko  end s 
      //       int tmp = arr[start];
      //       arr[start] = arr[end];
      //       arr[end] = tmp;
      //        reverseArray(arr, start + 1, end - 1);   // fir start k next p aage or end s ek phle aage unhe kia same above process and so on
      //    }
      // }
      // public static void main(String[] args) {
      //    int n = 5;
      //    int arr[] = { 5, 4, 3, 2, 1};  //reverse-1 2 3 4 5 
      //    reverseArray(arr, 0, n - 1);
      //    printArray(arr, n);
      // }

      // Using library function (New Approach)   tc-o(n)  s.c-o(1)

      static void printArray(Integer arr[], int n) {
         System.out.print("Reversed array is:- \n");
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
      }
   //Reverse array using library function
   static void reverseArray(Integer arr[]) {
      //fetching array as list object
      //reversing the fetched object
      Collections.reverse(Arrays.asList(arr));
   }
   public static void main(String[] args) {
      int n = 5;
      Integer arr[] = {5,4,3,2,1};
      reverseArray(arr);
      printArray(arr, n);
   }
}

  