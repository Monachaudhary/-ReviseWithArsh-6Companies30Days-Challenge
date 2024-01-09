class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 1; // Initialize to 1 to account for subarrays starting from the beginning
        int oddCount = 0;
        int count = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }

            if (oddCount >= k) {
                count += dp[oddCount - k];
            }

            dp[oddCount]++;
        }

        return count;
    }
}
