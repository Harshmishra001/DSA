// Example 1:
// Input: N = 5
// Output: 0 1 1 2 3 5
// Explanation: 0 1 1 2 3 5 is the fibonacci series up to 5th term.(0 based indexing)

import java.sql.Time;

public class FibbonacciSeries {

    //BRUTE FORCE APPROACH  T.C-O(N)+O(N)  S.C-O(N) 

    // public static void main(String args[]){   

    //     int n = 5;   //5 TK KA FIBBONACCI SERIES NIKAL DO

    //     if (n == 0) {
    //       System.out.println(0);
    //     } 

    //     else 
    //     {
    //       int fib[] = new int[n + 1];   //TAKING EXTRA SPACE HERE
    //     //   FIBONACCI SERIES  2 KA SUM NEXT HOTA H AND SO ON ISLIYE WE FIRST DECLARE  OUR 1ST 2 FIBBONACCI SERIES VALUE
    //       fib[0] = 0;
    //       fib[1] = 1;
    //       for (int i = 2; i <= n; i++) {
    //         fib[i] = fib[i - 1] + fib[i - 2];
    //       }
    //       System.out.println("The Fibonacci Series up to "+n+"th term:");
    //       for (int i = 0; i <= n; i++) {
    //         System.out.print(fib[i] + " ");
    //       }
    //     }
    // }


    // SPACE  OPTIMISED 
//     Time Complexity: O(N).As we are iterating over just one for a loop.
//     Space Complexity: O(1).
    public static void main(String args[]) {
        int n = 5;

        if (n == 0)
        {
        System.out.println("The Fibonacci Series up to "+n+"th term:");
        System.out.print(0);   //agr n =0 then simple 0 dedo
        } 
        else {

          int secondLast = 0;
          int last = 1;
          int cur;
          System.out.println("The Fibonacci Series up to "+n+"th term:");
          System.out.print(secondLast + " " + last + " ");    //agr sirf isse pring kraoge toh ye jo 2 upr initialize kre h fibbo seris shuru k vhi print krdega but we want nth fibbo series so we have to priint curr given below 

          for (int i = 2; i <= n; i++) 
          {
            cur = last + secondLast;
            secondLast = last;
            last = cur;

            System.out.print(cur + " ");
          }
        }
      }
}
