class pair{
    String x;
    int y;
    pair(String x1, int y1){
         x= x1;
         y=y1;
    }
}
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;
         PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> (b.x.compareTo(a.x) == 0 ? b.y - a.y : b.x.compareTo(a.x)));
        int ind=0;
        int [] ans = new int[n];
        for(int []num:queries){
            int trim = num[1];
            int k= num[0];
            int index=0;
            for(String s : nums){
                int ln = s.length();
                s = s.substring(ln-trim);
                pq.add(new pair(s,index));
                if(pq.size()>k){
                    pq.poll();
                }
                index++;
               
            }
             ans[ind++] = pq.poll().y;
                pq.clear();

        }
        return ans;
        
    }
}
