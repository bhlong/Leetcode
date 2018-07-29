/*

Problem Statement:

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example:

    Input: 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

*/

/*

Thought Process:

We use a recursive approach. Base case n = 1 -> 1, n = 2 -> 2. Recursive step: n -> fn(n-1) + fn(n-2).
We also use a hashmap to store previously calculated values.

*/

class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<Integer, Integer>());
    }

    private int climbStairs(int n, HashMap<Integer, Integer> hm){
        if(n <= 2) return n;
        if(hm.containsKey(n)) return hm.get(n);
        int nMinusOne = climbStairs(n-1, hm);
        int nMinusTwo = climbStairs(n-2, hm);
        hm.put(n, nMinusOne+nMinusTwo);
        return nMinusOne+nMinusTwo;
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()

This is fibonacci!

*/