package y2021.m09.d14;

/**
 * @author ： cxyxh
 * @date : 9/14/2021 11:47 AM
 * @describetion :476. 数字的补数
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 * 示例 1：
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * <p>
 * 示例 2：
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindComplement {

    public static void main(String[] args) {
        int res = findComplement(5);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(1)
     * 空间复杂度O(1)
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        int maxBitCount = 0;
        int tmp = num;
        while (tmp > 0) {
            maxBitCount++;
            tmp >>= 1;
        }
        return num ^ ((1 << maxBitCount) - 1);
    }

}
