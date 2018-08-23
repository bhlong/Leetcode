/*

Problem Statement:



Example:



*/

/*

Thought Process:



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
                if(freq[s.charAt(start++)]++ > -1) dup = false;
            }
            
            if(!dup){
                System.out.println(s.substring(start, end-1));
                int length = end - start - 1;
                if(length > longest) longest = length;
            }
        }
        return longest;
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()



*/