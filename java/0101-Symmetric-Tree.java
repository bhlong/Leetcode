/*

Problem Statement:

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example:

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3

*/

/*

Thought Process:

Revursive:

isSymmetric(root) = isMirror(root.left, root.right).
isMirror(left, right) = (left.val == right.val) && (isMirror(left.left, right.right) && isMirror(left.right, right.left)) 


Iterative:

We use a queue to compare the mirror nodes.

*/


// Recursive
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == null && right == null;
        return (left.val == right.val) && (isMirror(left.left, right.right) && isMirror(left.right, right.left));
    }
}

//Iterative

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left); 
        }
        return true;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)



*/