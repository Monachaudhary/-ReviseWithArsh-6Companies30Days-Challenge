import java.util.*;

class Solution {

    // Function to calculate the least common multiple (LCM)
    static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    // Function to calculate the greatest common divisor (GCD)
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Main function to minimize the set
    public static long minimizeSet(long divisor1, long divisor2, long uniqueCnt1, long uniqueCnt2) {
        long need = uniqueCnt1 + uniqueCnt2;
        long n = need;

        long lcm = lcm(divisor1, divisor2);

        while (need > 0) {
            long only1 = n / divisor2 - n / lcm;
            long only2 = n / divisor1 - n / lcm;
            long free = n - n / divisor1 - n / divisor2 + n / lcm;

            need = Math.max(Math.max(0, uniqueCnt1 - only1) + Math.max(0, uniqueCnt2 - only2) - free, 0);

            n += need;
        }

        return n;
    }

    public static void main(String[] args) {
        // Example usage
        long divisor1 = 3;
        long divisor2 = 5;
        long uniqueCnt1 = 2;
        long uniqueCnt2 = 3;

        long result = minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2);
        System.out.println(result);
    }
}
