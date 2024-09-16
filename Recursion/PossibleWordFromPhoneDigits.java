import java.util.ArrayList;
// Expected Time Complexity: O(4N * N).
// Expected Auxiliary Space: O(N).
class PossibleWordFromPhoneDigits
{
    // Function to find list of all words possible by pressing given numbers.
    static ArrayList<String> possibleWords(int a[], int N)
    {
        // Creating a list to store the result
        ArrayList<String> result = new ArrayList<>();
        
        // If no numbers are provided, return the empty result
        if (N == 0) {
            return result;
        }

        // Call helper function to generate words using backtracking
        generateWords(a, N, 0, new StringBuilder(), result);

        // Return the final list of possible words
        return result;
    }
    
    // Static array representing the characters corresponding to each number on the keypad
    static final String[] KEYPAD = {
        "",     // 0 (not used)
        "",     // 1 (not used)
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    
    // Recursive helper function to generate all possible words
    static void generateWords(int[] a, int N, int index, StringBuilder current, ArrayList<String> result)
    {
        // Base case: if we have processed all digits, add the formed word to the result
        if (index == N) {
            result.add(current.toString());
            return;
        }

        // Get the string of possible letters for the current digit
        String letters = KEYPAD[a[index]];

        // Iterate through each letter in the corresponding string
        for (int i = 0; i < letters.length(); i++) {
            // Append the current letter to the 'current' string
            current.append(letters.charAt(i));

            // Recursive call to process the next digit
            generateWords(a, N, index + 1, current, result);

            // Backtrack by removing the last letter added
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        // Sample test case: pressing numbers 2, 3 generates words like "ad", "ae", "af", etc.
        int[] input = {2, 3};
        int N = input.length;
        
        // Call the possibleWords method
        ArrayList<String> result = possibleWords(input, N);
        
        // Print the result
        for (String word : result) {
            System.out.println(word);
        }
    }
}
