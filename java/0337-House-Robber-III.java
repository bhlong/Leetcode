/*

Problem Statement:

The thief has found himself a new place for his thievery again. There is only one entrance to 
this area, called the "root." Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree". It 
will automatically contact the police if two directly-linked houses were broken into on the same 
night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example:

    Example 1:

    Input: [3,2,3,null,3,null,1]

         3
        / \
       2   3
        \   \ 
        3   1

    Output: 7 
    Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
    Example 2:

    Input: [3,4,5,1,3,null,1]

        3
       / \
      4   5
     / \   \ 
    1   3   1

    Output: 9
    Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

*/

/*

Thought Process:

1)
From the root, the thief has two choices
1. steal current house
Then max will be value of curr + rob(2 left children 2 levels deep) + rob(2 right children 2 levels deep)
2. skip current house
Then max will be Math.max(left child, right child)

2)
robSub returns an int array instead, element at index 0 stores max value from stealing the house,
while element at index 1 stores max value from not stealing the house.
*/

//1)
class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        //                                     steal                                        skip
        return Math.max( root.val + robStoleLast(root.left) + robStoleLast(root.right) , rob(root.left) + rob(root.right) );
    }

    private int robStoleLast(TreeNode root){
        if(root == null) return 0;
        return rob(root.left) + rob(root.right);
    }
}

//2)
class Solution {
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root){
        int[] ans = new int[2];
        if(root == null) return ans;

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        ans[0] = root.val + left[1] + right[1];
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return ans;
    }
}

/*

Final thoughts:

2)
Time complexity: O(n)
Space complexity: O(1)



*/