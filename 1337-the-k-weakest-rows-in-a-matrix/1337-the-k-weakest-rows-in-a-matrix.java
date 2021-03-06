class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j]==1)
                    count++;
                else break;
            }
            map.put(i, count);
            count = 0;
        }
        List<Map.Entry<Integer, Integer> > list =
               new LinkedList<Map.Entry<Integer, Integer>> (map.entrySet());
        Collections.sort(list, (a, b) -> {
            if(a.getValue()==b.getValue())
                return a.getKey() - b.getKey();
            return a.getValue() - b.getValue();
        });
        int i = 0;
        int res[] = new int[k];
        for(Map.Entry<Integer, Integer> e: list) {
            if(i<k) {
                res[i++] = e.getKey();
            }
            else {
                break;
            }
        }
        return res;
    }
}