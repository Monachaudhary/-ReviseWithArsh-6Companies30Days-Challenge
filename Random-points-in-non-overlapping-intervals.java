

class Solution {
    int[][] rects;
    int totalArea;
    Random random;
    int[] cumulativeSum;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.totalArea = 0;
        this.random = new Random();
        this.cumulativeSum = new int[rects.length];

        // Calculate the total area of all rectangles and compute cumulative sum
        for (int i = 0; i < rects.length; i++) {
            totalArea += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            cumulativeSum[i] = totalArea;
        }
    }

    public int[] pick() {
        // Generate a random number between 1 and the total area
        int rand = random.nextInt(totalArea) + 1;

        // Binary search to find the chosen rectangle
        int left = 0, right = rects.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (cumulativeSum[mid] < rand) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Get the chosen rectangle
        int[] chosenRect = rects[left];

        // Generate a random point within the chosen rectangle
        int x = chosenRect[0] + random.nextInt(chosenRect[2] - chosenRect[0] + 1);
        int y = chosenRect[1] + random.nextInt(chosenRect[3] - chosenRect[1] + 1);

        return new int[]{x, y};
    }
}
