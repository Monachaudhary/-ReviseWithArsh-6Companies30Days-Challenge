import java.util.*;

public class Solution {
    long mod = 1000000007;
    int[] notAllowed;

    public int squareFreeSubsets(int[] nums) {
        notAllowed = new int[31];
        Arrays.fill(notAllowed, 0);

        for (int i = 2; i <= 5; ++i) {
            int cur = i * i;
            for (int j = cur; j <= 30; j += cur) {
                notAllowed[j]++;
            }
        }

        List<Long> z = new ArrayList<>();
        long[] fre = new long[31];
        Arrays.fill(fre, 0);

        for (int x : nums) {
            fre[x]++;
            if (notAllowed[x] == 0) {
                z.add((long) x);
                notAllowed[x]++;
            }
        }

        long ex = 1;
        if (notAllowed[1] > 0) {
            ex = power(2, fre[1]) - 1;
        }

        int n = z.size();
        long ans = 0;
        int lim = (1 << n);

        for (int i = 1; i <= lim; ++i) {
            long pro = 1;
            long gc = 1;
            int f = 0, g = 0;
            long val = 1, e = 1;

            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) > 0) {
                    gc = gcd(pro, z.get(j));
                    g = 1;

                    if (gc > 1) {
                        f = 1;
                        break;
                    }

                    pro *= z.get(j);
                    if (z.get(j) != 1) {
                        long h =z.get(j);
                        val *= fre[(int)h];
                        val %= mod;
                    } else {
                        e = ex;
                    }
                }
            }

            if (f == 1);
            else if (g == 1) {
                val *= e;
                val %= mod;
                ans += val;
                ans %= mod;
            }
        }

        return (int) ans;
    }

    private long power(long a, long b) {
        long res = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                res *= a;
                res %= mod;
            }
            b >>= 1;
            a *= a;
            a %= mod;
        }
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

  
}
