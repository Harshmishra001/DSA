import java.util.Arrays;
// Time Complexity: O(n log n) due to sorting the jobs array
// Space Complexity: O(1) as no extra space is used apart from variables
public class ShortestJobFirst {

    // Function to calculate average waiting time using Shortest Job First algorithm
    static float shortestJobFirst(int[] jobs) {
        // Sort the jobs in ascending order
        Arrays.sort(jobs);

        // Initialize total waiting time
        float waitTime = 0;
        // Initialize total time taken
        int totalTime = 0;
        // Get the number of jobs
        int n = jobs.length;

        // Iterate through each job to calculate waiting time
        for (int i = 0; i < n; ++i) {
            // Add current total time to waiting time
            waitTime += totalTime;

            // Add current job's time to total time
            totalTime += jobs[i];
        }

        // Return the average waiting time
        return waitTime / n;
    }

    public static void main(String[] args) {
        // Example job durations
        int[] jobs = {4, 3, 7, 1, 2};

        // Print the array representing job durations
        System.out.print("Array Representing Job Durations: ");
        for (int i = 0; i < jobs.length; i++) {
            System.out.print(jobs[i] + " ");
        }
        System.out.println();

        // Calculate the average waiting time
        float ans = shortestJobFirst(jobs);

        // Print the average waiting time
        System.out.println("Average waiting time: " + ans);

        // Dry run explanation:
        // Step 1: Sort the jobs array -> {1, 2, 3, 4, 7}
        // Step 2: Calculate waiting time:
        //         Job 1: Wait = 0, Total Time = 1
        //         Job 2: Wait = 1, Total Time = 3
        //         Job 3: Wait = 3, Total Time = 6
        //         Job 4: Wait = 6, Total Time = 10
        //         Job 5: Wait = 10, Total Time = 17
        //         Total Wait Time = 0 + 1 + 3 + 6 + 10 = 20
        // Step 3: Average Waiting Time = Total Wait Time / Number of Jobs = 20 / 5 = 4.0
    }
}
