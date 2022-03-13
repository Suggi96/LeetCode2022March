class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
boolean visit[][]=new boolean[n][n];
        for(int arr[]:dig){
            visit[arr[0]][arr[1]]=true;
        }
        
        int ans=0;
        for(int arr[]:artifacts){
            
            boolean flag=true;
            int x1 = arr[0];
            int y1 = arr[1];
            int x2 = arr[2];
            int y2 = arr[3];
            for(int i=x1;i<=x2;i++){
                for(int j=y1;j<=y2;j++){
                    if(visit[i][j]==false) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) ans++;
        }
        return ans;
    }
}
