/*

Problem Statement:

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach 
the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Example:

    Example 1:

    Input: m = 3, n = 2
    Output: 3
    Explanation:
    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Right -> Down
    2. Right -> Down -> Right
    3. Down -> Right -> Right

    Example 2:

    Input: m = 7, n = 3
    Output: 28

*/

/*

Thought Process:

We create an auxilary array of size m x n. And we populate each element by using the sum of its left and
top element.

*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] aux = new int[n][m];
        for(int i = 0 ; i < m ; i++) aux[0][i] = 1;
        for(int i = 0 ; i < n ; i++) aux[i][0] = 1;
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                aux[i][j] = aux[i-1][j] + aux[i][j-1];
            }
        }
        return aux[n-1][m-1];
    }
}

/*

Final thoughts:

Time complexity: O(mn)
Space complexity: O(mn)



*/