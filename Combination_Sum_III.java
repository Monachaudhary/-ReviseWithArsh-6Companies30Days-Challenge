class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1,k,n,new ArrayList<>(), list);
        return list;
    }
    private void backtrack(int start, int k, int n, List<Integer> arr, List<List<Integer>>result){
        if(k==0&&n==0){
            result.add(new ArrayList<>(arr));
            return;
        }
        if(k==0&&n!=0){
            return;
        }
        for(int i=start; i<=9;i++){
            if(i>n){
                break;
            }
            arr.add(i);
            backtrack(i+1,k-1,n-i,arr,result);
            arr.remove(arr.size()-1);
        }
    }
}
