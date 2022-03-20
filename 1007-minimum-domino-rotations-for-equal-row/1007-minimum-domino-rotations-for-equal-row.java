class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int freqT[] = new int[7];
        int freqB[] = new int[7];
        for(int i: tops)
            freqT[i]++;
        
        for(int i: bottoms)
            freqB[i]++;
        int maxT = findMax(freqT);
        int maxB = findMax(freqB);
        
        int ans1 = minRot(tops, bottoms, maxT);
        int ans2 = minRot(bottoms, tops, maxB);
        
        if(ans1>0 && ans2>0)
            return Math.min(ans1, ans2);
        
        if(ans1>0)
            return ans1;
        else
            return ans2;
        
    }
    
    private int minRot(int[] source, int[] dest, int k) {
        int swaps = 0;
        for(int i=0;i<source.length;i++) {
            if(source[i]!=k && dest[i]!=k)
                return -1;
            if(source[i]!=k && dest[i]==k)
                swaps++;
        }
        return swaps;
    }
    
    private int findMax(int[] freq) {
        int maxi = Integer.MIN_VALUE;
        int maxE = 0;
        for(int i=0;i<freq.length;i++) {
            if(freq[i]>maxi) {
                maxi = freq[i];
                maxE = i;
            }
        }
        return maxE;
    }
}