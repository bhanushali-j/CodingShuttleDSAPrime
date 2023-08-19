package week3_Recursion;

/*Problem Statement
Given three numbers x, n and p, compute (xn) % p. 

Example 1:
Input: 
x = 2.00000, n = 10
Output:
1024.00000
Example 2:
Input:
x = 2.00000, n = -2
Output:
0.25000
Explanation: 
2-2 = 1/22 = 1/4 = 0.25*/
public class PowerFunctionWithModulo {
	public double myPow(double x, int n, int p) {
		return power(x, n) % p;
	}

	public static double power(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n < 0) {
			x = 1 / x;
			n = Math.abs(n);
			return x * power(x, n - 1);
		}
		return x * power(x, n - 1);
	}
}
