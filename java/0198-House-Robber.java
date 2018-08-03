/*

Problem Statement:

You are a professional robber planning to rob houses along a street. Each house has a 
certain amount of money stashed, the only constraint stopping you from robbing each of 
them is that adjacent houses have security system connected and it will automatically 
contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Example:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.

*/

/*

Thought Process:

For house at index n, you either rob it or you don't. If you rob it, then the max profit so far will be
the value at house n and rob(n-2); if you don't rob it, then the max profit so far will be rob(n-1)


*/

class Solution {
    public int rob(int[] nums) {
        int robPrev = 0;
        int noRobPrev = 0;

        for(int i : nums){
            int temp = robPrev;
            robPrev = noRobPrev + i;
            noRobPrev = Math.max(temp, noRobPrev);
        }
        return Math.max(robPrev, noRobPrev);
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()



*/