package week7_Arrays;

/*Problem Statement
A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is 
the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.
Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.
Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.

Example 1:
Input:
[1, 4, 2, 8]
[1, 3, 2, 4]

Output:
false

Example 2:
Input:
[2, 4, 10, 8]
[1, 2, 6, 6]

Output:
true*/
public class RectangleOverlaps {
	public static void main(String[] args) {
		int rec1[]= {1,4,2,8};
		int rec2[]= {1,3,2,4};
		
		System.out.println(rectangleOverlap(rec1,rec2));
	}

	private static boolean rectangleOverlap(int[] rec1, int[] rec2) {
		
		if(rec1[0]>=rec2[2] || rec1[2]<=rec2[0]) {
			return false;
		}
		
		if(rec1[1]>=rec2[3] || rec1[3]<=rec2[1]) {
			return false;
		}
		
		return true;
		
	}
}
