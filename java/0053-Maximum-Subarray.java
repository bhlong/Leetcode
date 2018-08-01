/*

Problem Statement:

Given an integer array nums, find the contiguous subarray (containing at least one number) which 
has the largest sum and return its sum.

Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

*/

/*

Thought Process:

We loop through the array and maintain 2 variables: maxSoFar, and max. maxSoFar represents the max sum 
produced by a contiguous subarray so far, and max represent the max sum produced by any point up to where 
we currently are at. In the end, return maxSoFar.

*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int max = 0;
        for(int i : nums){
            max += i;
            if(maxSoFar < max) maxSoFar = max;
            if(max < 0) max = 0;
        }
        return maxSoFar;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(1)



*/