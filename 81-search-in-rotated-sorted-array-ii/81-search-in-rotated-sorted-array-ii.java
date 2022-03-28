class Solution {
    public boolean search(int[] nums, int target) {
        HashSet<Integer> set = new LinkedHashSet<>();
        for(int i: nums)
            set.add(i);
        int[] arr = new int[set.size()];
        int j = 0;
        for(int i: set)
            arr[j++] = i;
        int n = arr.length;
        int l = 0, r = n-1;
        //find index of smallest index in nums
        //call bs from 0 to idx-1 and bs from idx+1 to n-1 according to target
        while(l<r) {
            int mid = l + (r-l)/2;
            if(arr[mid]>arr[r])
                l = mid +1;
            else
                r = mid;
        }
        int minIdx = l;
        if(target<=arr[n-1])
           return binarySearch(arr, target, minIdx, n-1);
        else
          return binarySearch(arr, target, 0, minIdx-1);
    }
        private boolean binarySearch(int[] nums, int target, int l, int r) {
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(target==nums[mid])
                return true;
            else if(target<nums[mid])
                r = mid - 1;
            else 
                l = mid + 1;
        }
        return false;
}
}