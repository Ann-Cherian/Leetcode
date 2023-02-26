class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] ans = new int[nums.length];
        int leftSum = 0;
        int rightSum = 0;
        for (int num : nums)
            rightSum += num;
        for (int i = 0; i < ans.length; i++) {
            rightSum -= nums[i];
            ans[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return ans;
    }
}