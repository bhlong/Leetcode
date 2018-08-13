/*

Problem Statement:

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate 
the number of 1's in their binary representation and return them as an array.

Example:

    Example 1:

    Input: 2
    Output: [0,1,1]
    Example 2:

    Input: 5
    Output: [0,1,1,2,1,2]

*/

/*

Thought Process:

We build the array using values we've built previously. Every number will refer to the number made by 
dropping the least significant bit. For example, 1010 and 1011 will refer to 101, and their respective
value will be ans[101] and ans[101]+1.

*/

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        if(num == 0) return ans;
        ans[1] = 1;
        if(num == 1) return ans;
        int referenceIndex = 1;
        int i = 2;

        while(i <= num){
            ans[i] = ans[referenceIndex];
            if(i + 1 <= num) ans[i+1] = ans[referenceIndex]+1;
            referenceIndex++;
            i+=2;
        }
        return ans;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)



*/