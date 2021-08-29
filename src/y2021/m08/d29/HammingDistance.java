package y2021.m08.d29;

/**
 * @author ： cxyxh
 * @date : 8/29/2021 11:15 PM
 * @describetion :461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HammingDistance {

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int res = hammingDistance(x, y);
        System.out.println(res);
    }

    /**
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int s = x ^ y;
        int res = 0;
        while (s != 0) {
            res += s & 1;
            s = s >> 1;
        }
        return res;
    }
}
