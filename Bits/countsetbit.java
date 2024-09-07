public class countsetbit {
    public static int countSetBitsForNumber(int n) {   //this is called brain kerningrams algorithm
        int res = 0;
        while (n > 0) {
            n = (n & (n - 1));  // Remove the lowest set bit
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 5;  //101 -> 2 1 h mtlb set bit
        System.out.println("count set bits  is: " + countSetBitsForNumber(n));
       
    }

    
}
