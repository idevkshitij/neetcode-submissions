class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //bruteforce
        //linear search in range (1, MAX_IN_ARRAY)
        // return bruteForceSol(piles, h);

        //optimized
        ////binary search in range (1, MAX_IN_ARRAY)
        return optimizedSol(piles, h);
    }

    public int getTotalTime(int k, int[] piles){
        int res = 0;
        for(int element : piles){
            // res = res + (int) Math.ceil((double) element/k);
            res = res + (element + k - 1) / k;
        }
        System.out.println("Total time for : " + k + " : " + res);
        return res;
    }

    public int bruteForceSol(int[] piles, int h){
        //get max
        int max = 0;
        for(int element : piles) {
            if(element > max)   max = element;
        }

        //search for each value
        int k = 0;
        for(k = 1; k <= max; k++){
            if(getTotalTime(k, piles) <= h)
                return k;
        }

        return k;

    }

    public int optimizedSol(int[] piles, int h){
        int res = 0;
        int max = 0;
        for(int element : piles){
            if(element > max) max = element;
        }
        int low = 1, high = max;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(getTotalTime(mid, piles) <= h) high = mid;
            else    low = mid + 1;
        }
        return high;
    }
}
