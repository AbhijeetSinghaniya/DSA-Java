class FindSumPairs {
    private int[] arr1, arr2;
    Map<Integer, Integer> mp = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1 = nums1;
        arr2 = nums2;

        // keeping arr2 because its length is bigger than arr1
        for(int x : arr2) mp.put(x, mp.getOrDefault(x, 0) + 1);
    }
    
    public void add(int index, int val) {
        mp.put(arr2[index], mp.get(arr2[index]) - 1);

        arr2[index] += val;
        mp.put(arr2[index], mp.getOrDefault(arr2[index], 0) + 1);
    }
    
    public int count(int total) {
        int count = 0;
        for(int x : arr1) {
            count += mp.getOrDefault(total - x, 0);
        }
        return count;
    }
}
