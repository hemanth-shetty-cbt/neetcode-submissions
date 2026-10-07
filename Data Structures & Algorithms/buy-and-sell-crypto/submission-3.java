class Solution {
    public int maxProfit(int[] prices) {

        

        int max = 0;
        int n = prices.length;
        int left = 0 , right =left +1;

        while (right <n) {

            if (prices[left] < prices[right]) {
                int sum = prices[right] - prices[left];
                max = Math.max(max, sum);
            } else {
                left = right;
            }

            right++;
        }

        return max;


        
    }
}
