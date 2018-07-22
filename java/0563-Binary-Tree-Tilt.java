/*

Problem Statement:

Given a binary tree, return the tilt of the whole tree.
The tilt of a tree node is defined as the absolute difference between the sum of all left 
subtree node values and the sum of all right subtree node values. Null node has tilt 0.
The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:

    Input: 
            1
          /   \
        2     3
    Output: 1
    Explanation: 
    Tilt of node 2 : 0
    Tilt of node 3 : 0
    Tilt of node 1 : |2-3| = 1
    Tilt of binary tree : 0 + 0 + 1 = 1

*/

/*

Thought Process:

We approach this question recursively by calling a helper function. The helper function does a
post order traversal, adding tilt of each node in the process and return the sum of the node.

*/

class Solution {
    int sum = 0;
    
    public int findTilt(TreeNode root) {
        findSum(root);
        return sum;
    }
    private int findSum(TreeNode root){
        if(root == null) return 0;
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        int difference = Math.abs(leftSum - rightSum);
        sum+=difference;
        return leftSum + rightSum + root.val;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(log(n))

If we don't want global variables, we could pass in an integer array of size 1

*/