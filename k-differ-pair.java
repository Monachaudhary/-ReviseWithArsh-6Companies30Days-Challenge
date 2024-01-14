import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0; // k cannot be negative
        }

        // Create a HashMap to store the count of each number
        Map<Integer, Integer> numCountMap = new HashMap<>();

        // Populate the HashMap with the count of each number
        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        // Count of unique k-diff pairs
        int count = 0;

        // Iterate through the array
        for (int num : numCountMap.keySet()) {
            if (k == 0) {
                // For k=0, count the number of elements that appear more than once
                if (numCountMap.get(num) > 1) {
                    count++;
                }
            } else {
                // For k>0, check if there exists another number with absolute difference k
                if (numCountMap.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
