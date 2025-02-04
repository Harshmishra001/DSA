public class GCD {
    // Euclidean Algorithm Code
    // static int gcd(int a, int b)
	// {
	// 	while(a!=b)
	// 	{
	// 		if(a > b)
	// 			a = a - b;
	// 		else
	// 			b = b - a; 
	// 	}
	// 	return a;
	// }
            
    //  optimised approach  - Euclidean Algorithm Code
    static int gcd(int a, int b)
	{
		if(b==0)
			return a;

		return gcd(b, a % b);
	}


	public static void main (String[] args) {
		int a = 12, b = 15;
		System.out.println(gcd(a, b));
	}
}
