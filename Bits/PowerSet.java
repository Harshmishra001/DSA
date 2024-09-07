import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PowerSet {
    
    // Function to generate all possible non-empty substrings of the input string in sorted order
    public List<String> AllPossibleStrings(String s) {
       
        List<String> sorted = new ArrayList<>(); // List to store all possible substrings

        int n = s.length(); // Length of the input string

        // Loop through all possible combinations of substrings using bit manipulation
        // There are 2^n possible combinations for a string of length n
        for (int i = 0; i < Math.pow(2, n); i++) {
            String ans = ""; // Temporary string to build the current subset

            // Check each bit position to determine if the corresponding character should be included
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit of i is set
                if ((i & (1 << j)) != 0) {
                    ans += s.charAt(j); // Add character to the current subset string
                }
            }

            // Add the non-empty subset to the list
            if (!ans.isEmpty()) {
                sorted.add(ans);
            }
        }

        // Sort the list of subsets in lexicographical order
        Collections.sort(sorted);

        return sorted; // Return the sorted list of subsets
    }

    public static void main(String[] args) {
        PowerSet sol = new PowerSet();

        // Test case 1
        String s1 = "abc";
        List<String> result1 = sol.AllPossibleStrings(s1);
        System.out.println("All possible substrings of '" + s1 + "': " + result1);
        // Expected Output: [a, ab, abc, ac, b, bc, c]

        // Test case 2
        String s2 = "123";
        List<String> result2 = sol.AllPossibleStrings(s2);
        System.out.println("All possible substrings of '" + s2 + "': " + result2);
        // Expected Output: [1, 12, 123, 13, 2, 23, 3]

        // Test case 3
        String s3 = "a";
        List<String> result3 = sol.AllPossibleStrings(s3);
        System.out.println("All possible substrings of '" + s3 + "': " + result3);
        // Expected Output: [a]
    }
}

