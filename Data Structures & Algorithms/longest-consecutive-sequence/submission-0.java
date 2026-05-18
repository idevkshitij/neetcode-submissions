class Solution {
    public int longestConsecutive(int[] nums) {
        //bruteforce
        return bruteforceSol(nums);

        //optimized
        // return optimizedSol(nums);
    }

    public int bruteforceSol(int[] nums) {
        int maxStreakLen = 0;
        for(int index = 0; index < nums.length; index++){
            int streakLen = 1;
            int currNum = nums[index];

            while(containsElement(currNum + 1, nums)){
                streakLen++;
                currNum++;
            }
            maxStreakLen = Math.max(maxStreakLen, streakLen);
        }


        return maxStreakLen;
    }

    public boolean containsElement(int element, int[] nums){
        for(int item : nums){
            if(item == element) return true;
        }

        return false;
    }
}
