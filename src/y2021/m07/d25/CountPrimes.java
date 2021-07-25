package y2021.m07.d25;

/**
 * @author ： cxyxh
 * @date : 7/25/2021 3:25 PM
 * @describetion :leetcode编号204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountPrimes {

    public static void main(String[] args) {
        int ans = countPrimes(10);
        System.out.println(ans);
    }

    /**
     * 时间复杂度O(n*n^(1/2))
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int count = 0;
        // 遍历这是范围里面的数字
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断每个数字是否是质数
     *
     * @param x
     * @return
     */
    public static boolean isPrimes(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
