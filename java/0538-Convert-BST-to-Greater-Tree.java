/*

Problem Statement:

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the 
original BST is changed to the original key plus sum of all keys greater than the original
key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

*/

/*

Thought Process:

We populate a sorted arraylist from the tree. Then, we create a hashmap which maps a key
from the tree to sum of all keys greater than it. We create the hashmap by traversing
through the array backwards, hm(arr[i]) = hm(arr[i]) + hm(arr[i+1]) 

*/

class Solution {

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        ArrayList<Integer> keysSorted = new ArrayList<>();
        sortTree(root, keysSorted);

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(keysSorted.get(keysSorted.size()-1), keysSorted.get(keysSorted.size()-1));

        for(int i = keysSorted.size() - 2 ; i >= 0 ; i--){
            hm.put(keysSorted.get(i), keysSorted.get(i) + hm.get(keysSorted.get(i+1)));
        }

        changeValue(root, hm);
        return root;
    }

    private void changeValue(TreeNode root, HashMap<Integer, Integer> hm){
        if(root == null) return;
        root.val = hm.get(root.val);
        changeValue(root.left, hm);
        changeValue(root.right, hm);
    }

    private void sortTree(TreeNode root, ArrayList<Integer> keysSorted){
        if(root == null) return;
        sortTree(root.left, keysSorted);
        keysSorted.add(root.val);
        sortTree(root.right, keysSorted);
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)

Could have just traversed the tree postorder while keeping a sum and modify every node value.

Could also apply Reverse Morris In-order Traversal, Space complexity becomes O(1)

*/