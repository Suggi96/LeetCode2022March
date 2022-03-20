class Solution {
    public int countHillValley(int[] nums) {
        int hill = 0;
        int valley = 0;
        int n = nums.length;
        for(int i=1;i<=n-2;i++) {
            if(nums[i-1]==nums[i]) continue;
            int j = i-1;
            int k = i+1;
            while(j>=0 && nums[i]==nums[j]) j--;
            if(j < 0) continue;
            while(k<n && nums[i]==nums[k]) k++;
            if(k == n) continue;
            
            if(nums[i]>nums[j] && nums[i]>nums[k])
                hill++;
            if(nums[i]<nums[j] && nums[i]<nums[k])
                valley++;
        }

        return hill + valley;
        
    }
}