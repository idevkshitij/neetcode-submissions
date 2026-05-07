class Solution {
    public int maxArea(int[] heights) {


        //brute force
        // int maxArea = Integer.MIN_VALUE;
        // for(int firstItr = 0; firstItr < heights.length-1; firstItr++) {
        //     int area = Integer.MIN_VALUE;
        //     for(int secondItr = firstItr + 1; secondItr < heights.length; secondItr++) {
        //         area = Math.min(heights[secondItr], heights[firstItr]) * (secondItr-firstItr);
        //         System.out.println("Area : " + area);
        //         maxArea = Math.max(maxArea, area);
        //     }    
        // }

        //optimized
        //idea : 
        int left = 0, right = heights.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(left < right) {
            //compute area
            int area = Math.min(heights[left], heights[right]) * (right-left);
            maxArea = Math.max(maxArea, area);

            //update pointers
            //base case
            if(heights[left] == heights[right])
                left++;
            if(heights[left] > heights[right])
                right--;
            else
                left++;
        }

        return maxArea;
        
    }
}
