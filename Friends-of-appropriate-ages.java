class Solution {
    public int numFriendRequests(int[] ages) {
        int[] ageFrequency = new int[121];

        // Count the frequency of each age and store it in the 'ageFrequency' array
        for (int age : ages) {
            ageFrequency[age]++;
        }

        // Calculate cumulative sum in 'ageFrequency' array
        for (int i = 1; i <= 120; i++) {
            ageFrequency[i] += ageFrequency[i - 1];
        }

        int totalFriendRequests = 0;

        // Calculate the total number of friend requests satisfying the conditions
        for (int i = 0; i < ages.length; i++) {
            int minAllowedAge = ages[i] / 2 + 7;

            // If the condition is true, skip to the next iteration
            if (minAllowedAge >= ages[i]) {
                continue;
            }

            // Calculate the number of friend requests based on the cumulative sum
            totalFriendRequests += ageFrequency[ages[i]] - ageFrequency[minAllowedAge] - 1;
        }

        // Return the total number of friend requests
        return totalFriendRequests;
    }
}
