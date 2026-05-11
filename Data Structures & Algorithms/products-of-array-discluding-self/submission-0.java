class Solution {
    public int[] productExceptSelf(int[] nums) {
        //brute force soln
        return bruteForceSol(nums);
        //optimized sol1

        //optimized sol2
    }

    public int[] bruteForceSol(int[] nums){
        int[] res = new int[nums.length];
        for(int index = 0; index < nums.length; index++){
            int currIndexProduct = 1;
            for(int otherIndex = 0; otherIndex < nums.length; otherIndex++){
                if(otherIndex == index) continue;
                currIndexProduct = currIndexProduct * nums[otherIndex];
            }
            res[index] = currIndexProduct;
        }
        return res;
    }
}  
