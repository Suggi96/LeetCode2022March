class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>(); //key is value in nums1 and 
                                                         //value is index of nums1 value
        for(int i=0;i<n;i++) {
            map.put(nums1[i], i);
        }
        Arrays.fill(ans, -1);
        for(int i=0;i<nums2.length;i++) {
         if(map.containsKey(nums2[i])) {
             int j = i+1;
             while(j<nums2.length && nums2[j]<nums2[i]) j++;
             if(j<nums2.length) {
                 int idx = map.get(nums2[i]);
                 ans[idx] = nums2[j];
             }
         }   
        }
        return ans;
    }
}