/*

Problem Statement:

Given an array of integers and an integer k, you need to find the total number of continuous subarrays 
whose sum equals to k.


Example:

Input:nums = [1,1,1], k = 2
Output: 2

*/

/*

Thought Process:

1. Brute force. Loop through all possible starting points.
2. Use a hashmap to map sum -> occurence, where sum is accumulated sum at points before the current
   point.
   
*/

// 1 
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int total = 0;
            for(int j = i ; j < nums.length ; j++){
                total += nums[j];
                if(total == k) count++;
            }
        }
        return count;
    }
}


// 2
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            if(preSum.containsKey(sum-k)) count += preSum.get(sum-k);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

/*

Final thoughts:

1.
Time complexity: O(n^2)
Space complexity: O(1)

2.
Time complexity: O(n)
Space complexity: O(n)

*/