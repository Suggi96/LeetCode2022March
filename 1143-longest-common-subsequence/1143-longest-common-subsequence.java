class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        return lcs(s1, s2, 0, 0, s1.length(), s2.length(), new HashMap<String, Integer>());
    }
    private int lcs(String s1, String s2, int i, int j, int m, int n,
                   HashMap<String, Integer> memo) {
        if(i>=m || j>=n)
            return 0;
        String curKey = i + "-" + j;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        int ans = -1;
        if(s1.charAt(i)==s2.charAt(j)) {
            ans = 1 +  lcs(s1, s2, i+1, j+1, m, n, memo);
            memo.put(curKey, ans);
        }
        else {
            int a =  lcs(s1, s2, i, j+1, m, n, memo);
            int b =  lcs(s1, s2, i+1, j, m, n, memo);
            ans = Math.max(a, b);
            memo.put(curKey, ans);
        }
        return memo.get(curKey);
    }
}