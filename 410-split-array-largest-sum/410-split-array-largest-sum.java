class Solution {
    public int splitArray(int[] nums, int m) {
        int left = -1, right = 0;
        for(int i=0;i<nums.length;i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        int res = right;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(canSplit(mid, nums, m)) {
                res = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return res;
    }
    private boolean canSplit(int largest, int[] nums, int m) {
        int subarrays = 1; //used to count number of subarrays. 
        int curSum = 0; 
        for(int i=0;i<nums.length;i++) {
            curSum += nums[i];
            if(curSum>largest) { //make split if curSum exceeds largest
                curSum = nums[i]; //curSum starts from n in next iteration because 
                                //it exceeded largest so we made a split and new subarray
                                //starts from cur
                subarrays++; //increase subarrays count by 1;
            }
        }
        if(subarrays <=m) //
            return true;
        return false;
    }
}