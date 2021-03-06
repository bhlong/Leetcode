/*

Problem Statement:

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?


Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

/*

Thought Process:

The the number unique BST can be calculated recursively. We first see how many BSTs there are with 0 nodes on
the left side and n-1 nodes on the right side, then 1 node on the left and n-2 nodes on the right...
And the number of BSTs with x nodes on the left side and y nodes on the right side can be calculated
recursively to be fn(x) * fn(y)

*/

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i <= n ; i++){
            for(int j = 0 ; j < i ; j++){
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}

/*

Final thoughts:

Time complexity: O(n^2)
Space complexity: O(n)



*/