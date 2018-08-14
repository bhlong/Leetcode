/*

Problem Statement:

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example:

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

/*

Thought Process:

We create a helper method which takes in the list, current state, number of left paren and number right paren. If number of
left paren is greater than 0, we also have a recursive case for that. If number of right paren is bigger than number of
left paren, we also have a recursive case for that. Add to list when both numbers are 0.

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(n, n, "", list);
        return list;
    }

    private void generateParenthesis(int left, int right, String curr, List<String> list){
        if(left == 0 && right == 0) {
            list.add(curr);
            return;
        }
        if(left != 0){
            generateParenthesis(left-1, right, curr + "(", list);
        } 
        if(right > left){
            generateParenthesis(left, right-1, curr + ")", list);
        }
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()



*/