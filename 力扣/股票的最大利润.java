package 力扣;

/**
 * @author peiqi
 * @date 2022/4/2113:34
 */
public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        //记录最大利润
        int max = 0;
        //记录股票售价最低
        int min = prices[0];
        for (int price : prices) {
            max = Math.max(max,price-min);
            min = Math.min(min,price);
        }
        return max;
    }
}
