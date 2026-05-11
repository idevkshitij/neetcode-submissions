class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        List<Integer>[] freqAsIndex = new ArrayList[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int element : nums) {
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
        }

        for (int index = 1; index < freqAsIndex.length; index++) {
            freqAsIndex[index] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> mapElement : freqMap.entrySet()) {
            int index = mapElement.getValue();
            int value = mapElement.getKey();
            freqAsIndex[index].add(value);
        }

        for (int index = 1; index < freqAsIndex.length; index++) {
            System.out.println("index : " + index + " value : " + freqAsIndex[index].toString());
        }

        int indexOfRes = 0;
        for (int index = freqAsIndex.length - 1; index > 0; index--) {
            System.out.println(freqAsIndex[index].toString());
            for (int elementInList : freqAsIndex[index]) {
                res[indexOfRes++] = elementInList;
                if (indexOfRes == k)
                    return res;
            }
        }

        // System.out.println(freqMap.toString());
        return res;
    }
}
