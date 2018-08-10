/*

Problem Statement:

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be 
larger than 20,100.

The order of output does not matter.

Example:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

*/

/*

Thought Process:

First idea: brute force. (TLE)
Second idea: sliding window.

*/

// brute force
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : p.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < s.length()-p.length()+1 ; i++){
            char c = s.charAt(i);
            if(freq.containsKey(c) && isAnagram(new HashMap<Character, Integer>(freq), 
                s.substring(i, i+p.length()))) ans.add(i);
        }
        return ans;
    }

    private boolean isAnagram(HashMap<Character, Integer> freq, String s){
        for(char c : s.toCharArray()){
            if(!freq.containsKey(c)) return false;
            freq.put(c, freq.get(c)-1);
            if(freq.get(c) < 0) return false;
        }
        return true;
    }
}

// sliding window 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s == null || p == null || s.length() == 0 || p.length() == 0) return ans;

        int[] hash = new int[256];
        for(char c : p.toCharArray()){
            hash[c]++;
        }

        int left = 0, right = 0, counter = p.length(); 

        while(right < s.length()){
            if(hash[s.charAt(right++)]-- >= 1) counter--;
            if(counter == 0){
                ans.add(left);
            }
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0) counter++;
        }
        return ans;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)



*/

