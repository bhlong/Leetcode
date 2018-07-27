/*

Problem Statement:

Consider all the leaves of a binary tree.  From left to right order, the values of those 
leaves form a leaf value sequence.

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example:



*/

/*

Thought Process:
We make a helper that returns the leaf sequence in an arraylist, then compare the result of 
passing in root1 and root2.


*/

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        leafs(root1, list1);        
        ArrayList<Integer> list2 = new ArrayList<>();
        leafs(root2, list2);

        if(list1.size() != list2.size()) return false;

        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
    }

    private void leafs(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        if(root.left != null) {
            leafs(root.left, list);
        }
        if(root.right != null) {
            leafs(root.right, list);
        }
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)

Could utilize the ArrayList.equals() built-in method to improve readability.

*/