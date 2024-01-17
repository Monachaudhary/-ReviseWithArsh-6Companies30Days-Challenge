class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        for(int i=1-nums2.length;i<nums1.length;i++){
            int count=0;
            for(int j=0;j<nums2.length;j++){
                if(i+j<0){
                    continue;
                }else if(i+j>=nums1.length){
                    break;
                }else if(nums1[i+j]==nums2[j]){
                    count++;
                    max = Math.max(max, count); 
                }else{
                    count=0;
                }
            }
        }
        return max;
    }
}
