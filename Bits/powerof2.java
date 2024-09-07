public class powerof2 {
   static boolean poweroftwo(int n){ 
    if(n==0) {
        return false;
    }
    else
    {
       return((n&(n-1))==0);
        
    }
} 
    public static void main(String[] args) {
        int n = 6;
        System.out.println(poweroftwo(n));

          n = 4;
        System.out.println(poweroftwo(n));
    }
}
