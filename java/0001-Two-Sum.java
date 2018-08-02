/*

Problem Statement:

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

/*

Thought Process:

Keep track of all elements encountered in a hashmap.

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(seen.containsKey(target-nums[i])) return new int[]{i, seen.get(target-nums[i])};
            seen.put(nums[i], i);
        }
        return null;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)



*/