class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i: nums1)
            set1.add(i);
        Set<Integer> set2 = new HashSet<>();
        for(int i: nums2)
            set2.add(i);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i: set1) {
            if(!set2.contains(i)) {
                temp.add(i);
            }
        }
        ans.add(new ArrayList<>(temp));
        temp.clear();
        for(int i: set2) {
            if(!set1.contains(i)) {
                temp.add(i);
            }
        }
        ans.add(new ArrayList<>(temp));
        temp.clear();
        return ans;
    }
}