package firstweek;

public class BestTimeTuBuyAndSell {

    public int maxProfit(int[] prices) {

        int profit = 0;
        int maxProfit = 0;
        int min = prices[0];
        int max = prices[0];

        for (int price : prices) {
            if (price > max) {
                max = price;
                profit = max - min;
            }

            if (price < min) {
                min = price;
                max = price;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
                profit = 0;
            }
        }

        if (profit > maxProfit) {
            maxProfit = profit;
        }

        return maxProfit;
    }
}
