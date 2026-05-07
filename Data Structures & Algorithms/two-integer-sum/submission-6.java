class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                int firstIndex = (int) hm.get(target - nums[i]);
                int secondIndex = i;
                return new int[]{firstIndex, secondIndex};
            } else {
                hm.put(nums[i], i);
            }

        }

        return new int[]{};

}
}
