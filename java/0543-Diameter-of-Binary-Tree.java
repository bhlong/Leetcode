/*

Problem Statement:

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter 
of a binary tree is the length of the longest path between any two nodes in a tree. This path 
may or may not pass through the root.

Example:

Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

*/

/*

Thought Process:

For a tree, the diameter is max(left.depth + right.depth, diameter(left), diameter(right))

*/

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return Math.max(Math.max(depth(root.left) + depth(root.right), 
        diameterOfBinaryTree(root.left)), diameterOfBinaryTree(root.right));
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right))+1;
    }
}

/*

Final thoughts:

Time complexity: O(nlog(n))
Space complexity: O()



*/