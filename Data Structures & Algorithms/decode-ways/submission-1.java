class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];

        for(int i = 0; i<s.length(); i++){
            dp[i] = -1;
        }
        return decode(0, s, dp);
    }

    private int decode(int i, String s, int[] dp) {
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take1 = decode(i + 1, s, dp);
        int take2 = 0;

        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i,i+2));
            if(num >= 10 && num <= 26){
            take2 = decode(i + 2, s, dp);
            }
        }

        return dp[i] = take2 + take1;
    }
}
