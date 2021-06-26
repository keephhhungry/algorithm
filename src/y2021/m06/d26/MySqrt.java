package y2021.m06.d26;

/**
 * @author ： cxyxh
 * @date : 2021/6/26 10:19
 * @describetion : leetcode编号69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MySqrt {

    // TODO 牛顿迭代不会
    public static void main(String[] args) {
        System.out.println("结果是:[" + mySqrt(1) + "]");
        System.out.println("结果是:[" + mySqrt(8) + "]");
        System.out.println("结果是:[" + mySqrt(4) + "]");
        System.out.println("结果是:[" + mySqrt(17) + "]");
        System.out.println("结果是:[" + mySqrt(25) + "]");
    }

    /**
     * 思路：用二分查找法的思路，先取中间值(记为mid)
     * 如果 mid的平方小于等于目标值，那么把mid值赋给ans，往右边继续二分
     * 如果 mid的平方大于目标值，那么往左边继续二分
     * <p>
     * 时间复杂度：O(logx)，即为二分查找需要的次数。
     * 空间复杂度：O(1)O(1)。
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
