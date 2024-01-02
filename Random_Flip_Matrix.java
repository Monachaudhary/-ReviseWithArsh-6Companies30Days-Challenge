class Solution {
    private Map<Integer, Integer> myMap;
    private int rows, cols, total;
    private Random random;

    public Solution(int r1, int c1) {
        myMap = new HashMap<>();
        random = new Random();
        rows = r1;
        cols = c1;
        total = rows * cols;
    }

    public int[] flip() {
        // help to generate random number from 0 to total
        //we are decreasing total because when random generate the same number we do not return the pair which was already visited
        //if we get same number again and again we map it with different number
        int r = random.nextInt(total--);
        // check if we have already put something at this index
        int x = myMap.getOrDefault(r, r);
        // put total at index that we generated so that we do not get the pair which has already visited
        myMap.put(r, myMap.getOrDefault(total, total));
        return new int[] { x / cols, x % cols };
    }

    public void reset() {
        myMap.clear();
        total = rows * cols;
    }
}
