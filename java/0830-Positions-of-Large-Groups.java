/*

Problem Statement:

In a string S of lowercase letters, these letters form consecutive groups of the same character.
For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
Call a group large if it has 3 or more characters.  We would like the starting and ending positions 
of every large group.
The final answer should be in lexicographic order.

Example:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]

*/

/*

Thought Process:

Brute force.

*/

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        if(S.equals("") || S == null) return ans;

        int start = 0;
        int end = 0;
        int counter = 0;
        char prev = S.charAt(0);
        int index = 0;

        for(char c : S.toCharArray()){
            if(c == prev){
                counter++;
            } else {
                if(counter >= 3){
                    List<Integer> list = Arrays.asList(start, index-1);
                    ans.add(list);
                }
                start = index;
                counter = 1;
                prev = c;
            }
            index++;
        }

        if(counter >= 3){
            List<Integer> list = Arrays.asList(start, index-1);
            ans.add(list);
        }
        return ans;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)

Could have cleaner code by maintaining two pointers for start and end, have a while loop to
update end pointer until it's different than start, then add only if end - start >= 3 and set 
start = end.

*/