package week3_Recursion;

/*Q Write a program to find Nth Fibonacci number. 
The integers in the following order are the Fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 
21, 34, 55, 89, 144.*/
/*Example:
Input: 
n = 2
Output: 
1
Explanation: 
1 is the 2nd number of fibonacci series.*/
public class fibonacci {
	public static void main(String[] args) {
		System.out.println(nthFibonacci(6));
	}

	public static int nthFibonacci(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		return nthFibonacci(n - 1) + nthFibonacci(n - 2);
	}

}
