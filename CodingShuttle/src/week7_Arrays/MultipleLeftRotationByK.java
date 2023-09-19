package week7_Arrays;

/*Problem Statement
Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in a matrix where the ith row represents the rotated array for 
the ith value in B.

After every rotation, array A becomes equal to the original.

Example 1:
Input:

5 2
1 2 3 4 5
2 3

Output:

[[3, 4, 5, 1, 2], [4, 5, 1, 2, 3]]

Explanation

B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation

1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]*/

public class MultipleLeftRotationByK {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		int rotations[]= {3,4,10};
		int n=arr.length;
		int m=rotations.length;
		
		int result[][]=new int[m][n];
		
		//Create a temporary array with twice the size of array which we want to rotate
		int temp[]=new int[2*n];
		
		//adding values in temp array such as for array=[1,2,3,4,5], temp=[1,2,3,4,5,1,2,3,4,5]
		for(int i=0;i<n;i++) {
			temp[i]=arr[i];
			temp[i+n]=arr[i];
		}
		
		for(int i=0;i<m;i++) {
			//Because if we want to rotate suppose arr=[1,2,3] 32 times then eventually we left shift array by 2 times.
			//so we do k%n for finding offset where k is no. of times to left rotate and n is size of array to be rotated.
			
			//IMP TIP : If asked to do a right rotation then we can execute the same code of left rotation just by updating the
			//value of offset where for k left rotation is same as n-k right rotation. 
			int offset=rotations[i]%n;
			
			for(int j=0;j<n;j++) {
				result[i][j]=temp[j+offset];
			}
		}
		
		for(int[] i:result) {
			for(int j:i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
	}
}
