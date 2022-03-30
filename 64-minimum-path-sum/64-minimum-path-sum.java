class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return pathSum(grid, 0, 0, rows-1, cols-1, new HashMap<String, Integer>());
    }
    private int pathSum(int[][] grid, int curRow, int curCol, int lastRow 
                        ,int lastCol, HashMap<String, Integer> memo) {
        if(curRow==lastRow && curCol==lastCol)
            return grid[curRow][curCol];
        
        if(curRow>lastRow || curCol>lastCol)
            return 100001;
        String curKey = curRow + "-" + curCol;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int downMove = grid[curRow][curCol] + pathSum(grid, curRow+1, curCol
                                                     ,lastRow, lastCol, memo);
        int rightMove = grid[curRow][curCol] + pathSum(grid, curRow, curCol+1
                                                       ,lastRow, lastCol, memo);
        
        memo.put(curKey, Math.min(downMove, rightMove));
       return memo.get(curKey);
    } 
}