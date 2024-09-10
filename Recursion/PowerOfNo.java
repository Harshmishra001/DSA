class PowerOfNo {
    
    long power(int N, int R) {
        if (R == 0) {  // If the power is 0, the result will always be 1
            return 1;
        }
        if (R % 2 == 0) {  // If power is even
            long res = power(N, R / 2);
            return (res * res) % 1000000007;  // 1 followed by 8 zeros and 7
        } else {  // If power is odd
            long res = power(N, R - 1);
            return (res * N) % 1000000007;
        }
    }
    
    public static void main(String[] args) {
        // Hardcoded values for N and R
        int N = 5;
        int R = 3;

        PowerOfNo powerObj = new PowerOfNo();
        
        // Debugging message: printing inputs
        System.out.println("Base (N): " + N + ", Exponent (R): " + R);
        
        // Calculating power
        long result = powerObj.power(N, R);
        
        // Debugging message: printing result
        System.out.println("Result of " + N + "^" + R + " is: " + result);
    }
}