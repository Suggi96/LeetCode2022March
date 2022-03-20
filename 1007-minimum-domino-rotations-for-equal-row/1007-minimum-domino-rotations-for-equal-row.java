class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans1 = minConversionToTarget(tops, bottoms, tops[0]);
        int ans2 = minConversionToTarget(tops, bottoms, bottoms[0]);
        
        if(ans1>0 && ans2>0) {
            return Math.min(ans1, ans2);
        }
        else if(ans1>0) {
            return ans1;
        }
        else {
            return ans2;
        }
        
    }
    
    private int minConversionToTarget(int[] tops, int[] bottoms, int target) {
        int swapTop = 0;
        int swapBottom = 0;
        for(int i=0;i<tops.length;i++) {
            if(tops[i]!=target && bottoms[i]!=target)
                return -1;
            
            if(tops[i]!=target && bottoms[i]==target)
                swapTop++;
            
            if(bottoms[i]!=target && tops[i]==target)
                swapBottom++;
        }
        
        return Math.min(swapTop, swapBottom);
    }
}