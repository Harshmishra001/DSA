
public class factorial {
    // Recursive Approach
    // static int fact(int n)
	// {
	//     if(n==0)
	//         return 1;
	// 	return n * fact(n-1);
	// }

	// Iterative Approach
	static int fact(int n)
	{
		int res=1;
		for(int i=2; i<=n; i++)
		{
			res= res*i;       
		}
		return res;
	}

	public static void main (String[] args) {
		int number = 5;
		System.out.println(fact(number));

	}
}
