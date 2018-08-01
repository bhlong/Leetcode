/*

Problem Statement:

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with 
a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could 
also be considered as a subtree of itself.

Example:

    Given tree s:

         3
        / \
       4   5
      / \
     1   2
    Given tree t:
      4 
     / \
    1   2

    Return true, because t has the same structure and node values with a subtree of s.

    Given tree s:

         3
        / \
       4   5
      / \
     1   2
        /
       0
    Given tree t:
       4
      / \
     1   2
    Return false.

*/

/*

Thought Process:

We implement a helper function isSame(t1, t2) to check if two trees are the same. Then, using this helper, we could solve the problem
recursively. If t == null, return true. Base case: if s == null, return false. Recursive step: return isSame(s,t) || isSubtree(s.left, t) 
|| isSubtree(s.right, t).

*/

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null) return true;
        if(s == null) return false;
        return isSame(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t){
        if(s == null || t == null) return s==null && t==null;
        return s.val === t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()



*/