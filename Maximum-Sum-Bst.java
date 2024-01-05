class Solution {
    int maxSum=0;
    public NodePair getSum(TreeNode root){
        if(root==null){
            NodePair box = new NodePair();
            box.min = Integer.MAX_VALUE;
            box.max = Integer.MIN_VALUE;
            box.sum = 0;
            return box;
        }
        NodePair main = new NodePair();
        NodePair left = getSum(root.left);
        NodePair right = getSum(root.right);
        if(right.min>root.val&& left.max<root.val){
            main.min = Math.min(root.val, Math.min(left.min,right.min));
            main.max = Math.max(root.val,Math.max(left.max, right.max));
            main.sum = root.val+ left.sum + right.sum;
            maxSum = Math.max(maxSum, main.sum);
        }else{
            main.min = Integer.MIN_VALUE;
            main.max = Integer.MAX_VALUE;
            main.sum = Math.max(left.sum,right.sum);
        }
        return main;
    }
    public int maxSumBST(TreeNode root) {
        NodePair temp = new NodePair();
        temp = getSum(root);
        return maxSum>0?maxSum:0;
    }
}
class NodePair{
    int sum;
    int min;
    int max;
}
