class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==nums[high]) {
                high--;
            }
            else if(nums[mid] > nums[high]) { //rotation has happened. so eliminate left half
                low = mid + 1;
            }
            else { //case for nums[mid] < nums[high]
                high = mid;  //min is present in left half. so eliminate right half
            }
        }
        return nums[low];
    }
}