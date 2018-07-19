/*

Problem Statement:

Given a non-empty array of non-negative integers nums, the degree of this array is 
defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, 
that has the same degree as nums.

Example:

Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

*/

/*

Thought Process:

Using a hashmap, map the element to [frequency, starting index, ending index].
Then, iterate through the max frequency rows and get shortest subarray length.

*/

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> info = new HashMap<>();

        int degree = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i];
            if(!info.containsKey(num)){
                info.put(num, new int[]{1, i, i});
            } else {
                int[] record = info.get(num);
                info.put(num, new int[]{record[0]+1, record[1], i});
            }

            if(info.get(num)[0] > degree){
                degree = info.get(num)[0];
            }
        }

        int shortestLength = Integer.MAX_VALUE;
        for(int i : info.keySet()){
            int[] record = info.get(i);
            if(record[0] == degree){
                int length = record[2] - record[1];
                if(length < shortestLength){
                    shortestLength = length;
                }
            }
        }
        return shortestLength + 1;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)

Could make an object to replace the array for each element.

*/