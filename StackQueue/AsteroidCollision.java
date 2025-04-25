// We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

// Example 1:

// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
// Example 2:

// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.


// Time Complexity	O(n)
// Space Complexity	O(n)
import java.util.Stack;
import java.util.Arrays;

public class AsteroidCollision {

    // Function to simulate asteroid collision
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int asteroid : asteroids) {
            // If asteroid is moving right, just push it mtlb postive h toh right jara h or negative h toh left jara h
            if(asteroid > 0) {
                st.push(asteroid);
            } else {
                // Process collisions
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                    st.pop(); // Smaller right-moving asteroid destroyed
                }

                // If the current left-moving asteroid equals the top, both destroy each other
                if(!st.isEmpty() && st.peek() == Math.abs(asteroid)) {
                    st.pop();
                }
                // If no right-moving asteroid is left or top is a left-moving asteroid
                else if(st.isEmpty() || st.peek() < 0) {
                    st.push(asteroid);
                }
                // If peek > abs(asteroid), current asteroid is destroyed, do nothing
            }
        }

        // Convert stack to array
        int[] res = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }

    // Main method to run the code
    public static void main(String[] args) {
        AsteroidCollision solution = new AsteroidCollision();

        // Sample test case
        int[] asteroids = {5, 10, -5}; // Expected output: [5, 10]
        int[] result = solution.asteroidCollision(asteroids);

        System.out.println("After collisions: " + Arrays.toString(result));
    }
}
// 💡 Dry Run (for input {5, 10, -5}):
// 5 → right-moving → stack: [5]

// 10 → right-moving → stack: [5, 10]

// -5 → left-moving:

// Compare with 10: 10 > 5 → -5 destroyed (do nothing)

// stack remains [5, 10]

// Result: [5, 10]