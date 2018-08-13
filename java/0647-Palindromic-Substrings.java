/*

Problem Statement:

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of 
same characters.

Example:

    Example 1:
    Input: "abc"
    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".

    Example 2:
    Input: "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

*/

/*

Thought Process:

We solve recursively. If empty string, return 0. If length == 1, return 1; if length == 2, return 2 + [1]==[2].
If length > 2, return fn(sub(0, n-1)) + fn(1, n-1)

*/

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        if(n == 1) return 1;
        int sum = 0;
        if(s.charAt(0) == s.charAt(n-1)) sum++;
        return sum + countSubstrings(s.substring(1, n)) + countSubstrings(s.substring(0, n-1)) - countSubstrings(s.substring(1,n-1));
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()



*/