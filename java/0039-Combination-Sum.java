/*

Problem Statement:

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example:

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

*/

/*

Thought Process:

Backtrack. Exit condition is when sum is greater than target.

*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void combinationSum(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start){
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start ; i < candidates.length ; i++){
            int num = candidates[i];
            if(num > target) return;
            temp.add(num);
            combinationSum(res, temp, candidates, target - num, i);
            temp.remove(temp.size()-1);
        }
    }
}

/*

Final thoughts:

Time complexity: O(n^n)
Space complexity: O()



*/