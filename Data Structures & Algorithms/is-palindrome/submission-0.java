class Solution {
    public boolean isPalindrome(String s) {

        boolean isPalindrome = false;

        String cleanStr = s.trim().replaceAll(" +", "").replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        int start = 0;
        int end = cleanStr.length()-1;

        System.out.println(end);

        while(start < end) {
            if(cleanStr.charAt(start) == cleanStr.charAt(end)) {
                start++;
                end--;
            }
            else {
                return isPalindrome;
            }
        }

        isPalindrome = true;

        System.out.println(cleanStr);


        return isPalindrome;
        
    }
}
