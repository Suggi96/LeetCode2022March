class Solution {
    public int digArtifacts(int N, int[][] artifacts, int[][] dig) {
        int[][] mat = new int[N][N];
        int cur = 0;
        for(int[] artif : artifacts)
        {
            ++cur;
            for(int i = artif[0]; i <= artif[2]; i++)
                for(int j = artif[1]; j <= artif[3]; j++)
                        mat[i][j] = cur; // Marking each artifact with a unique number
        }
        
        for(int i = 0; i < dig.length; i++)
            mat[dig[i][0]][dig[i][1]] = -1; // Marking excavated
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(mat[i][j] > 0)
                    set.add(mat[i][j]); // All the unexcavated artifacts
        
        return cur-set.size();
    }
}