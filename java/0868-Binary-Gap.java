/*

Problem Statement:

Given a positive integer N, find and return the longest distance between two consecutive 1's in 
the binary representation of N.

If there aren't two consecutive 1's, return 0.

Example:

    Input: 22
    Output: 2
    Explanation: 
    22 in binary is 0b10110.
    In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
    The first consecutive pair of 1's have distance 2.
    The second consecutive pair of 1's have distance 1.
    The answer is the largest of these two distances, which is 2.

*/

/*

Thought Process:

Brute force.

*/

class Solution {
    public int binaryGap(int N) {
        int maxLength = 0;
        int length = 0;
        boolean seenOne = false;

        while(N > 0){
            int mod = N % 2;
            if(mod == 0 && seenOne){
                length++;
            } else if (mod == 1 && !seenOne){
                seenOne = true;
            } else if (mod == 1){
                length++;
                if(length > maxLength){
                    maxLength = length;
                }
                length = 0;
            }
            N /= 2;
        }
        return maxLength;
    }
}

/*

Final thoughts:

Time complexity: O(log(n))
Space complexity: O(1)



*/