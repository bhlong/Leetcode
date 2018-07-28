/*

Problem Statement:

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes 
have the same value.

Example:

    Input:     1         1
            / \       / \
            2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true

    Input:     1         1
            / \       / \
            2   1     1   2

            [1,2,1],   [1,1,2]

    Output: false


*/

/*

Thought Process:

DFS

*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return q==p;
        Stack<TreeNode> s1 = new Stack<>(); s1.push(p);
        Stack<TreeNode> s2 = new Stack<>(); s2.push(q);

        while(!s1.isEmpty()){
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();

            if(node1.val != node2.val) return false;
            if(node1.left == null ^ node2.left == null) return false;
            if(node1.right == null ^ node2.right == null) return false;
            if(node1.right != null) s1.push(node1.right);
            if(node1.left != null) s1.push(node1.left);
            if(node2.right != null) s2.push(node2.right);
            if(node2.left != null) s2.push(node2.left);
        }

        return true;
    }
}

/*

Final thoughts:

Time complexity: O(min(p.size(),q.size()))
Space complexity: O(n)



*/