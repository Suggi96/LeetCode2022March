class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastSeen = new int[26];
        List<String> word = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            lastSeen[c - 'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
             end = Math.max(end, lastSeen[s.charAt(i) - 'a']);
             if(i==end) {
                 ans.add(end-start+1);
                 start = end+1;
             }
              
        } 
        return ans;
    }
}