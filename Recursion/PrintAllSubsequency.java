import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// SIMILAR QN LIKE POWER SET

public class PrintAllSubsequency {
    // Recursive function to generate all possible substrings
    private void generateSubstrings(String s, String current, int index, List<String> result) {
        // If we've processed all characters, add the current substring (if it's not empty)
        if (index == s.length()) {
            if (!current.isEmpty()) {
                result.add(current);
            }
            return;
        }

        // Option 1: Exclude the current character
        generateSubstrings(s, current, index + 1, result);

        // Option 2: Include the current character
        generateSubstrings(s, current + s.charAt(index), index + 1, result);
    }

    // Main function to get all possible non-empty substrings in sorted order
    public List<String> getAllSubstrings(String s) {
        List<String> result = new ArrayList<>(); // List to store all substrings
        generateSubstrings(s, "", 0, result);    // Start recursion from the first character
        Collections.sort(result);                // Sort the result lexicographically
        return result;
    }

    public static void main(String[] args) {
        PrintAllSubsequency  sol = new PrintAllSubsequency();

        String s1 = "abc";
        List<String> result1 = sol.getAllSubstrings(s1);
        System.out.println("All possible substrings of '" + s1 + "': " + result1);
        // Output: [a, ab, abc, ac, b, bc, c]
    }
}


    