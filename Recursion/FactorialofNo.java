// Example 1:
// Input: X = 5
// Output: 120
// Explanation: 5! = 5*4*3*2*1

public class FactorialofNo {
     
    // ITERATIVE APPROACH
    // static int factorial(int X) {
    //     int ans = 1;
    //     for (int i = 1; i <= X; i++) {
    //        ans = ans * i;
    //     }
    //     return ans;
    //  }
    //  public static void main(String[] args) {
  
    //     int X = 5;
    //     int result = factorial(X);
    //     System.out.println("The factorial of " + X + " is " + result);
    //  }       
    
     // RECURSIVE APPROACH
     public static int factorial(int n){
        if(n == 0) {
          return 1;
        }
     
     return n * factorial(n-1);
     }
     public static void main(String[] args) {
         int n=5;
         System.out.println(factorial(5));
     }

}

