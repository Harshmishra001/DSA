// Problem Statement: Given an array representing a queue of customers and the value of bills they hold, 
// determine if it is possible to provide correct change to each customer. Customers can only pay with 5$, 10$ or 
// 20$ bills and we initially do not have any change at hand. Return true, if it is possible to provide correct 
// change for each customer otherwise return false.
//  *** 5$ ka h ek lemonade

// Examples
// Example 1:
// Input: bills = [5, 5, 5, 10, 20]
                
// Output: True
// Explanation: 
                
// Initially we have 0 change and the queue of customers is [5, 5, 5, 10, 20].
// First Customer pays 5$, no change required.
// Second Customer pays 5$, no change required.
// Third Customer pays 5$, no change required.
// The Fourth Customer pays 10$, out of the three 5$ bills we have, we pay a 5$ bill and accept the 10$ bill.
// Fifth Customer pays 20$, out of the two 5$ bills and one 10$ bill we have, we pay 15$ in change and have one 5$ bill left.


import java.util.ArrayList;
import java.util.List;
// Time Complexity: O(N)
// Space Complexity: O(1)
public class LemonadeChange {
    
    // Function to find whether each customer can 
    // be provided with correct change
    public static boolean lemonadeChange(List<Integer> bills) {
        // Initialize a counter
        // for $5 bills
        int five = 0; 
        // Initialize a counter
        // for $10 bills
        int ten = 0;   
        // Iterate through each customer's bill
        for(int i = 0; i < bills.size(); i++){
            // If the customer's
            // bill is $5
            if(bills.get(i) == 5){
                // Increment the
                // count of $5 bills
                five++;  
            }
            // If the customer's
            // bill is $10
            else if(bills.get(i) == 10){
                // Check if there are $5
                // bills available to give change
                if(five > 0){
                     // Use one $5 bill
                     // to give change
                    five--; 
                    // Receive one $10 bill
                    ten++;   
                }
                // If no $5 bill
                // available, return false
                else return false;  
            }
            // If the customer's
            // bill is $20
            else {
                // Check if there are both
                // $5 and $10 bills
                // available to give change
                if(five > 0 && ten > 0){
                     // Use one $5 bill
                    five--; 
                    // Use one $10 bill
                    ten--;   
                }
                // If there are not enough $10 bills,
                // check if there are at least
                // three $5 bills available
                else if (five >= 3){
                    // Use three $5 bills
                    // to give change
                    five -= 3;  
                }
                // If unable to give
                // change, return false
                else return false;  
            }
        }
        // Return true if all customers
        // are served with correct change
        return true;  
    }

    public static void main(String[] args) {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(5);
        bills.add(10);
        bills.add(20);
        
        System.out.print("Queues of customers: ");
        for(int bill : bills){
            System.out.print(bill + " ");
        }
        System.out.println();
        
        boolean ans = lemonadeChange(bills);
        if(ans)
            System.out.println("It is possible to provide change for all customers.");
        else
            System.out.println("It is not possible to provide change for all customers.");
    }
}
                            
                        