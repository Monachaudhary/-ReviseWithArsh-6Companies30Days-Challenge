public class Solution {
    public String getHint(String secret, String guess) {
        String result = "";
        int bulls = 0;
        int cows = 0;
        int[] freq = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s == g) {
                bulls++;
            } else {
                if (freq[s] < 0) cows++;
                if (freq[g] > 0) cows++;

                freq[s]++;
                freq[g]--;
            }
        }

        result = bulls + "A" + cows + "B";
        return result;
    }
}
