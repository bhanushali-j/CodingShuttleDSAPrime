package week7_Arrays;

/*Problem Statement
You are given an array of prices where prices[i] is the price of a given stock on the ith day. 
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day to sell that stock in the future. 
Return the maximum profit you can achieve from this transaction. If you cannot accomplish any profit, return 0.

Example 1:
Input:
[10, 19, 1, 30, 32]
Output:
31

Explanation:
Buy at Rs. 1 and Sell at Rs. 32 for a Profit of Rs. 31

Example 2:

Input:
[9, 17, 18, 5]
Output:
9

Explanation:
Buy at Rs. 9 and Sell at Rs. 18 for a Profit of Rs. 9*/
public class MaxProfitInStock {
	public static void main(String[] args) {
		int prices[]= {10,19,1,30,32};
		int maxProfit=0;
	      int minSoFar=prices[0];
	      for(int i=1;i<prices.length;i++){
	        minSoFar=Math.min(minSoFar,prices[i]);
	        maxProfit=Math.max(maxProfit,prices[i]-minSoFar);
	      }
	      System.out.println(maxProfit); 
	}
}
