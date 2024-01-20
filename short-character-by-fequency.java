import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p2.val - p1.val;
            }
        });

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            pq.add(new Pair(c, map.get(c)));
        }

         while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            for (int i = 0; i < pair.val; i++) {
                sb.append(pair.c);
            }
        }

        return sb.toString();
    }
}

class Pair {
    char c;
    int val;

    Pair(char c, int val) {
        this.val = val;
        this.c = c;
    }
}
