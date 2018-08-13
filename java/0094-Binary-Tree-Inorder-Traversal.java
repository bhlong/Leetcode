/*

Problem Statement:

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

    Input: [1,null,2,3]
    1
        \
        2
        /
    3

    Output: [1,3,2]

*/

/*

Thought Process:


*/

// recursive
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    private void traverse(TreeNode root, List<Integer> list){
        if(root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}


//iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null){
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            //curr is null
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)



*/