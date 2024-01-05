class Solution {
    public static class Node{
        private int val;
        private boolean isEnd;
        private Node [] childeren;
        public Node(int val){
            this.val = val;
            this.isEnd = false;
            this.childeren = new Node[201];
        }
    }
    private int totalCount =0;
    private Node root  = new Node(0);
    private void insert(int[]nums, int left, int right){
        Node curr = this.root;
        for(int i=left;i<=right;i++){
            int child  = nums[i];
            if(curr.childeren[child]==null){
                curr.childeren[child] = new Node(child);
            }
            curr = curr.childeren[child];
            if(!curr.isEnd){
                totalCount++;
                curr.isEnd=true;
            }
        }
    }
    public int countDistinct(int[] nums, int k, int p) {
        int count =0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        while(left<n){
            while(right<n){
                if(nums[right]%p==0){
                    count++;
                }
                if(count==k+1){
                    count--;
                    break;
                }
                right++;    
            }
            insert(nums,left,right-1);
            if(nums[left]%p==0){
                count--;
            }
            left++;
        }
        return totalCount;

    }
}
