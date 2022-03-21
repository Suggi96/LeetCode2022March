class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        if(n<=2)
            return ans;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++) {
            int start = i+1;
            int end = n - 1;
            while(start<end) {
                int sum = nums[i] + nums[start] + nums[end];
                List<Integer> list = new ArrayList<>();
                if(sum==0) {
                    list.add(nums[i]);
                    list.add(nums[start++]);
                    list.add(nums[end--]);
                    set.add(list);
                }
                else if(sum<0) {
                    start++;
                }
                else {
                    end--;
                }
            } 
        }
        for(List<Integer> l: set)
            ans.add(l);
        return ans;
    }
}