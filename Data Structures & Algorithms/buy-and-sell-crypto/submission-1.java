class Solution {
    public int maxProfit(int[] prices) {

        int min = prices[0], profit = 0;
        int sub = 0;

        for(int i=0;i<prices.length;i++) {

            if(prices[i] < min) {
                min = prices[i];
            }

            sub = prices[i] - min;

            profit = Math.max(profit, sub);
        }

        return profit;
        

    }
}
