class Solution {
    public boolean canJump(int[] nums) {
        int i, n = nums.length, max = 0;

        for (i = 0; i < n - 1; i++) {
            if (i > max)
                return false;
            max = Math.max(max, i + nums[i]);
        }

        return (max >= n - 1);
    }
}
