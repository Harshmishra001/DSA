public class CheckPerfectSumExistorNot {


    // Main function that checks if there's a subsequence in the array that sums to 'K'
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // Calling the recursive helper function 'seq' to check for subsequences
        return seq(arr, K, 0, 0);
    }

    // Recursive helper function to find if a subsequence adds up to 'target'
    // 'sum' is the current sum of the subsequence, 'i' is the current index
    public static boolean seq(int[] arr, int target, int sum, int i) {
        
        // Base case: If we have reached the end of the array
        if (i == arr.length) {
            // If the current sum equals the target, return true
            if (sum == target) {
                return true;
            }
            // If not, return false
            return false;
        }

        // If the sum has exceeded the target, no need to continue, return false
        if (sum > target) {
            return false;
        }

        // Recursive call: Try including the current element in the subsequence
        if (seq(arr, target, sum + arr[i], i + 1)) {
            return true;
        }

        // Recursive call: Try excluding the current element from the subsequence
        if (seq(arr, target, sum, i + 1)) {
            return true;
        }

        // If neither including nor excluding the element works, return false
        return false;
    }

    // Main method to test the checkSubsequenceSum function
    public static void main(String[] args) {
        CheckPerfectSumExistorNot  solution = new CheckPerfectSumExistorNot();
        
        // Example test case
        int arr[] = {1, 2, 3, 7};
        int N = arr.length;
        int K = 10;  // We want to check if a subsequence sums to 10

        // Call the checkSubsequenceSum function
        boolean result = solution.checkSubsequenceSum(N, arr, K);

        // Print the result
        if (result) {
            System.out.println("There is a subsequence with sum " + K);
        } else {
            System.out.println("No subsequence with sum " + K);
        }
    }
}


