/*

Problem Statement:

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers 
(h, k), where h is the height of the person and k is the number of people in front of this person who have a 
height greater than or equal to h. Write an algorithm to reconstruct the queue.

Example:

    Input:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    Output:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

*/

/*

Thought Process:

Sort by height from highest to lowest, then position from lowest to highest. From there, we can inset each entry to a
linked list sequentially to their index value (k value).

*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ans = new LinkedList<>();
        for(int[] arr : people){
            ans.add(arr[1], arr);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

/*

Final thoughts:

Time complexity: O(nlog(n))
Space complexity: O(n)



*/