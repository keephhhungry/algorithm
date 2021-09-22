package y2021.m09.d22;

/**
 * @author ： cxyxh
 * @date : 9/22/2021 11:35 PM
 * @describetion :908. 最小差值 I
 * 给你一个整数数组 nums，请你给数组中的每个元素 nums[i] 都加上一个任意数字 x （-k <= x <= k），从而得到一个新数组 result 。
 * 返回数组 result 的最大值和最小值之间可能存在的最小差值。
 * <p>
 * 示例 1：
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：result = [1]
 * <p>
 * 示例 2：
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：result = [2,8]
 * <p>
 * 示例 3：
 * 输入：nums = [1,3,6], k = 3
 * 输出：0
 * 解释：result = [3,3,3] or result = [4,4,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10000
 * 0 <= nums[i] <= 10000
 * 0 <= k <= 10000
 */
public class SmallestRangeI {

    public static void main(String[] args) {
        //int[] nums = new int[]{1, 3, 6};
        int[] nums = new int[]{0, 10};
        int res = smallestRangeI(nums, 2);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @param k
     * @return
     */
    public static int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        min += k;
        max -= k;
        return max - min <= 0 ? 0 : max - min;
    }
}
