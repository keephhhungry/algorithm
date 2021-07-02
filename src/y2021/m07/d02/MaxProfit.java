package y2021.m07.d02;

/**
 * @author ： cxyxh
 * @date : 2021/7/2 22:22
 * @describetion :leetcode编号121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * 提示：
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println("最多可以赚[" + i + "]块");
    }

    /**
     * 一次遍历
     * <p>
     * 思路：把数组的第一个值当做最小值，0当做最大收益，开始从1开始遍历数组
     * 如果有值比最小值还小，那么替换最小值
     * 如果当前值减去最小值的差大于最大收益，那么这就是目前的最大收益
     * <p>
     * 时间复杂度：O(n)，只需要遍历一次。
     * 空间复杂度：O(1)，只使用了常数个变量。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int mix = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 如果该角标值比最小值还要小，那么替换最小值
            if (prices[i] < mix) {
                mix = prices[i];
                // 如果该角标的值减去最小值，大于目前最大收益，那么最大收益替换成当前值
            } else if (prices[i] - mix > maxProfit) {
                maxProfit = prices[i] - mix;
            }
        }
        return maxProfit;
    }
}
