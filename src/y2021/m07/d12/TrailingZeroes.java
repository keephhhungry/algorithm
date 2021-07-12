package y2021.m07.d12;

/**
 * @author ： cxyxh
 * @date : 2021/7/12 22:27
 * @describetion :leetcode编号172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * <p>
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TrailingZeroes {

    public static void main(String[] args) {
        int i = trailingZeroes(125);
        System.out.println(i);
    }

    /**
     * 数学分析
     * 思路：尾数是0，主要看能拆分出来 (2 * 5)的数量有多少
     * 如10! = (2*5) * 9 * (2*4) * 7 * (2*3) * 5 (2*2) * 3 * 2 * 1
     * 可以直观感受到2的数量远大于5,2每两个数就可以出现一次，5要隔5个数才出现一次
     *
     * 每隔25个数，由于可以拆成(5*5),需要多算一个5
     * 每隔125个数，可以拆成(5*5*5),需要再多算一个5
     *
     * 所以5的数量为 n/5 + n/25 + n/125 + ....
     *
     * 时间复杂度：O(logn)。
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
