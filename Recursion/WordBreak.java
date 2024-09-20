import java.util.List;
import java.util.Arrays;

public class WordBreak {
        // Function to check if the string can be segmented into words from the dictionary
        public boolean wordBreak4(String s, List<String> wordDict) {
            // If the string is empty, we cannot segment it
            if ( s.isEmpty()) {
                return false;
            }
    
            // Get the length of the string
            int len = s.length();
            
            // Initialize a boolean array to store results of subproblems
            // dp[i] represents whether the substring from 0 to i can be segmented using wordDict
            boolean[] dp = new boolean[len];
            
            // Iterate through the string
            for (int i = 0; i < len; i++) {
                // For each index i, check all possible substrings ending at i
                for (int j = 0; j <= i; j++) {
                    // We update dp[i] only if:
                    // 1. j == 0 (this means we are checking a substring from the start)
                    // 2. dp[j - 1] is true, meaning the substring from 0 to j-1 can be segmented
                    if (j == 0 || dp[j - 1]) {
                        // Get the substring from index j to i
                        String sub = s.substring(j, i + 1);  //mtlb traverse kro s m 2 pointer ki madad se j or i j ko oth index p rkho fir i ko bdhate jao or wordict wale wrd s mtch kro 
                        // Check if this substring exists in the word dictionary
                        if (wordDict.contains(sub)) {
                            dp[i] = true;  // If it exists, mark dp[i] as true
                        }
                    }
                }
            }
            // Return the result for the full string (dp[len - 1] indicates if the full string can be segmented)
            return dp[len - 1];
        }
    
        // Main method to test the function
        public static void main(String[] args) {
            WordBreak solution = new WordBreak();
    
            // Test case 1
            String s = "leetcode";
            List<String> wordDict = Arrays.asList("leet", "code");
    
            // Test case 2
            String s2 = "applepenapple";
            List<String> wordDict2 = Arrays.asList("apple", "pen");
    
            // Test case 3
            String s3 = "catsandog";
            List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
    
            // Test the function with different cases
            System.out.println(solution.wordBreak4(s, wordDict));     // Expected output: true
            System.out.println(solution.wordBreak4(s2, wordDict2));   // Expected output: true
            System.out.println(solution.wordBreak4(s3, wordDict3));   // Expected output: false
        }
     
}
// Let’s go through the step-by-step execution of **Test Case 1** with the string `"leetcode"` and the word dictionary `["leet", "code"]`.

// ### Input:
// - `s = "leetcode"`
// - `wordDict = ["leet", "code"]`

// ### Step-by-Step Execution:

// 1. **Initialization**:
//    - The length of the string `s` is 8 (`len = 8`).
//    - We create a boolean array `dp` of size `len`, initialized to `false`:
//      ```java
//      dp = [false, false, false, false, false, false, false, false]
//      ```
//    - The `dp[i]` will be `true` if the substring `s[0...i]` can be segmented into valid words from `wordDict`.

// 2. **Outer Loop (i = 0 to 7)**:
//    - We iterate over each character of the string `s`.

// ---

// ### Iteration 1: **i = 0**

// - **Inner Loop (j = 0)**:
//   - **j = 0**: 
//     - The substring is `s.substring(0, 1) = "l"`.
//     - `"l"` is not in `wordDict`, so `dp[0]` remains `false`.

//   Result after iteration 1:
//   ```java
//   dp = [false, false, false, false, false, false, false, false]
//   ```

// ---

// ### Iteration 2: **i = 1**

// - **Inner Loop (j = 0 to 1)**:
//   - **j = 0**: 
//     - The substring is `s.substring(0, 2) = "le"`.
//     - `"le"` is not in `wordDict`, so `dp[1]` remains `false`.
  
//   - **j = 1**:
//     - The substring is `s.substring(1, 2) = "e"`.
//     - `"e"` is not in `wordDict`, so `dp[1]` remains `false`.

//   Result after iteration 2:
//   ```java
//   dp = [false, false, false, false, false, false, false, false]
//   ```

// ---

// ### Iteration 3: **i = 2**

// - **Inner Loop (j = 0 to 2)**:
//   - **j = 0**: 
//     - The substring is `s.substring(0, 3) = "lee"`.
//     - `"lee"` is not in `wordDict`, so `dp[2]` remains `false`.
  
//   - **j = 1**:
//     - The substring is `s.substring(1, 3) = "ee"`.
//     - `"ee"` is not in `wordDict`, so `dp[2]` remains `false`.

//   - **j = 2**:
//     - The substring is `s.substring(2, 3) = "e"`.
//     - `"e"` is not in `wordDict`, so `dp[2]` remains `false`.

//   Result after iteration 3:
//   ```java
//   dp = [false, false, false, false, false, false, false, false]
//   ```

// ---

// ### Iteration 4: **i = 3**

// - **Inner Loop (j = 0 to 3)**:
//   - **j = 0**:
//     - The substring is `s.substring(0, 4) = "leet"`.
//     - `"leet"` **is** in `wordDict`, so we mark `dp[3] = true`.

//   Result after iteration 4:
//   ```java
//   dp = [false, false, false, true, false, false, false, false]
//   ```

// ---

// ### Iteration 5: **i = 4**

// - **Inner Loop (j = 0 to 4)**:
//   - **j = 0**: 
//     - The substring is `s.substring(0, 5) = "leetc"`.
//     - `"leetc"` is not in `wordDict`, so `dp[4]` remains `false`.

//   - **j = 1**:
//     - The substring is `s.substring(1, 5) = "eetc"`.
//     - `"eetc"` is not in `wordDict`, so `dp[4]` remains `false`.

//   - **j = 2**:
//     - The substring is `s.substring(2, 5) = "etc"`.
//     - `"etc"` is not in `wordDict`, so `dp[4]` remains `false`.

//   - **j = 3**:
//     - The substring is `s.substring(3, 5) = "tc"`.
//     - `"tc"` is not in `wordDict`, so `dp[4]` remains `false`.

//   Result after iteration 5:
//   ```java
//   dp = [false, false, false, true, false, false, false, false]
//   ```

// ---

// ### Iteration 6: **i = 5**

// - **Inner Loop (j = 0 to 5)**:
//   - **j = 0**: 
//     - The substring is `s.substring(0, 6) = "leetco"`.
//     - `"leetco"` is not in `wordDict`, so `dp[5]` remains `false`.

//   - **j = 1**:
//     - The substring is `s.substring(1, 6) = "eetco"`.
//     - `"eetco"` is not in `wordDict`, so `dp[5]` remains `false`.

//   - **j = 2**:
//     - The substring is `s.substring(2, 6) = "etco"`.
//     - `"etco"` is not in `wordDict`, so `dp[5]` remains `false`.

//   - **j = 3**:
//     - The substring is `s.substring(3, 6) = "tco"`.
//     - `"tco"` is not in `wordDict`, so `dp[5]` remains `false`.

//   - **j = 4**:
//     - The substring is `s.substring(4, 6) = "co"`.
//     - `"co"` is not in `wordDict`, so `dp[5]` remains `false`.

//   Result after iteration 6:
//   ```java
//   dp = [false, false, false, true, false, false, false, false]
//   ```

// ---

// ### Iteration 7: **i = 6**

// - **Inner Loop (j = 0 to 6)**:
//   - **j = 0**: 
//     - The substring is `s.substring(0, 7) = "leetcod"`.
//     - `"leetcod"` is not in `wordDict`, so `dp[6]` remains `false`.

//   - **j = 1**:
//     - The substring is `s.substring(1, 7) = "eetcod"`.
//     - `"eetcod"` is not in `wordDict`, so `dp[6]` remains `false`.

//   - **j = 2**:
//     - The substring is `s.substring(2, 7) = "etcod"`.
//     - `"etcod"` is not in `wordDict`, so `dp[6]` remains `false`.

//   - **j = 3**:
//     - The substring is `s.substring(3, 7) = "tcod"`.
//     - `"tcod"` is not in `wordDict`, so `dp[6]` remains `false`.

//   - **j = 4**:
//     - The substring is `s.substring(4, 7) = "cod"`.
//     - `"cod"` is not in `wordDict`, so `dp[6]` remains `false`.

//   Result after iteration 7:
//   ```java
//   dp = [false, false, false, true, false, false, false, false]
//   ```

// ---

// ### Iteration 8: **i = 7**

// - **Inner Loop (j = 0 to 7)**:
//   - **j = 0**: 
//     - The substring is `s.substring(0, 8) = "leetcode"`.
//     - `"leetcode"` is not in `wordDict`, so `dp[7]` remains `false`.

//   - **j = 1**:
//     - The substring is `s.substring(1, 8) = "eetcode"`.
//     - `"eetcode"` is not in `wordDict`, so `dp[7]` remains `false`.

//   - **j = 2**:
//     - The substring is `s.substring(2, 8) = "etcode"`.
//     - `"etcode"` is not in `wordDict`, so `dp[7]` remains `false`.

//   - **j = 3**:
//     - The substring is `s.substring(3, 8) = "tcode"`.
//     - `"tcode"` is not in `wordDict`, so `dp[7]` remains `false`.

//   - **j = 4**:
//     - The substring is `s.substring(4, 8) = "code"`.
//     - `"code"` **is** in `wordDict`, and since `dp[3]` is `true` (the substring "leet" can be segmented), we set `dp[7] = true`.

//   Result after iteration 8:
//   ```java


//   dp = [false, false, false, true, false, false, false, true]
//   ```

// ---

// ### Final Result:
// - The final value of `dp[7]` is `true`, which means the string `"leetcode"` can be segmented using the words in `wordDict`.

// ### Output:
// ```java
// true
// ```