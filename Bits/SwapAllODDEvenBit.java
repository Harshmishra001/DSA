class SwapAllOddEvenBit {
    // Function to swap odd and even bits.
    public static int swapBits(int n) {
        // Mask to preserve odd bits: 01010101...
        int preservedOdd = 0X55555555;
        
        // Mask to preserve even bits: 10101010...
        int preservedEven = 0XAAAAAAAA;
        
        // Extracting odd bits from n using bitwise AND with the preservedOdd mask.
        int odd = n & preservedOdd;
        
        // Extracting even bits from n using bitwise AND with the preservedEven mask.
        int even = n & preservedEven;
        
        // Shifting even bits to the right by 1 position to make them odd.
        even = even >> 1;
        
        // Shifting odd bits to the left by 1 position to make them even.
        odd = odd << 1;
        
        // Combining the modified even and odd bits using bitwise OR to get the final result.
        return even | odd;
    }

    public static void main(String[] args) {
        // Test cases
        int number = 43; // Example number (binary: 00101011)
        
        // Print original number and its binary representation
        System.out.println("Original number: " + number);
        System.out.println("Original binary: " + Integer.toBinaryString(number));
        
        // Swap odd and even bits
        int result = swapBits(number);
        
        // Print the result and its binary representation
        System.out.println("Number after swapping odd and even bits: " + result);
        System.out.println("Result binary: " + Integer.toBinaryString(result));
    }
}


// Example:

// Let's say we have the integer `n = 43`. In binary, this is represented as `00101011`.

//  1. Masks:
//    - **Odd bits mask**: `0X55555555` (binary: `01010101010101010101010101010101`)
//    - **Even bits mask**: `0XAAAAAAAA` (binary: `10101010101010101010101010101010`)

//  2. Extract Odd and Even Bits:
//    - Extract Odd Bits:
    
//      odd = n & preservedOdd
//      odd = 00101011 & 01010101
//      odd = 00000001 (binary)
//      
//    - Extract Even Bits:
     
//      even = n & preservedEven
//      even = 00101011 & 10101010
//      even = 00101010 (binary)
//      

//  3. Shift Bits:
//    - Shift Even Bits Right:
    
//      even = even >> 1
//      even = 00101010 >> 1
//      even = 00010101 (binary)
//      ```
//    - Shift Odd Bits Left:
    
//      odd = odd << 1
//      odd = 00000001 << 1
//      odd = 00000010 (binary)
//      ```

//  4. Combine Using OR:
//    - 
//      result = even | odd
//      result = 00010101 | 00000010
//      result = 00010111 (binary)
//      ```

// Final Result:
// - The integer `43` (`00101011` in binary) with odd and even bits swapped results in `23` (`00010111` in binary).

// Summary:
// - **Input**: `43` (binary `00101011`)
// - **Output**: `23` (binary `00010111`)
