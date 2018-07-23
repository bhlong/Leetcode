/*

Problem Statement:

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, 
return -1.


Example:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

*/

/*

Thought Process:

Populate a hashmap that maps char to its frequency, then find the first char that maps to 1.

*/

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int index = 0;
        for(char c : s.toCharArray()){
            if(freq.get(c) == 1) return index;
            index++;
        }
        return -1;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)

Could use an array to store frequency as the question only considers lower case letters.

*/