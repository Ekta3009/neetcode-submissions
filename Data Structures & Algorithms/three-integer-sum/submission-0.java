class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length, i, j, sum;

        Arrays.sort(nums);

        i = 0;

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        while (i < n) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                sum = nums[left] + nums[i] + nums[right];

                if (sum == 0) {
                    temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[i]);
                    temp.add(nums[right]);
                    ans.add(temp);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }

                else if (sum < 0) {
                    left++;
                }

                else if (sum > 0) {
                    right--;
                }
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

            i++;
        }

        return ans;
    }
}
