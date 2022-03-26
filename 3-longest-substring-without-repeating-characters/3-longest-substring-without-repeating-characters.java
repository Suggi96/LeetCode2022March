class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxi = 0;
		int len = 0;
		char[] ch = s.toCharArray();
		int n = ch.length;
        
		HashSet<Character> set = new HashSet<>();
		int i = 0, j = 0;
		while(i<n) {
			j = i;
			while(j<n && !set.contains(ch[j])) {
				len++;
				set.add(ch[j]);
				j++;
			}
			maxi = Math.max(maxi, len);
			len = 0;
			i++;
			set.clear();
		}
		return maxi;
    }
}