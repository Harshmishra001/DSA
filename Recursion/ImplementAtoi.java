class ImplementAtoi {
    
    public int atoi(String s) {
        
        // Initialize the result number to 0
        int num = 0;
       
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If a '-' sign is found but not at the beginning, it's an invalid format
            if (ch == '-' && i != 0) return -1;
            
            // If a '-' sign is found at the beginning, skip it
            if (ch == '-' && i == 0) continue;

            // Check if the current character is a digit
            if (ch >= '0' && ch <= '9') {
                // Convert the character to its numeric value and update num
                num = (num * 10) + (ch - '0');
            } else {
                // If a non-digit character is found, return -1 (invalid input)
                return -1;
            }
        }
        
        // Return the number with appropriate sign based on whether the string started with '-'
        return s.charAt(0) == '-' ? -num : num;
    }

    public static void main(String[] args) {
        ImplementAtoi obj = new ImplementAtoi();
        
        // Single test case
        String testCase1 = "42";   //o/p->42
        String testCase2 = "-123"; //o/p-> -123
        String testCase3 = "21a";   //o/p-> -1

        // Convert the input string to integer
        int result1 = obj.atoi(testCase1);
        // Convert the input string to integer
        int result2 = obj.atoi(testCase2);
        // Convert the input string to integer
        int result3 = obj.atoi(testCase3);
        
        // Print the result
        System.out.println("Input: \"" + testCase1 +"\" -> Output: " + result1);
        // Print the result
        System.out.println("Input: \"" + testCase2 +"\" -> Output: " + result2);
        // Print the result
        System.out.println("Input: \"" + testCase3 +"\" -> Output: " + result3);
    }
}
//**dry run**

// The `atoi` method:
// 1. Converts a string input into an integer.
// 2. Handles cases with negative signs (`-`) at the start.
// 3. Returns `-1` if the string contains invalid characters.

// ---

// ### **Test Case 1: "42"**

// #### Input: `"42"`
// #### Dry Run:

// 1. **Initialization**: `num = 0`
// 2. Iterate through the string `"42"`.
//    - **First character**: `'4'`
//      - It is a digit. Convert `'4'` to `4` using `(ch - '0')`.
//      - Update `num = (0 * 10) + 4 = 4`.
//    - **Second character**: `'2'`
//      - It is a digit. Convert `'2'` to `2` using `(ch - '0')`.
//      - Update `num = (4 * 10) + 2 = 42`.
// 3. No invalid characters or `'-'` found. Return `num = 42`.

// #### Output:
// `42`

// ---

// ### **Test Case 2: "-123"**

// #### Input: `"-123"`
// #### Dry Run:

// 1. **Initialization**: `num = 0`
// 2. Iterate through the string `"-123"`.
//    - **First character**: `'-'`
//      - It is at index `0`. Skip it.
//    - **Second character**: `'1'`
//      - It is a digit. Convert `'1'` to `1`.
//      - Update `num = (0 * 10) + 1 = 1`.
//    - **Third character**: `'2'`
//      - It is a digit. Convert `'2'` to `2`.
//      - Update `num = (1 * 10) + 2 = 12`.
//    - **Fourth character**: `'3'`
//      - It is a digit. Convert `'3'` to `3`.
//      - Update `num = (12 * 10) + 3 = 123`.
// 3. Add a negative sign since the first character was `'-'`.
//    - Return `-num = -123`.

// #### Output:
// `-123`

// ---

// ### **Test Case 3: "21a"**

// #### Input: `"21a"`
// #### Dry Run:

// 1. **Initialization**: `num = 0`
// 2. Iterate through the string `"21a"`.
//    - **First character**: `'2'`
//      - It is a digit. Convert `'2'` to `2`.
//      - Update `num = (0 * 10) + 2 = 2`.
//    - **Second character**: `'1'`
//      - It is a digit. Convert `'1'` to `1`.
//      - Update `num = (2 * 10) + 1 = 21`.
//    - **Third character**: `'a'`
//      - It is not a digit. Return `-1` (invalid input).

// #### Output:
// `-1`

// ---

// ### **Walkthrough of Outputs:**

// For the given main method:
// ```java
// System.out.println("Input: \"" + testCase1 +"\" -> Output: " + result1);
// System.out.println("Input: \"" + testCase2 +"\" -> Output: " + result2);
// System.out.println("Input: \"" + testCase3 +"\" -> Output: " + result3);
// ```

// #### Final Outputs:
// 1. Input: `"42"` -> Output: `42`
// 2. Input: `"-123"` -> Output: `-123`
// 3. Input: `"21a"` -> Output: `-1`

// ---

// Let me know if you need further clarifications or optimizations!