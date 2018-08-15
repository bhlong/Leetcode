/*

Problem Statement:

Given an array nums of n integers where n > 1,  return an array output such that output[i] is 
equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

*/

/*

Thought Process:

We go through the input array twice. During the first iteration we will populate the arr with the product
of all elements to the left of each index, then in the second iteration, we multiply each index with the 
product of the right elements.

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        int temp = 1;
        for(int i = 0 ; i < length ; i++){
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int i = length - 1 ; i >= 0 ; i--){
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)



*/