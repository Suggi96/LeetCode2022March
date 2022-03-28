class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        //find index of smallest index in nums
        //call bs from 0 to idx-1 and bs from idx+1 to n-1 according to target
        while(l<r) {
            int mid = l + (r-l)/2;
            if(nums[mid]>nums[r])
                l = mid +1;
            else
                r = mid;
        }
        // when loop break l will have index of min element
        int minIdx = l;
        if(target>=nums[minIdx] && target<=nums[n-1])
           return binarySearch(nums, target, minIdx, n-1);
        else
          return binarySearch(nums, target, 0, minIdx-1);
    }
    private int binarySearch(int[] nums, int target, int l, int r) {
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(target==nums[mid])
                return mid;
            else if(target<nums[mid])
                r = mid - 1;
            else 
                l = mid + 1;
        }
        return -1;
    }
}