package y2021.m08.d11;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 8/11/2021 11:40 PM
 * @describetion :338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 * <p>
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountBits {

    public static void main(String[] args) {
        int[] res = countBits(5);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i / 2] + i % 2;
        }
        return res;
    }
}
