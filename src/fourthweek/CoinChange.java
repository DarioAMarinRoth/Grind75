package fourthweek;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 11));
    }

    private Map<Integer, Integer> coinChange;

    public int coinChange(int[] coins, int amount) {
        coinChange = new HashMap<>();
        coinChange.put(0, 0);
        int[] amounts = new int[amount + 1];
        for (int i = 0; i < amounts.length; i++) {
            amounts[i] = minAmountOfCoins(coins, i);
        }
        return amounts[amount];
    }

    private int minAmountOfCoins(int[] coins, int amount) {
        if (coinChange.containsKey(amount)) {
            return coinChange.get(amount);
        }

        int minAmountOfCoins = Integer.MAX_VALUE;
        int n;

        for (int coin : coins) {
            if (amount < coin) {
                continue;
            }
            n = minAmountOfCoins(coins, amount - coin);
            if (n != -1 && n + 1 < minAmountOfCoins) {
                minAmountOfCoins = n + 1;
            }
        }

        minAmountOfCoins = (minAmountOfCoins == Integer.MAX_VALUE) ? -1 : minAmountOfCoins;
        coinChange.put(amount, minAmountOfCoins);
        return minAmountOfCoins;
    }
}
