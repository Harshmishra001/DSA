import java.sql.Time;

/*Time Complexity: O(N) { Precisely, O(N/2) as we compare the elements N/2 times and swap them}.

Space Complexity: O(1) { The elements of the given array are swapped in place so no extra space is required}.*/

public class Palindromstring {      
 
//  APPROACH - initialize i as iteration if i exxceeds half of the string then it compare all the string so return true otherwise check start or end equal hai ya nhi? nhi h agr toh return false else start+1 or end -1 krdo


    static boolean palindrome(int i, String s){    
        // Base Condition
        // If i (index iterator) exceeds half of the string, means all the elements 
        // are compared, we return true.   coz start or end compare hota h fir start + 1 and end -1 so on..
        if( i >= s.length()/2 ) 
          return true;
        
        // If start is not equal to end, not palindrome.
        if( s.charAt(i) != s.charAt( s.length()-i-1 ))                 
          return false;
        
        // If both characters are same, increment i and check start+1 and end-1.
        return palindrome(i+1,s);
        

}
public static void main(String[] args) {

   // Example string.
   String s = "madam";
   System.out.println(palindrome(0,s));
}

}


    
    