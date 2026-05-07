class Solution {

    public void generateSubsets(List<List<Integer>> resList, List<Integer> list, int index, int[] nums){
        //base case
        if(index >= nums.length) {
            System.out.println(list.toString());
            List<Integer> singleSubset = new ArrayList<>(list);
            resList.add(singleSubset);
            return;
        }

        //inculde the element
        list.add(nums[index]);
        System.out.println("added : " + list.toString());
        generateSubsets(resList, list, index + 1, nums);

        //discard the element
        list.remove(list.size()-1);
        System.out.println("removed : " + list.toString());
        generateSubsets(resList, list, index + 1, nums);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        generateSubsets(resList, list, 0, nums);
        System.out.println(resList.toString());

        return resList;
    }
}
