/*

Problem Statement:

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that 
is missing from the array.

Example:

Input: [3,0,1]
Output: 2

*/

/*

Thought Process:

Find sum of 0...n, then subtract the sum from array.

*/

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i : nums) sum+=i;
        return (nums.length * (nums.length + 1)) / 2 - sum;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(1)

Might overflow, could use xor.

*/