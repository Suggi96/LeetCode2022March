class Solution {
    public int numTrees(int n) {
        return nthCatNum(n);
    }
    private int nthCatNum(int n) {
        if(n==0 || n==1) 
            return 1;
        
        int ways = 0;
        for(int i=0;i<n;i++)
            ways = ways + nthCatNum(i) * nthCatNum(n-i-1);
        
        return ways;
    }
}