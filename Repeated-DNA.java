class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<s.length()-10;i++){
            String ans = s.substring(i,i+11);
            map.put(ans,map.getOrDefault(ans,0)+1);
        }
        for(String a:map.keySet()){
            if(map.get(a)>1){
                list.add(a);
            }
        }
        return list;


    }
}
