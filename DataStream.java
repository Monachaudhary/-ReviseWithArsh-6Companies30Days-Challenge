class DataStream {
    private int value;
    private int k;
    private Queue<Integer> stream;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.stream = new LinkedList<>();
    }
    
    public boolean consec(int num) {
        return checkConsec(num);
    }
    private boolean checkConsec(int num){
        if(num==value){
            stream.offer(num);
        }else{
            stream = new LinkedList<>();
        }
        return stream.size()>=k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
