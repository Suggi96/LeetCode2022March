class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastSeen = new int[26];
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            lastSeen[c - 'a'] = i;
        }
        int i = 0;
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        List<String> words = new ArrayList<>();
        while(i<s.length()) {
            end = Math.max(end, lastSeen[s.charAt(i) - 'a']);
            if(i==end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
            i++;
        } 
        return ans;
    }
}