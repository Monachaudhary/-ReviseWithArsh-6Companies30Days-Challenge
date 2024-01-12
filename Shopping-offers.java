

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return helper(price, special, needs, memo);
    }

    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int sum = 0, len = price.size();
        for (int i = 0; i < len; i++) {
            sum += needs.get(i) * price.get(i);
        }

        for (List<Integer> offer : special) {
            List<Integer> temp = new ArrayList<>(needs);

            boolean validOffer = true;
            for (int j = 0; j < len; j++) {
                if (temp.get(j) < offer.get(j)) {
                    validOffer = false;
                    break;
                }
                temp.set(j, temp.get(j) - offer.get(j));
            }

            if (validOffer) {
                sum = Math.min(sum, offer.get(len) + helper(price, special, temp, memo));
            }
        }

        memo.put(needs, sum);
        return sum;
    }
}
