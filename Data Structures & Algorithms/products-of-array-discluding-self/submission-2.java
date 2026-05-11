class Solution {
    public int[] productExceptSelf(int[] nums) {
        // brute force soln
        //  return bruteForceSol(nums);

        // optimized sol1
        return optimizedSol1(nums);
        // optimized sol2
    }

    public int[] bruteForceSol(int[] nums) {
        int[] res = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            int currIndexProduct = 1;
            for (int otherIndex = 0; otherIndex < nums.length; otherIndex++) {
                if (otherIndex == index)
                    continue;
                currIndexProduct = currIndexProduct * nums[otherIndex];
            }
            res[index] = currIndexProduct;
        }
        return res;
    }

    public int[] optimizedSol1(int[] nums) {
        int res[] = new int[nums.length];
        int totalProduct = 1;
        int totalZeros = 0;
        for (int element : nums) {
            if (element == 0) {
                totalZeros++;
                continue;
            }
            totalProduct = totalProduct * element;
        }
        // case 1 : more than 1 zeros
        if (totalZeros > 1) {
            return res;
        }
        for (int index = 0; index < nums.length; index++) {
            // case 2 : excatly 1 zero
            if (totalZeros == 1) {
                res[index] = (nums[index] == 0) ? totalProduct : 0;
            }
            // case 3 : no zeros
            else
                res[index] = totalProduct / nums[index];
        }

        return res;
    }
}
