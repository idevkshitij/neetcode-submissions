class Solution {
    public boolean hasDuplicate(int[] nums) {

        //bruteforce sol
        //O(n^2)
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = i+1; j < nums.length; j++){
        //         if(nums[i] == nums[j]) return true;
        //     }
        // }

        //O(n)
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if(set.size() == nums.length) return false;
        else return true;

        

        // return false;
 
    }
}
