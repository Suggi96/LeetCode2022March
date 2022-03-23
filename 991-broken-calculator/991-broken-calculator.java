class Solution {
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while(Y > X) {
            res++;
            if(Y%2==0)
                Y = Y/2;
            else
                Y = Y+1;
        }
        return res + (X-Y);
    }
}