public class Solution {


    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        // Initialize the distance matrix with the given edges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        // Apply the Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int minCities = Integer.MAX_VALUE;
        int result = -1;

        // Check the number of reachable cities for each city
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }

            // Update result based on the conditions
            if (reachableCities <= minCities || (reachableCities == minCities && i > result)) {
                minCities = reachableCities;
                result = i;
            }
        }

        return result;
    }
}
