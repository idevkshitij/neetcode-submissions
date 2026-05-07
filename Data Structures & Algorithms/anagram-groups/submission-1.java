class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> inputList = new ArrayList<String>();
        List<String> tempList = null;
        List<List<String>> outputList = new ArrayList<List<String>>();

        //add list entires to inputList to check from in future and remove if selected
        for(String s : strs) {
            inputList.add(s);
            // System.out.println(s);
        }

        if(strs.length == 0)
            return outputList;
        if(strs.length == 1) {
            outputList.add(inputList);
            return outputList;   
        }

        System.out.println(inputList);

        //check each string with everyother remaining string in the inputList
        //if they are anagram of each other
        // Iterator<String> itr = new inputList.iterator();
        for(int i = 0; i < inputList.size(); ) {

            
            // boolean atleastOnePairFound = false;
            tempList = new ArrayList<String>();
            tempList.add(inputList.get(i));

            for(int j = i+1; j < inputList.size(); ) {
                //check if i & j are anagram
                if(isAnagram(inputList.get(i), inputList.get(j))) {
                    //add to temp and remove from input
                    tempList.add(inputList.get(j));
                    inputList.remove(j);
                    // atleastOnePairFound(true);
                } 
                else {
                    j++;
                }
            }
            
            //remove initial checking element
            inputList.remove(i);

            //add final tempList to outputList
            outputList.add(tempList);
        }

        return outputList;
    }

    
    boolean isAnagram(String input1, String input2){
        boolean res = false;

        System.out.println(input1 + " " + input2);
        
        //base case
        if(input1.length() != input2.length())
            return res;
        
        
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        char char1[] = input1.toCharArray();
        char char2[] = input2.toCharArray();

        //putting input1 chars to hashmap
        for(char c : char1) {
            map1.put(c, map1.get(c)!= null? map1.get(c) + 1 : 1);
        }

        //putting input2 chars to hashmap
        for(char c : char2) {
            map2.put(c, map2.get(c)!= null? map2.get(c) + 1 : 1);
        }

        for(char c : char1) {
            if(!map1.get(c).equals(map2.get(c))){
                return res;
            }
        }

        System.out.println(map1);
        System.out.println(map2);
        res = true;
        return res;
    }
}
