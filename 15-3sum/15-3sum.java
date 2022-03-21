class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n<=2)
            return ans;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int start = i+1;
            int end = n - 1;
            int target = 0-nums[i];
            while(start<end) {
                int sum = nums[start] + nums[end];
                if(sum==target) {
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while(start<end && nums[start]==nums[start+1]) start++;
                    while(start<end && nums[end]==nums[end-1]) end--;
                    start++;
                    end--;
                }
                else if(sum<target) {
                    start++;
                }
                else {
                    end--;
                }
            } 
        }

        return ans;
    }
}