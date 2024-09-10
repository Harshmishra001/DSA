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
