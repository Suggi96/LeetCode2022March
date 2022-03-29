class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0)+1);
        int[] ans = new int[2];
        int idx = 0;
        int missingNumber = 0;
        for(int i=1;i<=nums.length;i++) {
            if(map.containsKey(i)==false) {
                missingNumber = i;
            }
            if(map.containsKey(i) && map.get(i)==2) {
                ans[idx++] = i;
            }
                
        }
        ans[idx] = missingNumber;
        return ans;
    }
}