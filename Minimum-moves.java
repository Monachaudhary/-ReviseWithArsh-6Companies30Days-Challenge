class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int moves =0;
        for(int i=0;i<n/2;i++){
            moves +=nums[n-i-1] - nums[i];
        }
        return moves;
    }
}
