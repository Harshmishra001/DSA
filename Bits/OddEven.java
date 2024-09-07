class OddEven {
    // Function to determine whether n is odd or even.
    static String oddEven(int n) {
        // Check if the number is divisible by 2.
        if (n % 2 == 0) {
            return "even";  // If the remainder is 0, the number is even.
        } else {
            return "odd";   // If the remainder is not 0, the number is odd.
        }
    }

    // Main method to test the function.
    public static void main(String[] args) {
        int n = 15;  // Example number, change for other tests
        System.out.println(oddEven(n));  // Output: "odd"
        
        n = 8;  // Another example
        System.out.println(oddEven(n));  // Output: "even"
    }
}
