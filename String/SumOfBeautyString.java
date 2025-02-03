class SumOfBeautyOfString {

// **Time Complexity**: (O(n^2)), where \(n\) is the length of the string (nested loops for substrings and frequency array traversal).  
// **Space Complexity**: (O(1)), as the frequency array size is constant (\(26\) for lowercase English letters).

    // Method to calculate the beauty sum of all substrings
    public static int beautySum(String s) {
        int result = 0; // Variable to store the cumulative beauty sum

        // Outer loop: Start of substring
        for (int i = 0; i < s.length(); i++) {
            int freq[] = new int[26]; // Frequency array for character counts

            // Inner loop: End of substring
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++; // Update frequency for the current character

                // Calculate the maximum and minimum frequencies
                int max = maxchar(freq);
                int min = minchar(freq);

                // Add the difference (beauty value) to the result
                result += (max - min);
            }
        }
        return result; // Return the final beauty sum
    }

    // Helper method to find the maximum frequency of any character in the substring
    static int maxchar(int freq[]) {
        int max = Integer.MIN_VALUE; // Initialize max as the smallest possible value
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) { // Only consider non-zero frequencies
                max = Math.max(max, freq[i]);
            }
        }
        return max; // Return the maximum frequency
    }

    // Helper method to find the minimum frequency of any character in the substring
    static int minchar(int freq[]) {
        int min = Integer.MAX_VALUE; // Initialize min as the largest possible value
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) { // Only consider non-zero frequencies
                min = Math.min(min, freq[i]);
            }
        }
        return min ; // Ensure we don't return an invalid value
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        String s = "aabcb"; // Example input string
        int result = beautySum(s); // Calculate the beauty sum
        System.out.println("The beauty sum of the string \"" + s + "\" is: " + result);
    }
}


// ### **Initialization**
// - `s = "aabcb"`
// - `result = 0` (to store the cumulative beauty sum)

// #### **Step 1**: Starting at `i = 0`
// - `freq = [0, 0, 0, ..., 0]` (26 zeros, one for each letter)

// ---

// 1. **Substring: "a" (j = 0)**
//    - Update `freq`: `freq['a' - 'a']++ → freq = [1, 0, 0, ..., 0]`
//    - **max = 1**, **min = 1** (only 'a' exists)
//    - `beauty = max - min = 1 - 1 = 0`
//    - `result += beauty → result = 0`

// ---

// 2. **Substring: "aa" (j = 1)**
//    - Update `freq`: `freq['a' - 'a']++ → freq = [2, 0, 0, ..., 0]`
//    - **max = 2**, **min = 2**
//    - `beauty = max - min = 2 - 2 = 0`
//    - `result += beauty → result = 0`

// ---

// 3. **Substring: "aab" (j = 2)**
//    - Update `freq`: `freq['b' - 'a']++ → freq = [2, 1, 0, ..., 0]`
//    - **max = 2**, **min = 1** (for 'a' and 'b')
//    - `beauty = max - min = 2 - 1 = 1`
//    - `result += beauty → result = 1`

// ---

// 4. **Substring: "aabc" (j = 3)**
//    - Update `freq`: `freq['c' - 'a']++ → freq = [2, 1, 1, ..., 0]`
//    - **max = 2**, **min = 1** (for 'a', 'b', and 'c')
//    - `beauty = max - min = 2 - 1 = 1`
//    - `result += beauty → result = 2`

// ---

// 5. **Substring: "aabcb" (j = 4)**
//    - Update `freq`: `freq['b' - 'a']++ → freq = [2, 2, 1, ..., 0]`
//    - **max = 2**, **min = 1** (for 'a', 'b', and 'c')
//    - `beauty = max - min = 2 - 1 = 1`
//    - `result += beauty → result = 3`

// ---


//* #### **Step 2**: Starting at `i = 1`
// - Reset `freq = [0, 0, 0, ..., 0]`

// ---

// 1. **Substring: "a" (j = 1)**
//    - Update `freq`: `freq['a' - 'a']++ → freq = [1, 0, 0, ..., 0]`
//    - **max = 1**, **min = 1**
//    - `beauty = max - min = 1 - 1 = 0`
//    - `result += beauty → result = 3`

// ---

// 2. **Substring: "ab" (j = 2)**
//    - Update `freq`: `freq['b' - 'a']++ → freq = [1, 1, 0, ..., 0]`
//    - **max = 1**, **min = 1**
//    - `beauty = max - min = 1 - 1 = 0`
//    - `result += beauty → result = 3`

// ---

// 3. **Substring: "abc" (j = 3)**
//    - Update `freq`: `freq['c' - 'a']++ → freq = [1, 1, 1, ..., 0]`
//    - **max = 1**, **min = 1**
//    - `beauty = max - min = 1 - 1 = 0`
//    - `result += beauty → result = 3`

// ---

// 4. **Substring: "abcb" (j = 4)**
//    - Update `freq`: `freq['b' - 'a']++ → freq = [1, 2, 1, ..., 0]`
//    - **max = 2**, **min = 1**
//    - `beauty = max - min = 2 - 1 = 1`
//    - `result += beauty → result = 4`

// ---

// * #### **Step 3**: Starting at `i = 2`
// - Reset `freq = [0, 0, 0, ..., 0]`

// ---

// 1. **Substring: "b" (j = 2)**
//    - Update `freq`: `freq['b' - 'a']++ → freq = [0, 1, 0, ..., 0]`
//    - **max = 1**, **min = 1**
//    - `beauty = max - min = 1 - 1 = 0`
//    - `result += beauty → result = 4`

// ---

// 2. **Substring: "bc" (j = 3)**
//    - Update `freq`: `freq['c' - 'a']++ → freq = [0, 1, 1, ..., 0]`
//    - **max = 1**, **min = 1**
//    - `beauty = max - min = 1 - 1 = 0`
//    - `result += beauty → result = 4`

// ---

// 3. **Substring: "bcb" (j = 4)**
//    - Update `freq`: `freq['b' - 'a']++ → freq = [0, 2, 1, ..., 0]`
//    - **max = 2**, **min = 1**
//    - `beauty = max - min = 2 - 1 = 1`
//    - `result += beauty → result = 5`

// ---

//* #### **Step 4**: Starting at `i = 3`
// - Reset `freq = [0, 0, 0, ..., 0]`

// ---

// 1. **Substring: "c" (j = 3)**
//    - Update `freq`: `freq['c' - 'a']++ → freq = [0, 0, 1, ..., 0]`
//    - **max = 1**, **min = 1**
//    - `beauty = max - min = 1 - 1 = 0`
//    - `result += beauty → result = 5`

// ---

// 2. **Substring: "cb" (j = 4)**
//    - Update `freq`: `freq['b' - 'a']++ → freq = [0, 1, 1, ..., 0]`
//    - **max = 1**, **min = 1**
//    - `beauty = max - min = 1 - 1 = 0`
//    - `result += beauty → result = 5`

// ---

//* #### **Step 5**: Starting at `i = 4`
// - Reset `freq = [0, 0, 0, ..., 0]`

// 1. **Substring: "b" (j = 4)**
//    - Update `freq`: `freq['b' - 'a']++ → freq = [0, 1, 0, ..., 0]`
//    - **max = 1**, **min = 1**
//    - `beauty = max - min = 1 - 1 = 0`
//    - `result += beauty → result = 5`

// ---

// ### **Final Result**
// The total beauty sum for all substrings of `"aabcb"` is **`5`**.

// ### Summary Table:
// | Substring | Frequencies            | Max | Min | Beauty | Cumulative Result |
// |-----------|-------------------------|-----|-----|--------|--------------------|
// | a         | [1, 0, 0, ...]         | 1   | 1   | 0      | 0                  |
// | aa        | [2, 0, 0, ...]         | 2   | 2   | 0      | 0                  |
// | aab       | [2, 1, 0, ...]         | 2   | 1   | 1      | 1                  |
// | aabc      | [2, 1, 1, ...]         | 2   | 1   | 1      | 2                  |
// | aabcb     | [2, 2, 1, ...]         | 2   | 1   | 1      | 3                  |
// | ...       |                         |     |     |        | 5                  |

