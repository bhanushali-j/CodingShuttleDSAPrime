package week3_Recursion;

/*Problem Statement
Given a non-negative integer, N. Find the factorial of N.

Example 1:
Input:
N = 5
Output:
120
Explanation:
5*4*3*2*1 = 120*/
public class factorial {
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
	public static int factorial(int n){
		if(n==0){
            return 1;
          }
      return n*factorial(n-1);
    }
}
