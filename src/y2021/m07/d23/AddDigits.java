package y2021.m07.d23;

/**
 * @author ： cxyxh
 * @date : 2021/7/23 22:44
 * @describetion :leetcode编号258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddDigits {

    public static void main(String[] args) {
        int ans = addDigits1(38);
        System.out.println(ans);
    }

    /**
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     *
     * @param num
     * @return
     */
    public static int addDigits1(int num) {
        while (num >= 10) {
            int ans = 0;
            // 如果num除到0，那么ans赋给num
            while (num != 0) {
                ans += num % 10;
                num = num / 10;
            }
            num = ans;
        }
        return num;
    }

    /**
     * 时间复杂度O(1)
     * 空间复杂度O(1)
     *
     * @param num
     * @return
     */
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
