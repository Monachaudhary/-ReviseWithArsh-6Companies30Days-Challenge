class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length;
        int col = isWater[0].length;

        int[][] ans = new int[row][col];
        for(int[] rows: ans){
            Arrays.fill(rows, Integer.MAX_VALUE);
        }

        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(isWater[i][j] == 1){
                    ans[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int f = curr.first;
            int s = curr.second;

            int[] dr = {1, 0, -1, 0};
            int[] dc = {0, 1 ,0, -1};

            for(int i=0; i<4; i++){
                int nr = f + dr[i];
                int nc = s + dc[i];

                if(nr>=0 && nc>=0 && nr<row && nc<col && ans[nr][nc] > 1+ans[f][s]){
                    ans[nr][nc] = 1 + ans[f][s];
                    q.add(new Pair(nr, nc));
                }
            }
        }
        return ans;
    }
}
class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
