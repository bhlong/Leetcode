/*

Problem Statement:

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example:

    Example 1:

    Input: "()"
    Output: true
    Example 2:

    Input: "()[]{}"
    Output: true
    Example 3:

    Input: "(]"
    Output: false
    Example 4:

    Input: "([)]"
    Output: false
    Example 5:

    Input: "{[]}"
    Output: true

*/

/*

Thought Process:

Use a stack. Push if open paren, pop and match if close.

*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> parens = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                parens.push(c);
            } else {
                if(parens.isEmpty()) return false;
                char open = parens.pop();
                if(c == ')' && open != '(') return false; 
                if(c == '}' && open != '{') return false; 
                if(c == ']' && open != '[') return false; 
            }
        }
        return parens.isEmpty();
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)



*/