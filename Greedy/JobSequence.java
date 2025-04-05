// Problem Statement: You are given a set of N jobs where each job comes with a deadline and profit. The profit can only be 
// earned upon completing the job within its deadline. Find the number of jobs done and the maximum profit that can be obtained.
//  Each job takes a single unit of time and only one job can be performed at a time.

// Examples

// Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}

// Output: 2 60

// Explanation: The 3rd job with a deadline 1 is performed during the first unit of time .The 1st job is performed during the second unit of time as its deadline is 4.
// Profit = 40 + 20 = 60

// Example 2:

// Input: N = 5, Jobs = {(1,2,100),(2,1,19),(3,2,27),(4,1,25),(5,1,15)}

// Output: 2 127

// Explanation: The  first and third job both having a deadline 2 give the highest profit. 
// Profit = 100 + 27 = 127

import java.util.Arrays;
import java.util.Comparator;

// Comparator class to sort jobs in descending order of profit
class JobComparator implements Comparator<Job> {
    public int compare(Job j1, Job j2) {
        return j2.profit - j1.profit; // Sorting jobs by profit in descending order
    }
}

// Job class representing each job with a deadline and profit
class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class JobSchedulingSolution {
    private int[] parent; // DSU parent array

    // Find function for DSU
    private int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]); // Path compression
    }

    // Union function for DSU
    private void union(int u, int v) {
        parent[find(u)] = find(v);
    }

    /**
     * Brute Force Approach:
     * Time Complexity: O(n^2) (due to nested loops for checking slots)
     * Space Complexity: O(maxDeadline) (for slot array)
     */
    int[] JobSchedulingBruteForce(Job arr[], int n) {
        Arrays.sort(arr, new JobComparator()); // Sort jobs by profit

        int maxDeadline = 0;
        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        boolean[] slots = new boolean[maxDeadline + 1]; // Slot array
        int totalProfit = 0, totalJobs = 0;

        for (Job job : arr) {
            for (int j = Math.min(maxDeadline, job.deadline); j > 0; j--) {
                if (!slots[j]) { // If slot is available
                    slots[j] = true; // Mark slot as occupied
                    totalProfit += job.profit;
                    totalJobs++;
                    break;
                }
            }
        }

        return new int[] { totalJobs, totalProfit };
    }

    /**
     * Optimized Approach using Disjoint Set Union (DSU):
     * Time Complexity: O(n log n) (due to sorting) + O(n * α(n)) (for DSU
     * operations) = O(n log n)
     * Space Complexity: O(maxDeadline) (for parent array)
     */
    int[] JobSchedulingOptimized(Job arr[], int n) {
        Arrays.sort(arr, new JobComparator()); // Sort jobs by profit

        int maxDeadline = 0;
        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i; // Initialize DSU parent array
        }

        int totalProfit = 0, totalJobs = 0;

        for (Job job : arr) {
            int availableSlot = find(Math.min(maxDeadline, job.deadline));
            if (availableSlot > 0) { // If a slot is available
                union(availableSlot, availableSlot - 1); // Mark slot as occupied
                totalProfit += job.profit;
                totalJobs++;
            }
        }

        return new int[] { totalJobs, totalProfit };
    }

    public static void main(String[] args) {
        Job arr[] = { new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27),
                new Job(4, 1, 25), new Job(5, 1, 15) };

        JobSchedulingSolution solution = new JobSchedulingSolution();

        // Brute Force Approach
        int[] bruteForceResult = solution.JobSchedulingBruteForce(arr, arr.length);
        System.out.println("Brute Force - Total Jobs Done: " + bruteForceResult[0]);
        System.out.println("Brute Force - Total Profit Earned: " + bruteForceResult[1]);

        // Optimized Approach
        int[] optimizedResult = solution.JobSchedulingOptimized(arr, arr.length);
        System.out.println("Optimized - Total Jobs Done: " + optimizedResult[0]);
        System.out.println("Optimized - Total Profit Earned: " + optimizedResult[1]);
    }
}

/**
 * Dry Run:
 * Input: N = 5, Jobs = {(1,2,100),(2,1,19),(3,2,27),(4,1,25),(5,1,15)}
 * 
 * Step 1: Sort jobs by profit in descending order:
 * Sorted Jobs = {(1,2,100), (3,2,27), (4,1,25), (2,1,19), (5,1,15)}
 * 
 * Step 2: Initialize parent array for DSU:
 * parent = [0, 1, 2]
 * 
 * Step 3: Process each job:
 * - Job (1,2,100): Find available slot = 2. Assign job to slot 2. Union(2, 1).
 * parent = [0, 1, 1]. TotalProfit = 100, TotalJobs = 1.
 * - Job (3,2,27): Find available slot = 1. Assign job to slot 1. Union(1, 0).
 * parent = [0, 0, 1]. TotalProfit = 127, TotalJobs = 2.
 * - Job (4,1,25): No available slot.
 * - Job (2,1,19): No available slot.
 * - Job (5,1,15): No available slot.
 * 
 * Step 4: Output: TotalJobs = 2, TotalProfit = 127.
 */
