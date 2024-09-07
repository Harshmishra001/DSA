public class PrintNto1 {

    static void func(int i, int n){
        // Base Condition.
        if(i<1)    //1 s hi km h toh sidha return krdo
         return;
        System.out.println(i);
        // Function call to print i till i decrements to 1.
        func(i-1,n);
}
public static void main(String[] args) {
   int n = 4;
   func(n,n);
}
}


    
   
