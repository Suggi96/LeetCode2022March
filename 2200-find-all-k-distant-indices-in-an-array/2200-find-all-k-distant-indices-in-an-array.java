class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> jindex = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(key==nums[i]);
            jindex.add(i);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            for(int j: jindex) {
                if(Math.abs(i-j)<=k && nums[j]==key) {
                    set.add(i);
                }
            }
        }
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}