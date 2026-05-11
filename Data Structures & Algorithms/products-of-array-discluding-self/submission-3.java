class Solution {
    public int[] productExceptSelf(int[] nums) {
        // brute force soln
        //  return bruteForceSol(nums);

        // optimized sol1
        // return optimizedSol1(nums);
        // optimized sol3
        return optimizedSol3(nums);
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
        // TC : O(n) but division is not allowed
        // SC : O(n)
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

    public int[] optimizedSol3(int[] nums) {
        // use prefix and suffix arrays
        // TC : O(n)
        // SC : O(3n)    //make it O(n) later
        int res[] = new int[nums.length];
        int totalZeros = 0;
        int prefix[] = new int[nums.length];
        int suffix[] = new int[nums.length];
        int localProduct = 1;
        for (int index = 0; index < nums.length; index++) {
            localProduct =  nums[index] * localProduct;
            prefix[index] = localProduct;
        }

        localProduct = 1;
        for (int index = nums.length - 1; index >= 0; index--) {
            localProduct = nums[index] * localProduct;
            suffix[index] = localProduct;
        }

        //print both arrays
        //prefix
        for(int element : prefix){
            System.out.print(" " + element);
        }
        System.out.println("");
        //suffix
        for(int element : suffix){
            System.out.print(" " + element);
        }

        //final res
        int first = 0, second = 0;
        for(int index = 0; index < nums.length; index++){
            
            if(index == 0)  first = 1;
            else first = prefix[index-1];   
            
            if(index == nums.length-1) second = 1;
            else second = suffix[index+1];

            res[index] = first * second;
        }
        return res;
    }
}
