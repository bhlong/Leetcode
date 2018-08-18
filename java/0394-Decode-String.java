/*

Problem Statement:

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are 
well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are 
only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Example:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/

/*

Thought Process:

Brute force.

*/

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int digitStart = i;
                while(Character.isDigit(s.charAt(i))) i++;
                int counter = Integer.parseInt(s.substring(digitStart, i));
                int start = i + 1;
                i += 1;
                int open = 1;
                int close = 0;
                while(close < open) {
                    char h = s.charAt(i);
                    if(h == '[') open ++;
                    else if(h == ']') close++;
                    i++;
                }
                i--;
                String str = decodeString(s.substring(start, i));
                while(counter-- > 0){
                    sb.append(str);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()



*/