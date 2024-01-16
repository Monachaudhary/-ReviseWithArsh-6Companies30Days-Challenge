class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int func = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            func += i * nums[i];
        }

        int maxFunc = func;

        for (int i = 1; i < n; i++) {
            func = func + sum - n * nums[n - i];
            maxFunc = Math.max(maxFunc, func);
        }

        return maxFunc;
    }
}
