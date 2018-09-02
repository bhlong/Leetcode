/*

Problem Statement:

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
find the duplicate one.

Example:

    Example 1:

    Input: [1,3,4,2,2]
    Output: 2

    Example 2:

    Input: [3,1,3,4,2]
    Output: 3

*/

/*

Thought Process:

The array forms an infinite loop somewhere, where we can utilize the turtle and hare technique.

*/

class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];

        while(fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(1)



*/