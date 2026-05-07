class Solution {
    public boolean isValid(String s) {

        boolean res = false;
        Stack<String> stack = new Stack<String>();
        String[] sArr = s.split("");

        //mapping each parentheses
        Map<String, String> hm = new HashMap<String, String>();
        hm.put("]", "[");
        hm.put(")", "(");
        hm.put("}", "{");

        for(String p : sArr){
            // System.out.println(p);  
            if(hm.containsKey(p)){
                String value = hm.get(p);
                System.out.println(stack);

                if( !(stack.empty()) && value.equals(stack.peek()) ){
                    stack.pop();
                }
                else{
                    stack.push(p);
                }
                
            } else {
                stack.push(p);
            }   
        }

        res = stack.empty();
        // System.out.println(stack.isEmpty());
        return res;
        
    }
}
