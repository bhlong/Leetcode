/*

Problem Statement:

Given a collection of distinct integers, return all possible permutations.


Example:

    Input: [1,2,3]
    Output:
    [
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
    ]

*/

/*

Thought Process:

Use backtracking to get all possible permutations.

*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), new HashSet<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, Set<Integer> tempSet, int[] nums){
        if(temp.size() == nums.length) list.add(new ArrayList<>(temp));
        else {
            for(int i = 0 ; i < nums.length ; i++){
                if(tempSet.contains(nums[i])) continue;
                tempSet.add(nums[i]);
                temp.add(nums[i]);
                backtrack(list, temp, tempSet, nums);
                tempSet.remove(temp.get(temp.size()-1));
                temp.remove(temp.size()-1);
            }
        }
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()



*/