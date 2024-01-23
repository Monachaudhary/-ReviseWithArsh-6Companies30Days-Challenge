class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        // Priority Queue to store sum and index tuples
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        heap.add(new int[] {nums[0], 0});
        int ans = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            // Remove elements that violate the constraint
            while (i - heap.peek()[1] > k) {
                heap.remove();
            }

            // Calculate current sum and update the answer
            int curr = Math.max(0, heap.peek()[0]) + nums[i];
            ans = Math.max(ans, curr);
            heap.add(new int[] {curr, i});
        }

        return ans;
    }
}
