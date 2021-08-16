package zuo.level2.class13;

/**
 * @author ： cxyxh
 * @date : 8/14/2021 4:48 PM
 * @describetion :从左往右的尝试模型
 * <p>
 * 给定两个长度都为N的数组weights和values
 * weight[i] 和 values[i] 分为代表i号物品的重量和价值
 * 给定一个整数bag，表示一个载重bag的袋子
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少？
 */
public class Code04_Knapsack {

    /**
     * @param w   所有货的重量
     * @param v   所有货的价格
     * @param bag 背包的容量
     * @return 不超重的情况下，能够得到的最大价值
     */
    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        // 尝试函数！
        return process(w, v, 0, bag);
    }

    /**
     * @param w     所有货的重量数组
     * @param v     所有货的价格数组
     * @param index 当前的角标
     * @param rest  剩余的空间
     * @return 不超重的情况下，能够得到的最大价值
     */
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        // 不装当前的东西
        int p1 = process(w, v, index + 1, rest);
        int p2 = 0;
        // 装当前的东西
        int next = process(w, v, index + 1, rest - w[index]);
        if (next != -1) {
            p2 = v[index] + next;
        }
        return Math.max(p1, p2);
    }

    public static int dp(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dp(weights, values, bag));
    }
}
