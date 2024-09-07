class PrintNameNtimes {      // t.c-o(n) sc.-o(n)
    
    static void func(int i, int n){
        
            // Base Condition.
            if(i>n) 
             return;
            System.out.println("Harsh");
            // Function call to print till i increments.
            func(i+1,n);
    }
    public static void main(String[] args) {
       int n = 4;     // Here, let’s take the value of n to be 4.
       func(1,n);
    }
}