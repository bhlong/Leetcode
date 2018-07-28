/*

Problem Statement:

Given an array of size n, find the majority element. The majority element is the element that 
appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example:

Input: [3,2,3]
Output: 3

Input: [2,2,1,1,1,2,2]
Output: 2

*/

/*

Thought Process:

Store num->frequency in a hashmap, then find the num with the most frequency.

*/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            if(freq.get(i) > nums.length/2) return i;
        }
        return 0;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)

Could use boyer-moore majority vote algorithm to solve it in constant space.

*/