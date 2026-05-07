class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        boolean ans = true;
        int arr[] = new int[26];
        int i = 0;
        
        //hashing count of each character in String
        while(i < t.length()) {
            arr[s.charAt(i) - 97]++;
            arr[t.charAt(i) - 97]--;
            i++;
        }

        for(int p : arr) if(p != 0) return false;

        return ans;

    }
}
