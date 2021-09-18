package y2021.m09.d19;

/**
 * @author ： cxyxh
 * @date : 9/19/2021 12:06 AM
 * @describetion :643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * 示例 2：
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxAverage {

    public static void main(String[] args) {
        //int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int[] nums = new int[]{0, 4, 0, 3, 2};
        double res = findMaxAverage(nums, 1);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) {
            return 0;
        }
        int sum = 0;
        // 先计算前k个数
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        // 开始往右滑动 计算每K个数的情况
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return ((double) maxSum) / k;
    }

}
