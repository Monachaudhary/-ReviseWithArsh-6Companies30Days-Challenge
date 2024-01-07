class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->(a[0]==b[0])?b[1]-a[1]:a[0]-b[0]);
        int []nums  = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            nums[i] = envelopes[i][1];
        }
        return lengthLIS(nums);
    }
    public int lengthLIS(int[]nums){
        int tail[] = new int[nums.length];
        int len= 1;
        tail[0] = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>tail[len-1]){
                tail[len] = nums[i];
                len++;
            }else{
                int c= ceilIndex(tail,0,len-1,nums[i]);
                nums[c] = nums[i];
            }
        }
        return len;
    }
    public int ceilIndex(int []tail, int start, int end, int x){
        while(start<end){
            int mid = start + (end-start)/2;
            if(tail[mid] >= x){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
}
