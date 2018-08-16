/*

Problem Statement:

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, 
level by level).


Example:

    Given binary tree [3,9,20,null,null,15,7],
        3
    / \
    9  20
        /  \
    15   7
    return its level order traversal as:
    [
    [3],
    [9,20],
    [15,7]
    ]

*/

/*

Thought Process:

We traverse through each level by using a queue. 

*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int queueSize = q.size();
            for(int i = 0 ; i < queueSize ; i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ret.add(temp);
        }
        return ret;
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()



*/