package week3_Recursion;

/*Problem Statement
Create a function that counts the number of times a string (str2) appears in another string (str1).

Example 1:
Input : 
str1 = "hello world, hello universe"
str2 = 'hello'

Output :
2

Explanation:
'hello' appears two times in str1.*/

public class StringOccurences {
	
	public static void main(String[] args) {
		System.out.println(StringOccurenceHelper("hello world, hello universe","worl",0));
	}
	public static int StringOccurenceHelper(String text, String word,int i) {
       if(i>text.length() - word.length()) {
    	   return 0;
       }
       int subproblemCount=StringOccurenceHelper(text,word,i+1);
       
       boolean isSubProblemMatch=text.substring(i, i+word.length()).equals(word);
       
       if(isSubProblemMatch) {
    	   return subproblemCount+1;
       }
       
       return subproblemCount;
    }
}
