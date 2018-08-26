/*

Problem Statement:

Given a string, find the length of the longest substring without repeating characters.

Example:

    Example 1:

    Input: "abcabcbb"
    Output: 3 
    Explanation: The answer is "abc", which the length is 3.

    Example 2:

    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:

    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3. 
                Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

/*

Thought Process:

We approach the problem with the sliding window technique. We use an integer array to keep track of 
repeatition, when an entry of the array has a negative value, it means there is a repeating letter in
the current substring. When that happens, we increment start until the repeating letter is no longer 
repeating.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        for(int i = 0; i < 128 ; i++){
            freq[i] = 1;
        }
        int start = 0, end = 0, longest = 1;
        boolean dup = false;

        while(end < s.length()){
            if(freq[s.charAt(end++)]-- == 0) dup = true;
            
            while(dup){
                if(freq[s.charAt(start++)]++ == -1) dup = false;
            }
            
            int length = end - start;
            if(length > longest) longest = length;
        }
        return longest;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(1)

Could use a hashmap to map char to its index to skip ahead.

*/