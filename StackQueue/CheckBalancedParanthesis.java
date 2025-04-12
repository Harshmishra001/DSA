
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.*;

class CheckBalancedParenthesis {
    
    // Function to check if a given string of parentheses is balanced
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>(); // Stack to store opening brackets
        
        for (char it : s.toCharArray()) {
            // If an opening bracket is encountered, push it onto the stack
            if (it == '(' || it == '[' || it == '{') {
                st.push(it);
            } 
            // If a closing bracket is encountered
            else {
                if (st.isEmpty()) return false; // If stack is empty, return false (unmatched closing bracket)
                
                char ch = st.pop(); // Pop top element
                
                // Check if popped element matches the corresponding opening bracket
                if (!((it == ')' && ch == '(') ||  
                      (it == ']' && ch == '[') || 
                      (it == '}' && ch == '{'))) {
                    return false;
                }
            }
        }
        
        return st.isEmpty(); // If stack is empty at last then, brackets are balanced
    }

    public static void main(String[] args) {
        String s = "()[{}()]";
        
        if (isValid(s))
            System.out.println("True"); // Expected Output: True
        else
            System.out.println("False");
    }
}


// ---

// Got it! Here's the step-by-step dry run in a **detailed list format**:

// ---

// ### **Input:** `"()[{}()]"`  
// **Initial Stack:** `[]` (Empty)

// 1. Read `'('` → It's an **opening bracket**, so **push** it onto the stack.  
//    **Stack:** `['(']`  

// 2. Read `')'` → It's a **closing bracket**, so **pop** from the stack.  
//    - Top of the stack is `'('`, which **matches** `')'`. ✅  
//    **Stack after pop:** `[]`  

// 3. Read `'['` → It's an **opening bracket**, so **push** it onto the stack.  
//    **Stack:** `['[']`  

// 4. Read `'{'` → It's an **opening bracket**, so **push** it onto the stack.  
//    **Stack:** `['[', '{']`  

// 5. Read `'}'` → It's a **closing bracket**, so **pop** from the stack.  
//    - Top of the stack is `'{'`, which **matches** `'}'`. ✅  
//    **Stack after pop:** `['[']`  

// 6. Read `'('` → It's an **opening bracket**, so **push** it onto the stack.  
//    **Stack:** `['[', '(']`  

// 7. Read `')'` → It's a **closing bracket**, so **pop** from the stack.  
//    - Top of the stack is `'('`, which **matches** `')'`. ✅  
//    **Stack after pop:** `['[']`  

// 8. Read `']'` → It's a **closing bracket**, so **pop** from the stack.  
//    - Top of the stack is `'['`, which **matches** `']'`. ✅  
//    **Stack after pop:** `[]`  

// ### **Final Stack:** `[]` (Empty)  
// ✅ Since the stack is **empty**, the string is **balanced**.

// ### **Output:** `"True"`

