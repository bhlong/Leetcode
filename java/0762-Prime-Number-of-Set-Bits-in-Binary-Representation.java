/*

Problem Statement:

Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a 
prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in 
binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

Example:

    Input: L = 6, R = 10
    Output: 4
    Explanation:
    6 -> 110 (2 set bits, 2 is prime)
    7 -> 111 (3 set bits, 3 is prime)
    9 -> 1001 (2 set bits , 2 is prime)
    10->1010 (2 set bits , 2 is prime)

*/

/*

Thought Process:

Use bitcount to get number of 1s, then use a prime checker.

*/

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i = L; i <= R; i++){
            if(isPrime(Integer.bitCount(i))) count++;
        }
        return count;
    }

    private boolean isPrime(int n){
        if(n > 2 && n%2==0) return false;
        for(int i = 3; i*i <= n; i+=2){
            if(n%i == 0) return false;
        }
        return n > 1;
    }
}

/*

Final thoughts:

Time complexity: O(R-L)
Space complexity: O()

Can limit the possible primes due to constraint on input, also:
665772

*/