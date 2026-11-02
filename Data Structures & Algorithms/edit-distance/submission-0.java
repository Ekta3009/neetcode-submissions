class Solution {
    public int minDistance(String s1, String s2) {
        int i,j,m=s1.length(),n=s2.length(),min=Integer.MAX_VALUE;
        int dp[][] = new int[m+1][n+1];

        for(i=0;i<m+1;i++){
            dp[i][0] = i;
        }

        for(j=0;j<n+1;j++){
            dp[0][j] = j;
        }

        for(i=1;i<=m;i++){
            for(j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];

                    min = Math.min(insert, Math.min(delete, replace));

                    dp[i][j] = min;

                }
            }
        }

        return dp[m][n];


    }
}
