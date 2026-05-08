class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findAllCombinations(0, nums, target, new ArrayList<>(), ans);
        return ans;
    }

    public void findAllCombinations(int index, int[] nums, int target, List<Integer> ds, List<List<Integer>> ans){
        //base case
        if(index == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(nums[index] <= target){
            ds.add(nums[index]);
            findAllCombinations(index, nums, target-nums[index], ds, ans);
            ds.remove(ds.size()-1);
        }
        findAllCombinations(index+1, nums, target, ds, ans);
    }
}
