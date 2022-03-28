class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 100001;
        HashMap<String, Integer> memo = new HashMap<>();
        for(int curColumn=0;curColumn<n;curColumn++) {
            int temp = minPathSum(matrix, 0, curColumn, m, n, memo);
            ans = Math.min(temp, ans);
        }
        return ans;
    }
    private int minPathSum(int[][] matrix, int curRow, int curColumn, int m, int n,
                          HashMap<String, Integer> memo) {
        if(curColumn<0 || curColumn>=n)
            return 100001;
        if(curRow==m-1)
            return matrix[curRow][curColumn];
        
        String curKey = curRow + "-" + curColumn;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int diagonalLeft = matrix[curRow][curColumn] + minPathSum(matrix, curRow+1, 
                                                                  curColumn-1, m, n, memo);
        int down = matrix[curRow][curColumn] + minPathSum(matrix, curRow+1, 
                                                                  curColumn, m, n, memo);
        int diagonalRight = matrix[curRow][curColumn] + minPathSum(matrix, curRow+1, 
                                                                  curColumn+1, m, n, memo);
        int ans = Math.min(diagonalLeft, Math.min(down, diagonalRight));
        memo.put(curKey, ans);
        return ans;
    }
}