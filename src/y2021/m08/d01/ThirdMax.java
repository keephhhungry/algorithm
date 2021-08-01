package y2021.m08.d01;

/**
 * @author ： cxyxh
 * @date : 8/1/2021 10:18 PM
 * @describetion :414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -2^31 <= nums[i] <= 2^31 - 1
 * <p>
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThirdMax {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 54, 4, 23, 1, 3, 6, 43, 44};
        int ans = thirdMax(nums);
        System.out.println(ans);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int num : nums) {
            // 如果相等直接跳过
            if (firstMax == num || secondMax == num || thirdMax == num) {
                continue;
            }
            // 如果大于最大的数，最大数依次后退一个
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
                // 如果大于第二大的数，第二大的数依次后退一个
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
                // 如果大于第三大的数，那么取代第三大的数
            } else if (num > thirdMax) {
                thirdMax = num;
            }
        }
        return (int) (thirdMax != Long.MIN_VALUE ? thirdMax : firstMax);
    }

}
