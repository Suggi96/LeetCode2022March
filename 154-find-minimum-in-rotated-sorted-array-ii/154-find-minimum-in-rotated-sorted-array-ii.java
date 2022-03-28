class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<high) {
            int mid = low + (high-low)/2;
            if(nums[high]==nums[mid]) {
                high--;
            }
            //check if left half is sorted. if yes min element lies in left half
            else if(nums[high] > nums[mid]) {
                high = mid;
            }
            else {
                low = mid + 1; //right half is sorted and min element must lie in right half
            }
        }
        return nums[low];
    }
}