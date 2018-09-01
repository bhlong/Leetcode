/*

Problem Statement:

Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

/*

Thought Process:

For each element, we either include it or not include it, resurse on this.

*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        selection(nums, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void selection(int[] nums, List<List<Integer>> ans, List<Integer> temp, int curr){
        if(curr == nums.length) ans.add(new ArrayList<>(temp));
        else {
            selection(nums, ans, temp, curr+1);
            temp.add(nums[curr]);
            selection(nums, ans, temp, curr+1);
            temp.remove(temp.size()-1);
        }
    }
}

/*

Final thoughts:

Time complexity: O(2^n)
Space complexity: O(2^n)



*/