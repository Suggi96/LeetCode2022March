class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[n-1];
        int curSum = 0;
        for(int i=0;i<n-2;i++) {
            int start = i+1;
            int end = n-1;
            while(start<end) {
                curSum = nums[i] + nums[start] + nums[end];
                if(curSum < target) {
                    start++;
                }
                else {
                    end--;
                }
                 if(Math.abs(curSum - target) < Math.abs(closestSum - target)) {
                    closestSum = curSum;
                 }
            }
        }
        return closestSum;
    }
}