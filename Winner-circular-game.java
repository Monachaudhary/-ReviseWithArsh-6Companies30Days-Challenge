class Solution {
    int personalive =0;
    public int findTheWinner(int n, int k) {
        int index=0;
        k--;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++ ){
            list.add(i);
        }
        alive_People(list, k, index);
        return personalive;
    }
    public void alive_People(List<Integer> list, int k , int index){
        if(list.size()==1){
            personalive = list.get(0);
            return;
        }
        index = (index+k)%list.size();
        list.remove(index);
        alive_People(list, k, index);
    }
}
