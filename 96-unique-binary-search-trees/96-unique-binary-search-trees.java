class Solution {
    public int numTrees(int n) {
        return nthCatNum(n, new HashMap<Integer, Integer>());
    }
    private int nthCatNum(int n, HashMap<Integer, Integer> memo) {
        if(n==0 || n==1) 
            return 1;
        int curKey = n;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int ways = 0;
        for(int i=0;i<n;i++)
        {
           ways = ways + nthCatNum(i, memo) * nthCatNum(n-i-1, memo); 
        }
        memo.put(curKey, ways);
        
        return memo.get(curKey);
    }
}