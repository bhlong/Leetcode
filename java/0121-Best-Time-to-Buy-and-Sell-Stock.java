/*

Problem Statement:

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one 
share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

*/

/*

Thought Process:

Loop through the array while keeping track of the smallest element, while elements are bigger than
the smallest element, calculate the difference and store the largest one. If a smaller element is
encountered, update the smallest element.

*/

class Solution {
    public int maxProfit(int[] prices) {
        int smallest = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i : prices){
            if(i < smallest){
                smallest = i;
            } else if ((i - smallest) > maxProfit) {
                maxProfit = i - smallest;
            }
        }

        return maxProfit;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(1)



*/