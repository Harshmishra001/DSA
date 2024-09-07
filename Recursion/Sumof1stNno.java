// Example 1:
// Input: N=5
// Output: 15
// Explanation: 1+2+3+4+5=15


// USING LOOP
public class Sumof1stNno {

  // public static void solve(int n) {
  //   int sum = 0;
  //   for (int i = 1; i <= n; i++) {
  //     sum += i;
  //   }
  //   System.out.println("The sum of the first " + n + " numbers is: " + sum);
  // }

  public static void main(String[] args) {

    System.out.println(solve(5));
    System.out.println(solve(4));
  }

  // USING FORMULA
  // public static void solve(int N) {
  //   int sum = N * (N + 1) / 2;   
  //   System.out.println("The sum of the first " + N + " numbers is: " + sum);
  // }

  // RECURCIVE WAY
  static int solve(int n){   
    // Base Condition.
    if(n == 0){ 
        return 0;
    }
    // Problem broken down into 2 parts and then combined.
    return n + solve(n-1);
}
    

}
