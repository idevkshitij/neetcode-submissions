class Solution {
    public int longestConsecutive(int[] nums) {
        //bruteforce
        // return bruteforceSol(nums);

        //optimized
        return optimizedSol(nums);
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

    public int optimizedSol(int nums[]) {
        int maxStreakLen = 0;
        //use a hashset for constant time contains check
        Set<Integer> set = new HashSet<>();
        for(int element : nums){
            set.add(element);
        }

        for(int element : nums) {
            int streakLen = 1;
            //check for streak for element only if its the starting element of the streak
            if(!(set.contains(element-1))){
                while(set.contains(element + 1)){
                    streakLen++;
                    element++;
                }
                maxStreakLen = Math.max(maxStreakLen, streakLen);
            }
        }

        System.out.println(set.toString());

        return maxStreakLen;
    }
}
