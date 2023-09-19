package week7_Arrays;

/*Problem Statement
You are given an array of N integers, A1, A2 ,..., AN. Return maximum value of f(i, j) for all
1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute 
value of x.

Example 1:
Input:
A = [1, 3, -1]

Output:
5

Explanation:
f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
So, we return 5.

Example 2:
Input:
A = {3, -2, 5, -4}

Output:
10*/

public class MaximumAbsoluteDifference {
	public static void main(String[] args) {
		
//		We can write |A[i] - A[j]| + |i - j| as below : 
//			
//									  Largest		smallest
//		when -(A[i] - A[j]) -(i-j) = -(A[i] + i) + (A[j] + j) aipi (A[i] plus i) // i and j are just index
//		when +(A[i] - A[j]) +(i-j) =  (A[i] + i) - (A[j] + j) aipi
//		when -(A[i] - A[j]) +(i-j) = -(A[i] + i) + (A[j] - j) aimi (A[i] minus i)
//		when  (A[i] - A[j]) -(i-j) =  (A[i] - i) - (A[j] - j) aimi
		int a[]= {3,-2,5,-4};
		
		
		int Minaipi=Integer.MAX_VALUE;
		int Maxaipi=Integer.MIN_VALUE;
		int Minaimi=Integer.MAX_VALUE;
		int Maxaimi=Integer.MIN_VALUE;
				
		for(int i=0;i<a.length;i++) {
			Minaipi=Math.min(Minaipi, a[i]+i);
			Maxaipi=Math.max(Maxaipi, a[i]+i);
			Minaimi=Math.min(Minaimi, a[i]-i);
			Maxaimi=Math.max(Maxaimi, a[i]-i);
		}
		
		int MaxDiffaipi=Maxaipi-Minaipi;
		int MaxDiffaimi=Maxaimi-Minaimi;
		
		System.out.println(Math.max(MaxDiffaipi, MaxDiffaimi));
			
	}
}
