class Solution {
    public int maxArea(int[] heights) {

        int maxArea = Integer.MIN_VALUE;

        //brute force
        for(int firstItr = 0; firstItr < heights.length-1; firstItr++) {
            int area = Integer.MIN_VALUE;
            for(int secondItr = firstItr + 1; secondItr < heights.length; secondItr++) {
                area = Math.min(heights[secondItr], heights[firstItr]) * (secondItr-firstItr);
                System.out.println("Area : " + area);
                maxArea = Math.max(maxArea, area);
            }    
        }

        return maxArea;
        
    }
}
