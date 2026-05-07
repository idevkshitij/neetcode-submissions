class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //bruteforce
        int res[] = new int[temperatures.length];
        for(int currElement = 0; currElement < temperatures.length; currElement++){
            int nextWarmerDay = 0;
           for(int comparingElement = currElement + 1; comparingElement < temperatures.length; comparingElement++){
                if(temperatures[currElement] < temperatures[comparingElement]){
                    nextWarmerDay = comparingElement - currElement;
                    break;
                }
            }

            res[currElement] = nextWarmerDay;
        }
        return res;
    }
}
