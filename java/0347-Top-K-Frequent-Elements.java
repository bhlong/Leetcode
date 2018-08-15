/*

Problem Statement:

Given a non-empty array of integers, return the k most frequent elements.

Example:

    Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:

    Input: nums = [1], k = 1
    Output: [1]

*/

/*

Thought Process:

We first populate a frequency map, then create a bucket (an array of arraylists) of size n+1 where n
is the length of the input. Then we can loop through the bucket and find the K elements.

*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0) return list;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);

        List<Integer>[] bucket = new ArrayList[nums.length+1];

        for(int key : freq.keySet()){
            int occurrance = freq.get(key);
            if(bucket[occurrance] == null) bucket[occurrance] = new ArrayList<>();
            bucket[occurrance].add(key);
        }

        for (int pos = bucket.length - 1; pos >= 0 && list.size() < k; pos--) {
            if (bucket[pos] != null) {
                list.addAll(bucket[pos]);
            }
	    }
        return list.subList(0, k);
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(n)



*/