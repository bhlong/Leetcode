/*

Problem Statement:


Given scores of N athletes, find their relative ranks and the people with the top three highest 
scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example:

Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver 
Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.

Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.

*/

/*

Thought Process:

Sort the array in descending order, then make a string array with their corresponding ranks. Populate 
a hashmap for score -> rank, then go throught the original array to populate a new string array.

*/

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] sorted = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++) sorted[i] = nums[i];
        Arrays.sort(sorted);
        for(int i = 0 ; i < sorted.length/2 ; i++){
            int temp = sorted[i];
            sorted[i] = sorted[sorted.length - 1 - i];
            sorted[sorted.length - 1 - i] = temp;
        }

        HashMap<Integer, String> ranks = new HashMap<>();

        for(int i = 0 ; i < sorted.length ; i++){
            String rank = Integer.toString(i+1);
            if(i == 0) rank = "Gold Medal";
            if(i == 1) rank = "Silver Medal";
            if(i == 2) rank = "Bronze Medal";
            ranks.put(sorted[i], rank);
        }
        String[] ans = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            ans[i] = ranks.get(nums[i]);
        }
        return ans;
    }
}

/*

Final thoughts:

Time complexity: O(nlog(n))
Space complexity: O(n)

Could populate an array of size (max score + 1) that maps score to index. Then iterate the array 
backwards populating the answer.

*/