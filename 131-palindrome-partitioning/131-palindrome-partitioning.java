class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTrack(s, 0, list, ans);
        return ans;
    }
    private void backTrack(String s, int start, List<String> list, List<List<String>> ans) {
        //base case 
        if(start>=s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<s.length();i++) {
            if(isPalindrome(s, start, i)) {
                list.add(s.substring(start, i+1));
                backTrack(s, i+1, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}