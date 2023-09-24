package week7_Arrays;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

/*Problem Statement
You are given an unsorted array of size N. Array elements are from 1 to N. One number from the set {1, 2, …n} is missing, and one number (not missing) occurs twice in the array. Find these two numbers.

Example 1:
Input:
6
[1, 1, 2, 3, 4, 6]

Output:
[5, 1]

Example 2:
Input:
4
[4, 2, 3, 2]

Output:
[1, 2]*/
public class MissingRepeatingNumber {
	public static void main(String[] args) {
		int a[]= {1,1,2,3,4,6};
		
		Vector<Integer> result=new Vector<>();
        Set<Integer> set=new LinkedHashSet<>();
        int repeated=0;
       
        for(int i=0;i<a.length;i++){
          if(set.contains(a[i])){
             repeated=a[i]; 
          }
          else{
            set.add(a[i]);
          }  
        }
       
       for(int i=0;i<a.length;i++){
         if(!set.contains(i+1)){
           result.add(i+1);
           break;
         }
       }
     result.add(repeated);
     System.out.println(result);	
     }
}
