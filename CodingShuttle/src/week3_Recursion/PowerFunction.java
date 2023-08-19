package week3_Recursion;

/*Problem Statement
Given two integers x and n, write a function to determine xn.

Example 1:
Input : 

x = 2, n = 3

Output : 

8

Example 2:
Input :

x = 1, n = 1

Output :

1

Constraints:
-100 < x < 100

0 <= n <= 100

x and n are integers.

Either x is not zero or n is not zero.

0 <= xn <= 104*/

public class PowerFunction {
	public static int power(int x, int n)
    {
          
          if(n==0){
            return 1;
          }
          if(n==1){
           return x;
          }
          
          return x*power(x,n-1);
        
    }
}
