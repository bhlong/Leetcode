/*

Problem Statement:

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending 
order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example:

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

*/

/*

Thought Process:

The start will be the smallest non-min value at index j where min value is the subarray j->end.
The end will be the biggest non-max value at index i where min value is the subarray start->i.

*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 1
        int maxIndex = 0;
        
        for(int i = 0, j = nums.length - 1 ; i < nums.length ; i++, j--){
            min = Math.min(min, nums[j]);
            if(nums[j] != min) minIndex = j;
            max = Math.max(max, nums[i]);
            if(nums[i] != max) maxIndex = i;
        }
        return maxIndex - minIndex + 1;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(1)



*/