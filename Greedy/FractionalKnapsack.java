// Problem Statement: The weight of N items and their corresponding values are given. We have to put these 
// items in a knapsack of weight W such that the total value obtained is maximized.

// Note: We can either take the item as a whole or break it into smaller units.

// Example:

// Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.

// Output: 240.00

// Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. Total value = 100 + 60 + 80 = 240.00


import java.util.*;  // Importing necessary Java utilities

// Class to represent an item with value and weight
class Item {
    int value, weight;

    // Constructor to initialize value and weight
    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

// Comparator class to sort items based on value/weight ratio in descending order
class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double) (a.value) / (double) (a.weight);  // Value per weight of item a
        double r2 = (double) (b.value) / (double) (b.weight);  // Value per weight of item b
        
        if (r1 < r2) return 1;   // Higher ratio should come first
        else if (r1 > r2) return -1;
        else return 0;
    }
}

// Main class to solve the Fractional Knapsack problem
public class  FractionalKnapsack  {
    // Time Complexity: O(n log n) (due to sorting) + O(n) (for iteration) = O(n log n)
    // Space Complexity: O(1) (only a few extra variables are used)
    
    // Function to calculate the maximum value in the knapsack
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new ItemComparator()); // Sort items by value/weight ratio

        int curWeight = 0;  // Current weight in the knapsack
        double finalValue = 0.0;  // Maximum value stored

        // Iterating through all items
        for (int i = 0; i < n; i++) {
            // If adding the whole item doesn't exceed weight limit
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;  // Add item weight
                finalValue += arr[i].value;  // Add full value
            }
            // If item can't be fully added, take the fraction
            else {
                int remain = W - curWeight;  // Remaining capacity
                finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain; // Add fractional value
                break; // Knapsack is full, break loop
            }
        }
        return finalValue; // Return maximum value
    }

    // Main function to execute the program
    public static void main(String args[]) {
        int n = 3, weight = 50;  // Number of items and knapsack weight capacity
        Item arr[] = {new Item(100, 20), new Item(60, 10), new Item(120, 30)}; // Array of items
        
        double ans = fractionalKnapsack(weight, arr, n);  // Calculate maximum value
        System.out.println("The maximum value is " + ans);  // Print the result
    }
}

/*
Detailed Dry Run Walkthrough:

### Given Input:
Knapsack capacity (W) = 50
Items:
1. Item 1: Value = 100, Weight = 20
2. Item 2: Value = 60, Weight = 10
3. Item 3: Value = 120, Weight = 30

### Step 1: Compute Value-to-Weight Ratio
| Item  | Value | Weight | Value/Weight Ratio |
|--------|--------|---------|------------------|
| Item 1 | 100  | 20      | **5.0**          |
| Item 2 | 60   | 10      | **6.0**          |
| Item 3 | 120  | 30      | **4.0**          |

### Step 2: Sorting Items by Value/Weight Ratio
Sorted order (highest ratio first): **Item 2 -> Item 1 -> Item 3**

### Step 3: Filling the Knapsack
#### Iteration 1: Adding Item 2 (60, 10)
- **Code Execution:** `if (curWeight + arr[i].weight <= W) { curWeight += arr[i].weight; finalValue += arr[i].value; }`
- Current weight = 10
- Current value = 60
- Remaining capacity = 50 - 10 = 40

#### Iteration 2: Adding Item 1 (100, 20)
- **Code Execution:** `if (curWeight + arr[i].weight <= W) { curWeight += arr[i].weight; finalValue += arr[i].value; }`
- Current weight = 30 (10 + 20)
- Current value = 160 (60 + 100)
- Remaining capacity = 50 - 30 = 20

#### Iteration 3: Adding Fraction of Item 3
- **Code Execution:** `int remain = W - curWeight; finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain; break;`
- Available weight = 30, but only 20 can be added.
- Fraction to take = (20/30) = 2/3
- Value added = (2/3) * 120 = 80
- Final weight = 50 (full)
- Final value = 240 (160 + 80)

### Final Output:
```
The maximum value is 240.0
```

### Summary of the Algorithm:
1. **Sort items** by their value-to-weight ratio in descending order.
2. **Iterate over the sorted items**, adding them completely if possible.
3. **If the item cannot be added completely, add a fraction** to fill the remaining capacity.
4. **Return the total maximum value obtained**.

This ensures we obtain the highest possible value within the given weight constraint.
*/
