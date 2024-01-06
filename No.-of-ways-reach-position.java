class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        //
        int [][] dp = new int[2*(startPos+k)][k+1];
        for(int []a:dp){
            Arrays.fill(a,-1);
        }
        //to prevent it from going in negative 
        int maxDis = Math.abs(startPos-k);
        return ways(startPos+maxDis, endPos+maxDis, k, dp);
    }
    int mod = (int)1e9+7;
    public int ways(int startPos, int endPos, int k, int[][]dp) {
        if (k == 0 && startPos == endPos) {
            return 1;
        }

        if (k == 0 && startPos != endPos) {
            return 0;
        }
        if(dp[startPos][k] !=-1){
            return dp[startPos][k];
        }
        int left= ways(startPos - 1, endPos, k - 1, dp);
        int right= ways(startPos + 1, endPos, k - 1, dp);

        return dp[startPos][k] = (left+right)%mod;
    }
}
