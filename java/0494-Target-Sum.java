/*

Problem Statement:

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 
2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.

Example:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

*/

/*

Thought Process:

1. For each element, we either add or subtract it, recurse on each scenario.
2. We create an array to store the number of ways we can create a certain sum, index being the sum,
   we have the array of size s*2+1, s being the sum of all numbers. *2 because we have to account
   for negative numbers, +1 because we could also have 0.
   Then we loop through each element, for each element, loop through all the sums to update the array.

*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return countSum(nums, S, 0, 0);
    }

    private int countSum(int[] nums, int target, int curr, int temp){
        if(curr == nums.length){
            if(temp == target) return 1;
            else return 0;
        }
        return countSum(nums, target, curr+1, temp + nums[curr]) + 
               countSum(nums, target, curr+1, temp - nums[curr]);
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(S > sum || S < -sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[sum+0] = 1;

        for(int i = 0 ; i < nums.length ; i++){
            int[] next = new int[2*sum+1];
            for(int j = 0 ; j < 2*sum+1 ; j++){
                if(dp[j] != 0){
                    next[j+nums[i]] += dp[j];
                    next[j-nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[sum+S];
    }
}

/*

Final thoughts:

1)
Time complexity: O(2^n)
Space complexity: O(n)

2)
Time complexity: O(n*sum)
Space complexity: O(sum)



*/