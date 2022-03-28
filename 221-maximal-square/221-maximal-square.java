class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int area = 0;
        int dp[][] = new int[m][n];
        HashMap<String, Integer> memo = new HashMap<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]=='1') {
                    int side = maxLength(matrix, i, j, m, n, dp);
                    area = Math.max(area, side*side);
                }
            }
        }
        return area;
    }
    private int maxLength(char[][] matrix, int curRow, int curCol, int m, int n, 
                         int[][] dp) {
        //base case
        if(curRow<0 || curRow>=m || curCol<0 || curCol>=n ||
          matrix[curRow][curCol]=='0') //if u enter out of bounds cell or cell with value 0
            return 0;
        
        if(dp[curRow][curCol]!=0)
            return dp[curRow][curCol];
        
        int rightExpand = 1 + maxLength(matrix, curRow, curCol+1, m, n, dp);
        int downExpand = 1 + maxLength(matrix, curRow+1, curCol, m, n, dp);
        int diagExpand = 1 + maxLength(matrix, curRow+1, curCol+1, m, n, dp);
        
        int sidetoAdd = Math.min(rightExpand, Math.min(downExpand, diagExpand));
        
        dp[curRow][curCol] = sidetoAdd;
        
        return sidetoAdd;
    }
}