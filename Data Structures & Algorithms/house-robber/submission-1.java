class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            dp[i] = -1;
        }
        return rob(0,nums,dp);
    }

    private int rob(int index, int[] nums, int[] dp){
        if(index == nums.length - 1){
            return nums[index];
        }

        if(index >= nums.length){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int notRob = rob(index+1, nums, dp);
        int doRob = 0, max = nums[index];

        for(int i=index+2;i<nums.length;i++){
           doRob = nums[index] + rob(i,nums, dp);
           max = Math.max(doRob, max);
        }

        return dp[index] = Math.max(notRob, max);
    }
}
